package controledenotas.view.system;

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

import controledenotas.domain.entity.Professor;
import controledenotas.business.entity.ProfessorBC;

@ViewController
@PreviousView("/system/cadastro.xhtml")
@NextView("/system/cadastro.xhtml")
public class CadastroMB extends AbstractPageBean {

	private static final long serialVersionUID = 1L;

	@Inject
	private MessageContext messageContext;

	@Inject
	@Name("messages")
	private ResourceBundle bundle;

	private Professor professor = new Professor(0, getNextView(), getNextView(), getNextView());
	
	public Professor getProfessor() {
		return this.professor;
	}
	
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	@Inject
	private ProfessorBC professorBC;
	
	@Transactional
	public String insert() {
		this.professorBC.insert(getProfessor());
		messageContext.add(new DefaultMessage("{pages.msg.insertsuccess}"));
		return getPreviousView();
	}
	
	@Transactional
	public String save() {
		this.professorBC.update(getProfessor());
		messageContext.add(new DefaultMessage("{pages.msg.updatesuccess}"));
		return getCurrentView();
	}

}
