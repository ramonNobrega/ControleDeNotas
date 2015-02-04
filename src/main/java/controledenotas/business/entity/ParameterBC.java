package controledenotas.business.entity;

import controledenotas.domain.entity.Parameter;
import controledenotas.persistence.entity.ParameterDAO;
import java.util.*;
import javax.inject.Inject;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

@BusinessController
public class ParameterBC extends DelegateCrud<Parameter, Long, ParameterDAO> {

	private static final long serialVersionUID = 1L;

	public List<Parameter> findByExample(Parameter example) {
		return getDelegate().findByExample(example);
	}

	public List<Parameter> findByCriteria(java.util.Map<String, Object> parameters) {
		return getDelegate().findByCriteria(parameters);
	}

	@Override
	@Transactional
	public Parameter load(Long id) {
		List<Parameter> parameters = findAll();
		Parameter parameter = new Parameter();
		if(parameters != null && ! parameters.isEmpty()){
			parameter = parameters.get(0);
		}
		return parameter;
	}

}

