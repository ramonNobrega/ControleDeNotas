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
	private Integer codigo;

	@ManyToOne
	@JoinColumn(name="id_aluno", referencedColumnName="id_aluno")
	private Aluno matriculaAluno;

	public Turma() {
		super();
	}

	public Turma(Integer codigo, Aluno matriculaAluno) {
		this();
		this.codigo = codigo;
		this.matriculaAluno = matriculaAluno;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Aluno getMatriculaAluno() {
		if (matriculaAluno == null) {
			matriculaAluno= new Aluno();
		}
		return matriculaAluno;
	}

	public void setMatriculaAluno(Aluno matriculaAluno) {
		this.matriculaAluno = matriculaAluno;
	}

}
