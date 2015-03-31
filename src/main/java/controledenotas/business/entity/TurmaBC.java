package controledenotas.business.entity;

import controledenotas.domain.entity.Turma;
import controledenotas.persistence.entity.TurmaDAO;
import java.util.*;
import javax.inject.Inject;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

@BusinessController
public class TurmaBC extends DelegateCrud<Turma, Integer, TurmaDAO> {

	private static final long serialVersionUID = 1L;

	public List<Turma> findByExample(Turma example) {
		return getDelegate().findByExample(example);
	}

	public List<Turma> findByCriteria(java.util.Map<String, Object> parameters) {
		return getDelegate().findByCriteria(parameters);
	}

}

