package controledenotas.view.professor;

import java.util.*;

import javax.annotation.*;
import javax.inject.Inject;

import br.gov.frameworkdemoiselle.annotation.*;
import br.gov.frameworkdemoiselle.exception.*;
import br.gov.frameworkdemoiselle.message.*;
import br.gov.frameworkdemoiselle.stereotype.*;
import br.gov.frameworkdemoiselle.template.*;
import br.gov.frameworkdemoiselle.transaction.*;
import controledenotas.domain.entity.*;
import controledenotas.domain.enumeration.*;
import controledenotas.domain.view.*;
import controledenotas.business.entity.*;
import controledenotas.business.process.*;
import controledenotas.constant.*;
import controledenotas.exception.*;
import controledenotas.security.ContextMB;
import controledenotas.business.entity.ProfessorBC;

@ViewController
@PreviousView("/professor/tabPerfilProfessor.xhtml")
@NextView("/professor/tabPerfilProfessor.xhtml")
public class TabPerfilProfessorMB extends AbstractPageBean {

	private static final long serialVersionUID = 1L;

	@Inject
	private ContextMB context;
	
	@Inject
	private MessageContext messageContext;

	@Inject
	@Name("messages")
	private ResourceBundle bundle;

	@Inject
	private ProfessorBC professorBC;
	
	private List<Professor> professorResultList;
	
	public List<Professor> getProfessorResultList() {
		professorResultList = new ArrayList<Professor>();
		Professor prof = this.professorBC.load(new Long(context.getUser().getId()));
		professorResultList.add(prof);
		return professorResultList;
	}
	
	public void setProfessorResultList(List<Professor> professorResultList) {
		this.professorResultList = professorResultList;
	}

}
