package controledenotas.security;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import controledenotas.domain.entity.Role;
import controledenotas.persistence.entity.UserDAO;
import br.gov.frameworkdemoiselle.security.User;

public class JPAAuthenticator implements br.gov.frameworkdemoiselle.security.Authenticator {

  private static final long serialVersionUID = 1L;

  @Inject
  private Credential credential;

  @Inject
  private UserDAO userDAO;

  @Override
  public boolean authenticate() {
    String username = credential.getUsername();
    String password = credential.getPassword();
    controledenotas.domain.entity.User userEntity = authenticate(username, password);
    if (userEntity == null || userEntity.getId() == null) {
      return false;
    }
    User user = credential.getUser();
    if (user == null) {
	    user = new controledenotas.security.User();
      credential.setUser(user);
    }
    ((controledenotas.security.User)user).setId(userEntity.getId().toString());
    ((controledenotas.security.User)user).setLogin(credential.getUsername());
    user.setAttribute(controledenotas.security.User.NAME_ATTRIBUTE, userEntity.getName());
    Set<String> roles = new HashSet<String>();
    List<Role> rolesEntity = userEntity.getRoles();
    if (rolesEntity != null) {
      for (Role role: rolesEntity) {
        roles.add(role.getName());
      }
    }
    user.setAttribute(controledenotas.security.User.ROLES_ATTRIBUTE, roles);
    /*
    Map<String, String> resourceMap = new HashMap<String, String>();
    resourceMap.put("role", "find");
    user.putAllAttribute(controledenotas.security.User.RESOURCES_ATTRIBUTE, resourceMap);
    */
    return true;
  }

  private controledenotas.domain.entity.User authenticate(String username, String password) {
    controledenotas.domain.entity.User user = null;
    controledenotas.domain.entity.User userExample = new controledenotas.domain.entity.User();
    userExample.setEmail(username);
    List<controledenotas.domain.entity.User> userList = userDAO.findByExample(userExample);
    if (userList == null || userList.size()==0) {
      return null;
    }
    user = userList.get(0);
    String currentPassword = user.getPassword();
    if (currentPassword != null) {
      if (!currentPassword.equals(controledenotas.security.SecurityHelper.cryptMD5(password))) {
        return null;
      }
    }
    return user;
  }

  @Override
  public void unAuthenticate() {
    credential.clear();
  }

  @Override
  public User getUser() {
		return credential.getUser();
  }

}
