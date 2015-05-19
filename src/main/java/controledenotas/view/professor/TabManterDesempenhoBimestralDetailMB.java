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

import controledenotas.business.entity.DesempenhoBimestralBC;
import controledenotas.domain.entity.DesempenhoBimestral;

@ViewController
@PreviousView("/professor/tabManterDesempenhoBimestral.xhtml")
@NextView("/professor/tabManterDesempenhoBimestralDetail.xhtml")
public class TabManterDesempenhoBimestralDetailMB extends AbstractEditPageBean<DesempenhoBimestral, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private MessageContext messageContext;

	@Inject
	@Name("messages")
	private ResourceBundle bundle;

	@Inject
	private DesempenhoBimestralBC desempenhoBimestralBC;
	
	@Override
	@Transactional
	public String insert() {
		this.desempenhoBimestralBC.insert(getBean());
		messageContext.add(new DefaultMessage("{pages.msg.insertsuccess}"));
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.desempenhoBimestralBC.update(getBean());
		messageContext.add(new DefaultMessage("{pages.msg.updatesuccess}"));
		/* TriggerCall[edit.update.calculaMediaBimestral] */
		calculaMediaBimestral();
		/* TriggerCall[edit.update.calculaMediaBimestral] */
		/* TriggerCall[edit.update.calculaMediaFinal] */
		calculaMediaFinal();
		/* TriggerCall[edit.update.calculaMediaFinal] */
		return getPreviousView();
	}
	
	/* Trigger[edit.update.calculaMediaBimestral] */
	public void calculaMediaBimestral() {
			Double media = (getBean().getNota1() + getBean().getNota2() + getBean().getNota3())/3;
			desempenhoBimestralBC.load(getId()).setMediaBimestre(media);
	}
	
	/* Trigger[edit.update.calculaMediaBimestral] */
	
	/* Trigger[edit.update.calculaMediaFinal] */
	public void calculaMediaFinal() {
		DesempenhoBC desempenhoBC = new DesempenhoBC();
		Double media = getBean().getMediaBimestre();
		Double atual = desempenhoBC.load(new Long(getBean().getAluno().getDesempenhos().get(0).getCodigo())).getMediaParcial();
		desempenhoBC.load(new Long(getBean().getAluno().getDesempenhos().get(0).getCodigo())).setMediaParcial(atual + media/4);;		
	}
	/* Trigger[edit.update.calculaMediaFinal] */
	
	@Override
	protected void handleLoad() {
		setBean(this.desempenhoBimestralBC.load(getId()));
	}

}
