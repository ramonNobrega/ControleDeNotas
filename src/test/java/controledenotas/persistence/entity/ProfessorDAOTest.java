package controledenotas.persistence.entity;

import controledenotas.domain.entity.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.util.*;
import javax.inject.Inject;
import org.junit.*;
import org.junit.runner.RunWith;
import br.gov.frameworkdemoiselle.junit.DemoiselleRunner;

@RunWith(DemoiselleRunner.class)
public class ProfessorDAOTest {

	@Inject
	private ProfessorDAO professorDAO;

	@Before
	public void before() {
		for (Professor professor : professorDAO.findAll()) {
		  professorDAO.delete(professor.getMatricula());
		}
	}

	@After
	public void after() {
		before();
	}

	@Test
	public void insert() {
		Professor professor = new Professor();
		professor.setMatricula(new Integer("1"));
		professor.setNome("XXXXXXXXXXXXXXXXXXXX");
		professor.setSenha("XXXXXXXXXXXXXXXXXXXX");
		professorDAO.insert(professor);
		List<Professor> professorList = professorDAO.findAll();
		assertNotNull(professorList);
		assertEquals(1, professorList.size());
	}

	@Test
	public void update() {
		Professor professor = new Professor();
		professor.setMatricula(new Integer("1"));
		professor.setNome("XXXXXXXXXXXXXXXXXXXX");
		professor.setSenha("XXXXXXXXXXXXXXXXXXXX");
		professorDAO.insert(professor);
		List<Professor> professorList = professorDAO.findAll();
		assertNotNull(professorList);
		assertTrue(professorList.size()>0);
		Professor beforeUpdate = professorList.get(0);
		assertEquals("XXXXXXXXXXXXXXXXXXXX", beforeUpdate.getSenha());
		beforeUpdate.setSenha("YYYYYYYYYYYYYYYYYYYY");
		professorDAO.update(beforeUpdate);
		professorList = professorDAO.findAll();
		Professor afterUpdate = professorList.get(0);
		assertEquals("YYYYYYYYYYYYYYYYYYYY", afterUpdate.getSenha());
	}

	@Test
	public void delete() {
		Professor professor = new Professor();
		professor.setMatricula(new Integer("1"));
		professor.setNome("XXXXXXXXXXXXXXXXXXXX");
		professor.setSenha("XXXXXXXXXXXXXXXXXXXX");
		professorDAO.insert(professor);
		List<Professor> professorList = professorDAO.findAll();
		assertNotNull(professorList);
		assertEquals(1, professorList.size());
		professorDAO.delete(professor.getMatricula());
		professorList = professorDAO.findAll();
		assertEquals(0, professorList.size());
	}

}

