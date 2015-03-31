package controledenotas.converter;

import javax.faces.convert.FacesConverter;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.Name;
import java.util.ResourceBundle;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import controledenotas.domain.entity.Professor;
import br.gov.frameworkdemoiselle.util.Beans;
import controledenotas.business.entity.ProfessorBC;

@FacesConverter(forClass = Professor.class)
@ManagedBean(name = "professorConverter")
@Named
public class ProfessorConverter implements Converter {

	@Inject
	@Name("messages")
	private ResourceBundle bundle;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Object result = null;
		if (value != null && value.length()>0) {
			ProfessorBC professorBC = Beans.getReference(ProfessorBC.class);
			result = professorBC.load(Integer.valueOf(value));
		}
		return result;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		String result = null;
		if (value != null && value instanceof Professor) {
			result = ((Professor) value).getMatricula().toString();
		}
		return result;
	}

}

