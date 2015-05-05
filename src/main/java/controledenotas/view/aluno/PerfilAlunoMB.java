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
import controledenotas.business.entity.AlunoBC;
import controledenotas.business.entity.DesempenhoBC;
import controledenotas.domain.entity.Aluno;
import javax.faces.model.SelectItem;
import br.gov.frameworkdemoiselle.report.Type;

@ViewController
@PreviousView("/aluno/perfilAluno.xhtml")
@NextView("/aluno/perfilAluno.xhtml")
public class PerfilAlunoMB extends AbstractListPageBean<Aluno, Integer> {

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
	private AlunoBC alunoBC;
	
	public SelectItem[] getDesempenhosListList() {
		Type[] types = Type.values();
		SelectItem[] options = new SelectItem[types.length];
		for (int i=0; i<types.length; i++) {
			Type type = types[i];
			options[i] = new SelectItem(type, type.name());
		}
		return options;
	}
	
	public SelectItem[] getDesempenhoBimestralListList() {
		Type[] types = Type.values();
		SelectItem[] options = new SelectItem[types.length];
		for (int i=0; i<types.length; i++) {
			Type type = types[i];
			options[i] = new SelectItem(type, type.name());
		}
		return options;
	}

}
