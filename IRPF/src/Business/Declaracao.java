package Business;

import javax.swing.JOptionPane;

public class Declaracao extends PessoaFisica {

	/**
	 * String tipoDeclaracao double contribuicaoPrevOficial,totalRendimentos
	 */
	private String tipoDeclaracao;
	private double contribuicaoPrevOficial;

	/**
	 * 
	 * @param nome
	 * @param cpf
	 * @param idade
	 * @param totalDependentes
	 * @param totalRendimentos
	 * @param tipoDeclaracao
	 * @param contribuicaoPrevOficial
	 */
	public Declaracao(String nome, String cpf, int idade, int totalDependentes, int totalRendimentos,
			String tipoDeclaracao, double contribuicaoPrevOficial) {
		super(nome, cpf, idade, totalDependentes, totalRendimentos);
		setTipoDeclaracao(tipoDeclaracao);
		setContribuicaoPrevOficial(contribuicaoPrevOficial);
	}

	/**
	 * 
	 * @return tipoDeclaracao
	 */
	public String getTipoDeclaracao() {
		return tipoDeclaracao;
	}

	/**
	 * 
	 * @param tipoDeclaracao
	 * @return FALSE se tipo de declaração não for informada, e TRUE se a mesma
	 *         foi informada
	 * 
	 */
	public boolean setTipoDeclaracao(String tipoDeclaracao) {
		// SE NÃO FOR SELECIONADA A OPÇÃO DE TIPO DE DECLARAÇÃO
		if (tipoDeclaracao.length() == 0) {
			JOptionPane.showMessageDialog(null, "Você de informar o tipo de declaração!");
			return false;
		} else {
			this.tipoDeclaracao = tipoDeclaracao;
			return true;
		}
	}

	/**
	 * 
	 * @return contribuicaoPrevOficial
	 */
	public double getContribuicaoPrevOficial() {
		return contribuicaoPrevOficial;
	}

	/**
	 * 
	 * @param contribuicaoPrevOficial
	 * @return FALSE se contribuição informada for <=0 e TRUE se o valor
	 *         informado é válido.
	 */
	public boolean setContribuicaoPrevOficial(double contribuicaoPrevOficial) {
		if (contribuicaoPrevOficial <= 0) {
			JOptionPane.showMessageDialog(null, "Você deve informar o valor de contribuição de previdencia oficial!");
			return false;
		} else {
			this.contribuicaoPrevOficial = contribuicaoPrevOficial;
			return true;
		}
	}
	/**
	 * 
	 * @param p
	 * @return double totalTendimentos
	 */
	public double calculaBase(PessoaFisica p){
		double contribuicaoOficial = 0;
		double totalRendimentos = p.getTotalRendimentos();
		
		if(p.getIdade() <65 && p.getTotalDependentes() <=2){
			contribuicaoOficial = p.getTotalRendimentos()*0.02;
		}
		else if(p.getIdade() <65 && (p.getTotalDependentes() >=3 ||p.getTotalDependentes() <=5  )){
			contribuicaoOficial = p.getTotalRendimentos()*0.035;
		}
		else if(p.getIdade() <65 && (p.getTotalDependentes() >5 )){
			contribuicaoOficial = p.getTotalRendimentos()*0.05;
		}
		else if(p.getIdade() >=65 && (p.getTotalDependentes() <=2 )){
			contribuicaoOficial = p.getTotalRendimentos()*0.03;
		}
		else if(p.getIdade() >=65 && (p.getTotalDependentes() >=3 ||p.getTotalDependentes() <=5  )){
			contribuicaoOficial = p.getTotalRendimentos()*0.045;
		}
		else if(p.getIdade() >=65 && (p.getTotalDependentes() >=5 )){
			contribuicaoOficial = p.getTotalRendimentos()*0.06;
		}
		double base = totalRendimentos - contribuicaoOficial ;
		return base;
	}
	/**
	public double calculaContribuicao(double base){
		double valorCalculado = 0;
		if(base <12000){
			valorCalculado = base;
			return valorCalculado;
		}
		else if(base >12000 && base <24000){
			valorCalculado = base * 0.15;
			return valorCalculado;
		}
		if(base >24000){
			
		}
		
		
		
		
	}*/

	@Override
	public String toString() {
		String s = super.toString() + "\n" + "Tipo de Declaração: " + getTipoDeclaracao() + "\n"
				+ "\n" + "Contribuição Previdenciária Oficial: " + getContribuicaoPrevOficial()+ "\n";
		return s;
	}
}
