package Business;

import java.text.NumberFormat;

import javax.swing.JOptionPane;

public class Declaracao {

	/**
	 * Atributos
	 */
	private char tipoDeclaracao;
	private double impostoPago;
	Contribuinte contribuinte;
	/**
	 * 
	 * @param contribuinte
	 * @param tipo
	 */
	public Declaracao(Contribuinte contribuinte, char tipo) {
		this.contribuinte = contribuinte;
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
	public void setTipoDeclaracao(char tipoDeclaracao) {
		this.tipoDeclaracao = tipoDeclaracao;
	}

	/**
	 * 
	 * @param p
	 * @return double calculo da base salarial.
	 */
	public double calculaBase(Contribuinte contribuinte) {
		return contribuinte.getTotalRendimentos() - contribuinte.getContribuicaoOficial();
	}

	/**
	 * 
	 * @param p
	 * @return boolean imposto
	 */
	public double calculaContribuicaoCompleta(Contribuinte contribuinte) {
		double base = calculaBase(contribuinte);
		double impostoBase = base;

		if (contribuinte.getIdade() < 65 && contribuinte.getTotalDependentes() <= 2) {
			impostoBase = impostoBase - contribuinte.getTotalRendimentos() * 0.02;
		}
		if (contribuinte.getIdade() < 65 && (contribuinte.getTotalDependentes() >= 3 && contribuinte.getTotalDependentes() <= 5)) {
			impostoBase = impostoBase - contribuinte.getTotalRendimentos() * 0.035;
		}
		if (contribuinte.getIdade() < 65 && (contribuinte.getTotalDependentes() > 5)) {
			impostoBase = impostoBase - contribuinte.getTotalRendimentos() * 0.05;
		}
		if (contribuinte.getIdade() >= 65 && (contribuinte.getTotalDependentes() <= 2)) {
			impostoBase = impostoBase - contribuinte.getTotalRendimentos() * 0.03;
		}
		if (contribuinte.getIdade() >= 65 && (contribuinte.getTotalDependentes() >= 3 && contribuinte.getTotalDependentes() <= 5)) {
			impostoBase = impostoBase - contribuinte.getTotalRendimentos() * 0.045;
		}
		if (contribuinte.getIdade() >= 65 && (contribuinte.getTotalDependentes() >= 5)) {
			impostoBase = impostoBase - contribuinte.getTotalRendimentos() * 0.06;
		}
		return calculaImposto(impostoBase);
	}

	/**
	 * 
	 * @param p
	 * @return boolean imposto
	 */
	public double calculaContribuicaoSimples(Contribuinte contribuinte) {
		double base = calculaBase(contribuinte);
		double impostoBase = base - (base * 0.05);
		return calculaImposto(impostoBase);
	}

	/**
	 * 
	 * @param base
	 * @return double imposto
	 */
	private double calculaImposto(double base) {
		double valorCalculado = 0;
		if (base <= 12000) {
			valorCalculado = 0;
		}
		if (base > 12000 && base < 24000) {
			valorCalculado = (base - 12000) * 0.15;
		}
		if (base >= 24000) {
			valorCalculado = ((base - 12000) * 0.15) + ((base - 24000) * 0.275);
		}
		return valorCalculado;
	}

	public double getImpostoPago() {
		return impostoPago;
	}

	public void setImpostoPago(double impostoPago) {
		this.impostoPago = impostoPago;
	}

	public boolean validaTipoDeclaracao(boolean declaracaoSimplificada, boolean declaracaoCompleta) {
		if ((declaracaoSimplificada == false && declaracaoCompleta == false)
				|| declaracaoSimplificada == true && declaracaoCompleta == true) {
			JOptionPane.showMessageDialog(null, "Tipo de declaração deve ser selecionado e único!");
			return false;
		}
		if (declaracaoSimplificada == true) {
			declaracaoCompleta = false;
		} else {
			declaracaoCompleta = true;
			declaracaoSimplificada = false;
		}
		return true;
	}
	


	public Contribuinte getContribuinte() {
		return contribuinte;
	}
	public String imprimirDeclaracao(Contribuinte contribuinte) {
		double valorPagar = 0;
		String s = "";
		s = "DECLARAÇÃO DE IMPOSTO DE RENDA DE P.FÍSICA:  " + "\n" + "\n" + "Tipo de Declaração: " + getTipoDeclaracao()
				+ "\n" + "Declarante:  " + contribuinte.getNome() + "\n" + "CPF:  " + contribuinte.getCpf() + "\n" + "Idade: " + contribuinte.getIdade()
				+ "\n" + "Total de Dependentes: " + contribuinte.getTotalDependentes() + "\n" + "Total de Rendimentos "
				+ NumberFormat.getCurrencyInstance().format(contribuinte.getTotalRendimentos()) + "\n"
				+ "Contribuição Previdencial Oficial "
				+ NumberFormat.getCurrencyInstance().format(contribuinte.getContribuicaoOficial()) + "\n" + "IRPF: "
				+ NumberFormat.getCurrencyInstance().format(getImpostoPago()) + "\n"

				+ "\n";
		return s;
	}
}
