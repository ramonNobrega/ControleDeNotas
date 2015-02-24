package controledenotas.business.entity;

import controledenotas.domain.entity.Aluno;
import controledenotas.business.entity.AlunoBC;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.util.*;
import javax.inject.Inject;
import org.junit.*;
import org.junit.runner.RunWith;
import br.gov.frameworkdemoiselle.junit.DemoiselleRunner;

@RunWith(DemoiselleRunner.class)
public class AlunoBCTest {

	@Inject
	private AlunoBC alunoBC;

	@Before
	public void before() {
		for (Aluno aluno : alunoBC.findAll()) {
		  alunoBC.delete(aluno.getMatricula());
		}
	}

	@After
	public void after() {
		before();
	}

	@Test
	public void insert() {
		Aluno aluno = new Aluno(0, null, null, null);
		aluno.setMatricula(new Integer("1"));
		aluno.setNome("XXXXXXXXXXXXXXXXXXXX");
		aluno.setSenha("XXXXXXXXXXXXXXXXXXXX");
		alunoBC.insert(aluno);
		List<Aluno> alunoList = alunoBC.findAll();
		assertNotNull(alunoList);
		assertEquals(1, alunoList.size());
	}

	@Test
	public void update() {
		Aluno aluno = new Aluno(0, null, null, null);
		aluno.setMatricula(new Integer("1"));
		aluno.setNome("XXXXXXXXXXXXXXXXXXXX");
		aluno.setSenha("XXXXXXXXXXXXXXXXXXXX");
		alunoBC.insert(aluno);
		List<Aluno> alunoList = alunoBC.findAll();
		assertNotNull(alunoList);
		assertTrue(alunoList.size()>0);
		Aluno beforeUpdate = alunoList.get(0);
		assertEquals("XXXXXXXXXXXXXXXXXXXX", beforeUpdate.getSenha());
		beforeUpdate.setSenha("YYYYYYYYYYYYYYYYYYYY");
		alunoBC.update(beforeUpdate);
		alunoList = alunoBC.findAll();
		Aluno afterUpdate = alunoList.get(0);
		assertEquals("YYYYYYYYYYYYYYYYYYYY", afterUpdate.getSenha());
	}

	@Test
	public void delete() {
		Aluno aluno = new Aluno(0, null, null, null);
		aluno.setMatricula(new Integer("1"));
		aluno.setNome("XXXXXXXXXXXXXXXXXXXX");
		aluno.setSenha("XXXXXXXXXXXXXXXXXXXX");
		alunoBC.insert(aluno);
		List<Aluno> alunoList = alunoBC.findAll();
		assertNotNull(alunoList);
		assertEquals(1, alunoList.size());
		alunoBC.delete(aluno.getMatricula());
		alunoList = alunoBC.findAll();
		assertEquals(0, alunoList.size());
	}

}

