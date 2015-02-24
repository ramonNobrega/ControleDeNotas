package controledenotas.domain.entity;

import java.io.*;
import java.util.*;
import javax.persistence.*;
import controledenotas.domain.entity.Professor;

@Entity
@Table(name="tb_aluno", schema="controledenotas")
public class Aluno implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_aluno", nullable=false)
	private Integer matricula;

	@Column(name="nome_aluno", length=100, nullable=false)
	private String nome;

	@Column(name="senha_aluno", length=32, nullable=false)
	private String senha;

	@ManyToOne
	@JoinColumn(name="professor", referencedColumnName="id_professor")
	private Professor professor;

	public Aluno(int matricula, String nome, String senha, Professor professor){
	super();
	this.matricula = matricula;
	this.nome = nome;
	this.senha = senha;
	this.professor = professor;
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

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	@Override
	public String toString() {
		String string = "";
		if (nome != null) {
			string += nome;
		}
		if (string.length() == 0) {
			string = super.toString();
		}
		return string;
	}

}
