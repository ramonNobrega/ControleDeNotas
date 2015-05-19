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

import controledenotas.business.entity.DesempenhoBimestralBC;
import controledenotas.security.ContextMB;

@ViewController
@PreviousView("/aluno/tabDesempenhoBimestralAluno.xhtml")
@NextView("/aluno/tabDesempenhoBimestralAluno.xhtml")
public class TabDesempenhoBimestralAlunoMB extends AbstractPageBean {

	private static final long serialVersionUID = 1L;

	@Inject
	private MessageContext messageContext;

	@Inject
	@Name("messages")
	private ResourceBundle bundle;

	/* DatasetCode[desempenhoBimestralblock] */
	@Inject
	private DesempenhoBimestralBC desempenhoBimestralBC;
	
	@Inject
	private ContextMB context;
	
	private List<DesempenhoBimestral> desempenhoBimestralResultList;
	
	public List<DesempenhoBimestral> getDesempenhoBimestralResultList() {
		AlunoBC alunoBc = new AlunoBC();
		Aluno aluno = alunoBc.load(new Long(context.getUser().getId()));
		HashMap<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("aluno", aluno);
		desempenhoBimestralResultList = desempenhoBimestralBC.findByCriteria(parameters);
		calculaMediaBimestral();
		return desempenhoBimestralResultList;
	}
	
	public void setDesempenhoBimestralResultList(List<DesempenhoBimestral> desempenhoBimestralResultList) {
		this.desempenhoBimestralResultList = desempenhoBimestralResultList;
	}
	
	public void calculaMediaBimestral() {
		for (DesempenhoBimestral item : desempenhoBimestralBC.findAll()) {
			item.setMediaBimestre((item.getNota1() + item.getNota2() + item.getNota3())/3);
		}
	}
	/* DatasetCode[desempenhoBimestralblock] */

}
