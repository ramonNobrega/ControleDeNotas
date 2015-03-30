package controledenotas.business.entity;

import controledenotas.domain.entity.Desempenho;
import controledenotas.persistence.entity.DesempenhoDAO;
import java.util.*;
import javax.inject.Inject;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

@BusinessController
public class DesempenhoBC extends DelegateCrud<Desempenho, Object, DesempenhoDAO> {

	private static final long serialVersionUID = 1L;

	public List<Desempenho> findByExample(Desempenho example) {
		return getDelegate().findByExample(example);
	}

	public List<Desempenho> findByCriteria(java.util.Map<String, Object> parameters) {
		return getDelegate().findByCriteria(parameters);
	}

}

