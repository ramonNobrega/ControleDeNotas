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

	@Inject
	private ObjectBC objectBC;

	@Before
	public void before() {
		for (Aluno aluno : alunoBC.findAll()) {
		  alunoBC.delete(aluno.getMatriculaDoAluno());
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
		objectBC.insert(matriculaDoAluno);
		aluno.setMatriculaDoAluno(matriculaDoAluno);
		aluno.setSenhaDoAluno("XXXXXXXXXXXXXXXXXXXX");
		alunoBC.insert(aluno);
		List<Aluno> alunoList = alunoBC.findAll();
		assertNotNull(alunoList);
		assertEquals(1, alunoList.size());
	}

	@Test
	public void update() {
		Aluno aluno = new Aluno();
		Object matriculaDoAluno = new Object();
		objectBC.insert(matriculaDoAluno);
		aluno.setMatriculaDoAluno(matriculaDoAluno);
		aluno.setNomeDoAluno("XXXXXXXXXXXXXXXXXXXX");
		aluno.setSenhaDoAluno("XXXXXXXXXXXXXXXXXXXX");
		alunoBC.insert(aluno);
		List<Aluno> alunoList = alunoBC.findAll();
		assertNotNull(alunoList);
		assertTrue(alunoList.size()>0);
		Aluno beforeUpdate = alunoList.get(0);
		assertEquals("XXXXXXXXXXXXXXXXXXXX", beforeUpdate.getSenhaDoAluno());
		beforeUpdate.setSenhaDoAluno("YYYYYYYYYYYYYYYYYYYY");
		alunoBC.update(beforeUpdate);
		alunoList = alunoBC.findAll();
		Aluno afterUpdate = alunoList.get(0);
		assertEquals("YYYYYYYYYYYYYYYYYYYY", afterUpdate.getSenhaDoAluno());
	}

	@Test
	public void delete() {
		Aluno aluno = new Aluno();
		Object matriculaDoAluno = new Object();
		objectBC.insert(matriculaDoAluno);
		aluno.setMatriculaDoAluno(matriculaDoAluno);
		aluno.setSenhaDoAluno("XXXXXXXXXXXXXXXXXXXX");
		alunoBC.insert(aluno);
		List<Aluno> alunoList = alunoBC.findAll();
		assertNotNull(alunoList);
		assertEquals(1, alunoList.size());
		  alunoBC.delete(aluno.getMatriculaDoAluno());
		alunoList = alunoBC.findAll();
		assertEquals(0, alunoList.size());
	}

}

