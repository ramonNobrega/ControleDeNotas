package controledenotas.domain.entity;

import java.io.*;
import java.util.*;
import javax.persistence.*;
import controledenotas.domain.entity.Aluno;

@Entity
@Table(name="tb_turma", schema="controledenotas")
public class Turma implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_turma", nullable=false)
	private Object idTurma;

	@ManyToOne
	@JoinColumn(name="id_aluno", referencedColumnName="id_aluno")
	private Aluno matriculaDoAluno;

	public Turma() {
		super();
	}

	public Turma(Object idTurma, Aluno matriculaDoAluno) {
		this();
		this.idTurma = idTurma;
		this.matriculaDoAluno = matriculaDoAluno;
	}

	public Object getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(Object idTurma) {
		this.idTurma = idTurma;
	}

	public Aluno getMatriculaDoAluno() {
		if (matriculaDoAluno == null) {
			matriculaDoAluno= new Aluno();
		}
		return matriculaDoAluno;
	}

	public void setMatriculaDoAluno(Aluno matriculaDoAluno) {
		this.matriculaDoAluno = matriculaDoAluno;
	}

}
