package Business;

import javax.swing.JOptionPane;

public class PessoaFisica {
	
	/**
	 * String nome, cpf
	 * int idade
	 */
	private String nome, cpf;
	private int idade,totalDependentes,totalRendimentos;

	public PessoaFisica(String nome, String cpf, int idade, int totalDependentes,int totalRendimentos) {
		setNome(nome);
		setCpf(cpf);
		setIdade(idade);
		setTotalRendimentos(totalRendimentos);
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
	 * @return FALSE se n�o for informado campo nome e TRUE se for.
	 */
	public boolean setNome(String nome) {
		if(nome.length() == 0){
			JOptionPane.showMessageDialog(null, "Voc� deve preencher o campo nome! ");
			return false;
		}else{
		this.nome = nome;
		return true;
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
	public boolean setCpf(String cpf) {
		if(cpf.length() != 11 ){
			JOptionPane.showInputDialog(null,"Voc� deve informar os 11 d�gitos do seu CPF! ");
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
	public void setIdade(int idade) {
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
	 *         valor informado � v�lido.
	 */

	public boolean setTotalRendimentos(double totalRendimentos) {
		if (totalRendimentos <= 0) {
			JOptionPane.showMessageDialog(null, "Total de rendimentos deve ser superior a R$ 0 !");
			return false;
		} else {
			totalRendimentos = totalRendimentos;
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
	public boolean setTotalDependentes(int totalDependentes) {
		if (totalDependentes < 0) {
			JOptionPane.showMessageDialog(null, "Valor informado para Total de Dependentes � inv�lido!");
			return false;
		} else {
			this.totalDependentes = totalDependentes;
			return true;
		}
	}

	
	@Override
	public String toString() {
		String s = "Nome: "+getNome() +"\n"
				+"CPF: " +getCpf() +"\n"
				+"Idade: "+getIdade()+"\n"
				+"Total de Rendimentos: "+getTotalRendimentos() +"\n"
				+"Total de Dependentes: "+getTotalDependentes()+"\n";
		return s;
		
	}
}
