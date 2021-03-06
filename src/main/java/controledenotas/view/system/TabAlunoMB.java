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
import controledenotas.persistence.entity.RoleDAO;
@ViewController
@PreviousView("/system/login.xhtml")
@NextView("/system/tabAluno.xhtml")
public class TabAlunoMB extends AbstractPageBean {

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
	
	@Transactional
	public String salvarAluno() {
		/* TriggerCall[blocoAluno.salvarAluno.cadastraDesempenho] */
		cadastraDesempenho();
		/* TriggerCall[blocoAluno.salvarAluno.cadastraDesempenho] */
		/* TriggerCall[blocoAluno.salvarAluno.cadastraPapel] */
		cadastraPapel();
		/* TriggerCall[blocoAluno.salvarAluno.cadastraPapel] */
		this.alunoBC.update(getAluno());
		messageContext.add(new DefaultMessage("{pages.msg.updatesuccess}"));
		return getCurrentView();
	}
	
	/* Trigger[blocoAluno.salvarAluno.cadastraDesempenho] */
	private void cadastraDesempenho(){
	for (int i = 1; i <= 4; i++) {
				// Botao de insert
				DesempenhoBimestral bimestral = new DesempenhoBimestral();
				bimestral.setNumero(i);
				bimestral.setAluno(getAluno());
				bimestral.setNota1(0.0);
				bimestral.setNota2(0.0);
				bimestral.setNota3(0.0);
				getAluno().getDesempenhosBimestrais().add(bimestral);
			}
			
			Desempenho desempenho = new Desempenho();
			desempenho.setMediaFinal(0.0);
			desempenho.setMediaParcial(0.0);
			desempenho.setSituacao("REPROVADO");
			desempenho.setAluno(getAluno());
			aluno.getDesempenhos().add(desempenho);
	}
	
	/* Trigger[blocoAluno.salvarAluno.cadastraDesempenho] */
	
	/* Trigger[blocoAluno.salvarAluno.cadastraPapel] */
	private void cadastraPapel(){
		RoleDAO roleDAO = new RoleDAO();
		//Caso o papel no exista, crie
		Role papel = roleDAO.load("aluno");
		if(papel == null){
			papel = new Role();
			papel.setName("aluno");
		}
		getAluno().getUser().getRoles().add(papel);
	}
	
	/* Trigger[blocoAluno.salvarAluno.cadastraPapel] */

}
