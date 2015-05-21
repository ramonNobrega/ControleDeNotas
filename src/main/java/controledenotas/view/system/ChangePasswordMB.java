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
import controledenotas.security.ContextMB;

@ViewController
@PreviousView("/system/home.xhtml")
@NextView("/system/home.xhtml")
public class ChangePasswordMB extends AbstractPageBean {

	private static final long serialVersionUID = 1L;

	@Inject
	private MessageContext messageContext;

	@Inject
	@Name("messages")
	private ResourceBundle bundle;

	private User user = new User();
	
	public User getUser() {
		return this.user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	@Inject
	private UserBC userBC;
	
	private String currentPassword;
	
	public String getCurrentPassword() {
		return this.currentPassword;
	}
	
	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}
	
	private String newPassword;
	
	public String getNewPassword() {
		return this.newPassword;
	}
	
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	private String confirmPassword;
	
	public String getConfirmPassword() {
		return this.confirmPassword;
	}
	
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	@Inject
	private ContextMB contextMB;
	
	public ContextMB getContextMB() {
		return this.contextMB;
	}
	
	public void setContextMB(ContextMB contextMB) {
		this.contextMB = contextMB;
	}
	
	/* Button[edit.update] */
	@Transactional
	public String update() {
		try {
			this.userBC.changePassword(getUser(), this.getCurrentPassword(), this.getNewPassword());
			messageContext.add(new DefaultMessage("{pages.msg.updatesuccess}"));
		} catch (Exception e) {
			messageContext.add("{pages.msg.error}", SeverityType.ERROR, e.getMessage());
		}
		return getCurrentView();
	}
	/* Button[edit.update] */
	
	/* Button[edit.handleLoad] */
	@PostConstruct
	protected void handleLoad() {
		String _id = contextMB.getUser().getId();
		setUser(userBC.load(Long.valueOf(_id)));
	}
	/* Button[edit.handleLoad] */

}
