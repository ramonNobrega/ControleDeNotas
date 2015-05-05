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

	@Before
	public void before() {
		for (DesempenhoBimestral desempenhoBimestral : desempenhoBimestralDAO.findAll()) {
		desempenhoBimestralDAO.delete(desempenhoBimestral.getId());
		}
	}

	@After
	public void after() {
		before();
	}

	@Test
	public void insert() {
		DesempenhoBimestral desempenhoBimestral = new DesempenhoBimestral();
		desempenhoBimestral.setNumero(new Integer("1"));
		desempenhoBimestralDAO.insert(desempenhoBimestral);
		List<DesempenhoBimestral> desempenhoBimestralList = desempenhoBimestralDAO.findAll();
		assertNotNull(desempenhoBimestralList);
		assertEquals(1, desempenhoBimestralList.size());
	}

	@Test
	public void update() {
		DesempenhoBimestral desempenhoBimestral = new DesempenhoBimestral();
		desempenhoBimestral.setNumero(new Integer("1"));
		desempenhoBimestralDAO.insert(desempenhoBimestral);
		List<DesempenhoBimestral> desempenhoBimestralList = desempenhoBimestralDAO.findAll();
		assertNotNull(desempenhoBimestralList);
		assertTrue(desempenhoBimestralList.size()>0);
		DesempenhoBimestral beforeUpdate = desempenhoBimestralList.get(0);
		assertEquals(new Integer("1"), beforeUpdate.getNumero());
		beforeUpdate.setNumero(new Integer("2"));
		desempenhoBimestralDAO.update(beforeUpdate);
		desempenhoBimestralList = desempenhoBimestralDAO.findAll();
		DesempenhoBimestral afterUpdate = desempenhoBimestralList.get(0);
		assertEquals(new Integer("2"), afterUpdate.getNumero());
	}

	@Test
	public void delete() {
		DesempenhoBimestral desempenhoBimestral = new DesempenhoBimestral();
		desempenhoBimestral.setNumero(new Integer("1"));
		desempenhoBimestralDAO.insert(desempenhoBimestral);
		List<DesempenhoBimestral> desempenhoBimestralList = desempenhoBimestralDAO.findAll();
		assertNotNull(desempenhoBimestralList);
		assertEquals(1, desempenhoBimestralList.size());
		desempenhoBimestralDAO.delete(desempenhoBimestral.getId());
		desempenhoBimestralList = desempenhoBimestralDAO.findAll();
		assertEquals(0, desempenhoBimestralList.size());
	}

}

