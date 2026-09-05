import com.adonaisoft.adonaisdesktop.configuration.database.ConexaoBanco;
import com.adonaisoft.adonaisdesktop.view.aniversariantes.form.Aniversariantes;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
import java.time.LocalDate;

/** Execute em uma JVM separada; usa somente um banco temporario. */
public class SQLiteRegressionTest {
    public static void main(String[] args) throws Exception {
        Path directory = Files.createTempDirectory("adonai-sqlite-test-");
        Files.createDirectory(directory.resolve("data"));
        String originalDirectory = System.getProperty("user.dir");
        System.setProperty("user.dir", directory.toString());
        Connection connection = null;
        try {
            ConexaoBanco database = new ConexaoBanco();
            connection = database.connectDatabase();
            try (Statement statement = connection.createStatement()) {
                statement.execute("CREATE TABLE membros (datanascimento DATE)");
            }
            if (connection.isClosed() || connection != database.connectDatabase()) {
                throw new AssertionError("Fechar um comando nao deve fechar a conexao compartilhada");
            }
            Field field = Aniversariantes.class.getDeclaredField("MES_NASCIMENTO");
            field.setAccessible(true);
            String month = (String) field.get(null);
            String[] dates = {"1940-01-01", "1969-12-31", "1970-01-01", "2000-02-29",
                    "2001-03-01", "2026-09-30", "2026-12-31"};
            for (String value : dates) {
                try (PreparedStatement insert = connection.prepareStatement("INSERT INTO membros VALUES (?)")) {
                    insert.setDate(1, Date.valueOf(value));
                    insert.executeUpdate();
                }
                assertMonth(connection, month, LocalDate.parse(value).getMonthValue());
                try (Statement statement = connection.createStatement()) {
                    statement.executeUpdate("DELETE FROM membros");
                    statement.executeUpdate("INSERT INTO membros VALUES ('" + value + "')");
                }
                assertMonth(connection, month, LocalDate.parse(value).getMonthValue());
                try (Statement statement = connection.createStatement()) {
                    statement.executeUpdate("DELETE FROM membros");
                }
            }
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate("INSERT INTO membros VALUES (NULL)");
                try (ResultSet rs = statement.executeQuery("SELECT " + month + " FROM membros")) {
                    if (!rs.next() || rs.getObject(1) != null) throw new AssertionError("Data nula");
                }
                try (ResultSet rs = statement.executeQuery("SELECT CAST(strftime('%m', 'now', 'localtime') AS INTEGER)")) {
                    if (!rs.next() || rs.getInt(1) != LocalDate.now().getMonthValue()) {
                        throw new AssertionError("Mes atual local");
                    }
                }
            }
            connection.close();
            connection = database.connectDatabase();
            try (Statement statement = connection.createStatement();
                 ResultSet rs = statement.executeQuery("SELECT count(*) FROM membros")) {
                if (!rs.next() || rs.getInt(1) != 1) throw new AssertionError("Reabertura do mesmo banco");
            }
            System.out.println("OK: conexao compartilhada, reconexao, datas JDBC/ISO, nulas e mes atual");
        } finally {
            if (connection != null) connection.close();
            System.setProperty("user.dir", originalDirectory);
            Files.deleteIfExists(directory.resolve("data/base.db"));
            Files.delete(directory.resolve("data"));
            Files.delete(directory);
        }
    }

    private static void assertMonth(Connection connection, String expression, int expected) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT count(*) FROM membros WHERE " + expression + " = ?")) {
            statement.setInt(1, expected);
            try (ResultSet rs = statement.executeQuery()) {
                if (!rs.next() || rs.getInt(1) != 1) throw new AssertionError("Filtro do mes " + expected);
            }
        }
    }
}
