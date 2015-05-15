package controledenotas.view.aluno;

import java.util.*;

import javax.annotation.*;
import javax.inject.Inject;

import com.mysql.fabric.xmlrpc.base.Array;

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
import controledenotas.security.ContextMB;
import controledenotas.business.entity.AlunoBC;
import controledenotas.domain.entity.Aluno;

@ViewController
@PreviousView("/aluno/tabDadosAlunoForm.xhtml")
@NextView("/aluno/tabDadosAlunoForm.xhtml")
public class TabDadosAlunoFormMB extends AbstractPageBean {

	private static final long serialVersionUID = 1L;

	@Inject
	private ContextMB context;
	
	@Inject
	private MessageContext messageContext;

	@Inject
	@Name("messages")
	private ResourceBundle bundle;

	@Inject
	private AlunoBC alunoBC;
	
	private List<Aluno> alunoResultList;
	
	public List<Aluno> getAlunoResultList() {
		alunoResultList = new ArrayList<Aluno>();
		Aluno a = this.alunoBC.load(new Long(context.getUser().getId()));
		alunoResultList.add(a);
		return alunoResultList;
	}
	
	public void setAlunoResultList(List<Aluno> alunoResultList) {
		this.alunoResultList = alunoResultList;
	}

}
