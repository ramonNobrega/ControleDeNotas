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

	@Inject
	private ObjectDAO objectDAO;

	@Before
	public void before() {
		for (Professor professor : professorDAO.findAll()) {
		professorDAO.delete(professor.getMatriculaDoProfessor());
		}
	}

	@After
	public void after() {
		before();
	}

	@Test
	public void insert() {
		Professor professor = new Professor();
		Object matriculaDoProfessor = new Object();
		objectDAO.insert(matriculaDoProfessor);
		professor.setMatriculaDoProfessor(matriculaDoProfessor);
		professor.setSenhaDoProfessor("XXXXXXXXXXXXXXXXXXXX");
		professorDAO.insert(professor);
		List<Professor> professorList = professorDAO.findAll();
		assertNotNull(professorList);
		assertEquals(1, professorList.size());
	}

	@Test
	public void update() {
		Professor professor = new Professor();
		Object matriculaDoProfessor = new Object();
		objectDAO.insert(matriculaDoProfessor);
		professor.setMatriculaDoProfessor(matriculaDoProfessor);
		professor.setNomeDoProfessor("XXXXXXXXXXXXXXXXXXXX");
		professor.setSenhaDoProfessor("XXXXXXXXXXXXXXXXXXXX");
		professorDAO.insert(professor);
		List<Professor> professorList = professorDAO.findAll();
		assertNotNull(professorList);
		assertTrue(professorList.size()>0);
		Professor beforeUpdate = professorList.get(0);
		assertEquals("XXXXXXXXXXXXXXXXXXXX", beforeUpdate.getSenhaDoProfessor());
		beforeUpdate.setSenhaDoProfessor("YYYYYYYYYYYYYYYYYYYY");
		professorDAO.update(beforeUpdate);
		professorList = professorDAO.findAll();
		Professor afterUpdate = professorList.get(0);
		assertEquals("YYYYYYYYYYYYYYYYYYYY", afterUpdate.getSenhaDoProfessor());
	}

	@Test
	public void delete() {
		Professor professor = new Professor();
		Object matriculaDoProfessor = new Object();
		objectDAO.insert(matriculaDoProfessor);
		professor.setMatriculaDoProfessor(matriculaDoProfessor);
		professor.setSenhaDoProfessor("XXXXXXXXXXXXXXXXXXXX");
		professorDAO.insert(professor);
		List<Professor> professorList = professorDAO.findAll();
		assertNotNull(professorList);
		assertEquals(1, professorList.size());
		professorDAO.delete(professor.getMatriculaDoProfessor());
		professorList = professorDAO.findAll();
		assertEquals(0, professorList.size());
	}

}

