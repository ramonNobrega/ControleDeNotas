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
	private ObjectBC objectBC;

	@Inject
	private AlunoBC alunoBC;

	@Before
	public void before() {
		for (Turma turma : turmaBC.findAll()) {
		  turmaBC.delete(turma.getIdTurma());
		}
	}

	@After
	public void after() {
		before();
	}

	@Test
	public void insert() {
		Turma turma = new Turma();
		Object idTurma = new Object();
		objectBC.insert(idTurma);
		turma.setIdTurma(idTurma);
		turmaBC.insert(turma);
		List<Turma> turmaList = turmaBC.findAll();
		assertNotNull(turmaList);
		assertEquals(1, turmaList.size());
	}

	@Test
	public void update() {
		Turma turma = new Turma();
		Object idTurma = new Object();
		objectBC.insert(idTurma);
		turma.setIdTurma(idTurma);
		Aluno matriculaDoAluno = new Aluno();
		Object matriculaDoAluno = new Object();
		objectBC.insert(matriculaDoAluno);
		matriculaDoAluno.setMatriculaDoAluno(matriculaDoAluno);
		matriculaDoAluno.setNomeDoAluno("XXXXXXXXXXXXXXXXXXXX");
		matriculaDoAluno.setSenhaDoAluno("XXXXXXXXXXXXXXXXXXXX");
		alunoBC.insert(matriculaDoAluno);
		turma.setMatriculaDoAluno(matriculaDoAluno);
		turmaBC.insert(turma);
		List<Turma> turmaList = turmaBC.findAll();
		assertNotNull(turmaList);
		assertTrue(turmaList.size()>0);
	}

	@Test
	public void delete() {
		Turma turma = new Turma();
		Object idTurma = new Object();
		objectBC.insert(idTurma);
		turma.setIdTurma(idTurma);
		turmaBC.insert(turma);
		List<Turma> turmaList = turmaBC.findAll();
		assertNotNull(turmaList);
		assertEquals(1, turmaList.size());
		  turmaBC.delete(turma.getIdTurma());
		turmaList = turmaBC.findAll();
		assertEquals(0, turmaList.size());
	}

}

