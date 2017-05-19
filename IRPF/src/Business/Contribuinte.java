package Business;

public class Contribuinte {

	/**
	 * Atributos
	 */
	private String nome, cpf;
	private int totalDependentes, idade;
	private double totalRendimentos, contribuicaoOficial;

	/**
	 * Construtor
	 * 
	 * @param nome
	 * @param cpf
	 * @param idade
	 * @param totalDependentes
	 * @param totalRendimentos
	 * @param contribuicaoOficial
	 */
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
	 */
	public void setNome(String nome) {
		this.nome = nome;
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
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * 
	 * @return idade
	 */
	public int getIdade() {
		return idade;
	}

	/**
	 * 
	 * @param idade
	 */
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
	 */
	public void setTotalRendimentos(double totalRendimentos) {
		this.totalRendimentos = totalRendimentos;
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
	 */
	public void setTotalDependentes(int totalDependentes) {
		this.totalDependentes = totalDependentes;

	}

	/**
	 * 
	 * @return contribuicaoOficial
	 */
	public double getContribuicaoOficial() {
		return contribuicaoOficial;
	}

	/**
	 * 
	 * @param contribuicaoOficial
	 */
	public void setContribuicaoOficial(double contribuicaoOficial) {
		this.contribuicaoOficial = contribuicaoOficial;
	}
}
