package Business;

import javax.swing.JOptionPane;

public class Contribuinte {

	/**
	 * String nome, cpf int idade
	 */
	private String nome, cpf;
	private int totalDependentes, idade;
	private double totalRendimentos, contribuicaoOficial;

	public Contribuinte(String nome, String cpf, int idade, int totalDependentes, double totalRendimentos,
			double contribuicaoOficial) {
		setNome(nome);
		setCpf(cpf);
		setIdade(idade);
		setTotalRendimentos(totalRendimentos);
		setContribuicaoOficial(contribuicaoOficial);
		setTotalDependentes(totalDependentes);
	}

	/**
	 * 
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * 
	 * @param nome
	 * @return FALSE se não for informado campo nome e TRUE se for.
	 */
	private void setNome(String nome) {
		if (nome.length() == 0) {
			JOptionPane.showMessageDialog(null, "Você deve preencher o campo nome! ");
		} else {
			this.nome = nome;
		}
	}

	/**
	 * 
	 * @return cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * 
	 * @param cpf
	 */
	private void setCpf(String cpf) {
		if (cpf.length() != 11) {
			JOptionPane.showMessageDialog(null, "Você deve informar os 11 dígitos do seu CPF! ");
		} else {
			this.cpf = cpf;
		}
	}

	/**
	 * 
	 * @return idade
	 */
	public int getIdade() {
		return idade;
	}

	private void setIdade(int idade) {
		this.idade = idade;
	}

	/**
	 * 
	 * @return totalRendimentos
	 */
	public double getTotalRendimentos() {
		return totalRendimentos;
	}

	/**
	 * 
	 * @param totalRendimentos
	 * @return FALSE se total de rendimentos informado for <= 0 ou TRUE se o
	 *         valor informado é válido.
	 */

	private void setTotalRendimentos(double totalRendimentos) {
		if (totalRendimentos <= 0) {
			JOptionPane.showMessageDialog(null, "Total de rendimentos deve ser superior a R$ 0 !");
		} else {
			this.totalRendimentos = totalRendimentos;
		}
	}

	/**
	 * 
	 * @return totalDependentes
	 */
	public int getTotalDependentes() {
		return totalDependentes;
	}

	/**
	 * 
	 * @param totalDependentes
	 * @return False se valor for negativo e TRUE se valor >=0
	 */
	private void setTotalDependentes(int totalDependentes) {
		if (totalDependentes < 0) {
			JOptionPane.showMessageDialog(null, "Valor informado para Total de Dependentes é inválido!");
		} else {
			this.totalDependentes = totalDependentes;
		}
	}

	public double getContribuicaoOficial() {
		return contribuicaoOficial;
	}

	private void setContribuicaoOficial(double contribuicaoOficial) {
		if (contribuicaoOficial <= 0) {
			JOptionPane.showMessageDialog(null, "Valor informado para Contribuição Previdencial Oficial é inválido!");
		} else {
			this.contribuicaoOficial = contribuicaoOficial;
		}
	}

	@Override
	public String toString() {
		String s = "Nome: " + getNome() + "\n" + "CPF: " + getCpf() + "\n" + "Idade: " + getIdade() + "\n"
				+ "Total de Dependentes: " + getTotalDependentes() + "\n" + "Total de Rendimentos: R$  "
				+ getTotalRendimentos() + "\n" + "Contribuição Previdencial Oficial: R$  " + getContribuicaoOficial()
				+ "\n";
		return s;

	}
}
