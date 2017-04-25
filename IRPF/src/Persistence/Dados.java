package Persistence;

import javax.swing.JTextField;

/**
 * 
 * @author EVANDRO ROCHA DA CUNHA
 *
 */

public class Dados {

	/**
	 * 
	 * @param tNome
	 * @return TRUE se campo nome for informado ou FALSE se não for informado
	 */
	public boolean validaNome(JTextField tNome) {
		if (tNome.getText().length() > 0) {
			tNome.setVisible(false);
			return true;
		} else {
			tNome.setVisible(true);
			return false;
		}

	}

}
