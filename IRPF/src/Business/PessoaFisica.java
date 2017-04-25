package Business;

public class PessoaFisica {
	
	private String nome, cpf;
	private int idade,numeroDependentes;
	private double totalRendimentos,contribuicaoPrevOficial;
	
	
	public PessoaFisica(String nome, String cpf, int idade, int numeroDependentes, double totalRendimentos,
			double contribuicaoPrevOficial) {
		setNome(nome);
		setCpf(cpf);
		setIdade(idade);
		setNumeroDependentes(numeroDependentes);
		setTotalRendimentos(totalRendimentos);
		setContribuicaoPrevOficial(contribuicaoPrevOficial);
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public int getNumeroDependentes() {
		return numeroDependentes;
	}
	public void setNumeroDependentes(int numeroDependentes) {
		this.numeroDependentes = numeroDependentes;
	}
	public double getTotalRendimentos() {
		return totalRendimentos;
	}
	public void setTotalRendimentos(double totalRendimentos) {
		this.totalRendimentos = totalRendimentos;
	}
	public double getContribuicaoPrevOficial() {
		return contribuicaoPrevOficial;
	}
	public void setContribuicaoPrevOficial(double contribuicaoPrevOficial) {
		this.contribuicaoPrevOficial = contribuicaoPrevOficial;
	}
	@Override
	public String toString() {
		String s = "Nome: "+getNome() +"\n"
				+"CPF: " +getCpf() +"\n"
				+"Idade: "+getIdade()+"\n"
				+"Número de Dependentes: "+getNumeroDependentes() +"\n"
				+"Total de Rendimentos: "+getTotalRendimentos() +"\n"
				+"Contribuição Previdenciária Oficial "+getContribuicaoPrevOficial()+"\n";
		return s;
		
	}
	
	

}
