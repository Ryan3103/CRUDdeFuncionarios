CREATE DATABASE IF NOT EXISTS tech;

USE tech;

CREATE TABLE IF NOT EXISTS funcionarios (
  id BIGINT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  senha VARCHAR(255) NOT NULL,
  cep VARCHAR(10) NOT NULL,
  endereco VARCHAR(255) NOT NULL,
  numero VARCHAR(10) NOT NULL,
  bairro VARCHAR(100) NOT NULL,
  cidade VARCHAR(100) NOT NULL,
  estado VARCHAR(2) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY email_UNIQUE (email)
);

CREATE TABLE IF NOT EXISTS cargos (
  id BIGINT auto_increment PRIMARY KEY,
  nome VARCHAR(90) NOT NULL,	
  descricao VARCHAR(200) NOT NULL
);

CREATE TABLE IF NOT EXISTS funcionario_por_cargo (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  funcionario_id BIGINT NOT NULL,
  cargo_id BIGINT NOT NULL,
  detalhes VARCHAR(355),
  data_inicio DATE NOT NULL,
  data_fim DATE,
  FOREIGN KEY (funcionario_id) REFERENCES funcionarios(id),
  FOREIGN KEY (cargo_id) REFERENCES cargos(id)
);