package controledenotas.domain.entity;

import java.io.*;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name="tb_aluno", schema="controledenotas")
public class Aluno implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_aluno", nullable=false, updatable=false)
	private Integer matricula;

	@Column(name="nome_aluno", length=100, nullable=false, updatable=false)
	private String nome;

	@Column(name="senha_aluno", length=32, nullable=false, updatable=false)
	private String senha;

	@OneToMany(mappedBy="aluno", cascade=CascadeType.ALL, fetch=FetchType.LAZY, orphanRemoval=true)
	private List<Desempenho> desempenhosList;

	@OneToMany(mappedBy="aluno", cascade=CascadeType.ALL, fetch=FetchType.LAZY, orphanRemoval=true)
	private List<DesempenhoBimestral> desempenhoBimestralList;

	@OneToMany(mappedBy="matriculaAluno", cascade=CascadeType.ALL, fetch=FetchType.LAZY, orphanRemoval=true)
	private List<Turma> turmaList;

	public Aluno() {
		super();
	}

	public Aluno(Integer matricula, String nome, String senha, List<Desempenho> desempenhosList, List<DesempenhoBimestral> desempenhoBimestralList, List<Turma> turmaList) {
		this();
		this.matricula = matricula;
		this.nome = nome;
		this.senha = senha;
		this.desempenhosList = desempenhosList;
		this.desempenhoBimestralList = desempenhoBimestralList;
		this.turmaList = turmaList;
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

	public List<Desempenho> getDesempenhosList() {
		if (desempenhosList == null) {
			desempenhosList = new ArrayList<Desempenho>();
		}
		return desempenhosList;
	}

	public void setDesempenhosList(List<Desempenho> desempenhosList) {
		this.desempenhosList = desempenhosList;
	}

	public List<DesempenhoBimestral> getDesempenhoBimestralList() {
		if (desempenhoBimestralList == null) {
			desempenhoBimestralList = new ArrayList<DesempenhoBimestral>();
		}
		return desempenhoBimestralList;
	}

	public void setDesempenhoBimestralList(List<DesempenhoBimestral> desempenhoBimestralList) {
		this.desempenhoBimestralList = desempenhoBimestralList;
	}

	public List<Turma> getTurmaList() {
		if (turmaList == null) {
			turmaList = new ArrayList<Turma>();
		}
		return turmaList;
	}

	public void setTurmaList(List<Turma> turmaList) {
		this.turmaList = turmaList;
	}

}
