package Business;

import java.text.NumberFormat;

import javax.swing.JOptionPane;

public class Declaracao {

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
	public Declaracao(Contribuinte p, char tipo) {
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
	public double calculaBase(Contribuinte p) {
		return p.getTotalRendimentos() - p.getContribuicaoOficial();
	}

	/**
	 * 
	 * @param p
	 * @return boolean imposto
	 */
	public double calculaContribuicaoCompleta(Contribuinte p) {
		double base = calculaBase(p);
		double impostoBase = base;

		if (p.getIdade() < 65 && p.getTotalDependentes() <= 2) {
			impostoBase = impostoBase - p.getTotalRendimentos() * 0.02;
		}
		if (p.getIdade() < 65 && (p.getTotalDependentes() >= 3 && p.getTotalDependentes() <= 5)) {
			impostoBase = impostoBase - p.getTotalRendimentos() * 0.035;
		}
		if (p.getIdade() < 65 && (p.getTotalDependentes() > 5)) {
			impostoBase = impostoBase - p.getTotalRendimentos() * 0.05;
		}
		if (p.getIdade() >= 65 && (p.getTotalDependentes() <= 2)) {
			impostoBase = impostoBase - p.getTotalRendimentos() * 0.03;
		}
		if (p.getIdade() >= 65 && (p.getTotalDependentes() >= 3 && p.getTotalDependentes() <= 5)) {
			impostoBase = impostoBase - p.getTotalRendimentos() * 0.045;
		}
		if (p.getIdade() >= 65 && (p.getTotalDependentes() >= 5)) {
			impostoBase = impostoBase - p.getTotalRendimentos() * 0.06;
		}
		System.out.println(impostoBase);
		return calculaImposto(impostoBase);
	}

	/**
	 * 
	 * @param p
	 * @return boolean imposto
	 */
	public double calculaContribuicaoSimples(Contribuinte p) {
		double base = calculaBase(p);
		double impostoBase = base - (base * 0.05);
		return calculaImposto(impostoBase);
	}

	/**
	 * 
	 * @param base
	 * @return double imposto
	 */
	public double calculaImposto(double base) {
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

	public String imprimirDeclaracao(Contribuinte p) {
		double valorPagar = 0;
		String s = "";
		s = "DECLARAÇÃO DE IMPOSTO DE RENDA DE P.FÍSICA:  " + "\n" + "\n" + "Tipo de Declaração: " + getTipoDeclaracao()
				+ "\n" + "Declarante:  " + p.getNome() + "\n" + "CPF:  " + p.getCpf() + "\n" + "Idade: " + p.getIdade()
				+ "\n" + "Total de Dependentes: " + p.getTotalDependentes() + "\n" + "Total de Rendimentos "
				+ NumberFormat.getCurrencyInstance().format(p.getTotalRendimentos()) + "\n"
				+ "Contribuição Previdencial Oficial "
				+ NumberFormat.getCurrencyInstance().format(p.getContribuicaoOficial()) + "\n" + "IRPF: "
				+ NumberFormat.getCurrencyInstance().format(getImpostoPago()) + "\n"

				+ "\n";
		return s;
	}
}
