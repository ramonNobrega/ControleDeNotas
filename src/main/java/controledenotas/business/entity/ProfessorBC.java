package controledenotas.business.entity;

import controledenotas.domain.entity.Professor;
import controledenotas.persistence.entity.ProfessorDAO;
import java.util.*;
import javax.inject.Inject;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

@BusinessController
public class ProfessorBC extends DelegateCrud<Professor, Long, ProfessorDAO> {

	private static final long serialVersionUID = 1L;

	public List<Professor> findByExample(Professor example) {
		return getDelegate().findByExample(example);
	}

	public List<Professor> findByCriteria(java.util.Map<String, Object> parameters) {
		return getDelegate().findByCriteria(parameters);
	}

}

