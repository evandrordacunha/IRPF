package Business;

import javax.swing.JOptionPane;

public class PessoaFisica {
	
	/**
	 * String nome, cpf
	 * int idade
	 */
	private String nome, cpf;
	private int totalDependentes,idade;
	private double totalRendimentos,contribuicaoOficial;

	public PessoaFisica(String nome, String cpf, int idade, int totalDependentes,double totalRendimentos,double contribuicaoOficial) {
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
		if(nome.length() == 0){
			JOptionPane.showMessageDialog(null, "Você deve preencher o campo nome! ");
		}else{
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
	private boolean setCpf(String cpf) {
		if(cpf.length() != 11 ){
			JOptionPane.showInputDialog(null,"Você deve informar os 11 dígitos do seu CPF! ");
			return false;
		}else{
			this.cpf = cpf;
			return true;
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

	private boolean setTotalRendimentos(double totalRendimentos) {
		if (totalRendimentos <= 0) {
			JOptionPane.showMessageDialog(null, "Total de rendimentos deve ser superior a R$ 0 !");
			return false;
		} else {
			this.totalRendimentos = totalRendimentos;
			return true;
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
	private boolean setTotalDependentes(int totalDependentes) {
		if (totalDependentes < 0) {
			JOptionPane.showMessageDialog(null, "Valor informado para Total de Dependentes é inválido!");
			return false;
		} else {
			this.totalDependentes = totalDependentes;
			return true;
		}
	}

	
	public double getContribuicaoOficial() {
		return contribuicaoOficial;
	}
	private boolean setContribuicaoOficial(double contribuicaoOficial) {
		if (contribuicaoOficial <= 0) {
			JOptionPane.showMessageDialog(null, "Valor informado para Contribuição Previdencial Oficial é inválido!");
			return false;
		} else {
			this.contribuicaoOficial = contribuicaoOficial;
			return true;
		}
	}
	@Override
	public String toString() {
		String s = "Nome: "+getNome() +"\n"
				+"CPF: " +getCpf() +"\n"
				+"Idade: "+getIdade()+"\n"
				+"Total de Dependentes: "+getTotalDependentes()+"\n"
				+"Total de Rendimentos: R$  "+getTotalRendimentos() +"\n"
				+"Contribuição Previdencial Oficial: R$  " +getContribuicaoOficial()+"\n";
		return s;
		
	}
}
