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

	@Inject
	private ObjectBC objectBC;

	@Before
	public void before() {
		for (Desempenho desempenho : desempenhoBC.findAll()) {
		  desempenhoBC.delete(desempenho.getIdDesempenho());
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
		objectBC.insert(idDesempenho);
		desempenho.setIdDesempenho(idDesempenho);
		desempenhoBC.insert(desempenho);
		List<Desempenho> desempenhoList = desempenhoBC.findAll();
		assertNotNull(desempenhoList);
		assertEquals(1, desempenhoList.size());
	}

	@Test
	public void update() {
		Desempenho desempenho = new Desempenho();
		Object idDesempenho = new Object();
		objectBC.insert(idDesempenho);
		desempenho.setIdDesempenho(idDesempenho);
		Object mediaParcial = new Object();
		objectBC.insert(mediaParcial);
		desempenho.setMediaParcial(mediaParcial);
		desempenhoBC.insert(desempenho);
		List<Desempenho> desempenhoList = desempenhoBC.findAll();
		assertNotNull(desempenhoList);
		assertTrue(desempenhoList.size()>0);
		Desempenho beforeUpdate = desempenhoList.get(0);
		assertEquals("XXXXXXXXXXXXXXXXXXXX", beforeUpdate.getSituacao());
		beforeUpdate.setSituacao("YYYYYYYYYYYYYYYYYYYY");
		desempenhoBC.update(beforeUpdate);
		desempenhoList = desempenhoBC.findAll();
		Desempenho afterUpdate = desempenhoList.get(0);
		assertEquals("YYYYYYYYYYYYYYYYYYYY", afterUpdate.getSituacao());
	}

	@Test
	public void delete() {
		Desempenho desempenho = new Desempenho();
		Object idDesempenho = new Object();
		objectBC.insert(idDesempenho);
		desempenho.setIdDesempenho(idDesempenho);
		desempenhoBC.insert(desempenho);
		List<Desempenho> desempenhoList = desempenhoBC.findAll();
		assertNotNull(desempenhoList);
		assertEquals(1, desempenhoList.size());
		  desempenhoBC.delete(desempenho.getIdDesempenho());
		desempenhoList = desempenhoBC.findAll();
		assertEquals(0, desempenhoList.size());
	}

}

