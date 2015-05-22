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
import controledenotas.persistence.entity.RoleDAO;

@ViewController
@PreviousView("/system/login.xhtml")
@NextView("/system/tabProfessor.xhtml")
public class TabProfessorMB extends AbstractPageBean {

	private static final long serialVersionUID = 1L;

	@Inject
	private MessageContext messageContext;

	@Inject
	@Name("messages")
	private ResourceBundle bundle;

	private Professor professor = new Professor();
	
	public Professor getProfessor() {
		return this.professor;
	}
	
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	@Inject
	private ProfessorBC professorBC;
	
	@Transactional
	public String save() {
		/* TriggerCall[blocoProfessor.save.cadastraPapel] */
		cadastraPapel();
		/* TriggerCall[blocoProfessor.save.cadastraPapel] */
		this.professorBC.update(getProfessor());
		messageContext.add(new DefaultMessage("{pages.msg.updatesuccess}"));
		return getCurrentView();
	}
	
	/* Trigger[blocoProfessor.save.cadastraPapel] */
	private void cadastraPapel(){
		RoleDAO roleDAO = new RoleDAO();
		//Caso o papel no exista, crie
		Role papel = roleDAO.load("professor");
		if(papel == null){
			papel = new Role();
			papel.setName("professor");
		}
		getProfessor().getUser().getRoles().add(papel);
	}
	
	/* Trigger[blocoProfessor.save.cadastraPapel] */

}
