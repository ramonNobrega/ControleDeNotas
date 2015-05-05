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
import controledenotas.domain.entity.Turma;

@RunWith(DemoiselleRunner.class)
public class AlunoBCTest {

	@Inject
	private AlunoBC alunoBC;

	@Inject
	private TurmaBC turmaBC;

	@Before
	public void before() {
		for (Aluno aluno : alunoBC.findAll()) {
		  alunoBC.delete(aluno.getUser().getId());
		}
	}

	@After
	public void after() {
		before();
	}

	@Test
	public void insert() {
		Aluno aluno = new Aluno();
		alunoBC.insert(aluno);
		List<Aluno> alunoList = alunoBC.findAll();
		assertNotNull(alunoList);
		assertEquals(1, alunoList.size());
	}

	@Test
	public void update() {
		Aluno aluno = new Aluno();
		Turma turma = new Turma();
		turma.setNome("XXX");
		turmaBC.insert(turma);
		aluno.setTurma(turma);
		alunoBC.insert(aluno);
		List<Aluno> alunoList = alunoBC.findAll();
		assertNotNull(alunoList);
		assertTrue(alunoList.size()>0);
	}

	@Test
	public void delete() {
		Aluno aluno = new Aluno();
		alunoBC.insert(aluno);
		List<Aluno> alunoList = alunoBC.findAll();
		assertNotNull(alunoList);
		assertEquals(1, alunoList.size());
		  alunoBC.delete(aluno.getUser().getId());
		alunoList = alunoBC.findAll();
		assertEquals(0, alunoList.size());
	}

}

