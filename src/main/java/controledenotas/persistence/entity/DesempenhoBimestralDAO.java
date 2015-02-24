package controledenotas.persistence.entity;

import java.util.*;
import javax.inject.Inject;
import javax.persistence.*;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;

import controledenotas.domain.entity.DesempenhoBimestral;
import br.gov.frameworkdemoiselle.template.JPACrud;
import javax.persistence.criteria.*;

@PersistenceController
public class DesempenhoBimestralDAO extends JPACrud<DesempenhoBimestral, Integer> {

	private static final long serialVersionUID = 1L;

	@Override
	public List<DesempenhoBimestral> findByExample(DesempenhoBimestral example) {
		if (example == null) {
			example = new DesempenhoBimestral(0, null, null);
		}
		return super.findByExample(example);
	}

	public List<DesempenhoBimestral> findByCriteria(java.util.Map<String, Object> parameters) {
		if (parameters == null) {
			parameters = new java.util.HashMap<String, Object>();
		}
		CriteriaBuilder cb = super.getCriteriaBuilder();
		CriteriaQuery<DesempenhoBimestral> q = cb.createQuery(DesempenhoBimestral.class);
		Root<DesempenhoBimestral> r = q.from(DesempenhoBimestral.class);
		Predicate where = null;
		Object parameter = null; 
		parameter = parameters.get("id");
		if (parameter != null) {
			Predicate expression = null;
			if (parameter instanceof java.util.List<?>) {
				@SuppressWarnings("unchecked")
				List<Integer> collection = (List<Integer>)parameter;
				expression = r.get("id").in(collection);
			} else if (parameter instanceof Integer) {
				expression = cb.equal(r.get("id"), parameter);
			}
			if (expression != null) {
				where = expression;
			}
		}
		parameter = parameters.get("nota1");
		if (parameter != null) {
			Predicate expression = null;
			if (parameter instanceof java.util.List<?>) {
				@SuppressWarnings("unchecked")
				List<Integer> collection = (List<Integer>)parameter;
				expression = r.get("nota1").in(collection);
			} else if (parameter instanceof Integer) {
				expression = cb.equal(r.get("nota1"), parameter);
			}
			if (expression != null) {
				if (where == null) {
					where = expression;
				} else {
					where = cb.and(where, expression);
				}
			}
		}
		parameter = parameters.get("nota2");
		if (parameter != null) {
			Predicate expression = null;
			if (parameter instanceof java.util.List<?>) {
				@SuppressWarnings("unchecked")
				List<Integer> collection = (List<Integer>)parameter;
				expression = r.get("nota2").in(collection);
			} else if (parameter instanceof Integer) {
				expression = cb.equal(r.get("nota2"), parameter);
			}
			if (expression != null) {
				if (where == null) {
					where = expression;
				} else {
					where = cb.and(where, expression);
				}
			}
		}
		parameter = parameters.get("nota3");
		if (parameter != null) {
			Predicate expression = null;
			if (parameter instanceof java.util.List<?>) {
				@SuppressWarnings("unchecked")
				List<Integer> collection = (List<Integer>)parameter;
				expression = r.get("nota3").in(collection);
			} else if (parameter instanceof Integer) {
				expression = cb.equal(r.get("nota3"), parameter);
			}
			if (expression != null) {
				if (where == null) {
					where = expression;
				} else {
					where = cb.and(where, expression);
				}
			}
		}
		parameter = parameters.get("mediaBimestre");
		if (parameter != null) {
			Predicate expression = null;
			if (parameter instanceof java.util.List<?>) {
				@SuppressWarnings("unchecked")
				List<Integer> collection = (List<Integer>)parameter;
				expression = r.get("mediaBimestre").in(collection);
			} else if (parameter instanceof Integer) {
				expression = cb.equal(r.get("mediaBimestre"), parameter);
			}
			if (expression != null) {
				if (where == null) {
					where = expression;
				} else {
					where = cb.and(where, expression);
				}
			}
		}
		parameter = parameters.get("aluno");
		if (parameter != null) {
			Predicate expression = null;
			if (parameter instanceof java.util.List<?>) {
				@SuppressWarnings("unchecked")
				List<Integer> collection = (List<Integer>)parameter;
				expression = r.get("aluno").get("matricula").in(collection);
			} else if (parameter instanceof Integer) {
				expression = cb.equal(r.get("aluno").get("matricula"), parameter);
			} else if (parameter instanceof controledenotas.domain.entity.Aluno) {
				expression = cb.equal(r.get("aluno"), parameter);
			}
			if (expression != null) {
				if (where == null) {
					where = expression;
				} else {
					where = cb.and(where, expression);
				}
			}
		}
		parameter = parameters.get("desempenho");
		if (parameter != null) {
			Predicate expression = null;
			if (parameter instanceof java.util.List<?>) {
				@SuppressWarnings("unchecked")
				List<Integer> collection = (List<Integer>)parameter;
				expression = r.get("desempenho").get("matricula").in(collection);
			} else if (parameter instanceof Integer) {
				expression = cb.equal(r.get("desempenho").get("matricula"), parameter);
			} else if (parameter instanceof controledenotas.domain.entity.Desempenho) {
				expression = cb.equal(r.get("desempenho"), parameter);
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
		List<DesempenhoBimestral> results =  getEntityManager().createQuery(q).getResultList();
		return results;
	}

}

