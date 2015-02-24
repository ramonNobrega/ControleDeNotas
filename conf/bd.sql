CREATE TABLE IF NOT EXISTS controledenotas.tb_aluno (
	id_aluno INT NOT NULL,
	nome_aluno VARCHAR(100) NOT NULL,
	senha_aluno VARCHAR(32) NOT NULL,
	professor INT
);
ALTER TABLE controledenotas.tb_aluno ADD CONSTRAINT pk_aluno PRIMARY KEY(id_aluno);

CREATE TABLE IF NOT EXISTS controledenotas.tb_desempenho (
	id_desempenho INT NOT NULL,
	media_parcial INT,
	prova_final INT,
	media_final INT,
	situacao VARCHAR(10),
	aluno INT
);
ALTER TABLE controledenotas.tb_desempenho ADD CONSTRAINT pk_desempenho PRIMARY KEY(id_desempenho);

CREATE TABLE IF NOT EXISTS controledenotas.tb_desempenho_bimestral (
	id_bimestre INT NOT NULL,
	nota1 INT,
	nota2 INT,
	nota3 INT,
	media_bimestre INT,
	aluno INT,
	desempenho INT
);
ALTER TABLE controledenotas.tb_desempenho_bimestral ADD CONSTRAINT pk_desempenho_bimestral PRIMARY KEY(id_bimestre);

CREATE TABLE IF NOT EXISTS controledenotas.tb_professor (
	id_professor INT NOT NULL,
	nome_professor VARCHAR(100) NOT NULL,
	senha_professor VARCHAR(32) NOT NULL,
	disciplina VARCHAR(100)
);
ALTER TABLE controledenotas.tb_professor ADD CONSTRAINT pk_professor PRIMARY KEY(id_professor);


ALTER TABLE controledenotas.tb_aluno ADD CONSTRAINT fk_tb_aluno_id_professor FOREIGN KEY (professor) REFERENCES controledenotas.tb_professor (id_professor);
ALTER TABLE controledenotas.tb_desempenho ADD CONSTRAINT fk_tb_desempenho_id_aluno FOREIGN KEY (aluno) REFERENCES controledenotas.tb_aluno (id_aluno);
ALTER TABLE controledenotas.tb_desempenho_bimestral ADD CONSTRAINT fk_tb_desempenho_bimestral_id_aluno FOREIGN KEY (aluno) REFERENCES controledenotas.tb_aluno (id_aluno);
ALTER TABLE controledenotas.tb_desempenho_bimestral ADD CONSTRAINT fk_tb_desempenho_bimestral_id_desempenho FOREIGN KEY (desempenho) REFERENCES controledenotas.tb_desempenho (id_desempenho);
