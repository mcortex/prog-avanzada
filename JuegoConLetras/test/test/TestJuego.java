package test;

import juego.Juego;
import org.junit.*;

public class TestJuego {
	
	@Test
	public void testSimple() {
		Juego juego = new Juego("LotePrueba/in/01_simple.in","LotePrueba/out/01_simple.out");
		Assert.assertEquals(2, juego.getDimensionTablero());
		Assert.assertEquals(1, juego.getCantidadPalabras());
		Assert.assertEquals("ey",juego.getPalabras()[0]);
		juego.resolver();

	}
	@Test
	public void testPalabraRepetida() {
		Juego juego = new Juego("LotePrueba/in/03_palabra_repetida.in","LotePrueba/out/03_palabra_repetida.out");
		Assert.assertEquals(4, juego.getDimensionTablero());
		Assert.assertEquals(1, juego.getCantidadPalabras());
		Assert.assertEquals("hey",juego.getPalabras()[0]);
		juego.resolver();

	}
	
	@Test
	public void testEnunciado() {
		Juego juego = new Juego("LotePrueba/in/00_rapigrama.in","LotePrueba/out/00_rapigrama.out");
		Assert.assertEquals(8, juego.getDimensionTablero());
		Assert.assertEquals(4, juego.getCantidadPalabras());
		juego.resolver();

	}
	
	@Test
	public void testFatigaUnaPalabra() {
		Juego juego = new Juego("LotePrueba/in/04_fatiga_una_palabra.in","LotePrueba/out/04_fatiga_una_palabra.out");
		Assert.assertEquals(100, juego.getDimensionTablero());
		Assert.assertEquals(1, juego.getCantidadPalabras());
		juego.resolver();
	}
	@Test
	public void testFatigaEncuentraTresPalabras() {
		Juego juego = new Juego("LotePrueba/in/05_fatiga_tres_palabras.in","LotePrueba/out/05_fatiga_tres_palabras.out");
		Assert.assertEquals(100, juego.getDimensionTablero());
		Assert.assertEquals(4, juego.getCantidadPalabras());
		juego.resolver();
	}


}
