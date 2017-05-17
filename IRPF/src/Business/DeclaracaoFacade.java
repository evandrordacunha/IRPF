package Business;

import java.awt.Checkbox;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Persistence.DeclaracoesCadastradas;

public class DeclaracaoFacade {
	
	/**
	 * Vari�veis
	 */
	private Contribuinte contribuinte = null;
	private Declaracao declaracao = null;
	private String nome, cpf;
	private int idade, totalDependentes;
	private double contribuicao, rendimentos, imposto, base, IR;
	private boolean declaracaoSimplificada, declaracaoCompleta;
	private char tipodeclaracao;
	private DeclaracoesCadastradas declaracoes; 

	/**
	 * Construtor
	 */
	public DeclaracaoFacade() {
		declaracoes = new DeclaracoesCadastradas();
	}

	/**
	 * 
	 * @param tNome
	 * @param tCpf
	 * @param tIdade
	 * @param tContribuicaoOficial
	 * @param tTotalRendimentos
	 * @param tDependentes
	 * @return Contribuinte contribuinte
	 */
	public Contribuinte instanciarContribuinte(JTextField tNome, JTextField tCpf, JTextField tIdade,
			JTextField tContribuicaoOficial, JTextField tTotalRendimentos, JComboBox tDependentes) {
		nome = tNome.getText().toUpperCase();
		cpf = tCpf.getText();
		idade = Integer.parseInt(tIdade.getText());
		contribuicao = Double.parseDouble(tContribuicaoOficial.getText());
		totalDependentes = Integer.parseInt(tDependentes.getSelectedItem().toString());
		rendimentos = Double.parseDouble(tTotalRendimentos.getText());
		Contribuinte contribuinte = new Contribuinte(nome, cpf, idade, totalDependentes, rendimentos, contribuicao);
		return contribuinte;
	}

	/**
	 * 
	 * @param contribuinte
	 * @param rdSimples
	 * @param rdCompleta
	 * @param textArea
	 * @return Declaracao declaracao
	 */
	public Declaracao instanciarDeclaracao(Contribuinte contribuinte, JRadioButton rdSimples, JRadioButton rdCompleta,
			JTextArea textArea) {
		if (rdSimples.isSelected()) {
			tipodeclaracao = 'S';
			declaracao = new Declaracao(contribuinte, tipodeclaracao);
			declaracoes.incluirDeclaracao(declaracao);
			declaracao.setImpostoPago(declaracao.calculaContribuicaoSimples(contribuinte));
			textArea.setText(declaracao.imprimirDeclaracao(contribuinte));
		}
		if (rdCompleta.isSelected()) {
			tipodeclaracao = 'C';
			declaracao = new Declaracao(contribuinte, tipodeclaracao);
			declaracoes.incluirDeclaracao(declaracao);
			declaracao.setImpostoPago(declaracao.calculaContribuicaoCompleta(contribuinte));
			textArea.setText(declaracao.imprimirDeclaracao(contribuinte));
		}
		return declaracao;
	}
}
