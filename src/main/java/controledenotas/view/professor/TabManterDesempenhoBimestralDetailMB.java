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
public class TabManterDesempenhoBimestralDetailMB extends
		AbstractEditPageBean<DesempenhoBimestral, Long> {

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
		calculaMediaBimestral();
		calculaMediaFinal();
		this.desempenhoBimestralBC.update(getBean());
		messageContext.add(new DefaultMessage("{pages.msg.updatesuccess}"));
		
		return getPreviousView();
	}

	/* Trigger[edit.update.calculaMediaBimestral] */
	public void calculaMediaBimestral() {
		
		if (getBean().getNota1() != null && getBean().getNota2() != null
				&& getBean().getNota3() != null) {
			Double media = (getBean().getNota1() + getBean().getNota2() + getBean()
					.getNota3()) / 3;
			getBean().setMediaBimestre(media);
		}
	}

	/* Trigger[edit.update.calculaMediaBimestral] */

	/* Trigger[edit.update.calculaMediaFinal] */
	public void calculaMediaFinal() {
		
		DesempenhoBC desempenhoBC = new DesempenhoBC();
		Double mediaParcial = 0.0;
		List<DesempenhoBimestral> desempenhoBimestralList = getBean().getAluno().getDesempenhosBimestrais();
		for (DesempenhoBimestral bimestre : desempenhoBimestralList) {
			if(bimestre.getMediaBimestre() != null){
				mediaParcial += bimestre.getMediaBimestre();
			}
		}
		
		Desempenho desempenho = getBean().getAluno().getDesempenhos().get(0);
		mediaParcial = mediaParcial / desempenhoBimestralList.size();
		desempenho.setMediaParcial(mediaParcial);
		if (mediaParcial >= 7) {
			desempenho.setSituacao("APROVADO");
		} else if( mediaParcial < 7 && mediaParcial >= 4){
			desempenho.setSituacao("FINAL");
		}else {
			desempenho.setSituacao("REPROVADO");
		}
		
		desempenhoBC.update(desempenho);
	}

	/* Trigger[edit.update.calculaMediaFinal] */

	@Override
	protected void handleLoad() {
		setBean(this.desempenhoBimestralBC.load(getId()));
	}

	@Override
	public String delete() {
		// TODO Auto-generated method stub
		return null;
	}

}
