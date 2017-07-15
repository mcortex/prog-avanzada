package test_dado;

import org.junit.Assert;
import org.junit.Test;

import dado.Cubilete;
import dado.Dado;
import dado.RandomGeneratorStub;

public class DadoTests {

	@Test
	public void queSumaCorrectamenteLosValores() {
		Dado dado1 = new Dado();
		dado1.setRandomGenerator(new RandomGeneratorStub(5));
		Dado dado2 = new Dado();
		dado2.setRandomGenerator(new RandomGeneratorStub(2));
		Cubilete cubilete = new Cubilete();
		cubilete.agregar(dado1);
		cubilete.agregar(dado2);
		
		Assert.assertEquals(5 + 2, cubilete.tirar());
	}
}
