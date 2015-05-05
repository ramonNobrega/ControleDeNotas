package controledenotas.domain.entity;

import java.io.*;
import java.util.*;
import javax.persistence.*;
import controledenotas.domain.entity.User;
import controledenotas.domain.entity.Turma;

@Entity
@Table(name="tb_aluno", schema="controledenotas")
public class Aluno implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ManyToOne(cascade=CascadeType.ALL, optional=false)
	@JoinColumn(name="id_aluno", referencedColumnName="id_user")
	private User user;

	@ManyToOne
	@JoinColumn(name="id_turma", referencedColumnName="id_turma")
	private Turma turma;

	@OneToMany(mappedBy="aluno", cascade=CascadeType.ALL, fetch=FetchType.LAZY, orphanRemoval=true)
	private List<Desempenho> desempenhos;

	@OneToMany(mappedBy="aluno", cascade=CascadeType.ALL, fetch=FetchType.LAZY, orphanRemoval=true)
	private List<DesempenhoBimestral> desempenhosBimestrais;

	public Aluno() {
		super();
		user = new User();
	}

	public Aluno(User user, Turma turma, List<Desempenho> desempenhos, List<DesempenhoBimestral> desempenhosBimestrais) {
		this();
		this.user = user;
		this.turma = turma;
		this.desempenhos = desempenhos;
		this.desempenhosBimestrais = desempenhosBimestrais;
	}

	public User getUser() {
		if (user == null) {
			user= new User();
		}
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public List<Desempenho> getDesempenhos() {
		if (desempenhos == null) {
			desempenhos = new ArrayList<Desempenho>();
		}
		return desempenhos;
	}

	public void setDesempenhos(List<Desempenho> desempenhos) {
		this.desempenhos = desempenhos;
	}

	public List<DesempenhoBimestral> getDesempenhosBimestrais() {
		if (desempenhosBimestrais == null) {
			desempenhosBimestrais = new ArrayList<DesempenhoBimestral>();
		}
		return desempenhosBimestrais;
	}

	public void setDesempenhosBimestrais(List<DesempenhoBimestral> desempenhosBimestrais) {
		this.desempenhosBimestrais = desempenhosBimestrais;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((turma == null) ? 0 : turma.hashCode());
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
		Aluno other = (Aluno) obj;
			if (user == null) {
				if (other.user != null) {
					return false;
				}
			} else if (!user.equals(other.user)) {
				return false;
			}
			if (turma == null) {
				if (other.turma != null) {
					return false;
				}
			} else if (!turma.equals(other.turma)) {
				return false;
			}
		return true;
	}

}
