package dado;

public class Dado {

	private RandomGenerator aleatorizador;

	public Dado() {
		this.aleatorizador = new ActualRandomGenerator();
	}
	
	public void setRandomGenerator(RandomGeneratorStub randomGeneratorStub) {
		this.aleatorizador = randomGeneratorStub;	
	}

	public int tirar() {
		return this.aleatorizador.obtenerAleatorioMenorQue(6);
	}
}
