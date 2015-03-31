package controledenotas.domain.entity;

import java.io.*;
import java.util.*;
import javax.persistence.*;
import controledenotas.domain.entity.Turma;

@Entity
@Table(name="tb_professor", schema="controledenotas")
public class Professor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_professor", nullable=false)
	private Integer matricula;

	@Column(name="nome_professor", length=100, nullable=false)
	private String nome;

	@Column(name="senha_professor", length=32, nullable=false)
	private String senha;

	@Column(name="disciplina", length=100)
	private String disciplina;

	@ManyToOne
	@JoinColumn(name="turma", referencedColumnName="id_turma")
	private Turma turma;

	public Professor() {
		super();
	}

	public Professor(Integer matricula, String nome, String senha, String disciplina, Turma turma) {
		this();
		this.matricula = matricula;
		this.nome = nome;
		this.senha = senha;
		this.disciplina = disciplina;
		this.turma = turma;
	}

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public Turma getTurma() {
		if (turma == null) {
			turma= new Turma();
		}
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

}
