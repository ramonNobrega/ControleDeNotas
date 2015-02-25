package controledenotas.persistence.entity;

import java.util.*;
import javax.inject.Inject;
import javax.persistence.*;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;

import controledenotas.domain.entity.Aluno;
import br.gov.frameworkdemoiselle.template.JPACrud;
import javax.persistence.criteria.*;

@PersistenceController
public class AlunoDAO extends JPACrud<Aluno, Integer> {

	private static final long serialVersionUID = 1L;

	@Override
	public List<Aluno> findByExample(Aluno example) {
		if (example == null) {
			example = new Aluno();
		}
		return super.findByExample(example);
	}

	public List<Aluno> findByCriteria(java.util.Map<String, Object> parameters) {
		if (parameters == null) {
			parameters = new java.util.HashMap<String, Object>();
		}
		CriteriaBuilder cb = super.getCriteriaBuilder();
		CriteriaQuery<Aluno> q = cb.createQuery(Aluno.class);
		Root<Aluno> r = q.from(Aluno.class);
		Predicate where = null;
		Object parameter = null; 
		parameter = parameters.get("matricula");
		if (parameter != null) {
			Predicate expression = null;
			if (parameter instanceof java.util.List<?>) {
				@SuppressWarnings("unchecked")
				List<Integer> collection = (List<Integer>)parameter;
				expression = r.get("matricula").in(collection);
			} else if (parameter instanceof Integer) {
				expression = cb.equal(r.get("matricula"), parameter);
			}
			if (expression != null) {
				where = expression;
			}
		}
		parameter = parameters.get("nome");
		if (parameter != null) {
			Predicate expression = null;
			if (parameter instanceof java.util.List<?>) {
				@SuppressWarnings("unchecked")
				List<String> collection = (List<String>)parameter;
				expression = r.get("nome").in(collection);
			} else if (parameter instanceof String && ((String)parameter).length()>0) {
				expression = cb.like(r.<String>get("nome"), "%" + parameter + "%");
			}
			if (expression != null) {
				if (where == null) {
					where = expression;
				} else {
					where = cb.and(where, expression);
				}
			}
		}
		parameter = parameters.get("senha");
		if (parameter != null) {
			Predicate expression = null;
			if (parameter instanceof java.util.List<?>) {
				@SuppressWarnings("unchecked")
				List<String> collection = (List<String>)parameter;
				expression = r.get("senha").in(collection);
			} else if (parameter instanceof String && ((String)parameter).length()>0) {
				expression = cb.like(r.<String>get("senha"), "%" + parameter + "%");
			}
			if (expression != null) {
				if (where == null) {
					where = expression;
				} else {
					where = cb.and(where, expression);
				}
			}
		}
		parameter = parameters.get("professor");
		if (parameter != null) {
			Predicate expression = null;
			if (parameter instanceof java.util.List<?>) {
				@SuppressWarnings("unchecked")
				List<Integer> collection = (List<Integer>)parameter;
				expression = r.get("professor").get("matricula").in(collection);
			} else if (parameter instanceof Integer) {
				expression = cb.equal(r.get("professor").get("matricula"), parameter);
			} else if (parameter instanceof controledenotas.domain.entity.Professor) {
				expression = cb.equal(r.get("professor"), parameter);
			}
			if (expression != null) {
				if (where == null) {
					where = expression;
				} else {
					where = cb.and(where, expression);
				}
			}
		}
		if (where != null) {
			q.where(where);
		}
		List<Aluno> results =  getEntityManager().createQuery(q).getResultList();
		return results;
	}

}

