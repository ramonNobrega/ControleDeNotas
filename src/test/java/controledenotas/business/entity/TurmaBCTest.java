package controledenotas.business.entity;

import controledenotas.domain.entity.Turma;
import controledenotas.business.entity.TurmaBC;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.util.*;
import javax.inject.Inject;
import org.junit.*;
import org.junit.runner.RunWith;
import br.gov.frameworkdemoiselle.junit.DemoiselleRunner;
import controledenotas.domain.entity.Aluno;

@RunWith(DemoiselleRunner.class)
public class TurmaBCTest {

	@Inject
	private TurmaBC turmaBC;

	@Inject
	private AlunoBC alunoBC;

	@Before
	public void before() {
		for (Turma turma : turmaBC.findAll()) {
		  turmaBC.delete(turma.getCodigo());
		}
	}

	@After
	public void after() {
		before();
	}

	@Test
	public void insert() {
		Turma turma = new Turma();
		turma.setCodigo(new Integer("1"));
		turmaBC.insert(turma);
		List<Turma> turmaList = turmaBC.findAll();
		assertNotNull(turmaList);
		assertEquals(1, turmaList.size());
	}

	@Test
	public void update() {
		Turma turma = new Turma();
		turma.setCodigo(new Integer("1"));
		Aluno matriculaAluno = new Aluno();
		matriculaAluno.setMatricula(new Integer("1"));
		matriculaAluno.setNome("XXXXXXXXXXXXXXXXXXXX");
		matriculaAluno.setSenha("XXXXXXXXXXXXXXXXXXXX");
		alunoBC.insert(matriculaAluno);
		turma.setMatriculaAluno(matriculaAluno);
		turmaBC.insert(turma);
		List<Turma> turmaList = turmaBC.findAll();
		assertNotNull(turmaList);
		assertTrue(turmaList.size()>0);
		Turma beforeUpdate = turmaList.get(0);
		assertEquals(new Integer("1"), beforeUpdate.getMatriculaAluno());
		beforeUpdate.setMatriculaAluno(null);
		turmaBC.update(beforeUpdate);
		turmaList = turmaBC.findAll();
		Turma afterUpdate = turmaList.get(0);
		assertEquals(null, afterUpdate.getMatriculaAluno());
	}

	@Test
	public void delete() {
		Turma turma = new Turma();
		turma.setCodigo(new Integer("1"));
		turmaBC.insert(turma);
		List<Turma> turmaList = turmaBC.findAll();
		assertNotNull(turmaList);
		assertEquals(1, turmaList.size());
		  turmaBC.delete(turma.getCodigo());
		turmaList = turmaBC.findAll();
		assertEquals(0, turmaList.size());
	}

}

