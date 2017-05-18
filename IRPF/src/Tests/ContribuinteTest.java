package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Business.Contribuinte;

public class ContribuinteTest {
	
	Contribuinte contribuinte; 
	@Before 
	public void inicializa(){
		contribuinte = new Contribuinte("Pedro", "00526547852", 36, 2, 29000, 1200);
	}

	@Test
	/**
	 * Tenta limpar o nome já salvo do contribuinte, e depois
	 * verifica, se continua retornando o nome antigo, então ele
	 * filtrou corretamente e não deixou salvar em branco, retorna true.
	 */
	public void testSetNome() {
		contribuinte.setNome("");
		assertTrue(contribuinte.getNome().equals("Pedro"));

	}

	@Test
	/**
	 * Tenta alterar o cpf para padrões inválidos, depois verifica
	 * se continuar trazendo o valor antigo, é porque o filtro funcionou
	 * e não deixou ser salva a alteração, retorna true.
	 */
	public void testSetCpf() {
	 contribuinte.setCpf("123");
	 assertTrue(contribuinte.getCpf().equals("00526547852"));	
	}
	
	@Test
	public void testSetIdade() {
		contribuinte.setIdade(-23);
		
	}
	/*
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
