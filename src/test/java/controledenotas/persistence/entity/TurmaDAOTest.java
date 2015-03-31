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
	private AlunoDAO alunoDAO;

	@Before
	public void before() {
		for (Turma turma : turmaDAO.findAll()) {
		turmaDAO.delete(turma.getCodigo());
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
		turmaDAO.insert(turma);
		List<Turma> turmaList = turmaDAO.findAll();
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
		alunoDAO.insert(matriculaAluno);
		turma.setMatriculaAluno(matriculaAluno);
		turmaDAO.insert(turma);
		List<Turma> turmaList = turmaDAO.findAll();
		assertNotNull(turmaList);
		assertTrue(turmaList.size()>0);
		Turma beforeUpdate = turmaList.get(0);
		assertEquals(new Integer("1"), beforeUpdate.getMatriculaAluno());
		beforeUpdate.setMatriculaAluno(null);
		turmaDAO.update(beforeUpdate);
		turmaList = turmaDAO.findAll();
		Turma afterUpdate = turmaList.get(0);
		assertEquals(null, afterUpdate.getMatriculaAluno());
	}

	@Test
	public void delete() {
		Turma turma = new Turma();
		turma.setCodigo(new Integer("1"));
		turmaDAO.insert(turma);
		List<Turma> turmaList = turmaDAO.findAll();
		assertNotNull(turmaList);
		assertEquals(1, turmaList.size());
		turmaDAO.delete(turma.getCodigo());
		turmaList = turmaDAO.findAll();
		assertEquals(0, turmaList.size());
	}

}

