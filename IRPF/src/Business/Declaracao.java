package Business;
import javax.swing.JOptionPane;

public class Declaracao extends PessoaFisica {

	/**
	 * String tipoDeclaracao double contribuicaoPrevOficial,totalRendimentos
	 */
	private String tipoDeclaracao;
	private double impostoPago;

	/**
	 * 
	 * @param nome
	 * @param cpf
	 * @param idade
	 * @param totalDependentes
	 * @param totalRendimentos
	 * @param contribuicaoOficial
	 * @param tipoDeclaracao
	 * @param contribuicaoPrevOficial
	 * @param impostoPago
	 */
	public Declaracao(String nome, String cpf, int idade, int totalDependentes, double totalRendimentos,
			double contribuicaoOficial, String tipoDeclaracao, double contribuicaoPrevOficial, double impostoPago) {
		super(nome, cpf, idade, totalDependentes, totalRendimentos, contribuicaoOficial);
		setTipoDeclaracao(tipoDeclaracao);
		setImpostoPago(impostoPago);
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
	 * @param p
	 * @return double calculo da base salarial.
	 */
	public double calculaBase(PessoaFisica p){
		double base =p.getTotalRendimentos() - p.getContribuicaoOficial(); 
		return base;
	}
	
	/**
	 * 
	 * @param p
	 * @return boolean imposto
	 */
	public double calculaContribuicaoCompleta(PessoaFisica p){
		double base = calculaBase(p);
		double imposto = base;
		
		if(p.getIdade() <65 && p.getTotalDependentes() <=2){
			imposto = p.getTotalRendimentos()*0.02;
		}
		if(p.getIdade() <65 && (p.getTotalDependentes() >=3 ||p.getTotalDependentes() <=5  )){
			imposto = p.getTotalRendimentos()*0.035;
		}
		if(p.getIdade() <65 && (p.getTotalDependentes() >5 )){
			imposto = p.getTotalRendimentos()*0.05;
		}
		if(p.getIdade() >=65 && (p.getTotalDependentes() <=2 )){
			imposto = p.getTotalRendimentos()*0.03;
		}
		if(p.getIdade() >=65 && (p.getTotalDependentes() >=3 ||p.getTotalDependentes() <=5  )){
			imposto = p.getTotalRendimentos()*0.045;
		}
		if(p.getIdade() >=65 && (p.getTotalDependentes() >=5 )){
			imposto = p.getTotalRendimentos()*0.06;
		}
		return calculaImposto(imposto);
	}
	
	/**
	 * 
	 * @param p
	 * @return boolean imposto
	 */
	public double calculaContribuicaoSimples(PessoaFisica p){
		double base = calculaBase(p);
		double imposto = base - (base * 0.05);
			return calculaImposto(imposto);
	}
	
	/**
	 * 
	 * @param base
	 * @return double imposto
	 */
	public double calculaImposto(double base){
		double valorCalculado = 0;
		double valorExcedente = 0;
		if(base <=12000){
			valorCalculado = base;
			return valorCalculado;
		}
		if(base >12000 && base <24000){
		    valorExcedente = base - 11999;
			valorCalculado = valorExcedente * 0.15;
			return valorCalculado;
		}
		if(base >=24000){
			valorExcedente = base - 23999;
			valorCalculado = (base*0.15) +(valorExcedente*0.275);
		}
		return valorCalculado;
	}
	

	/**
	 * 
	 * @return double imposto pago
	 */
	public double getImpostoPago() {
		return impostoPago;
	}

	/**
	 * 
	 * @param impostoPago
	 */
	public void setImpostoPago(double impostoPago) {
		this.impostoPago = impostoPago;
	}

	@Override
	public String toString() {
		String s = super.toString() + "\n" + "Tipo de Declaração: " + getTipoDeclaracao() + "\n"
				+"\n" +"Imposto a ser pago: "+getImpostoPago();
		return s;
	}
}
