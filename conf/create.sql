CREATE TABLE IF NOT EXISTS controledenotas.tb_aluno (
	id_aluno INTEGER NOT NULL,
	nome_aluno VARCHAR(100),
	senha VARCHAR(32) NOT NULL
);
ALTER TABLE tb_aluno ADD CONSTRAINT pk_aluno PRIMARY KEY(id_aluno);

CREATE TABLE IF NOT EXISTS controledenotas.tb_desempenho (
	id_desempenho INTEGER NOT NULL,
	media_parcial INTEGER,
	prova_final INTEGER,
	media_final INTEGER,
	situacao VARCHAR(45),
	aluno INTEGER
);
ALTER TABLE tb_desempenho ADD CONSTRAINT pk_desempenho PRIMARY KEY(id_desempenho);

CREATE TABLE IF NOT EXISTS controledenotas.tb_desempenho_bimestral (
	id_bimestre INTEGER NOT NULL,
	nota1 INTEGER,
	nota2 INTEGER,
	nota3 INTEGER,
	media_bimestre INTEGER,
	desempenho INTEGER
);
ALTER TABLE tb_desempenho_bimestral ADD CONSTRAINT pk_desempenho_bimestral PRIMARY KEY(id_bimestre);

CREATE TABLE IF NOT EXISTS controledenotas.tb_professor (
	id_professor INTEGER NOT NULL,
	nome_professor VARCHAR(100),
	senha VARCHAR(32) NOT NULL,
	disciplina VARCHAR(100),
	turma INTEGER
);
ALTER TABLE tb_professor ADD CONSTRAINT pk_professor PRIMARY KEY(id_professor);

CREATE TABLE IF NOT EXISTS controledenotas.tb_turma (
	id_turma INTEGER NOT NULL,
	id_aluno INTEGER
);
ALTER TABLE tb_turma ADD CONSTRAINT pk_turma PRIMARY KEY(id_turma);


ALTER TABLE controledenotas.tb_desempenho ADD CONSTRAINT fk_tb_desempenho_id_aluno FOREIGN KEY (aluno) REFERENCES tb_aluno (id_aluno);
ALTER TABLE controledenotas.tb_desempenho_bimestral ADD CONSTRAINT fk_tb_desempenho_bimestral_id_desempenho FOREIGN KEY (desempenho) REFERENCES tb_desempenho (id_desempenho);
ALTER TABLE controledenotas.tb_professor ADD CONSTRAINT fk_tb_professor_id_turma FOREIGN KEY (turma) REFERENCES tb_turma (id_turma);
ALTER TABLE controledenotas.tb_turma ADD CONSTRAINT fk_tb_turma_id_aluno FOREIGN KEY (id_aluno) REFERENCES tb_aluno (id_aluno);
