package Business;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Controle {

	private JTextField tNome, tCpf, tIdade, tContribuicaoOficial, tTotalRendimentos;
	private JRadioButton rdSimples, rdCompleta;
	private static final double deducao = 28559.70;

	public Controle(JTextField tNome, JTextField tCpf, JTextField tIdade, JTextField tContribuicaoOficial,
			JTextField tTotalRendimentos, JRadioButton rdSimples, JRadioButton rdCompleta) {
		this.tNome = tNome;
		this.tCpf = tCpf;
		this.tIdade = tIdade;
		this.tContribuicaoOficial = tContribuicaoOficial;
		this.tTotalRendimentos = tTotalRendimentos;
		this.rdSimples = rdSimples;
		this.rdCompleta = rdCompleta;
	}

	public boolean validaCampos() {

		if (tNome.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "Voc� de informar seu nome completo!", "Nome inv�lido!",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (tCpf.getText().length() != 11) {
			JOptionPane.showMessageDialog(null, "Voc� deve informar os 11 d�gitos do seu CPF!", "CPF inv�lido!",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		int idade = Integer.parseInt(tIdade.getText());
		if (idade < 16) {
			JOptionPane.showMessageDialog(null,
					"Contribuinte deve ser maior de 16 anos e possuir Carteira de Trabalho!", "Idade inv�lida!",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		int contribuicao = Integer.parseInt(tContribuicaoOficial.getText());
		if (contribuicao < 0) {
			JOptionPane.showMessageDialog(null, "Valor informado para contribui��o inv�lido!", "Valor inv�lido!",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		int rendimentos = Integer.parseInt(tTotalRendimentos.getText());
		if (rendimentos < deducao) {
			JOptionPane.showMessageDialog(null, "Valor informado para rendimentos inv�lido!", "Valor inv�lido!",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (rdSimples.isSelected() && rdCompleta.isSelected()) {
			JOptionPane.showMessageDialog(null, "Selecione apenas 1 tipo de contribui��o!",
					"Tipo de contribui��o inv�lido!", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (!rdSimples.isSelected() && !rdCompleta.isSelected()) {
			JOptionPane.showMessageDialog(null, "Selecione ao menos 1 tipo de contribui��o!",
					"Tipo de contribui��o n�o informado!", JOptionPane.ERROR_MESSAGE);
			return false;
		} else {
			return true;
		}
	}
}
