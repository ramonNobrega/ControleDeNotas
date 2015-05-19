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

import controledenotas.business.entity.DesempenhoBC;
import controledenotas.domain.entity.Desempenho;

@ViewController
@PreviousView("/professor/tabManterDesempenho.xhtml")
@NextView("/professor/tabManterDesempenhoDetail.xhtml")
public class TabManterDesempenhoDetailMB extends AbstractEditPageBean<Desempenho, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private MessageContext messageContext;

	@Inject
	@Name("messages")
	private ResourceBundle bundle;

	@Inject
	private DesempenhoBC desempenhoBC;
	
	@Override
	@Transactional
	public String insert() {
		this.desempenhoBC.insert(getBean());
		messageContext.add(new DefaultMessage("{pages.msg.insertsuccess}"));
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.desempenhoBC.update(getBean());
		messageContext.add(new DefaultMessage("{pages.msg.updatesuccess}"));
		/* TriggerCall[edit.update.calculaMediaFinal] */
		calculaMediaFinal();
		/* TriggerCall[edit.update.calculaMediaFinal] */
		/* TriggerCall[edit.update.calculaSituacao] */
		calculaSituacao();
		/* TriggerCall[edit.update.calculaSituacao] */
		return getPreviousView();
	}
	
	/* Trigger[edit.update.calculaMediaFinal] */
	public void calculaMediaFinal() {
		Double media = getBean().getMediaParcial()*(0.6) + getBean().getProvaFinal()*(0.4);
		desempenhoBC.load(getId()).setMediaFinal(media);
	}
	
	/* Trigger[edit.update.calculaMediaFinal] */
	
	/* Trigger[edit.update.calculaSituacao] */
	public void calculaSituacao() {
				String situacao = "";
				if ((getBean().getMediaFinal() >= 5.0)) {
					situacao = "APROVADO";
				} else {
					situacao = "REPROVADO";
				}
				desempenhoBC.load(getId()).setSituacao(situacao);
			}
	
	/* Trigger[edit.update.calculaSituacao] */
	
	@Override
	protected void handleLoad() {
		setBean(this.desempenhoBC.load(getId()));
	}

}
