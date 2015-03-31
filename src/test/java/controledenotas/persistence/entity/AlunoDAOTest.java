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
public class AlunoDAOTest {

	@Inject
	private AlunoDAO alunoDAO;

	@Before
	public void before() {
		for (Aluno aluno : alunoDAO.findAll()) {
		alunoDAO.delete(aluno.getMatricula());
		}
	}

	@After
	public void after() {
		before();
	}

	@Test
	public void insert() {
		Aluno aluno = new Aluno();
		aluno.setMatricula(new Integer("1"));
		aluno.setNome("XXXXXXXXXXXXXXXXXXXX");
		aluno.setSenha("XXXXXXXXXXXXXXXXXXXX");
		alunoDAO.insert(aluno);
		List<Aluno> alunoList = alunoDAO.findAll();
		assertNotNull(alunoList);
		assertEquals(1, alunoList.size());
	}

	@Test
	public void update() {
		Aluno aluno = new Aluno();
		aluno.setMatricula(new Integer("1"));
		aluno.setNome("XXXXXXXXXXXXXXXXXXXX");
		aluno.setSenha("XXXXXXXXXXXXXXXXXXXX");
		alunoDAO.insert(aluno);
		List<Aluno> alunoList = alunoDAO.findAll();
		assertNotNull(alunoList);
		assertTrue(alunoList.size()>0);
		Aluno beforeUpdate = alunoList.get(0);
		assertEquals("XXXXXXXXXXXXXXXXXXXX", beforeUpdate.getSenha());
		beforeUpdate.setSenha("YYYYYYYYYYYYYYYYYYYY");
		alunoDAO.update(beforeUpdate);
		alunoList = alunoDAO.findAll();
		Aluno afterUpdate = alunoList.get(0);
		assertEquals("YYYYYYYYYYYYYYYYYYYY", afterUpdate.getSenha());
	}

	@Test
	public void delete() {
		Aluno aluno = new Aluno();
		aluno.setMatricula(new Integer("1"));
		aluno.setNome("XXXXXXXXXXXXXXXXXXXX");
		aluno.setSenha("XXXXXXXXXXXXXXXXXXXX");
		alunoDAO.insert(aluno);
		List<Aluno> alunoList = alunoDAO.findAll();
		assertNotNull(alunoList);
		assertEquals(1, alunoList.size());
		alunoDAO.delete(aluno.getMatricula());
		alunoList = alunoDAO.findAll();
		assertEquals(0, alunoList.size());
	}

}

