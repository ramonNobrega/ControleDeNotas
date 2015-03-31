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
	private Integer codigo;

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

	public Desempenho() {
		super();
	}

	public Desempenho(Integer codigo, Integer mediaParcial, Integer provaFinal, Integer mediaFinal, String situacao, Aluno aluno) {
		this();
		this.codigo = codigo;
		this.mediaParcial = mediaParcial;
		this.provaFinal = provaFinal;
		this.mediaFinal = mediaFinal;
		this.situacao = situacao;
		this.aluno = aluno;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
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
		if (aluno == null) {
			aluno= new Aluno();
		}
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

}
