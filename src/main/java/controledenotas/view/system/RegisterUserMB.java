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

import controledenotas.domain.entity.User;
import controledenotas.business.entity.UserBC;
import controledenotas.domain.entity.Aluno;
import controledenotas.business.entity.AlunoBC;
import controledenotas.persistence.entity.RoleDAO;

@ViewController
@PreviousView("/system/home.xhtml")
@NextView("/system/home.xhtml")
public class RegisterUserMB extends AbstractPageBean {

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
	
	/* Button[blocoAluno.inserirAluno] */
	@Transactional
	public String inserirAluno() {
			RoleDAO roleDAO = new RoleDAO();
			//Caso o papel no exista, crie
			Role papel = roleDAO.load("aluno");
			if(papel == null){
				papel = new Role();
				papel.setName("aluno");
			}
			getAluno().getUser().getRoles().add(papel);
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
			this.alunoBC.insert(getAluno());
			messageContext.add(new DefaultMessage("{pages.msg.updatesuccess}"));
			return getCurrentView();
	}
	/* Button[blocoAluno.inserirAluno] */
	
	private User user = new User();
	
	public User getUser() {
		return this.user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	@Inject
	private UserBC userBC;
	
	private String email;
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	private String password;
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	private String confirmPassword;
	
	public String getConfirmPassword() {
		return this.confirmPassword;
	}
	
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	/* Button[edit.registerNewUser] */
	
	@Transactional
	public String registerNewUser() {
		try {
			User userExample = new User();
			userExample.setEmail(email);
			List<User> userList = userBC.findByExample(userExample);
			if (userList != null && userList.size()>0) {
			  messageContext.add("{system.maintainuser.validation.duplicatedemail}", SeverityType.ERROR);
			  return getCurrentView();
			}
			this.userBC.registerNewUser(getUser(), email, password);
			messageContext.add(new DefaultMessage("{pages.msg.insertsuccess}"));
		} catch (Exception e) {
			messageContext.add("{pages.msg.error}", SeverityType.ERROR, e.getMessage());
		}
		return getCurrentView();
	}
	/* Button[edit.registerNewUser] */

}
