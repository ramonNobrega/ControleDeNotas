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
public class TabManterDesempenhoMB extends AbstractListPageBean<Desempenho, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private MessageContext messageContext;

	@Inject
	@Name("messages")
	private ResourceBundle bundle;

	@Inject
	private DesempenhoBC desempenhoBC;
	
	@Override
	protected List<Desempenho> handleResultList() {
		/* TriggerCall[list.handleResultList.calculaMediaParcial] */
		calculaMediaParcial();
		/* TriggerCall[list.handleResultList.calculaMediaParcial] */
		/* TriggerCall[list.handleResultList.calculaMediaFinal] */
		calculaMediaFinal();
		/* TriggerCall[list.handleResultList.calculaMediaFinal] */
		/* TriggerCall[list.handleResultList.calculaSituacao] */
		calculaSituacao();
		/* TriggerCall[list.handleResultList.calculaSituacao] */
		return this.desempenhoBC.findAll();
	}
	
	/* Trigger[list.handleResultList.calculaMediaParcial] */
	public void calculaMediaParcial() {
		for (Desempenho item : desempenhoBC.findAll()) {
				desempenhoBC.load(item.getCodigo()).getMediaParcial();
			}
	}
	
	/* Trigger[list.handleResultList.calculaMediaParcial] */
	
	/* Trigger[list.handleResultList.calculaMediaFinal] */
	public void calculaMediaFinal() {
		for (Desempenho item : desempenhoBC.findAll()) {
				desempenhoBC.load(item.getCodigo()).getMediaFinal();
			}
	}
	/* Trigger[list.handleResultList.calculaMediaFinal] */
	
	/* Trigger[list.handleResultList.calculaSituacao] */
	public void calculaSituacao() {
		for (Desempenho item : desempenhoBC.findAll()) {
			if ((item.getMediaParcial() >= 7.0)
					|| (item.getProvaFinal() != null && item.getMediaFinal() >= 5.0)) {
				item.setSituacao("APROVADO");
			} else if ((item.getMediaParcial() >= 4.0 && item.getMediaParcial() < 7.0)
					&& item.getProvaFinal() == null) {
				item.setSituacao("FINAL");
			} else if (item.getMediaParcial() < 4.0)  {
				item.setSituacao("REPROVADO");
			}
			desempenhoBC.update(item);
		}
	}
	
	/* Trigger[list.handleResultList.calculaSituacao] */

}
