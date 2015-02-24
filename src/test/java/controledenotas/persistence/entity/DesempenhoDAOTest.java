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

	@Before
	public void before() {
		for (Desempenho desempenho : desempenhoDAO.findAll()) {
		  desempenhoDAO.delete(desempenho.getMatricula());
		}
	}

	@After
	public void after() {
		before();
	}

	@Test
	public void insert() {
		Desempenho desempenho = new Desempenho(0, null);
		desempenho.setMatricula(new Integer("1"));
		desempenhoDAO.insert(desempenho);
		List<Desempenho> desempenhoList = desempenhoDAO.findAll();
		assertNotNull(desempenhoList);
		assertEquals(1, desempenhoList.size());
	}

	@Test
	public void update() {
		Desempenho desempenho = new Desempenho(0, null);
		desempenho.setMatricula(new Integer("1"));
		desempenho.setMediaParcial(new Integer("1"));
		desempenhoDAO.insert(desempenho);
		List<Desempenho> desempenhoList = desempenhoDAO.findAll();
		assertNotNull(desempenhoList);
		assertTrue(desempenhoList.size()>0);
		Desempenho beforeUpdate = desempenhoList.get(0);
		assertEquals(new Integer("1"), beforeUpdate.getMediaParcial());
		beforeUpdate.setMediaParcial(new Integer("2"));
		desempenhoDAO.update(beforeUpdate);
		desempenhoList = desempenhoDAO.findAll();
		Desempenho afterUpdate = desempenhoList.get(0);
		assertEquals(new Integer("2"), afterUpdate.getMediaParcial());
	}

	@Test
	public void delete() {
		Desempenho desempenho = new Desempenho(0, null);
		desempenho.setMatricula(new Integer("1"));
		desempenhoDAO.insert(desempenho);
		List<Desempenho> desempenhoList = desempenhoDAO.findAll();
		assertNotNull(desempenhoList);
		assertEquals(1, desempenhoList.size());
		desempenhoDAO.delete(desempenho.getMatricula());
		desempenhoList = desempenhoDAO.findAll();
		assertEquals(0, desempenhoList.size());
	}

}

