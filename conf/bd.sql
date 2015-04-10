CREATE TABLE controledenotas.tb_aluno (
	id_aluno INT NOT NULL AUTO_INCREMENT,
	nome_aluno VARCHAR(100) NOT NULL,
	senha_aluno VARCHAR(32) NOT NULL,
    CONSTRAINT pk_tb_aluno PRIMARY KEY(id_aluno)
);

CREATE TABLE controledenotas.tb_desempenho (
	id_desempenho INT NOT NULL AUTO_INCREMENT,
	media_parcial FLOAT NOT NULL DEFAULT 0,
	prova_final FLOAT NOT NULL DEFAULT 0,
	media_final FLOAT NOT NULL DEFAULT 0,
	situacao VARCHAR(10) NOT NULL DEFAULT 'REPROVADO',
	aluno INT,
    CONSTRAINT pk_tb_desempenho PRIMARY KEY(id_desempenho)
);

CREATE TABLE controledenotas.tb_desempenho_bimestral (
	id_bimestre INT NOT NULL AUTO_INCREMENT,
	nu_bim INT NOT NULL,
	nota1 FLOAT NOT NULL DEFAULT 0,
	nota2 FLOAT NOT NULL DEFAULT 0,
	nota3 FLOAT NOT NULL DEFAULT 0,
	media_bimestre INT NOT NULL DEFAULT 0,
	aluno INT,
    CONSTRAINT pk_tb_desempenho_bimestral PRIMARY KEY(id_bimestre)
);

CREATE TABLE controledenotas.tb_professor (
	id_professor INT NOT NULL,
	nome_professor VARCHAR(100) NOT NULL,
	senha_professor VARCHAR(32) NOT NULL,
	disciplina VARCHAR(100),
	turma INT,
    CONSTRAINT pk_tb_professor PRIMARY KEY(id_professor)
);

CREATE table controledenotas.tb_turma (
	id_turma INT NOT NULL,
	id_aluno INT,
    CONSTRAINT pk_tb_turma PRIMARY KEY(id_turma)
);

ALTER TABLE controledenotas.tb_turma ADD CONSTRAINT fk_tb_turma_id_aluno FOREIGN KEY (id_aluno) REFERENCES controledenotas.tb_aluno (id_aluno);
ALTER TABLE controledenotas.tb_professor ADD CONSTRAINT fk_tb_professor_id_turma FOREIGN KEY (turma) REFERENCES controledenotas.tb_turma (id_turma);
ALTER TABLE controledenotas.tb_desempenho ADD CONSTRAINT fk_tb_desempenho_id_aluno FOREIGN KEY (aluno) REFERENCES controledenotas.tb_aluno (id_aluno);
ALTER TABLE controledenotas.tb_desempenho_bimestral ADD CONSTRAINT fk_tb_desempenho_bimestral_id_aluno FOREIGN KEY (aluno) REFERENCES controledenotas.tb_aluno (id_aluno);