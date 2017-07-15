package dado;

import java.util.Random;

public class ActualRandomGenerator extends RandomGenerator {

	@Override
	public int obtenerAleatorioMenorQue(int maximo) {
		return new Random().nextInt(maximo);
	}
}
