package controledenotas.domain.entity;

import java.io.*;
import java.util.*;
import javax.persistence.*;

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

	public Aluno() {
		super();
	}

	public Aluno(Integer matricula, String nome, String senha) {
		this();
		this.matricula = matricula;
		this.nome = nome;
		this.senha = senha;
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

}
