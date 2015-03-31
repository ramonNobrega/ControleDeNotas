CREATE TABLE IF NOT EXISTS controledenotas.tb_aluno (
	id_aluno INT NOT NULL,
	nome_aluno VARCHAR(100) NOT NULL,
	senha_aluno VARCHAR(32) NOT NULL
);
ALTER TABLE controledenotas.tb_aluno ADD CONSTRAINT pk_tb_aluno PRIMARY KEY(id_aluno);

CREATE TABLE IF NOT EXISTS controledenotas.tb_desempenho (
	id_desempenho INT NOT NULL,
	media_parcial INT,
	prova_final INT,
	media_final INT,
	situacao VARCHAR(10),
	aluno INT
);
ALTER TABLE controledenotas.tb_desempenho ADD CONSTRAINT pk_tb_desempenho PRIMARY KEY(id_desempenho);

CREATE TABLE IF NOT EXISTS controledenotas.tb_desempenho_bimestral (
	id_bimestre INT NOT NULL,
	nota1 INT,
	nota2 INT,
	nota3 INT,
	media_bimestre INT,
	aluno INT,
	desempenho INT
);
ALTER TABLE controledenotas.tb_desempenho_bimestral ADD CONSTRAINT pk_tb_desempenho_bimestral PRIMARY KEY(id_bimestre);

CREATE TABLE IF NOT EXISTS controledenotas.tb_professor (
	id_professor INT NOT NULL,
	nome_professor VARCHAR(100) NOT NULL,
	senha_professor VARCHAR(32) NOT NULL,
	disciplina VARCHAR(100),
	turma INT
);
ALTER TABLE controledenotas.tb_professor ADD CONSTRAINT pk_tb_professor PRIMARY KEY(id_professor);

CREATE TABLE IF NOT EXISTS controledenotas.tb_turma (
	id_turma INT NOT NULL,
	id_aluno INT
);
ALTER TABLE controledenotas.tb_turma ADD CONSTRAINT pk_tb_turma PRIMARY KEY(id_turma);


ALTER TABLE controledenotas.tb_desempenho ADD CONSTRAINT fk_tb_desempenho_id_aluno FOREIGN KEY (aluno) REFERENCES controledenotas.tb_aluno (id_aluno);
ALTER TABLE controledenotas.tb_desempenho_bimestral ADD CONSTRAINT fk_tb_desempenho_bimestral_id_aluno FOREIGN KEY (aluno) REFERENCES controledenotas.tb_aluno (id_aluno);
ALTER TABLE controledenotas.tb_desempenho_bimestral ADD CONSTRAINT fk_tb_desempenho_bimestral_tb_desempenho FOREIGN KEY (desempenho) REFERENCES controledenotas.tb_desempenho (id_desempenho);
ALTER TABLE controledenotas.tb_professor ADD CONSTRAINT fk_tb_professor_id_turma FOREIGN KEY (turma) REFERENCES controledenotas.tb_turma (id_turma);
ALTER TABLE controledenotas.tb_turma ADD CONSTRAINT fk_tb_turma_id_aluno FOREIGN KEY (id_aluno) REFERENCES controledenotas.tb_aluno (id_aluno);
