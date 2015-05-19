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

import controledenotas.business.entity.AlunoBC;
import controledenotas.domain.entity.Aluno;
import controledenotas.business.entity.TurmaBC;

@ViewController
@PreviousView("/professor/tabManterAluno.xhtml")
@NextView("/professor/tabManterAlunoDetail.xhtml")
public class TabManterAlunoDetailMB extends AbstractEditPageBean<Aluno, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private MessageContext messageContext;

	@Inject
	@Name("messages")
	private ResourceBundle bundle;

	@Inject
	private AlunoBC alunoBC;
	
	@Inject
	private TurmaBC turmaBC;
	
	public List<Turma> getTurmaList() {
		List<Turma> list = turmaBC.findAll();
		if (list == null) {
			list = new ArrayList<Turma>();
		}
		return list;
	}
	
	@Override
	@Transactional
	public String insert() {
		this.alunoBC.insert(getBean());
		messageContext.add(new DefaultMessage("{pages.msg.insertsuccess}"));
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.alunoBC.update(getBean());
		messageContext.add(new DefaultMessage("{pages.msg.updatesuccess}"));
		return getPreviousView();
	}
	
	@Override
	protected void handleLoad() {
		setBean(this.alunoBC.load(getId()));
	}

}
