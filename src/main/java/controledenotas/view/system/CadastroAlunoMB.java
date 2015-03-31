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

import controledenotas.domain.entity.Aluno;
import controledenotas.business.entity.AlunoBC;
import controledenotas.business.entity.ProfessorBC;

@ViewController
@PreviousView("/system/cadastroAluno.xhtml")
@NextView("/system/cadastroAluno.xhtml")
public class CadastroAlunoMB extends AbstractPageBean {

	private static final long serialVersionUID = 1L;

	@Inject
	private MessageContext messageContext;

	@Inject
	@Name("messages")
	private ResourceBundle bundle;

	private Aluno aluno = new Aluno();
	
	public Aluno getAluno() {
		return this.aluno;
	}
	
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	@Inject
	private AlunoBC alunoBC;
	
	@Inject
	private ProfessorBC professorBC;
	
	public List<Professor> getProfessorList() {
		List<Professor> list = professorBC.findAll();
		if (list == null) {
			list = new ArrayList<Professor>();
		}
		return list;
	}
	
	@Transactional
	public String insert() {
		this.alunoBC.insert(getAluno());
		messageContext.add(new DefaultMessage("{pages.msg.insertsuccess}"));
		return getPreviousView();
	}
	
	@Transactional
	public String save() {
		this.alunoBC.update(getAluno());
		messageContext.add(new DefaultMessage("{pages.msg.updatesuccess}"));
		return getCurrentView();
	}

}
