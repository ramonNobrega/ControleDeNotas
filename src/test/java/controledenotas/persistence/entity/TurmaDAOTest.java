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
public class TurmaDAOTest {

	@Inject
	private TurmaDAO turmaDAO;

	@Before
	public void before() {
//		for (Turma turma : turmaDAO.findAll()) {
//		turmaDAO.delete(turma.getCodigo());
//		}
	}

	@After
	public void after() {
		before();
	}

	@Test
	public void insert() {
		Turma turma = new Turma();
		turma.setNome("A");
		turmaDAO.insert(turma);
		List<Turma> turmaList = turmaDAO.findAll();
		assertNotNull(turmaList);
		assertEquals(1, turmaList.size());
	}

	@Test
	public void update() {
		Turma turma = new Turma();
		turma.setNome("XXX");
		turmaDAO.insert(turma);
		List<Turma> turmaList = turmaDAO.findAll();
		assertNotNull(turmaList);
		assertTrue(turmaList.size()>0);
		Turma beforeUpdate = turmaList.get(0);
		assertEquals("XXX", beforeUpdate.getNome());
		beforeUpdate.setNome("YYY");
		turmaDAO.update(beforeUpdate);
		turmaList = turmaDAO.findAll();
		Turma afterUpdate = turmaList.get(0);
		assertEquals("YYY", afterUpdate.getNome());
	}

	@Test
	public void delete() {
		Turma turma = new Turma();
		turma.setNome("XXX");
		turmaDAO.insert(turma);
		List<Turma> turmaList = turmaDAO.findAll();
		assertNotNull(turmaList);
		assertEquals(1, turmaList.size());
		turmaDAO.delete(turma.getCodigo());
		turmaList = turmaDAO.findAll();
		assertEquals(0, turmaList.size());
	}

}

