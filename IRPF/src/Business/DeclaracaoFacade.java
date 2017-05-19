package Business;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import Persistence.DeclaracoesCadastradas;

public class DeclaracaoFacade {

	private Declaracao declaracao = null;
	private String nome, cpf;
	private int idade, totalDependentes;
	private double contribuicao, rendimentos;
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
			JTextField tContribuicaoOficial, JTextField tTotalRendimentos, JComboBox<Declaracao> tDependentes) {
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
			declaracao.setImpostoPago(declaracao.calculaContribuicaoSimples(contribuinte));
			declaracoes.incluirDeclaracao(declaracao);
			textArea.setText(declaracao.imprimirDeclaracao(contribuinte));
		}
		if (rdCompleta.isSelected()) {
			tipodeclaracao = 'C';
			declaracao = new Declaracao(contribuinte, tipodeclaracao);
			declaracao.setImpostoPago(declaracao.calculaContribuicaoCompleta(contribuinte));
			declaracoes.incluirDeclaracao(declaracao);
			textArea.setText(declaracao.imprimirDeclaracao(contribuinte));
		}
		return declaracao;
	}
}
