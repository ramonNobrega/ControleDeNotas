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
	private Object matriculaDoAluno;

	@Column(name="nome_aluno", length=100)
	private String nomeDoAluno;

	@Column(name="senha", length=32, nullable=false)
	private String senhaDoAluno;

	public Aluno() {
		super();
	}

	public Aluno(Object matriculaDoAluno, String nomeDoAluno, String senhaDoAluno) {
		this();
		this.matriculaDoAluno = matriculaDoAluno;
		this.nomeDoAluno = nomeDoAluno;
		this.senhaDoAluno = senhaDoAluno;
	}

	public Object getMatriculaDoAluno() {
		return matriculaDoAluno;
	}

	public void setMatriculaDoAluno(Object matriculaDoAluno) {
		this.matriculaDoAluno = matriculaDoAluno;
	}

	public String getNomeDoAluno() {
		return nomeDoAluno;
	}

	public void setNomeDoAluno(String nomeDoAluno) {
		this.nomeDoAluno = nomeDoAluno;
	}

	public String getSenhaDoAluno() {
		return senhaDoAluno;
	}

	public void setSenhaDoAluno(String senhaDoAluno) {
		this.senhaDoAluno = senhaDoAluno;
	}

}
