package controledenotas.persistence.entity;

import java.util.*;
import javax.inject.Inject;
import javax.persistence.*;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;

import controledenotas.domain.entity.Aluno;
import br.gov.frameworkdemoiselle.template.JPACrud;
import javax.persistence.criteria.*;

@PersistenceController
public class AlunoDAO extends JPACrud<Aluno, Long> {

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
		parameter = parameters.get("user");
		if (parameter != null) {
			Predicate expression = null;
			if (parameter instanceof java.util.List<?>) {
				@SuppressWarnings("unchecked")
				List<Long> collection = (List<Long>)parameter;
				expression = r.get("user").get("id").in(collection);
			} else if (parameter instanceof Long) {
				expression = cb.equal(r.get("user").get("id"), parameter);
			} else if (parameter instanceof controledenotas.domain.entity.User) {
				expression = cb.equal(r.get("user"), parameter);
			}
			if (expression != null) {
				where = expression;
			}
		}
		parameter = parameters.get("turma");
		if (parameter != null) {
			Predicate expression = null;
			if (parameter instanceof java.util.List<?>) {
				@SuppressWarnings("unchecked")
				List<Integer> collection = (List<Integer>)parameter;
				expression = r.get("turma").get("codigo").in(collection);
			} else if (parameter instanceof Integer) {
				expression = cb.equal(r.get("turma").get("codigo"), parameter);
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
		List<Aluno> results = new ArrayList<Aluno>();
		if (where != null) {
			q.where(where);
			results =  getEntityManager().createQuery(q).getResultList();
		}
		return results;
	}

}

