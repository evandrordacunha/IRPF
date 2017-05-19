package Tests;

import static org.junit.Assert.*;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.junit.Before;
import org.junit.Test;

import Business.Contribuinte;
import Business.Declaracao;
import Business.DeclaracaoFacade;

public class DeclaracaoFacadeTest {
	
	Contribuinte contribuinte;
	Declaracao declaracao;
	DeclaracaoFacade dF;
	JTextField tNome,tCpf,tIdade,tContribuicaoOficial,tTotalRendimentos;
	JComboBox tDependentes;
	JTextArea textArea;
	JRadioButton rdSimples,rdCompleta;

	@Before
	public void inicializa() {
		 dF = new DeclaracaoFacade();
		 tNome = new JTextField();
		 tCpf = new JTextField();
		 tIdade = new JTextField();
		 tContribuicaoOficial = new JTextField();
		 tTotalRendimentos = new JTextField();
		 tDependentes = new JComboBox();
		 tNome.setText("João");
		 tCpf.setText("55555555555");
		 tIdade.setText("45");
		 tContribuicaoOficial.setText("1200");
		 tTotalRendimentos.setText("29000");
		 tDependentes.setModel(new DefaultComboBoxModel(
					new String[] { "0", "1", "2", "3", "4", "5 ", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15",
							"16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30" }));
		 tDependentes.setSelectedIndex(6);
		 textArea = new JTextArea();
		 rdSimples = new JRadioButton("Simplificada");
		 rdCompleta = new JRadioButton("Completa");
		 rdCompleta.isSelected();
		 textArea = new JTextArea();
		 
	}

	@Test
	/**
	 * Testa o método InstanciarContribuinte() e verifica, se criar um contribuinte normalmente
	 * retorna TRUE e passa no teste, se retornar NULL, não passa.
	 */
	public void testInstanciarContribuinte() {
		assertTrue(dF.instanciarContribuinte(tNome,tCpf,tIdade,tContribuicaoOficial,tTotalRendimentos,tDependentes) !=null);
	}
/*
	@Test
	public void testInstanciarDeclaracao() {
		Contribuinte contribuinte = dF.instanciarContribuinte(tNome,tCpf,tIdade,tContribuicaoOficial,tTotalRendimentos,tDependentes);
		Declaracao declaracao = dF.instanciarDeclaracao(contribuinte, rdSimples, rdCompleta, textArea);
		textArea.setText(declaracao.imprimirDeclaracao(contribuinte));
		assertTrue(declaracao!=null);
	System.out.println(dF.instanciarDeclaracao(contribuinte, rdSimples, rdCompleta, textArea));
	}
*/
}
