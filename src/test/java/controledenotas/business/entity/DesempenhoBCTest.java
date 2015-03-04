package controledenotas.business.entity;

import controledenotas.domain.entity.Desempenho;
import controledenotas.business.entity.DesempenhoBC;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.util.*;
import javax.inject.Inject;
import org.junit.*;
import org.junit.runner.RunWith;
import br.gov.frameworkdemoiselle.junit.DemoiselleRunner;

@RunWith(DemoiselleRunner.class)
public class DesempenhoBCTest {

	@Inject
	private DesempenhoBC desempenhoBC;

	@Before
	public void before() {
		for (Desempenho desempenho : desempenhoBC.findAll()) {
		  desempenhoBC.delete(desempenho.getMatricula());
		}
	}

	@After
	public void after() {
		before();
	}

	@Test
	public void insert() {
		Desempenho desempenho = new Desempenho();
		desempenho.setMatricula(new Integer("1"));
		desempenhoBC.insert(desempenho);
		List<Desempenho> desempenhoList = desempenhoBC.findAll();
		assertNotNull(desempenhoList);
		assertEquals(1, desempenhoList.size());
	}

	@Test
	public void update() {
		Desempenho desempenho = new Desempenho();
		desempenho.setMatricula(new Integer("1"));
		desempenho.setMediaParcial(new Integer("1"));
		desempenhoBC.insert(desempenho);
		List<Desempenho> desempenhoList = desempenhoBC.findAll();
		assertNotNull(desempenhoList);
		assertTrue(desempenhoList.size()>0);
		Desempenho beforeUpdate = desempenhoList.get(0);
		assertEquals(new Integer("1"), beforeUpdate.getMediaParcial());
		beforeUpdate.setMediaParcial(new Integer("2"));
		desempenhoBC.update(beforeUpdate);
		desempenhoList = desempenhoBC.findAll();
		Desempenho afterUpdate = desempenhoList.get(0);
		assertEquals(new Integer("2"), afterUpdate.getMediaParcial());
	}

	@Test
	public void delete() {
		Desempenho desempenho = new Desempenho();
		desempenho.setMatricula(new Integer("1"));
		desempenhoBC.insert(desempenho);
		List<Desempenho> desempenhoList = desempenhoBC.findAll();
		assertNotNull(desempenhoList);
		assertEquals(1, desempenhoList.size());
		desempenhoBC.delete(desempenho.getMatricula());
		desempenhoList = desempenhoBC.findAll();
		assertEquals(0, desempenhoList.size());
	}

}

