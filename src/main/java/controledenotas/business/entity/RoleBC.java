package controledenotas.business.entity;

import controledenotas.domain.entity.Role;
import controledenotas.persistence.entity.RoleDAO;
import java.util.*;
import javax.inject.Inject;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

@BusinessController
public class RoleBC extends DelegateCrud<Role, String, RoleDAO> {

	private static final long serialVersionUID = 1L;

	public List<Role> findByExample(Role example) {
		return getDelegate().findByExample(example);
	}

}

