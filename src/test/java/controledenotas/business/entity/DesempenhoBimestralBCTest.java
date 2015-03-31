package controledenotas.business.entity;

import controledenotas.domain.entity.DesempenhoBimestral;
import controledenotas.business.entity.DesempenhoBimestralBC;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.util.*;
import javax.inject.Inject;
import org.junit.*;
import org.junit.runner.RunWith;
import br.gov.frameworkdemoiselle.junit.DemoiselleRunner;

@RunWith(DemoiselleRunner.class)
public class DesempenhoBimestralBCTest {

	@Inject
	private DesempenhoBimestralBC desempenhoBimestralBC;

	@Before
	public void before() {
		for (DesempenhoBimestral desempenhoBimestral : desempenhoBimestralBC.findAll()) {
		  desempenhoBimestralBC.delete(desempenhoBimestral.getIdBimestre());
		}
	}

	@After
	public void after() {
		before();
	}

	@Test
	public void insert() {
		DesempenhoBimestral desempenhoBimestral = new DesempenhoBimestral();
		desempenhoBimestral.setIdBimestre(new Integer("1"));
		desempenhoBimestralBC.insert(desempenhoBimestral);
		List<DesempenhoBimestral> desempenhoBimestralList = desempenhoBimestralBC.findAll();
		assertNotNull(desempenhoBimestralList);
		assertEquals(1, desempenhoBimestralList.size());
	}

	@Test
	public void update() {
		DesempenhoBimestral desempenhoBimestral = new DesempenhoBimestral();
		desempenhoBimestral.setIdBimestre(new Integer("1"));
		desempenhoBimestral.setNota1(new Integer("1"));
		desempenhoBimestralBC.insert(desempenhoBimestral);
		List<DesempenhoBimestral> desempenhoBimestralList = desempenhoBimestralBC.findAll();
		assertNotNull(desempenhoBimestralList);
		assertTrue(desempenhoBimestralList.size()>0);
		DesempenhoBimestral beforeUpdate = desempenhoBimestralList.get(0);
		assertEquals(new Integer("1"), beforeUpdate.getNota1());
		beforeUpdate.setNota1(new Integer("2"));
		desempenhoBimestralBC.update(beforeUpdate);
		desempenhoBimestralList = desempenhoBimestralBC.findAll();
		DesempenhoBimestral afterUpdate = desempenhoBimestralList.get(0);
		assertEquals(new Integer("2"), afterUpdate.getNota1());
	}

	@Test
	public void delete() {
		DesempenhoBimestral desempenhoBimestral = new DesempenhoBimestral();
		desempenhoBimestral.setIdBimestre(new Integer("1"));
		desempenhoBimestralBC.insert(desempenhoBimestral);
		List<DesempenhoBimestral> desempenhoBimestralList = desempenhoBimestralBC.findAll();
		assertNotNull(desempenhoBimestralList);
		assertEquals(1, desempenhoBimestralList.size());
		  desempenhoBimestralBC.delete(desempenhoBimestral.getIdBimestre());
		desempenhoBimestralList = desempenhoBimestralBC.findAll();
		assertEquals(0, desempenhoBimestralList.size());
	}

}

