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
@PreviousView("/professor/dadosProfessor.xhtml")
@NextView("/professor/dadosProfessor.xhtml")
public class DadosProfessorMB extends AbstractListPageBean<Professor, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private MessageContext messageContext;

	@Inject
	@Name("messages")
	private ResourceBundle bundle;

	@Inject
	private ProfessorBC professorBC;
	
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
		return this.professorBC.findAll();
	}

}
