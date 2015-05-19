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
import controledenotas.security.ContextMB;
@ViewController
@PreviousView("/professor/tabManterDesempenhoBimestral.xhtml")
@NextView("/professor/tabManterDesempenhoBimestralDetail.xhtml")
public class TabManterDesempenhoBimestralMB extends AbstractListPageBean<DesempenhoBimestral, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private MessageContext messageContext;

	@Inject
	@Name("messages")
	private ResourceBundle bundle;

	@Inject
	private DesempenhoBimestralBC desempenhoBimestralBC;
	
	@Inject
	private ContextMB context;
	
	@Override
	protected List<DesempenhoBimestral> handleResultList() {
		List<DesempenhoBimestral> desempenhoBimestralList = new ArrayList<DesempenhoBimestral>();
		ProfessorBC professorBC = new ProfessorBC();
		Professor professor = professorBC.load(new Long(context.getUser().getId()));
		for (DesempenhoBimestral item : desempenhoBimestralBC.findAll()) {
			if (item.getAluno().getTurma().equals(professor.getTurma())){
				desempenhoBimestralList.add(item);
			}
		}
		calculaMediaBimestral();
		//calculaMediaFinal();
		return desempenhoBimestralList;
	}
	
	/* Trigger[list.handleResultList.calculaMediaBimestral] */
	public void calculaMediaBimestral() {
		for (DesempenhoBimestral item : desempenhoBimestralBC.findAll()) {
			item.setMediaBimestre((item.getNota1() + item.getNota2() + item.getNota3())/3);
		}
	}
	/* Trigger[list.handleResultList.calculaMediaBimestral] */
	
	public void calculaMediaFinal(){
		DesempenhoBC desempenhoBC = new DesempenhoBC();
		for (DesempenhoBimestral item : desempenhoBimestralBC.findAll()) {
			Desempenho desempenho = desempenhoBC.load(new Long(item.getAluno().getUser().getId()));
			desempenho.setMediaParcial(item.getMediaBimestre()/4);
			desempenhoBC.update(desempenho);
		}
	}
}
