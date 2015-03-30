package controledenotas.persistence.entity;

import java.util.*;
import javax.inject.Inject;
import javax.persistence.*;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;

import controledenotas.domain.entity.DesempenhoBimestral;
import br.gov.frameworkdemoiselle.template.JPACrud;
import javax.persistence.criteria.*;

@PersistenceController
public class DesempenhoBimestralDAO extends JPACrud<DesempenhoBimestral, Object> {

	private static final long serialVersionUID = 1L;

	@Override
	public List<DesempenhoBimestral> findByExample(DesempenhoBimestral example) {
		if (example == null) {
			example = new DesempenhoBimestral();
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
		parameter = parameters.get("idBimestre");
		if (parameter != null) {
			Predicate expression = null;
			if (parameter instanceof java.util.List<?>) {
				@SuppressWarnings("unchecked")
				List<Object> collection = (List<Object>)parameter;
				expression = r.get("idBimestre").in(collection);
			} else if (parameter instanceof Object) {
				expression = cb.equal(r.get("idBimestre"), parameter);
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
				List<Object> collection = (List<Object>)parameter;
				expression = r.get("nota1").in(collection);
			} else if (parameter instanceof Object) {
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
				List<Object> collection = (List<Object>)parameter;
				expression = r.get("nota2").in(collection);
			} else if (parameter instanceof Object) {
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
				List<Object> collection = (List<Object>)parameter;
				expression = r.get("nota3").in(collection);
			} else if (parameter instanceof Object) {
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
				List<Object> collection = (List<Object>)parameter;
				expression = r.get("mediaBimestre").in(collection);
			} else if (parameter instanceof Object) {
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
		parameter = parameters.get("desempenho");
		if (parameter != null) {
			Predicate expression = null;
			if (parameter instanceof java.util.List<?>) {
				@SuppressWarnings("unchecked")
				List<Object> collection = (List<Object>)parameter;
				expression = r.get("desempenho").get("idDesempenho").in(collection);
			} else if (parameter instanceof Object) {
				expression = cb.equal(r.get("desempenho").get("idDesempenho"), parameter);
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
		List<DesempenhoBimestral> results = new ArrayList<DesempenhoBimestral>();
		if (where != null) {
			q.where(where);
			results =  getEntityManager().createQuery(q).getResultList();
		}
		return results;
	}

}

