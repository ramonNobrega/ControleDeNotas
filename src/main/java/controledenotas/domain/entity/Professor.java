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
	private Object matriculaDoProfessor;

	@Column(name="nome_professor", length=100)
	private String nomeDoProfessor;

	@Column(name="senha", length=32, nullable=false)
	private String senhaDoProfessor;

	@Column(name="disciplina", length=100)
	private String disciplina;

	@ManyToOne
	@JoinColumn(name="turma", referencedColumnName="id_turma")
	private Turma turma;

	public Professor() {
		super();
	}

	public Professor(Object matriculaDoProfessor, String nomeDoProfessor, String senhaDoProfessor, String disciplina, Turma turma) {
		this();
		this.matriculaDoProfessor = matriculaDoProfessor;
		this.nomeDoProfessor = nomeDoProfessor;
		this.senhaDoProfessor = senhaDoProfessor;
		this.disciplina = disciplina;
		this.turma = turma;
	}

	public Object getMatriculaDoProfessor() {
		return matriculaDoProfessor;
	}

	public void setMatriculaDoProfessor(Object matriculaDoProfessor) {
		this.matriculaDoProfessor = matriculaDoProfessor;
	}

	public String getNomeDoProfessor() {
		return nomeDoProfessor;
	}

	public void setNomeDoProfessor(String nomeDoProfessor) {
		this.nomeDoProfessor = nomeDoProfessor;
	}

	public String getSenhaDoProfessor() {
		return senhaDoProfessor;
	}

	public void setSenhaDoProfessor(String senhaDoProfessor) {
		this.senhaDoProfessor = senhaDoProfessor;
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
