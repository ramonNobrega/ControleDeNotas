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
	private Object idDesempenho;

	@Column(name="media_parcial")
	private Object mediaParcial;

	@Column(name="prova_final")
	private Object provaFinal;

	@Column(name="media_final")
	private Object mediaFinal;

	@Column(name="situacao", length=45)
	private String situacao;

	@ManyToOne
	@JoinColumn(name="aluno", referencedColumnName="id_aluno")
	private Aluno aluno;

	public Desempenho() {
		super();
	}

	public Desempenho(Object idDesempenho, Object mediaParcial, Object provaFinal, Object mediaFinal, String situacao, Aluno aluno) {
		this();
		this.idDesempenho = idDesempenho;
		this.mediaParcial = mediaParcial;
		this.provaFinal = provaFinal;
		this.mediaFinal = mediaFinal;
		this.situacao = situacao;
		this.aluno = aluno;
	}

	public Object getIdDesempenho() {
		return idDesempenho;
	}

	public void setIdDesempenho(Object idDesempenho) {
		this.idDesempenho = idDesempenho;
	}

	public Object getMediaParcial() {
		return mediaParcial;
	}

	public void setMediaParcial(Object mediaParcial) {
		this.mediaParcial = mediaParcial;
	}

	public Object getProvaFinal() {
		return provaFinal;
	}

	public void setProvaFinal(Object provaFinal) {
		this.provaFinal = provaFinal;
	}

	public Object getMediaFinal() {
		return mediaFinal;
	}

	public void setMediaFinal(Object mediaFinal) {
		this.mediaFinal = mediaFinal;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Aluno getAluno() {
		if (aluno == null) {
			aluno= new Aluno();
		}
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

}
