package Business;

public class Imposto {
	
	private double valorPago;
	private PessoaFisica p;

	public Imposto(PessoaFisica p) {
		this.p = p;
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
		return valorPago;
	}

	/**
	 * 
	 * @param impostoPago
	 */
	public void setImpostoPago(double impostoPago) {
		this.valorPago = impostoPago;
	}

}
