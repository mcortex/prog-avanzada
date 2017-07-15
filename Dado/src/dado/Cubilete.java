package dado;

import java.util.LinkedList;
import java.util.List;

public class Cubilete {

	private List<Dado> dados = new LinkedList<Dado>();

	public void agregar(Dado dado) {
		this.dados .add(dado);
	}

	public int tirar() {
		int resultado = 0;
		for (Dado dado : dados) {
			resultado += dado.tirar();
		}
		return resultado;
	}
}
