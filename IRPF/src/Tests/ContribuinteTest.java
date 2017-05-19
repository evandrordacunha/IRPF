package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Business.Contribuinte;

public class ContribuinteTest {
	Contribuinte contribuinte;

	@Before
	public void inicializa() {
		contribuinte = new Contribuinte("Pedro", "00526547852", 36, 2, 29000, 1200);
	}

	@Test
	/**
	 * Altera o nome do contribuinte e retorna TRUE se o nome foi alterado
	 * corretamente, comparando o nome gravado com o passado para alteração.
	 * (ANTES-> NOME = Pedro / ATUALMENTE-> NOME = Luan).
	 */
	public void testSetNome() {
		contribuinte.setNome("Luan");
		assertTrue(contribuinte.getNome().equals("Luan"));
	}

	@Test
	/**
	 * Altera o cpf do contribuinte e retorna TRUE se o cpf foi alterado
	 * corretamente, comparando o cpf gravado com o passado para alteração.
	 * (ANTES-> CPF = 00526547852 / ATUALMENTE-> CPF = 11111111111).
	 */
	public void testSetCpf() {
		contribuinte.setCpf("11111111111");
		assertTrue(contribuinte.getCpf().equals("11111111111"));
	}

	@Test
	/**
	 * Altera a idade do contribuinte e retorna TRUE se a idade foi alterada
	 * corretamente, comparando a idade gravada com a passada para alteração
	 * (ANTES-> IDADE = 36 / ATUALMENTE-> IDADE = 23).
	 */
	public void testSetIdade() {
		contribuinte.setIdade(23);
		assertTrue(contribuinte.getIdade() == 23);
	}

	/**
	 * Altera o total de dependentes do contribuinte e retorna TRUE se a o total
	 * de dependentes foi alterado corretamente, comparando o valor gravada com
	 * o passado para alteração (ANTES-> TOTAL DE DEPENDENTES = 2 / ATUALMENTE->
	 * TOTAL DE DEPENDENTES = 10).
	 */
	@Test
	public void testSetTotalDependentes() {
		contribuinte.setTotalDependentes(10);
		assertTrue(contribuinte.getTotalDependentes() == 10);
	}

	/**
	 * Altera o o valor de contribuição oficial do contribuinte e retorna TRUE
	 * se foi alterado corretamente, comparando o valor gravada com o passado
	 * para alteração (ANTES-> CONTRIBUIÇÃO OFICIAL = 1200 / ATUALMENTE->
	 * CONTRIBUIÇÃO OFICIAL = 1800).
	 */
	@Test
	public void testSetContribuicaoOficial() {
		contribuinte.setContribuicaoOficial(1800);
		assertTrue(contribuinte.getContribuicaoOficial() == 1800);
	}

	/**
	 * Altera o o valor de Total de Rendimentos do contribuinte e retorna TRUE
	 * se foi alterado corretamente, comparando o valor gravada com o passado
	 * para alteração (ANTES-> Total de Rendimentos = 29000 / ATUALMENTE-> Total
	 * de Rendimentos = 36000).
	 */
	@Test
	public void testSetTotalRendimentos() {
		contribuinte.setTotalRendimentos(36000);
		assertTrue(contribuinte.getTotalRendimentos() == 36000);
	}
}
