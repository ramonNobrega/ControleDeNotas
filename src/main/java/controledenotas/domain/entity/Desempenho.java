package controledenotas.domain.entity;

import java.io.*;
import java.util.*;
import javax.persistence.*;
import controledenotas.domain.entity.Aluno;
import controledenotas.domain.entity.User;
import controledenotas.domain.entity.Turma;

@Entity
@Table(name="tb_desempenho", schema="controledenotas")
public class Desempenho implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_desempenho", nullable=false)
	private Long codigo;

	@Column(name="media_parcial", columnDefinition="FLOAT(10) default 0")
	private Double mediaParcial;

	@Column(name="prova_final", columnDefinition="FLOAT(10) default 0")
	private Double provaFinal;

	@Column(name="media_final", columnDefinition="FLOAT(10) default 0")
	private Double mediaFinal;

	@Column(name="situacao", length=10, columnDefinition="VARCHAR(10) default 'REPROVADO'")
	private String situacao;

	@ManyToOne
	@JoinColumn(name="aluno", referencedColumnName="id_aluno")
	private Aluno aluno;

	public Desempenho() {
		super();
	}

	public Desempenho(Long codigo, Double mediaParcial, Double provaFinal, Double mediaFinal, String situacao, Aluno aluno) {
		this();
		this.codigo = codigo;
		this.mediaParcial = mediaParcial;
		this.provaFinal = provaFinal;
		this.mediaFinal = mediaFinal;
		this.situacao = situacao;
		this.aluno = aluno;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Double getMediaParcial() {
		return mediaParcial;
	}

	public void setMediaParcial(Double mediaParcial) {
		this.mediaParcial = mediaParcial;
	}

	public Double getProvaFinal() {
		return provaFinal;
	}

	public void setProvaFinal(Double provaFinal) {
		this.provaFinal = provaFinal;
	}

	public Double getMediaFinal() {
		return mediaFinal;
	}

	public void setMediaFinal(Double mediaFinal) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((mediaParcial == null) ? 0 : mediaParcial.hashCode());
		result = prime * result + ((provaFinal == null) ? 0 : provaFinal.hashCode());
		result = prime * result + ((mediaFinal == null) ? 0 : mediaFinal.hashCode());
		result = prime * result + ((situacao == null) ? 0 : situacao.hashCode());
		result = prime * result + ((aluno == null) ? 0 : aluno.hashCode());
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
		Desempenho other = (Desempenho) obj;
			if (codigo == null) {
				if (other.codigo != null) {
					return false;
				}
			} else if (!codigo.equals(other.codigo)) {
				return false;
			}
			if (mediaParcial == null) {
				if (other.mediaParcial != null) {
					return false;
				}
			} else if (!mediaParcial.equals(other.mediaParcial)) {
				return false;
			}
			if (provaFinal == null) {
				if (other.provaFinal != null) {
					return false;
				}
			} else if (!provaFinal.equals(other.provaFinal)) {
				return false;
			}
			if (mediaFinal == null) {
				if (other.mediaFinal != null) {
					return false;
				}
			} else if (!mediaFinal.equals(other.mediaFinal)) {
				return false;
			}
			if (situacao == null) {
				if (other.situacao != null) {
					return false;
				}
			} else if (!situacao.equals(other.situacao)) {
				return false;
			}
			if (aluno == null) {
				if (other.aluno != null) {
					return false;
				}
			} else if (!aluno.equals(other.aluno)) {
				return false;
			}
		return true;
	}

}
