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

import controledenotas.business.entity.ProfessorBC;
import controledenotas.domain.entity.Professor;

@ViewController
@PreviousView("/professor/tabManterProfessor.xhtml")
@NextView("/professor/tabManterProfessorDetail.xhtml")
public class TabManterProfessorDetailMB extends AbstractEditPageBean<Professor, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private MessageContext messageContext;

	@Inject
	@Name("messages")
	private ResourceBundle bundle;

	@Inject
	private ProfessorBC professorBC;
	
	@Override
	@Transactional
	public String insert() {
		this.professorBC.insert(getBean());
		messageContext.add(new DefaultMessage("{pages.msg.insertsuccess}"));
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.professorBC.update(getBean());
		messageContext.add(new DefaultMessage("{pages.msg.updatesuccess}"));
		return getPreviousView();
	}
	
	@Override
	protected void handleLoad() {
		setBean(this.professorBC.load(getId()));
	}

}
