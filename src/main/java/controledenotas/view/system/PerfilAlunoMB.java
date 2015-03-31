package controledenotas.view.system;

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

@ViewController
@PreviousView("/system/perfilAluno.xhtml")
@NextView("/system/perfilAluno.xhtml")
public class PerfilAlunoMB extends AbstractPageBean {

	private static final long serialVersionUID = 1L;

	@Inject
	private MessageContext messageContext;

	@Inject
	@Name("messages")
	private ResourceBundle bundle;

	@Inject
	private DesempenhoBimestralBC desempenhoBimestralBC;
	
	private List<DesempenhoBimestral> desempenhoBimestralResultList;
	
	public List<DesempenhoBimestral> getDesempenhoBimestralResultList() {
		desempenhoBimestralResultList = this.desempenhoBimestralBC.findAll();
		return desempenhoBimestralResultList;
	}
	
	public void setDesempenhoBimestralResultList(List<DesempenhoBimestral> desempenhoBimestralResultList) {
		this.desempenhoBimestralResultList = desempenhoBimestralResultList;
	}
	
	
	@Inject
	@Name("enum.truefalse.properties")
	private ResourceBundle truefalse.propertiesBundle;
	
	public void Desempenho() {
		if (truefalse.propertiesBundle != null) {
			Enumeration<String> keys = truefalse.propertiesBundle.getKeys();
			while (keys.hasMoreElements()) {
				String key = keys.nextElement();
			}
		}
	}

}
