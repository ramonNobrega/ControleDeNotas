package controledenotas.view.business.view;

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

import controledenotas.domain.entity.Desempenho;
import controledenotas.business.entity.DesempenhoBC;

@ViewController
@PreviousView("/business/view/perfilAluno2.xhtml")
@NextView("/business/view/perfilAluno2.xhtml")
public class PerfilAluno2MB extends AbstractPageBean {

	private static final long serialVersionUID = 1L;

	@Inject
	private MessageContext messageContext;

	@Inject
	@Name("messages")
	private ResourceBundle bundle;

	private Desempenho desempenho = new Desempenho();
	
	public Desempenho getDesempenho() {
		return this.desempenho;
	}
	
	public void setDesempenho(Desempenho desempenho) {
		this.desempenho = desempenho;
	}
	
	@Inject
	private DesempenhoBC desempenhoBC;
	
	private List<Desempenho> desempenhoResultList;
	
	public List<Desempenho> getDesempenhoResultList() {
		return this.desempenhoResultList;
	}
	
	public void setDesempenhoResultList(List<Desempenho> desempenhoResultList) {
		this.desempenhoResultList = desempenhoResultList;
	}
	
	@Transactional
	public String insert() {
		this.desempenhoBC.insert(getDesempenho());
		messageContext.add(new DefaultMessage("{pages.msg.insertsuccess}"));
		return getPreviousView();
	}
	
	@Transactional
	public String save() {
		this.desempenhoBC.update(getDesempenho());
		messageContext.add(new DefaultMessage("{pages.msg.updatesuccess}"));
		return getCurrentView();
	}

}
