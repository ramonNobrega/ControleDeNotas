package controledenotas.domain.entity;

import java.io.*;
import java.util.*;
import javax.persistence.*;
import controledenotas.domain.entity.Desempenho;

@Entity
@Table(name="tb_desempenho_bimestral", schema="controledenotas")
public class DesempenhoBimestral implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_bimestre", nullable=false)
	private Object idBimestre;

	@Column(name="nota1")
	private Object nota1;

	@Column(name="nota2")
	private Object nota2;

	@Column(name="nota3")
	private Object nota3;

	@Column(name="media_bimestre")
	private Object mediaBimestre;

	@ManyToOne
	@JoinColumn(name="desempenho", referencedColumnName="id_desempenho")
	private Desempenho desempenho;

	public DesempenhoBimestral() {
		super();
	}

	public DesempenhoBimestral(Object idBimestre, Object nota1, Object nota2, Object nota3, Object mediaBimestre, Desempenho desempenho) {
		this();
		this.idBimestre = idBimestre;
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.nota3 = nota3;
		this.mediaBimestre = mediaBimestre;
		this.desempenho = desempenho;
	}

	public Object getIdBimestre() {
		return idBimestre;
	}

	public void setIdBimestre(Object idBimestre) {
		this.idBimestre = idBimestre;
	}

	public Object getNota1() {
		return nota1;
	}

	public void setNota1(Object nota1) {
		this.nota1 = nota1;
	}

	public Object getNota2() {
		return nota2;
	}

	public void setNota2(Object nota2) {
		this.nota2 = nota2;
	}

	public Object getNota3() {
		return nota3;
	}

	public void setNota3(Object nota3) {
		this.nota3 = nota3;
	}

	public Object getMediaBimestre() {
		return mediaBimestre;
	}

	public void setMediaBimestre(Object mediaBimestre) {
		this.mediaBimestre = mediaBimestre;
	}

	public Desempenho getDesempenho() {
		if (desempenho == null) {
			desempenho= new Desempenho();
		}
		return desempenho;
	}

	public void setDesempenho(Desempenho desempenho) {
		this.desempenho = desempenho;
	}

}
