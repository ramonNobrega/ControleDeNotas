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

	@Inject
	private ObjectBC objectBC;

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
		Object idBimestre = new Object();
		objectBC.insert(idBimestre);
		desempenhoBimestral.setIdBimestre(idBimestre);
		desempenhoBimestralBC.insert(desempenhoBimestral);
		List<DesempenhoBimestral> desempenhoBimestralList = desempenhoBimestralBC.findAll();
		assertNotNull(desempenhoBimestralList);
		assertEquals(1, desempenhoBimestralList.size());
	}

	@Test
	public void update() {
		DesempenhoBimestral desempenhoBimestral = new DesempenhoBimestral();
		Object idBimestre = new Object();
		objectBC.insert(idBimestre);
		desempenhoBimestral.setIdBimestre(idBimestre);
		Object nota1 = new Object();
		objectBC.insert(nota1);
		desempenhoBimestral.setNota1(nota1);
		desempenhoBimestralBC.insert(desempenhoBimestral);
		List<DesempenhoBimestral> desempenhoBimestralList = desempenhoBimestralBC.findAll();
		assertNotNull(desempenhoBimestralList);
		assertTrue(desempenhoBimestralList.size()>0);
	}

	@Test
	public void delete() {
		DesempenhoBimestral desempenhoBimestral = new DesempenhoBimestral();
		Object idBimestre = new Object();
		objectBC.insert(idBimestre);
		desempenhoBimestral.setIdBimestre(idBimestre);
		desempenhoBimestralBC.insert(desempenhoBimestral);
		List<DesempenhoBimestral> desempenhoBimestralList = desempenhoBimestralBC.findAll();
		assertNotNull(desempenhoBimestralList);
		assertEquals(1, desempenhoBimestralList.size());
		  desempenhoBimestralBC.delete(desempenhoBimestral.getIdBimestre());
		desempenhoBimestralList = desempenhoBimestralBC.findAll();
		assertEquals(0, desempenhoBimestralList.size());
	}

}

