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
import controledenotas.persistence.entity.DesempenhoBimestralDAO;
import controledenotas.persistence.entity.DesempenhoDAO;
import controledenotas.security.ContextMB;
import controledenotas.business.entity.DesempenhoBimestralBC;

@ViewController
@PreviousView("/aluno/tabDesempenhoBimestralAluno.xhtml")
@NextView("/aluno/tabDesempenhoBimestralAluno.xhtml")
public class TabDesempenhoBimestralAlunoMB extends AbstractPageBean {

	private static final long serialVersionUID = 1L;
	private static final int NUMERO_BIMESTRES = 4;

	@Inject
	private ContextMB context;
	
	@Inject
	private MessageContext messageContext;

	@Inject
	@Name("messages")
	private ResourceBundle bundle;

	@Inject
	private DesempenhoBimestralBC desempenhoBimestralBC;
	
	private List<DesempenhoBimestral> desempenhoBimestralResultList;
	
	public List<DesempenhoBimestral> getDesempenhoBimestralResultList() {
			AlunoBC alunoBc = new AlunoBC();
			Aluno aluno = alunoBc.load(new Long(context.getUser().getId()));
			HashMap<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("aluno", aluno);
			desempenhoBimestralResultList = desempenhoBimestralBC.findByCriteria(parameters);
		return desempenhoBimestralResultList;
	}
	
	public void setDesempenhoBimestralResultList(List<DesempenhoBimestral> desempenhoBimestralResultList) {
		this.desempenhoBimestralResultList = desempenhoBimestralResultList;
	}

}
