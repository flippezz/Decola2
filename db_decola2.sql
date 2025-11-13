CREATE DATABASE IF NOT EXISTS db_decola;
USE db_decola;

CREATE TABLE IF NOT EXISTS usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS profissoes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS empregos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    profissao_id INT,
    FOREIGN KEY (profissao_id) REFERENCES profissoes(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS profissao_emprego (
    profissao_id INT,
    emprego_id INT,
    PRIMARY KEY(profissao_id, emprego_id),
    FOREIGN KEY (profissao_id) REFERENCES profissoes(id) ON DELETE CASCADE,
    FOREIGN KEY (emprego_id) REFERENCES empregos(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS teste_vocacional (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT,
    resultado VARCHAR(100),
    FOREIGN KEY (usuario_id) REFERENCES usuario(id) ON DELETE CASCADE
);

INSERT INTO profissoes (nome) VALUES
('Ciências Exatas, da Terra e Engenharias'),
('Ciências Biológicas e da Saúde'),
('Ciências Humanas e Sociais');

INSERT INTO empregos (nome, profissao_id) VALUES
('Engenharia Civil', 1),
('Cientista da Computação', 1),
('Engenheiro de Software', 1),
('Arquiteto e Urbanista', 1),
('Médico', 2),
('Enfermeiro', 2),
('Psicólogo', 2),
('Biólogo', 2),
('Nutricionista', 2),
('Advogado', 3),
('Administrador', 3),
('Jornalista', 3),
('Professor', 3),
('Designer Gráfico', 3);
