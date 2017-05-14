package Business;
import javax.swing.JOptionPane;

public class Declaracao{

	/**
	 * String tipoDeclaracao double contribuicaoPrevOficial,totalRendimentos
	 */
	private char tipoDeclaracao;
	private double impostoPago;

/**
 * 
 * @param p
 * @param tipo
 */
	public Declaracao(PessoaFisica p, char tipo){
		setTipoDeclaracao(tipo);
	}

	/**
	 * 
	 * @return tipoDeclaracao
	 */
	public char getTipoDeclaracao() {
		return tipoDeclaracao;
	}

	/**
	 * 
	 * @param tipoDeclaracao
	 * @return FALSE se tipo de declaração não for informada, e TRUE se a mesma
	 *         foi informada
	 * 
	 */
	public boolean setTipoDeclaracao(char tipoDeclaracao) {
		// SE NÃO FOR SELECIONADA A OPÇÃO DE TIPO DE DECLARAÇÃO
		if (tipoDeclaracao != 'S' ||tipoDeclaracao != 'C' ||tipoDeclaracao != 's' ||tipoDeclaracao !='c' ) {
			JOptionPane.showMessageDialog(null, "Você de selecionar um tipo para a declaração !");
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

	public double getImpostoPago() {
		return impostoPago;
	}

	public void setImpostoPago(double impostoPago) {
		this.impostoPago = impostoPago;
	}
	
	public boolean validaTipoDeclaracao(boolean declaracaoSimplificada,boolean declaracaoCompleta){
		if((declaracaoSimplificada = false && declaracaoCompleta == false) 
				|| declaracaoSimplificada == true && declaracaoCompleta == true){
			JOptionPane.showMessageDialog(null, "Tipo de declaração deve ser selecionado e único!");
		return false;
		}
		if(declaracaoSimplificada == true){
			declaracaoCompleta = false;
		}else{
			declaracaoCompleta = true;
			declaracaoSimplificada = false;
		}
		return true;
	}

	public String imprimirDeclaracao(PessoaFisica p) {
		double valorPagar =0;
		String s = "";
		s = "DECLARAÇÃO DE IMPOSTO DE RENDA DE P.FÍSICA:  " 
		+"\n"
		+"\n"	+"Tipo de Declaração: "+getTipoDeclaracao() +"\n"
				+"Declarante:  "+p.getNome() +"\n"
				+"CPF:  "+p.getCpf() +"\n"
				+"Idade: "+p.getIdade() +"\n"
				+"Total de Dependentes: "+p.getTotalDependentes()+"\n"
				+"Total de Rendimentos R$:  "+p.getTotalRendimentos() +"\n"
				+"Contribuição Previdencial Oficial R$:  "+p.getContribuicaoOficial()
		+"\n";
		
		if(getTipoDeclaracao() =='S' || getTipoDeclaracao() =='s'){
			valorPagar = calculaContribuicaoSimples(p);
			s = s+"Declarado R$:  "+valorPagar;
		}
		if(getTipoDeclaracao() =='C' || getTipoDeclaracao() =='c'){
			valorPagar = calculaContribuicaoCompleta(p);
			s = s+"Declarado R$:  "+valorPagar;
		}
		return s;
	}
}
