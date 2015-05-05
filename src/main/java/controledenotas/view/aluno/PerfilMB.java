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

import controledenotas.business.entity.DesempenhoBC;

@ViewController
@PreviousView("/aluno/perfil.xhtml")
@NextView("/aluno/perfilEdit.xhtml")
public class PerfilMB extends AbstractPageBean {

	private static final long serialVersionUID = 1L;

	@Inject
	private MessageContext messageContext;

	@Inject
	@Name("messages")
	private ResourceBundle bundle;

	@Inject
	private DesempenhoBC desempenhoBC;
	
	private List<Desempenho> desempenhoResultList;
	
	public List<Desempenho> getDesempenhoResultList() {
		desempenhoResultList = this.desempenhoBC.findAll();
		
//		Aluno a = new Aluno();
//		
//		desempenhoResultList.contains(
		return desempenhoResultList;
	}
	
	public void setDesempenhoResultList(List<Desempenho> desempenhoResultList) {
		this.desempenhoResultList = desempenhoResultList;
	}

}
