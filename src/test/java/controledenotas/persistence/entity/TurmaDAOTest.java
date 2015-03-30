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
public class TurmaDAOTest {

	@Inject
	private TurmaDAO turmaDAO;

	@Inject
	private ObjectDAO objectDAO;

	@Inject
	private AlunoDAO alunoDAO;

	@Before
	public void before() {
		for (Turma turma : turmaDAO.findAll()) {
		turmaDAO.delete(turma.getIdTurma());
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
		objectDAO.insert(idTurma);
		turma.setIdTurma(idTurma);
		turmaDAO.insert(turma);
		List<Turma> turmaList = turmaDAO.findAll();
		assertNotNull(turmaList);
		assertEquals(1, turmaList.size());
	}

	@Test
	public void update() {
		Turma turma = new Turma();
		Object idTurma = new Object();
		objectDAO.insert(idTurma);
		turma.setIdTurma(idTurma);
		Aluno matriculaDoAluno = new Aluno();
		Object matriculaDoAluno = new Object();
		objectDAO.insert(matriculaDoAluno);
		matriculaDoAluno.setMatriculaDoAluno(matriculaDoAluno);
		matriculaDoAluno.setNomeDoAluno("XXXXXXXXXXXXXXXXXXXX");
		matriculaDoAluno.setSenhaDoAluno("XXXXXXXXXXXXXXXXXXXX");
		alunoDAO.insert(matriculaDoAluno);
		turma.setMatriculaDoAluno(matriculaDoAluno);
		turmaDAO.insert(turma);
		List<Turma> turmaList = turmaDAO.findAll();
		assertNotNull(turmaList);
		assertTrue(turmaList.size()>0);
	}

	@Test
	public void delete() {
		Turma turma = new Turma();
		Object idTurma = new Object();
		objectDAO.insert(idTurma);
		turma.setIdTurma(idTurma);
		turmaDAO.insert(turma);
		List<Turma> turmaList = turmaDAO.findAll();
		assertNotNull(turmaList);
		assertEquals(1, turmaList.size());
		turmaDAO.delete(turma.getIdTurma());
		turmaList = turmaDAO.findAll();
		assertEquals(0, turmaList.size());
	}

}

