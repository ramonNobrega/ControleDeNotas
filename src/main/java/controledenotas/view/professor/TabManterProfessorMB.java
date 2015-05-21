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
import controledenotas.domain.entity.Professor;

@ViewController
@PreviousView("/professor/tabManterProfessor.xhtml")
@NextView("/professor/tabManterProfessorDetail.xhtml")
public class TabManterProfessorMB extends AbstractListPageBean<Professor, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private MessageContext messageContext;

	@Inject
	@Name("messages")
	private ResourceBundle bundle;

	@Inject
	private ProfessorBC professorBC;
	
	@Inject
	private ContextMB context;
	
	private List<Professor> professorResultList;
	
	public String newRecord() {
		return getNextView();
	}
	
	@Transactional
	public String delete() {
		boolean delete = false;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long selectedId = iter.next();
			delete = getSelection().get(selectedId);
			if (delete) {
				professorBC.delete(selectedId);
				iter.remove();
			}
		}
		if (delete) {
			messageContext.add(new DefaultMessage("{pages.msg.deletesuccess}"));
		}
		return getCurrentView();
	}
	
	@Override
	protected List<Professor> handleResultList() {
		professorResultList = new ArrayList<Professor>();
		Professor prof = this.professorBC.load(new Long(context.getUser().getId()));
		professorResultList.add(prof);
		return professorResultList;
		//return this.professorBC.findAll();
	}
	
	public void setProfessorResultList(List<Professor> professorResultList) {
		this.professorResultList = professorResultList;
	}

}
