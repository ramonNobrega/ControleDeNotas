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
		/*for (Professor professor : professorDAO.findAll()) {
		professorDAO.delete(professor.getUser().getId());
		}*/
	}

	@After
	public void after() {
		before();
	}

	@Test
	public void insert() {
		Professor professor = new Professor();
		User usuario = new User();
		usuario.setName("Elton");
		usuario.setEmail("eltonborges@egen.com.br");
		usuario.setPassword("12345");
		RoleDAO roleDAO = new RoleDAO();
		//Caso o papel no exista, crie
		Role papel = roleDAO.load("professor");
		if(papel == null){
			papel = new Role();
			papel.setName("professor");
		}
		usuario.getRoles().add(papel);
		professor.setUser(usuario);
		professor.setDisciplina("Desenvolvimento de Sistemas");
		HashMap<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("nome", "A");
		TurmaDAO turmaDAO = new TurmaDAO();
		List<Turma> listTurma = turmaDAO.findByCriteria(parameters);
		professor.setTurma(listTurma.get(0));
		professorDAO.insert(professor);
		List<Professor> professorList = professorDAO.findAll();
		assertNotNull(professorList);
		assertEquals(1, professorList.size());
	}

	@Test
	public void update() {
		Professor professor = new Professor();
		professor.setDisciplina("XXXXXXXXXXXXXXXXXXXX");
		professorDAO.insert(professor);
		List<Professor> professorList = professorDAO.findAll();
		assertNotNull(professorList);
		assertTrue(professorList.size()>0);
		Professor beforeUpdate = professorList.get(0);
		assertEquals("XXXXXXXXXXXXXXXXXXXX", beforeUpdate.getDisciplina());
		beforeUpdate.setDisciplina("YYYYYYYYYYYYYYYYYYYY");
		professorDAO.update(beforeUpdate);
		professorList = professorDAO.findAll();
		Professor afterUpdate = professorList.get(0);
		assertEquals("YYYYYYYYYYYYYYYYYYYY", afterUpdate.getDisciplina());
	}

	@Test
	public void delete() {
		Professor professor = new Professor();
		professorDAO.insert(professor);
		List<Professor> professorList = professorDAO.findAll();
		assertNotNull(professorList);
		assertEquals(1, professorList.size());
		professorDAO.delete(professor.getUser().getId());
		professorList = professorDAO.findAll();
		assertEquals(0, professorList.size());
	}

}

