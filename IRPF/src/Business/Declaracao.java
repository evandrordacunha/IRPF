package Business;
import javax.swing.JOptionPane;

public class Declaracao extends PessoaFisica {

	/**
	 * String tipoDeclaracao double contribuicaoPrevOficial,totalRendimentos
	 */
	private char tipoDeclaracao;
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
			double contribuicaoOficial, char tipoDeclaracao, double impostoPago) {
		super(nome, cpf, idade, totalDependentes, totalRendimentos, contribuicaoOficial);
		setTipoDeclaracao(tipoDeclaracao);
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
		if (tipoDeclaracao != 'S' ||tipoDeclaracao != 'C' ) {
			JOptionPane.showMessageDialog(null, "Você de informar o tipo de declaração!");
			return false;
		} else {
			this.tipoDeclaracao = tipoDeclaracao;
			return true;
		}
	}	

	

	public double getImpostoPago() {
		return impostoPago;
	}

	public void setImpostoPago(double impostoPago) {
		this.impostoPago = impostoPago;
	}

	@Override
	public String toString() {
		String s = super.toString() + "\n" + "Tipo de Declaração: " + getTipoDeclaracao() + "\n"
				+"\n" +"Imposto a ser pago: "+getImpostoPago()+"\n";
		return s;
	}
}
