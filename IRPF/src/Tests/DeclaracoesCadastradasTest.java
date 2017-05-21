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
		contribuinte = new Contribuinte("Jos�", "00235252525", 56, 10, 39000, 1600);
		declaracoesCadastradas = new DeclaracoesCadastradas();
		declaracao = new Declaracao(contribuinte, 's');
	}

	@Test
	/**
	 * Inclui uma declara��o e pesquisa pelo CPF do declarante, se for
	 * localizada ent�o passa no teste.
	 */
	public void testPesquisarDeclaracao() {
		declaracoesCadastradas.incluirDeclaracao(declaracao);
		assertTrue(declaracoesCadastradas.pesquisarDeclaracao(declaracao) == true);
	}

	@Test
	/**
	 * Inclui uma declara��o em uma nova lista de declara��es cadastradas e
	 * testa, se Size() >0 ent�o inclui a declara��o.
	 */
	public void testIncluirDeclaracao() {
		declaracao = new Declaracao(contribuinte, 's');
		declaracoesCadastradas.incluirDeclaracao(declaracao);
		assertTrue(declaracoesCadastradas.getDeclaracoes().size() > 0);
	}
}
