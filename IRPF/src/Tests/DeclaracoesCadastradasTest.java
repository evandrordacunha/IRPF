package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Business.Contribuinte;
import Business.Declaracao;
import Persistence.DeclaracoesCadastradas;

public class DeclaracoesCadastradasTest {

	Contribuinte contribuinte, contribuinte2;
	Declaracao declaracao, declaracao2;
	DeclaracoesCadastradas declaracoesCadastradas;

	@Before
	public void inicializa() {
		contribuinte = new Contribuinte("José", "00235252525", 56, 10, 39000, 1600);
		declaracoesCadastradas = new DeclaracoesCadastradas();
		declaracao = new Declaracao(contribuinte, 's');
	}

	@Test
	/**
	 * Inclui uma declaração e pesquisa pelo CPF do declarante, se for
	 * localizada então passa no teste.
	 */
	public void testPesquisarDeclaracao() {
		declaracoesCadastradas.incluirDeclaracao(declaracao);
		assertTrue(declaracoesCadastradas.pesquisarDeclaracao(declaracao) == true);
	}

	@Test
	/**
	 * Inclui uma declaração em uma nova lista de declarações cadastradas e
	 * testa, se Size() >0 então inclui a declaração.
	 */
	public void testIncluirDeclaracao() {
		declaracao = new Declaracao(contribuinte, 's');
		declaracoesCadastradas.incluirDeclaracao(declaracao);
		assertTrue(declaracoesCadastradas.getDeclaracoes().size() > 0);
	}
}
