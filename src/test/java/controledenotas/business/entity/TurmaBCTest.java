package controledenotas.business.entity;

import controledenotas.domain.entity.Turma;
import controledenotas.business.entity.TurmaBC;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.util.*;
import javax.inject.Inject;
import org.junit.*;
import org.junit.runner.RunWith;
import br.gov.frameworkdemoiselle.junit.DemoiselleRunner;

@RunWith(DemoiselleRunner.class)
public class TurmaBCTest {

	@Inject
	private TurmaBC turmaBC;

	@Before
	public void before() {
		for (Turma turma : turmaBC.findAll()) {
		  turmaBC.delete(turma.getCodigo());
		}
	}

	@After
	public void after() {
		before();
	}

	@Test
	public void insert() {
		Turma turma = new Turma();
		turma.setNome("XXX");
		turmaBC.insert(turma);
		List<Turma> turmaList = turmaBC.findAll();
		assertNotNull(turmaList);
		assertEquals(1, turmaList.size());
	}

	@Test
	public void update() {
		Turma turma = new Turma();
		turma.setNome("XXX");
		turmaBC.insert(turma);
		List<Turma> turmaList = turmaBC.findAll();
		assertNotNull(turmaList);
		assertTrue(turmaList.size()>0);
		Turma beforeUpdate = turmaList.get(0);
		assertEquals("XXX", beforeUpdate.getNome());
		beforeUpdate.setNome("YYY");
		turmaBC.update(beforeUpdate);
		turmaList = turmaBC.findAll();
		Turma afterUpdate = turmaList.get(0);
		assertEquals("YYY", afterUpdate.getNome());
	}

	@Test
	public void delete() {
		Turma turma = new Turma();
		turma.setNome("XXX");
		turmaBC.insert(turma);
		List<Turma> turmaList = turmaBC.findAll();
		assertNotNull(turmaList);
		assertEquals(1, turmaList.size());
		  turmaBC.delete(turma.getCodigo());
		turmaList = turmaBC.findAll();
		assertEquals(0, turmaList.size());
	}

}

