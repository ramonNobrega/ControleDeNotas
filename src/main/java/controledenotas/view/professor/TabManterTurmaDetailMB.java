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
import controledenotas.business.entity.TurmaBC;
import controledenotas.domain.entity.Turma;

@ViewController
@PreviousView("/professor/tabManterTurma.xhtml")
@NextView("/professor/dadosProfessor.xhtml")
public class TabManterTurmaDetailMB extends AbstractEditPageBean<Turma, Integer> {

	private static final long serialVersionUID = 1L;

	@Inject
	private MessageContext messageContext;

	@Inject
	@Name("messages")
	private ResourceBundle bundle;

	@Inject
	private TurmaBC turmaBC;
	
	@Inject
	private ContextMB context;
	
	@Override
	@Transactional
	public String insert() {
		this.turmaBC.insert(getBean());
		messageContext.add(new DefaultMessage("{pages.msg.insertsuccess}"));
		/* TriggerCall[edit.insert.cadastrarTurmaProfessor] */
		cadastrarTurmaProfessor();
		/* TriggerCall[edit.insert.cadastrarTurmaProfessor] */
		return getPreviousView();
	}
	
	/* Trigger[edit.insert.cadastrarTurmaProfessor] */
	public void cadastrarTurmaProfessor() {
		ProfessorBC professorBC = new ProfessorBC();
		Professor professor = professorBC.load(new Long(context.getUser().getId()));
		professor.setTurma(getBean());
		professorBC.update(professor);
	}
	/* Trigger[edit.insert.cadastrarTurmaProfessor] */
	
	@Override
	@Transactional
	public String update() {
		this.turmaBC.update(getBean());
		messageContext.add(new DefaultMessage("{pages.msg.updatesuccess}"));
		return getPreviousView();
	}
	
	@Override
	protected void handleLoad() {
		setBean(this.turmaBC.load(getId()));
	}

}
