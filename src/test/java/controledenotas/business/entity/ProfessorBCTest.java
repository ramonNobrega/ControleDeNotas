package controledenotas.business.entity;

import controledenotas.domain.entity.Professor;
import controledenotas.business.entity.ProfessorBC;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.util.*;
import javax.inject.Inject;
import org.junit.*;
import org.junit.runner.RunWith;
import br.gov.frameworkdemoiselle.junit.DemoiselleRunner;

@RunWith(DemoiselleRunner.class)
public class ProfessorBCTest {

	@Inject
	private ProfessorBC professorBC;

	@Inject
	private ObjectBC objectBC;

	@Before
	public void before() {
		for (Professor professor : professorBC.findAll()) {
		  professorBC.delete(professor.getMatriculaDoProfessor());
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
		objectBC.insert(matriculaDoProfessor);
		professor.setMatriculaDoProfessor(matriculaDoProfessor);
		professor.setSenhaDoProfessor("XXXXXXXXXXXXXXXXXXXX");
		professorBC.insert(professor);
		List<Professor> professorList = professorBC.findAll();
		assertNotNull(professorList);
		assertEquals(1, professorList.size());
	}

	@Test
	public void update() {
		Professor professor = new Professor();
		Object matriculaDoProfessor = new Object();
		objectBC.insert(matriculaDoProfessor);
		professor.setMatriculaDoProfessor(matriculaDoProfessor);
		professor.setNomeDoProfessor("XXXXXXXXXXXXXXXXXXXX");
		professor.setSenhaDoProfessor("XXXXXXXXXXXXXXXXXXXX");
		professorBC.insert(professor);
		List<Professor> professorList = professorBC.findAll();
		assertNotNull(professorList);
		assertTrue(professorList.size()>0);
		Professor beforeUpdate = professorList.get(0);
		assertEquals("XXXXXXXXXXXXXXXXXXXX", beforeUpdate.getSenhaDoProfessor());
		beforeUpdate.setSenhaDoProfessor("YYYYYYYYYYYYYYYYYYYY");
		professorBC.update(beforeUpdate);
		professorList = professorBC.findAll();
		Professor afterUpdate = professorList.get(0);
		assertEquals("YYYYYYYYYYYYYYYYYYYY", afterUpdate.getSenhaDoProfessor());
	}

	@Test
	public void delete() {
		Professor professor = new Professor();
		Object matriculaDoProfessor = new Object();
		objectBC.insert(matriculaDoProfessor);
		professor.setMatriculaDoProfessor(matriculaDoProfessor);
		professor.setSenhaDoProfessor("XXXXXXXXXXXXXXXXXXXX");
		professorBC.insert(professor);
		List<Professor> professorList = professorBC.findAll();
		assertNotNull(professorList);
		assertEquals(1, professorList.size());
		  professorBC.delete(professor.getMatriculaDoProfessor());
		professorList = professorBC.findAll();
		assertEquals(0, professorList.size());
	}

}

