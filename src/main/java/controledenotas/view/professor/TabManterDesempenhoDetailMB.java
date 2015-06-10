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
		calculaMediaFinal();
		calculaSituacao();
		this.desempenhoBC.update(getBean());
		messageContext.add(new DefaultMessage("{pages.msg.updatesuccess}"));
		
		return getPreviousView();
	}
	
	/* Trigger[edit.update.calculaMediaFinal] */
	public void calculaMediaFinal() {
		
		Desempenho desempenho = getBean().getAluno().getDesempenhos().get(0);
		Double media = getBean().getMediaParcial()*(0.6) + getBean().getProvaFinal()*(0.4);
		desempenho.setMediaFinal(media);
		desempenhoBC.update(desempenho);
	}
	
	/* Trigger[edit.update.calculaMediaFinal] */
	
	/* Trigger[edit.update.calculaSituacao] */
	public void calculaSituacao() {
		Desempenho desempenho = getBean().getAluno().getDesempenhos().get(0);
		String situacao = "";
		if ((getBean().getMediaFinal() >= 5.0)) {
			situacao = "APROVADO";
		} 
		else {
			situacao = "REPROVADO";
		}
		
		desempenho.setSituacao(situacao);
		desempenhoBC.update(desempenho);
	}
	
	/* Trigger[edit.update.calculaSituacao] */
	
	@Override
	protected void handleLoad() {
		setBean(this.desempenhoBC.load(getId()));
	}
}
