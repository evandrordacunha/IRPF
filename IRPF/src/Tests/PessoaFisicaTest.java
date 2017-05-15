package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Business.Contribuinte;

public class PessoaFisicaTest {
	
	Contribuinte p; 
	@Before 
	public void inicializa(){
		p = new Contribuinte("Pedro", "00526547852", 36, 2, 29000, 1200);
	}

	@Test
	public void testSetNome() {
		System.out.println(p.getNome());
		assertEquals("Pedro", p.getNome());

	}
/*
	@Test
	public void testSetCpf() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetIdade() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetTotalDependentes() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetContribuicaoOficial() {
		fail("Not yet implemented");
	}
*/
}
