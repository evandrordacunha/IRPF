package Business;

import java.text.NumberFormat;

public class Declaracao {

	/**
	 * Atributos
	 */
	private char tipoDeclaracao;
	private double impostoPago;
	/**
	 * 	Trata faixa com isenção até R$ 12000,00 e 
	 *	será usado para cálculo das faixas entre (R$ 12001,00 e R$ 24.000,00) c/ 15%
	 */
	private static double FAIXA_1 = 12000;  
	/**
	 *Trata as faixas com ganho acima de R$ 24.000,00
	 * 
	 */
	private static double FAIXA_2 = 24000;  
	private Contribuinte contribuinte;

	/**
	 * 
	 * @param contribuinte
	 * @param tipo
	 */
	public Declaracao(Contribuinte contribuinte, char tipo) {
		this.contribuinte = contribuinte;
		this.tipoDeclaracao = tipo;
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
	 * @param contribuinte
	 * @return calculoBase
	 */
	public double calculaBase(Contribuinte contribuinte) {
		return contribuinte.getTotalRendimentos() - contribuinte.getContribuicaoOficial();
	}

	/**
	 * 
	 * @param contribuinte
	 * @return impostoPago
	 */
	public double calculaContribuicaoCompleta(Contribuinte contribuinte) {
		double base = calculaBase(contribuinte);
		double vlrDesconto;
		int idade = contribuinte.getIdade();
		int dependentes = contribuinte.getTotalDependentes();
		//Se idade do Contribuinte for menor de 65 anos
		if (idade < 65) {
			//aplicando desconto de 2% até dois dependentes
			if (dependentes <= 2) {
				vlrDesconto = ((base * 0.02));
				base = base - vlrDesconto;
				//aplicando desconto de 3,5% de 2 a 4 dependentes
			} else if (dependentes > 2 && dependentes < 5) {
				vlrDesconto = ((base * 0.035));
				base = base - vlrDesconto;
			} else {
				//aplicando desconto de 5% a partir de 5 dependentes
				vlrDesconto = ((base * 0.05));
				base = base - vlrDesconto;
			}
		} else {
			//Se contribuinte for maior de 65 anos 
			if (dependentes <= 2) {
				//aplicando desconto de 3% até 2 dependentes
				vlrDesconto = ((base * 0.03));
				base = base - vlrDesconto;
				//aplicando desconto de 4,5% de 2 a 4 dependentes
			} else if (dependentes > 2 && dependentes < 5) {
				vlrDesconto = ((base * 0.045));
				base = base - vlrDesconto;
			} else {
				//aplicando desconto de 6% a partir de 5 dependentes
				vlrDesconto = ((base * 0.06));
				base = base - vlrDesconto;
			}
		}
		if (base <= FAIXA_1) {
			return 0.0;
		} else if (base > FAIXA_1 && base < FAIXA_2) {
			return (((base - FAIXA_1) * 0.15));
		} else {
			impostoPago = ((((FAIXA_1) * 0.15)) + (((base - FAIXA_2) * 0.275)));
			return impostoPago;
		}
	}
	/**
	 * 
	 * @param contribuinte
	 * @return imposto
	 */
	public double calculaContribuicaoSimples(Contribuinte contribuinte) {
		double base = calculaBase(contribuinte);
		double vlrDesconto = (base * 0.05);
		base = base - vlrDesconto;
		if (base <= FAIXA_1) {
			return 0.0;
		} else if (base > FAIXA_1 && base < FAIXA_2) {
			return (((base - FAIXA_1) * 0.15));
		} else {
		impostoPago = ((((FAIXA_1) * 0.15)) + (((base - FAIXA_2) * 0.275)));
		return impostoPago;
		} 
	}
	/**
	 * 
	 * @return impostoPago
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

	/**
	 * 
	 * @return contribuinte
	 */
	public Contribuinte getContribuinte() {
		return contribuinte;
	}

	/**
	 * 
	 * @param tipo
	 * @return tipoDeclaracao
	 */
	public String tratarTipoDeclaracao(char tipo) {
		String tipoDeclaracao = "";
		if (tipo == 'c' || tipo == 'C') {
			tipoDeclaracao = "Completa";
		}
		if (tipo == 's' || tipo == 'S') {
			tipoDeclaracao = "Simplificada";
		}
		return tipoDeclaracao;
	}

	/**
	 * 
	 * @param contribuinte
	 * @return dadosDeclaracao
	 */
	public String imprimirDeclaracao(Contribuinte contribuinte) {
		String dadosDeclaracao = "";
		dadosDeclaracao = "DECLARAÇÃO DE IMPOSTO DE RENDA DE P.FÍSICA:  " + "\n" + "\n" + "Tipo de Declaração: "
				+ tratarTipoDeclaracao(getTipoDeclaracao()) + "\n" + "Declarante:  " + contribuinte.getNome() + "\n"
				+ "CPF:  " + contribuinte.getCpf() + "\n" + "Idade: " + contribuinte.getIdade() + "\n"
				+ "Total de Dependentes: " + contribuinte.getTotalDependentes() + "\n" + "Total de Rendimentos "
				+ NumberFormat.getCurrencyInstance().format(contribuinte.getTotalRendimentos()) + "\n"
				+ "Contribuição Previdencial Oficial "
				+ NumberFormat.getCurrencyInstance().format(contribuinte.getContribuicaoOficial()) + "\n" + "IRPF: "
				+ NumberFormat.getCurrencyInstance().format(getImpostoPago()) + "\n"

				+ "\n";
		return dadosDeclaracao;
	}
}
