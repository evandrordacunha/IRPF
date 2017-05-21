package Persistence;

import java.util.ArrayList;
import Business.Declaracao;

/**
 * 
 * @author EVANDRO ROCHA DA CUNHA
 *
 */

public class DeclaracoesCadastradas {

	/**
	 * Atributos
	 */
	private ArrayList<Declaracao> declaracoes;

	/**
	 * Construtor
	 */
	public DeclaracoesCadastradas() {
		declaracoes = new ArrayList<>();
	}

	/**
	 * 
	 * @param declaracao
	 * @return true || false
	 */
	public boolean pesquisarDeclaracao(Declaracao declaracao) {
		Declaracao d = null;
		for (int i = 0; i < declaracoes.size(); i++) {
			d = declaracoes.get(i);
			if (d.getContribuinte().getCpf().equals(declaracao.getContribuinte().getCpf())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @param declaracao
	 */
	public void incluirDeclaracao(Declaracao declaracao) {
		if (pesquisarDeclaracao(declaracao) == false) {
			declaracoes.add(declaracao);
		}
	}

	/**
	 * 
	 * @return declaracoes
	 */
	public ArrayList<Declaracao> getDeclaracoes() {
		return declaracoes;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < declaracoes.size(); i++) {
			s = s + "\n" + declaracoes.get(i).toString() + "\n";
		}
		return s;
	}
}
