package Business;

import java.awt.Checkbox;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Facade {
	
 
	
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
	
	public void validaTipoDeclaracao(Checkbox check){
		
		
	}
	
}
