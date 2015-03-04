package controledenotas.domain.entity;

import java.io.*;
import java.util.*;
import javax.persistence.*;
import controledenotas.domain.entity.Aluno;
import controledenotas.domain.entity.Desempenho;

@Entity
@Table(name="tb_desempenho_bimestral", schema="controledenotas")
public class DesempenhoBimestral implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_bimestre", nullable=false)
	private Integer id;

	@Column(name="nota1")
	private Integer nota1;

	@Column(name="nota2")
	private Integer nota2;

	@Column(name="nota3")
	private Integer nota3;

	@Column(name="media_bimestre")
	private Integer mediaBimestre;

	@ManyToOne
	@JoinColumn(name="aluno", referencedColumnName="id_aluno")
	private Aluno aluno;

	@ManyToOne
	@JoinColumn(name="desempenho", referencedColumnName="id_desempenho")
	private Desempenho desempenho;

	public DesempenhoBimestral() {
		super();
	}

	public DesempenhoBimestral(Integer id, Integer nota1, Integer nota2, Integer nota3, Integer mediaBimestre, Aluno aluno, Desempenho desempenho) {
		this();
		this.id = id;
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.nota3 = nota3;
		this.mediaBimestre = mediaBimestre;
		this.aluno = aluno;
		this.desempenho = desempenho;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNota1() {
		return nota1;
	}

	public void setNota1(Integer nota1) {
		this.nota1 = nota1;
	}

	public Integer getNota2() {
		return nota2;
	}

	public void setNota2(Integer nota2) {
		this.nota2 = nota2;
	}

	public Integer getNota3() {
		return nota3;
	}

	public void setNota3(Integer nota3) {
		this.nota3 = nota3;
	}

	public Integer getMediaBimestre() {
		return mediaBimestre;
	}

	public void setMediaBimestre(Integer mediaBimestre) {
		this.mediaBimestre = mediaBimestre;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Desempenho getDesempenho() {
		return desempenho;
	}

	public void setDesempenho(Desempenho desempenho) {
		this.desempenho = desempenho;
	}

}
