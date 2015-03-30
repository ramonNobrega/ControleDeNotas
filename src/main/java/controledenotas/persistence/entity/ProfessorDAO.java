package controledenotas.persistence.entity;

import java.util.*;
import javax.inject.Inject;
import javax.persistence.*;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;

import controledenotas.domain.entity.Professor;
import br.gov.frameworkdemoiselle.template.JPACrud;
import javax.persistence.criteria.*;

@PersistenceController
public class ProfessorDAO extends JPACrud<Professor, Object> {

	private static final long serialVersionUID = 1L;

	@Override
	public List<Professor> findByExample(Professor example) {
		if (example == null) {
			example = new Professor();
		}
		return super.findByExample(example);
	}

	public List<Professor> findByCriteria(java.util.Map<String, Object> parameters) {
		if (parameters == null) {
			parameters = new java.util.HashMap<String, Object>();
		}
		CriteriaBuilder cb = super.getCriteriaBuilder();
		CriteriaQuery<Professor> q = cb.createQuery(Professor.class);
		Root<Professor> r = q.from(Professor.class);
		Predicate where = null;
		Object parameter = null; 
		parameter = parameters.get("matriculaDoProfessor");
		if (parameter != null) {
			Predicate expression = null;
			if (parameter instanceof java.util.List<?>) {
				@SuppressWarnings("unchecked")
				List<Object> collection = (List<Object>)parameter;
				expression = r.get("matriculaDoProfessor").in(collection);
			} else if (parameter instanceof Object) {
				expression = cb.equal(r.get("matriculaDoProfessor"), parameter);
			}
			if (expression != null) {
				where = expression;
			}
		}
		parameter = parameters.get("nomeDoProfessor");
		if (parameter != null) {
			Predicate expression = null;
			if (parameter instanceof java.util.List<?>) {
				@SuppressWarnings("unchecked")
				List<String> collection = (List<String>)parameter;
				expression = r.get("nomeDoProfessor").in(collection);
			} else if (parameter instanceof String && ((String)parameter).length()>0) {
				expression = cb.like(r.<String>get("nomeDoProfessor"), "%" + parameter + "%");
			}
			if (expression != null) {
				if (where == null) {
					where = expression;
				} else {
					where = cb.and(where, expression);
				}
			}
		}
		parameter = parameters.get("senhaDoProfessor");
		if (parameter != null) {
			Predicate expression = null;
			if (parameter instanceof java.util.List<?>) {
				@SuppressWarnings("unchecked")
				List<String> collection = (List<String>)parameter;
				expression = r.get("senhaDoProfessor").in(collection);
			} else if (parameter instanceof String && ((String)parameter).length()>0) {
				expression = cb.like(r.<String>get("senhaDoProfessor"), "%" + parameter + "%");
			}
			if (expression != null) {
				if (where == null) {
					where = expression;
				} else {
					where = cb.and(where, expression);
				}
			}
		}
		parameter = parameters.get("disciplina");
		if (parameter != null) {
			Predicate expression = null;
			if (parameter instanceof java.util.List<?>) {
				@SuppressWarnings("unchecked")
				List<String> collection = (List<String>)parameter;
				expression = r.get("disciplina").in(collection);
			} else if (parameter instanceof String && ((String)parameter).length()>0) {
				expression = cb.like(r.<String>get("disciplina"), "%" + parameter + "%");
			}
			if (expression != null) {
				if (where == null) {
					where = expression;
				} else {
					where = cb.and(where, expression);
				}
			}
		}
		parameter = parameters.get("turma");
		if (parameter != null) {
			Predicate expression = null;
			if (parameter instanceof java.util.List<?>) {
				@SuppressWarnings("unchecked")
				List<Object> collection = (List<Object>)parameter;
				expression = r.get("turma").get("idTurma").in(collection);
			} else if (parameter instanceof Object) {
				expression = cb.equal(r.get("turma").get("idTurma"), parameter);
			} else if (parameter instanceof controledenotas.domain.entity.Turma) {
				expression = cb.equal(r.get("turma"), parameter);
			}
			if (expression != null) {
				if (where == null) {
					where = expression;
				} else {
					where = cb.and(where, expression);
				}
			}
		}
		List<Professor> results = new ArrayList<Professor>();
		if (where != null) {
			q.where(where);
			results =  getEntityManager().createQuery(q).getResultList();
		}
		return results;
	}

}

