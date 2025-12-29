/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  geovane
 * Created: 11 de dez de 2022
 */

CREATE TABLE caixas
(
    codigocaixa integer PRIMARY KEY AUTOINCREMENT,
    descricaocaixa varchar(50) NOT NULL,
    dataabertura date NOT NULL,
    datafechamento date,
    saldo real,
    entradas real,
    saidas real,
    saldoinicial real,
    status varchar(15),
    quemfechou varchar(50)
);

CREATE TABLE cargo
(
    idcargo integer PRIMARY KEY AUTOINCREMENT,
    descricao varchar(50)
);

CREATE TABLE chamada
(
    id integer PRIMARY KEY AUTOINCREMENT,
    idclasse integer,
    datachamada date,
    presentes integer,
    ausentes integer,
    visitas integer,
    ofertas real,
    total integer,
	FOREIGN KEY (idclasse)  REFERENCES classe (idclasse)
);

CREATE TABLE classe
(
    idclasse integer PRIMARY KEY AUTOINCREMENT,
    descricao varchar(50)
);

CREATE TABLE configuracoes
(
    codiigreja integer PRIMARY KEY AUTOINCREMENT,
    nomeigreja varchar(70) NOT NULL,
    cnpjigreja varchar(20) NOT NULL,
    cep varchar(10),
    enderecoigreja varchar(70),
    bairroigreja varchar(50),
    cidadeigreja varchar(50),
    numero integer,
    estadoigreja varchar(2),
    telefoneigreja varchar(15),
    email varchar(60),
    pastorigreja varchar(60),
    pastorpresidente varchar(60),
    igrejasede varchar(50),
    secretarioigreja varchar(50),
    tesoureiroigreja varchar(50),
    pedirsenha boolean,
    tema varchar(50)
);

CREATE TABLE duplicatas
(
    id integer PRIMARY KEY AUTOINCREMENT,
    descricao varchar(50) NOT NULL,
    datac date NOT NULL,
    datav date,
    datap date,
    quempagou varchar(50),
    status varchar(30),
    valor real,
    observacoes varchar(500),
    tipo integer,
    idtipo integer,
    idcaixa integer,
    idmembro integer,
	FOREIGN KEY (idcaixa)  REFERENCES caixas (codigocaixa),
	FOREIGN KEY (idmembro)  REFERENCES membros (codigomembro),
	FOREIGN KEY (idtipo)  REFERENCES tipo (idtipo)
);

CREATE TABLE globais
(
    id_globais integer PRIMARY KEY AUTOINCREMENT,
    imagem bytea,
    testorelatório varchar(500),
    smpt varchar(50),
    porta integer,
    email varchar(70),
    senha varchar(50),
    usuario varchar(50),
    autenticacao varchar(50)
);

CREATE TABLE historicovisita
(
    codigovisitante integer PRIMARY KEY AUTOINCREMENT,
    idvisitante integer,
    datavisita date,
    anotacoes varchar(500),
	FOREIGN KEY (idvisitante)  REFERENCES visitantes (codigovisitante)
);

CREATE TABLE igrejas
(
    id_igreja integer PRIMARY KEY AUTOINCREMENT,
    nomeigreja varchar(70),
    telefone varchar(15),
    email varchar(70),
    pastorresponsavel varchar(70),
    endereco varchar(70),
    numero integer,
    bairro varchar(70),
    cidade varchar(70),
    uf varchar(2),
    cep varchar(9)
);

CREATE TABLE membros
(
    codigomembro integer PRIMARY KEY AUTOINCREMENT,
    nomecompleto varchar(70) NOT NULL,
    datanascimento date,
    telefone varchar(15),
    endereco varchar(70),
    bairro varchar(30),
    cidade varchar(50),
    numero integer,
    uf varchar(2),
    ativo boolean,
    idcargo integer,
    observacoes varchar(500),
    databatismo varchar(15),
    cep varchar(10),
    estadocivil varchar(15),
    imagem bytea,
    batizado boolean,
    email varchar(70),
	FOREIGN KEY (idcargo)  REFERENCES cargo (idcargo)
);

CREATE TABLE novoconvertido
(
    id_novoconverido integer PRIMARY KEY AUTOINCREMENT,
    nomeconvertido varchar(70),
    endereco varchar(60),
    bairro varchar(50),
    numero integer,
    cidade varchar(50),
    uf varchar(2),
    dataconversao date,
    obs varchar(500),
    telefone varchar(15),
    cep varchar(11)
);

CREATE TABLE registrochamada
(
    id integer PRIMARY KEY AUTOINCREMENT,
    idchamada integer,
    idmatriculado integer,
    presente boolean,
	FOREIGN KEY (idchamada)  REFERENCES chamada (id),
	FOREIGN KEY (idmatriculado)  REFERENCES membros (codigomembro)
);

CREATE TABLE tipo
(
    idtipo integer PRIMARY KEY AUTOINCREMENT,
    descricao varchar(50),
    pconta varchar(20)
);

CREATE TABLE turma
(
    idturma integer PRIMARY KEY AUTOINCREMENT,
    idclasse integer,
    idaluno integer,
    tipo integer,
	FOREIGN KEY (idaluno)  REFERENCES membros (codigomembro),
	FOREIGN KEY (idclasse) REFERENCES classe (idclasse)
);

CREATE TABLE usuario
(
    codigousuario integer PRIMARY KEY AUTOINCREMENT,
    nomeusuario varchar(30) NOT NULL,
    senha varchar(15) NOT NULL,
    confirmarsenha varchar(15) NOT NULL,
    membros boolean,
    despesas boolean,
    entradas boolean,
    caixas boolean,
    configuracoes boolean,
    usuarios boolean,
    relatorios boolean
);

CREATE TABLE visitantes
(
    codigovisitante integer PRIMARY KEY AUTOINCREMENT,
    nomevisitante varchar(50),
    datavisita date,
    denominacao varchar(50),
    cidade varchar(50),
    uf varchar(2)
);