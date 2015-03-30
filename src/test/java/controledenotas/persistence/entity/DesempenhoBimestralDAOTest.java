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
public class DesempenhoBimestralDAOTest {

	@Inject
	private DesempenhoBimestralDAO desempenhoBimestralDAO;

	@Inject
	private ObjectDAO objectDAO;

	@Before
	public void before() {
		for (DesempenhoBimestral desempenhoBimestral : desempenhoBimestralDAO.findAll()) {
		desempenhoBimestralDAO.delete(desempenhoBimestral.getIdBimestre());
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
		objectDAO.insert(idBimestre);
		desempenhoBimestral.setIdBimestre(idBimestre);
		desempenhoBimestralDAO.insert(desempenhoBimestral);
		List<DesempenhoBimestral> desempenhoBimestralList = desempenhoBimestralDAO.findAll();
		assertNotNull(desempenhoBimestralList);
		assertEquals(1, desempenhoBimestralList.size());
	}

	@Test
	public void update() {
		DesempenhoBimestral desempenhoBimestral = new DesempenhoBimestral();
		Object idBimestre = new Object();
		objectDAO.insert(idBimestre);
		desempenhoBimestral.setIdBimestre(idBimestre);
		Object nota1 = new Object();
		objectDAO.insert(nota1);
		desempenhoBimestral.setNota1(nota1);
		desempenhoBimestralDAO.insert(desempenhoBimestral);
		List<DesempenhoBimestral> desempenhoBimestralList = desempenhoBimestralDAO.findAll();
		assertNotNull(desempenhoBimestralList);
		assertTrue(desempenhoBimestralList.size()>0);
	}

	@Test
	public void delete() {
		DesempenhoBimestral desempenhoBimestral = new DesempenhoBimestral();
		Object idBimestre = new Object();
		objectDAO.insert(idBimestre);
		desempenhoBimestral.setIdBimestre(idBimestre);
		desempenhoBimestralDAO.insert(desempenhoBimestral);
		List<DesempenhoBimestral> desempenhoBimestralList = desempenhoBimestralDAO.findAll();
		assertNotNull(desempenhoBimestralList);
		assertEquals(1, desempenhoBimestralList.size());
		desempenhoBimestralDAO.delete(desempenhoBimestral.getIdBimestre());
		desempenhoBimestralList = desempenhoBimestralDAO.findAll();
		assertEquals(0, desempenhoBimestralList.size());
	}

}

