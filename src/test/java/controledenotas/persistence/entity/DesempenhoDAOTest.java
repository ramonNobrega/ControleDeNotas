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
public class DesempenhoDAOTest {

	@Inject
	private DesempenhoDAO desempenhoDAO;

	@Inject
	private ObjectDAO objectDAO;

	@Before
	public void before() {
		for (Desempenho desempenho : desempenhoDAO.findAll()) {
		desempenhoDAO.delete(desempenho.getIdDesempenho());
		}
	}

	@After
	public void after() {
		before();
	}

	@Test
	public void insert() {
		Desempenho desempenho = new Desempenho();
		Object idDesempenho = new Object();
		objectDAO.insert(idDesempenho);
		desempenho.setIdDesempenho(idDesempenho);
		desempenhoDAO.insert(desempenho);
		List<Desempenho> desempenhoList = desempenhoDAO.findAll();
		assertNotNull(desempenhoList);
		assertEquals(1, desempenhoList.size());
	}

	@Test
	public void update() {
		Desempenho desempenho = new Desempenho();
		Object idDesempenho = new Object();
		objectDAO.insert(idDesempenho);
		desempenho.setIdDesempenho(idDesempenho);
		Object mediaParcial = new Object();
		objectDAO.insert(mediaParcial);
		desempenho.setMediaParcial(mediaParcial);
		desempenhoDAO.insert(desempenho);
		List<Desempenho> desempenhoList = desempenhoDAO.findAll();
		assertNotNull(desempenhoList);
		assertTrue(desempenhoList.size()>0);
		Desempenho beforeUpdate = desempenhoList.get(0);
		assertEquals("XXXXXXXXXXXXXXXXXXXX", beforeUpdate.getSituacao());
		beforeUpdate.setSituacao("YYYYYYYYYYYYYYYYYYYY");
		desempenhoDAO.update(beforeUpdate);
		desempenhoList = desempenhoDAO.findAll();
		Desempenho afterUpdate = desempenhoList.get(0);
		assertEquals("YYYYYYYYYYYYYYYYYYYY", afterUpdate.getSituacao());
	}

	@Test
	public void delete() {
		Desempenho desempenho = new Desempenho();
		Object idDesempenho = new Object();
		objectDAO.insert(idDesempenho);
		desempenho.setIdDesempenho(idDesempenho);
		desempenhoDAO.insert(desempenho);
		List<Desempenho> desempenhoList = desempenhoDAO.findAll();
		assertNotNull(desempenhoList);
		assertEquals(1, desempenhoList.size());
		desempenhoDAO.delete(desempenho.getIdDesempenho());
		desempenhoList = desempenhoDAO.findAll();
		assertEquals(0, desempenhoList.size());
	}

}

