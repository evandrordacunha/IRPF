package Business;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ControleFormulario {
	
 
	
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
	
}
