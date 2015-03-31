package controledenotas.persistence.entity;

import java.util.*;
import javax.inject.Inject;
import javax.persistence.*;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;

import controledenotas.domain.entity.Turma;
import br.gov.frameworkdemoiselle.template.JPACrud;
import javax.persistence.criteria.*;

@PersistenceController
public class TurmaDAO extends JPACrud<Turma, Integer> {

	private static final long serialVersionUID = 1L;

	@Override
	public List<Turma> findByExample(Turma example) {
		if (example == null) {
			example = new Turma();
		}
		return super.findByExample(example);
	}

	public List<Turma> findByCriteria(java.util.Map<String, Object> parameters) {
		if (parameters == null) {
			parameters = new java.util.HashMap<String, Object>();
		}
		CriteriaBuilder cb = super.getCriteriaBuilder();
		CriteriaQuery<Turma> q = cb.createQuery(Turma.class);
		Root<Turma> r = q.from(Turma.class);
		Predicate where = null;
		Object parameter = null; 
		parameter = parameters.get("codigo");
		if (parameter != null) {
			Predicate expression = null;
			if (parameter instanceof java.util.List<?>) {
				@SuppressWarnings("unchecked")
				List<Integer> collection = (List<Integer>)parameter;
				expression = r.get("codigo").in(collection);
			} else if (parameter instanceof Integer) {
				expression = cb.equal(r.get("codigo"), parameter);
			}
			if (expression != null) {
				where = expression;
			}
		}
		parameter = parameters.get("matriculaAluno");
		if (parameter != null) {
			Predicate expression = null;
			if (parameter instanceof java.util.List<?>) {
				@SuppressWarnings("unchecked")
				List<Integer> collection = (List<Integer>)parameter;
				expression = r.get("matriculaAluno").get("matricula").in(collection);
			} else if (parameter instanceof Integer) {
				expression = cb.equal(r.get("matriculaAluno").get("matricula"), parameter);
			} else if (parameter instanceof controledenotas.domain.entity.Aluno) {
				expression = cb.equal(r.get("matriculaAluno"), parameter);
			}
			if (expression != null) {
				if (where == null) {
					where = expression;
				} else {
					where = cb.and(where, expression);
				}
			}
		}
		List<Turma> results = new ArrayList<Turma>();
		if (where != null) {
			q.where(where);
			results =  getEntityManager().createQuery(q).getResultList();
		}
		return results;
	}

}

