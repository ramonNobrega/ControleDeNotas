package controledenotas.domain.entity;

import java.io.*;
import java.util.*;
import javax.persistence.*;

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

	public Professor() {
		super();
	}

	public Professor(Integer matricula, String nome, String senha, String disciplina) {
		this();
		this.matricula = matricula;
		this.nome = nome;
		this.senha = senha;
		this.disciplina = disciplina;
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
