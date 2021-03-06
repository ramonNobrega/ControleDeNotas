package controledenotas.business.entity;

import controledenotas.domain.entity.Role;
import controledenotas.domain.entity.User;
import controledenotas.persistence.entity.UserDAO;
import java.util.*;
import javax.inject.Inject;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.gov.frameworkdemoiselle.annotation.Name;
import java.util.ResourceBundle;

@BusinessController
public class UserBC extends DelegateCrud<User, Long, UserDAO> {

	private static final long serialVersionUID = 1L;

	public List<User> findByExample(User example) {
		return getDelegate().findByExample(example);
	}

	@Inject
	@Name("messages")
	private ResourceBundle bundle;

	@br.gov.frameworkdemoiselle.transaction.Transactional
	public void changePassword(User user, String currentPassword, String newPassword) throws Exception {
		if (user != null) {
			String password = user.getPassword();
			if (password != null) {
				if (!password.equals(controledenotas.security.SecurityHelper.cryptMD5(currentPassword))) {
					throw new Exception(bundle.getString("business.entity.user.message1"));
				}
			}
			user.setPassword(newPassword);
			update(user);
		}
	}
	
	@Inject
	private controledenotas.persistence.entity.UserDAO userDAO;
	
	@Inject
	private controledenotas.persistence.entity.RoleDAO roleDAO;
	
	@Transactional
	public void registerNewUser(User user, String email, String password) {
		user.setEmail(email);
		user.setPassword(password);
		Role example = new Role();
		example.setName("user");
		List<Role> roles = roleDAO.findByExample(example);
		if (roles != null && roles.size()>0) {
			user.setRoles(roles);
		}
		userDAO.insert(user);
	}
	

}

