package controledenotas.view.professor;

import java.util.ResourceBundle;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.annotation.Name;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.message.DefaultMessage;
import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import controledenotas.business.DesempenhoBimestreCalculaMedia;
import controledenotas.business.entity.DesempenhoBimestralBC;
import controledenotas.domain.entity.DesempenhoBimestral;

@ViewController
@PreviousView("/professor/manterDesempenhoBimestral.xhtml")
@NextView("/professor/manterDesempenhoBimestralDetail.xhtml")
public class ManterDesempenhoBimestralDetailMB extends AbstractEditPageBean<DesempenhoBimestral, Integer> {

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
		//ativando o cálculo da média
		getBean().setMediaBimestre(DesempenhoBimestreCalculaMedia.calcularMedia(getBean().getNota1(), getBean().getNota2(), getBean().getNota3()));
		this.desempenhoBimestralBC.insert(getBean());
		messageContext.add(new DefaultMessage("{pages.msg.insertsuccess}"));
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		getBean().setMediaBimestre(DesempenhoBimestreCalculaMedia.calcularMedia(getBean().getNota1(), getBean().getNota2(), getBean().getNota3()));
		this.desempenhoBimestralBC.update(getBean());
		messageContext.add(new DefaultMessage("{pages.msg.updatesuccess}"));
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String delete() {
		this.desempenhoBimestralBC.delete(getBean().getIdBimestre());
		return getPreviousView();
	}
	
	@Override
	protected void handleLoad() {
		setBean(this.desempenhoBimestralBC.load(getId()));
	}

}
