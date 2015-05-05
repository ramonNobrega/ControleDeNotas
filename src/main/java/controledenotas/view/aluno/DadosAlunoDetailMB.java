package controledenotas.view.aluno;

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
import controledenotas.business.entity.DesempenhoBimestralBC;
import controledenotas.business.entity.DesempenhoBC;

@ViewController
@PreviousView("/aluno/dadosAluno.xhtml")
@NextView("/aluno/dadosAlunoDetail.xhtml")
public class DadosAlunoDetailMB extends AbstractEditPageBean<Aluno, Integer> {

	private static final long serialVersionUID = 1L;

	@Inject
	private MessageContext messageContext;

	@Inject
	@Name("messages")
	private ResourceBundle bundle;

	@Inject
	private AlunoBC alunoBC;
	
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
	@Transactional
	public String delete() {
		this.alunoBC.delete(getBean().getMatricula());
		return getPreviousView();
	}
	
	@Override
	protected void handleLoad() {
		setBean(this.alunoBC.load(getId()));
	}

}
