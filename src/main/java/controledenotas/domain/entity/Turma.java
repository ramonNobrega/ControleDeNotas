package controledenotas.domain.entity;

import java.io.*;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name="tb_turma", schema="controledenotas")
public class Turma implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_turma", nullable=false)
	private Integer codigo;

	@Column(name="nm_turma", length=3, nullable=false)
	private String nome;

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, orphanRemoval=true)
	private List<Aluno> alunos;

	@OneToMany(mappedBy="turma", cascade=CascadeType.ALL, fetch=FetchType.LAZY, orphanRemoval=true)
	private List<Professor> professores;

	public Turma() {
		super();
	}

	public Turma(Integer codigo, String nome, List<Aluno> alunos, List<Professor> professores) {
		this();
		this.codigo = codigo;
		this.nome = nome;
		this.alunos = alunos;
		this.professores = professores;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public List<Professor> getProfessores() {
		if (professores == null) {
			professores = new ArrayList<Professor>();
		}
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Turma other = (Turma) obj;
			if (codigo == null) {
				if (other.codigo != null) {
					return false;
				}
			} else if (!codigo.equals(other.codigo)) {
				return false;
			}
			if (nome == null) {
				if (other.nome != null) {
					return false;
				}
			} else if (!nome.equals(other.nome)) {
				return false;
			}
		return true;
	}

}
