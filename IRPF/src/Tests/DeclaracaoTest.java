package Tests;

import static org.junit.Assert.*;

import java.text.NumberFormat;

import org.junit.Before;
import org.junit.Test;

import Business.Contribuinte;
import Business.Declaracao;

public class DeclaracaoTest {
	
	Contribuinte contribuinte;
	Declaracao declaracao;

	@Before
	public void inicializa() {
		contribuinte = new Contribuinte("Jos�", "00235252525", 56, 10, 39000, 1600);
		declaracao = new Declaracao(contribuinte, 's');
		declaracao.calculaContribuicaoSimples(contribuinte);
	}
	@Test
	/**
	 * Testa se algu�m alterou a f�rmula, sendo que o resultado para o c�lculo
	 * n�o pode ser diferente de 37400, nem menor que 37399 e nem maior que 37401.
	 */
	public void testCalculaBase() {
		// base = 39000 - 1600 = 37400
		 double valorT = declaracao.calculaBase(contribuinte);
		 assertTrue(valorT >37399 && valorT <37401);
	}
	
	@Test
	/**
	 * Testa se algu�m alterou a f�rmula, sendo que o resultado para o c�lculo
	 * n�o pode ser menor que 6459 para esse cliente que tem como base de c�lculo
	 * 43100. (Valor do c�lculo = 6459,87)
	 */
	public void testCalculaContribuicaoCompleta() {
		contribuinte = new Contribuinte("Jean", "00435242424", 56, 9, 45000, 1900);
		double valor = declaracao.calculaContribuicaoCompleta(contribuinte);
		assertTrue(valor> 6459);	
	}
	/**
	 * Testa se algu�m alterou a f�rmula, sendo que o resultado para o c�lculo
	 * n�o pode ser menor que 4970 para esse cliente que tem como base de c�lculo
	 * 37400. (Valor do c�lculo = 4970,75)
	 */
	@Test
	public void testCalculaContribuicaoSimples() {
		// base = 39000 - 1600 = 37400
		double valor = declaracao.calculaContribuicaoSimples(contribuinte);
		assertTrue(valor> 4969 && valor< 4971);
	}
	@Test
	/**
	 * Valor pago de IR � 4970,75, for�amos a altera��o para 5000,00
	 * e usamos o m�todo Get para verificar se ocorreu realmente a altera��o
	 * trazendo falso se o valor continua o antigo entre 4970 e 4971.
	 */
	public void testSetImpostoPago() {
	declaracao.setImpostoPago(5000);
	assertFalse(declaracao.getImpostoPago()>4970 && declaracao.getImpostoPago()<4971);
	}
	
	@Test
	/**
	 * Passa como parametro um char = 's' e agaurda como retorno "Simplificada"
	 * que faz mens�o ao tipo de declara��o. Esse m�todo � usado apenas para converter
	 * o caractere recebido na plavra que identifica o tipo de declara��o.
	 */
	public void testTratarTipoDeclaracao() {
		assertEquals("Simplificada", declaracao.tratarTipoDeclaracao('s'));
	}
	/**
	 * Aguarda o retorno dos dados da declara��o, se imprimir alguma coisa
	 * retorna TRUE, do contr�rio, o m�todo n�o est� buscando as informa��es da declara��o.
	 */
	
	@Test
	public void testImprimirDeclaracao() {
		assertTrue(declaracao.imprimirDeclaracao(contribuinte) != "");
	}

}
