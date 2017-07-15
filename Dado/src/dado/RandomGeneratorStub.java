package dado;

public class RandomGeneratorStub extends RandomGenerator {

	private int valor;

	public RandomGeneratorStub(int valorFijo) {
		this.valor = valorFijo;
	}

	@Override
	public int obtenerAleatorioMenorQue(int maximo)  {
		return this.valor; // aqui esta el truco
	}
}
