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

import controledenotas.business.entity.UserBC;
import javax.faces.model.SelectItem;
import controledenotas.domain.entity.User;

@ViewController
@PreviousView("/system/maintainUser.xhtml")
@NextView("/system/maintainUserEdit.xhtml")
public class MaintainUserMB extends AbstractListPageBean<User, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private MessageContext messageContext;

	@Inject
	@Name("messages")
	private ResourceBundle bundle;

	@Inject
	private UserBC userBC;
	
	@Inject
	@Name("enum.yesnoboolean")
	private ResourceBundle yesnobooleanBundle;
	
	public SelectItem[] getActiveOptions() {
		Enumeration<String> keys = yesnobooleanBundle.getKeys();
		ArrayList<SelectItem> items = new ArrayList<SelectItem>();
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			items.add(new SelectItem(key, yesnobooleanBundle.getString(key)));
		}
		SelectItem[] options = new SelectItem[items.size()+1];
		options[0] = new SelectItem("", "");
		for (int i=0; i<items.size(); i++) {
			options[i+1] = items.get(i);
		}
		return options;
	}
	
	public String newRecord() {
		return getNextView();
	}
	
	@Transactional
	public String delete() {
		boolean delete = false;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long selectedId = iter.next();
			delete = getSelection().get(selectedId);
			if (delete) {
				userBC.delete(selectedId);
				iter.remove();
			}
		}
		if (delete) {
			messageContext.add(new DefaultMessage("{pages.msg.deletesuccess}"));
		}
		return getCurrentView();
	}
	
	@Override
	protected List<User> handleResultList() {
		return this.userBC.findAll();
	}

}
