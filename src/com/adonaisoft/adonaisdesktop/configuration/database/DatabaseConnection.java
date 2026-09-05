/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.adonaisoft.adonaisdesktop.configuration.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author geovane
 */
public class DatabaseConnection {
    
    private static DatabaseConnection instance;
    private Connection connection;

    private final String url = "jdbc:sqlite:" + System.getProperty("user.dir") + "/data/base.db";

    private DatabaseConnection() {
        try {
            
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException("Erro ao conectar ao banco SQLite", e);
        }
    }

    public static synchronized DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    /** A conexao pertence a aplicacao; os chamadores fecham apenas statements e resultados. */
    public synchronized Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(url);
            }
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao reconectar ao banco SQLite", e);
        }
    }
}
