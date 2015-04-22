package controledenotas.domain.entity;

import java.io.*;
import java.util.*;
import javax.persistence.*;
import controledenotas.domain.entity.Aluno;

@Entity
@Table(name="tb_desempenho_bimestral", schema="controledenotas")
public class DesempenhoBimestral implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_bimestre", nullable=false, columnDefinition="INT default 1")
	private Integer idBimestre;

	@Column(name="nota1", columnDefinition="FLOAT default 0")
	private Double nota1;

	@Column(name="nota2", columnDefinition="FLOAT default 0")
	private Double nota2;

	@Column(name="nota3", columnDefinition="FLOAT default 0")
	private Double nota3;

	@Column(name="media_bimestre")
	private double mediaBimestre;

	/*Opção oculta do mapeamento*/
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="aluno", referencedColumnName="id_aluno")
	private Aluno aluno;

	@Column(name="nu_bim", nullable=false)
	private Integer nu_bim;

	public DesempenhoBimestral() {
		super();
	}

	public DesempenhoBimestral(Integer idBimestre, Double nota1, Double nota2, Double nota3, Integer mediaBimestre, Aluno aluno, Integer nu_bim) {
		this();
		this.idBimestre = idBimestre;
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.nota3 = nota3;
		setMediaBimestre((nota1+nota2+nota3)/3);
		this.aluno = aluno;
		this.nu_bim = nu_bim;
	}

	public Integer getIdBimestre() {
		return idBimestre;
	}

	public void setIdBimestre(Integer idBimestre) {
		this.idBimestre = idBimestre;
	}

	public Double getNota1() {
		return nota1;
	}

	public void setNota1(Double nota1) {
		this.nota1 = nota1;
	}

	public Double getNota2() {
		return nota2;
	}

	public void setNota2(Double nota2) {
		this.nota2 = nota2;
	}

	public Double getNota3() {
		return nota3;
	}

	public void setNota3(Double nota3) {
		this.nota3 = nota3;
	}

	public double getMediaBimestre() {
		return mediaBimestre;
	}

	public void setMediaBimestre(double media) {
		this.mediaBimestre = media;
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

	public Integer getNu_bim() {
		return nu_bim;
	}

	public void setNu_bim(Integer nu_bim) {
		this.nu_bim = nu_bim;
	}

}
