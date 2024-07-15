  CREATE TABLE topicos (
       id BIGINT AUTO_INCREMENT PRIMARY KEY,
       titulo VARCHAR(100) NOT NULL,
       mensagem TEXT NOT NULL,
       data TIMESTAMP NOT NULL,
       status VARCHAR(50) NULL,
       autor VARCHAR(100) NOT NULL,
       curso VARCHAR(100) NOT NULL,
       respostas TEXT
  );