package Business;
import java.text.NumberFormat;

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
	 * @return FALSE se tipo de declara��o n�o for informada, e TRUE se a mesma
	 *         foi informada
	 * 
	 */
	public boolean setTipoDeclaracao(char tipoDeclaracao) {
		// SE N�O FOR SELECIONADA A OP��O DE TIPO DE DECLARA��O
		if (tipoDeclaracao != 'S' ||tipoDeclaracao != 'C' ||tipoDeclaracao != 's' ||tipoDeclaracao !='c' ) {
			JOptionPane.showMessageDialog(null, "Voc� de selecionar um tipo para a declara��o !");
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
		return p.getTotalRendimentos() - p.getContribuicaoOficial(); 
	}
	
	/**
	 * 
	 * @param p
	 * @return boolean imposto
	 */
	public double calculaContribuicaoCompleta(PessoaFisica p){
		double base = calculaBase(p);
		double impostoBase = base;
		
		if(p.getIdade() <65 && p.getTotalDependentes() <=2){
			impostoBase = impostoBase -p.getTotalRendimentos()*0.02;
		}
		if(p.getIdade() <65 && (p.getTotalDependentes() >=3 && p.getTotalDependentes() <=5  )){
			impostoBase = impostoBase - p.getTotalRendimentos()*0.035;
		}
		if(p.getIdade() <65 && (p.getTotalDependentes() >5 )){
			impostoBase = impostoBase -p.getTotalRendimentos()*0.05;
		}
		if(p.getIdade() >=65 && (p.getTotalDependentes() <=2 )){
			impostoBase = impostoBase -p.getTotalRendimentos()*0.03;
		}
		if(p.getIdade() >=65 && (p.getTotalDependentes() >=3 && p.getTotalDependentes() <=5  )){
			impostoBase =impostoBase - p.getTotalRendimentos()*0.045;
		}
		if(p.getIdade() >=65 && (p.getTotalDependentes() >=5 )){
			impostoBase =impostoBase - p.getTotalRendimentos()*0.06;
		}
		System.out.println(impostoBase);
		return calculaImposto(impostoBase);
	}
	
	/**
	 * 
	 * @param p
	 * @return boolean imposto
	 */
	public double calculaContribuicaoSimples(PessoaFisica p){
		double base = calculaBase(p);
		double impostoBase = base - (base * 0.05);
			return calculaImposto(impostoBase);
	}
	
	/**
	 * 
	 * @param base
	 * @return double imposto
	 */
	public double calculaImposto(double base){
		double valorCalculado = 0;
		if(base <=12000){
			valorCalculado = 0;
		}
		if(base >12000 && base <24000){
			valorCalculado =  (base - 12000)*0.15;
		}
		if(base >=24000){
			valorCalculado = ((base - 12000)*0.15) +((base - 24000)*0.275);
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
		if((declaracaoSimplificada == false && declaracaoCompleta == false) 
				|| declaracaoSimplificada == true && declaracaoCompleta == true){
			JOptionPane.showMessageDialog(null, "Tipo de declara��o deve ser selecionado e �nico!");
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
		s = "DECLARA��O DE IMPOSTO DE RENDA DE P.F�SICA:  " 
		+"\n"
		+"\n"	+"Tipo de Declara��o: "+getTipoDeclaracao() +"\n"
				+"Declarante:  "+p.getNome() +"\n"
				+"CPF:  "+p.getCpf() +"\n"
				+"Idade: "+p.getIdade() +"\n"
				+"Total de Dependentes: "+p.getTotalDependentes()+"\n"
				+"Total de Rendimentos "+NumberFormat.getCurrencyInstance().format(p.getTotalRendimentos()) +"\n"
				+"Contribui��o Previdencial Oficial "+NumberFormat.getCurrencyInstance().format(p.getContribuicaoOficial()) +"\n"
				+"IRPF: "+NumberFormat.getCurrencyInstance().format(getImpostoPago())+"\n"
				
		+"\n";
		return s;
		}
}
