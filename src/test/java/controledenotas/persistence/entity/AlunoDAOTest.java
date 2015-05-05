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
	private TurmaDAO turmaDAO;

	@Before
	public void before() {
//		for (Aluno aluno : alunoDAO.findAll()) {
//		alunoDAO.delete(aluno.getUser().getId());
//		}
	}

	@After
	public void after() {
		before();
	}

	@Test
	public void insert() {
		Aluno aluno = new Aluno();
		User usuario = new User();
		usuario.setName("Ramon");
		usuario.setEmail("ramon@ufcg.com.br");
		usuario.setPassword("12345");
		Role papel = new Role();
		papel.setName("aluno");
		usuario.getRoles().add(papel);
		aluno.setUser(usuario);
		
		for (int i = 1; i < 5; i++) {
			DesempenhoBimestral bimestral = new DesempenhoBimestral();
			bimestral.setNumero(i);
			bimestral.setAluno(aluno);
			bimestral.setNota1(7.5);
			bimestral.setNota2(9.0);
			bimestral.setNota3(10.0);
			Double mediaBimestre = (bimestral.getNota1() + bimestral.getNota2() + bimestral.getNota3())/3;
			bimestral.setMediaBimestre(mediaBimestre);
			aluno.getDesempenhosBimestrais().add(bimestral);
		}
		Desempenho desempenho = new Desempenho();
		desempenho.setAluno(aluno);
		Double mediaParcial = 0.0;
		for (DesempenhoBimestral bimestre : aluno.getDesempenhosBimestrais()) {
			mediaParcial+= bimestre.getMediaBimestre();
		}
		mediaParcial = mediaParcial/ aluno.getDesempenhosBimestrais().size();
		desempenho.setMediaParcial(mediaParcial);
		if(mediaParcial > 7){
			desempenho.setSituacao("Aprovado");
		}else{
			desempenho.setSituacao("Reprovado");
		}
		aluno.getDesempenhos().add(desempenho);
		HashMap<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("nome", "A");
		List<Turma> listTurma = turmaDAO.findByCriteria(parameters);
		aluno.setTurma(listTurma.get(0));
		alunoDAO.insert(aluno);
		List<Aluno> alunoList = alunoDAO.findAll();
		assertNotNull(alunoList);
		assertEquals(2, alunoList.size());
	}

	@Test
	public void update() {
		Aluno aluno = new Aluno();
		Turma turma = new Turma();
		turma.setNome("XXX");
		for (int i = 1; i < 5; i++) {
			DesempenhoBimestral bimestral = new DesempenhoBimestral();
			bimestral.setNumero(1);
			bimestral.setAluno(aluno);
			bimestral.setNota1(0.0);
			bimestral.setNota2(0.0);
			bimestral.setNota3(0.0);
			Double mediaBimestre = (bimestral.getNota1() + bimestral.getNota2() + bimestral.getNota3())/3;
			bimestral.setMediaBimestre(mediaBimestre);
			aluno.getDesempenhosBimestrais().add(bimestral);
		}
		turmaDAO.insert(turma);
		aluno.setTurma(turma);
		alunoDAO.insert(aluno);
		List<Aluno> alunoList = alunoDAO.findAll();
		assertNotNull(alunoList);
		assertTrue(alunoList.size()>0);
	}

	@Test
	public void delete() {
		Aluno aluno = new Aluno();
		alunoDAO.insert(aluno);
		List<Aluno> alunoList = alunoDAO.findAll();
		assertNotNull(alunoList);
		assertEquals(1, alunoList.size());
		alunoDAO.delete(aluno.getUser().getId());
		alunoList = alunoDAO.findAll();
		assertEquals(0, alunoList.size());
	}

}

