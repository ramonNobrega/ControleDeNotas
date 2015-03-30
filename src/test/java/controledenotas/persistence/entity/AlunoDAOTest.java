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

	@Inject
	private ObjectDAO objectDAO;

	@Before
	public void before() {
		for (Aluno aluno : alunoDAO.findAll()) {
		alunoDAO.delete(aluno.getMatriculaDoAluno());
		}
	}

	@After
	public void after() {
		before();
	}

	@Test
	public void insert() {
		Aluno aluno = new Aluno();
		Object matriculaDoAluno = new Object();
		objectDAO.insert(matriculaDoAluno);
		aluno.setMatriculaDoAluno(matriculaDoAluno);
		aluno.setSenhaDoAluno("XXXXXXXXXXXXXXXXXXXX");
		alunoDAO.insert(aluno);
		List<Aluno> alunoList = alunoDAO.findAll();
		assertNotNull(alunoList);
		assertEquals(1, alunoList.size());
	}

	@Test
	public void update() {
		Aluno aluno = new Aluno();
		Object matriculaDoAluno = new Object();
		objectDAO.insert(matriculaDoAluno);
		aluno.setMatriculaDoAluno(matriculaDoAluno);
		aluno.setNomeDoAluno("XXXXXXXXXXXXXXXXXXXX");
		aluno.setSenhaDoAluno("XXXXXXXXXXXXXXXXXXXX");
		alunoDAO.insert(aluno);
		List<Aluno> alunoList = alunoDAO.findAll();
		assertNotNull(alunoList);
		assertTrue(alunoList.size()>0);
		Aluno beforeUpdate = alunoList.get(0);
		assertEquals("XXXXXXXXXXXXXXXXXXXX", beforeUpdate.getSenhaDoAluno());
		beforeUpdate.setSenhaDoAluno("YYYYYYYYYYYYYYYYYYYY");
		alunoDAO.update(beforeUpdate);
		alunoList = alunoDAO.findAll();
		Aluno afterUpdate = alunoList.get(0);
		assertEquals("YYYYYYYYYYYYYYYYYYYY", afterUpdate.getSenhaDoAluno());
	}

	@Test
	public void delete() {
		Aluno aluno = new Aluno();
		Object matriculaDoAluno = new Object();
		objectDAO.insert(matriculaDoAluno);
		aluno.setMatriculaDoAluno(matriculaDoAluno);
		aluno.setSenhaDoAluno("XXXXXXXXXXXXXXXXXXXX");
		alunoDAO.insert(aluno);
		List<Aluno> alunoList = alunoDAO.findAll();
		assertNotNull(alunoList);
		assertEquals(1, alunoList.size());
		alunoDAO.delete(aluno.getMatriculaDoAluno());
		alunoList = alunoDAO.findAll();
		assertEquals(0, alunoList.size());
	}

}

