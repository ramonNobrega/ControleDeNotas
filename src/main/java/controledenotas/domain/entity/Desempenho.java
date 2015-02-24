package controledenotas.domain.entity;

import java.io.*;
import java.util.*;
import javax.persistence.*;
import controledenotas.domain.entity.Aluno;

@Entity
@Table(name="tb_desempenho", schema="controledenotas")
public class Desempenho implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_desempenho", nullable=false)
	private Integer matricula;

	@Column(name="media_parcial")
	private Integer mediaParcial;

	@Column(name="prova_final")
	private Integer provaFinal;

	@Column(name="media_final")
	private Integer mediaFinal;

	@Column(name="situacao", length=10)
	private String situacao;

	@ManyToOne
	@JoinColumn(name="aluno", referencedColumnName="id_aluno")
	private Aluno aluno;

	public Desempenho(int matricula, Aluno aluno){
	super();
	this.matricula = matricula;
	this.aluno = aluno;
	}

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public Integer getMediaParcial() {
		return mediaParcial;
	}

	public void setMediaParcial(Integer mediaParcial) {
		this.mediaParcial = mediaParcial;
	}

	public Integer getProvaFinal() {
		return provaFinal;
	}

	public void setProvaFinal(Integer provaFinal) {
		this.provaFinal = provaFinal;
	}

	public Integer getMediaFinal() {
		return mediaFinal;
	}

	public void setMediaFinal(Integer mediaFinal) {
		this.mediaFinal = mediaFinal;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

}
