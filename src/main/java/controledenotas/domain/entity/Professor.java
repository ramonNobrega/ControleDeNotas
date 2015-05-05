package controledenotas.domain.entity;

import java.io.*;
import java.util.*;
import javax.persistence.*;
import controledenotas.domain.entity.User;
import controledenotas.domain.entity.Turma;

@Entity
@Table(name="tb_professor", schema="controledenotas")
public class Professor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@OneToOne(cascade=CascadeType.ALL, optional=false, orphanRemoval=true)
	@JoinColumn(name="id_professor", referencedColumnName="id_user")
	private User user;

	@Column(name="disciplina", length=100)
	private String disciplina;

	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="turma", referencedColumnName="id_turma")
	private Turma turma;

	public Professor() {
		super();
		user = new User();
	}

	public Professor(User user, String disciplina, Turma turma) {
		this();
		this.user = user;
		this.disciplina = disciplina;
		this.turma = turma;
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

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((disciplina == null) ? 0 : disciplina.hashCode());
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
		Professor other = (Professor) obj;
			if (user == null) {
				if (other.user != null) {
					return false;
				}
			} else if (!user.equals(other.user)) {
				return false;
			}
			if (disciplina == null) {
				if (other.disciplina != null) {
					return false;
				}
			} else if (!disciplina.equals(other.disciplina)) {
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
