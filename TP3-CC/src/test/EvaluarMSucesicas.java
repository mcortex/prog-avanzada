package test;
import static org.junit.Assert.*;
import java.io.IOException;
import org.junit.Test;
import polinomios.Polinomio;


public class EvaluarMSucesicas {
	
	@Test
	public void testPruebagrado4() throws IOException {
		Polinomio pol = new Polinomio("Entradas/prueba-grado4.txt", "Salidas/prueba-grado4.txt");
		assertEquals(2685.48, pol.evaluarMSucesivas(5), 0.001);
	}
	
	@Test
	public void testPruebagrado9() throws IOException {
		Polinomio pol = new Polinomio("Entradas/prueba-grado9.txt", "Salidas/prueba-grado9.txt");
		assertEquals(8565573.34, pol.evaluarMSucesivas(5), 0.001);
	}
	
	@Test
	public void testPruebagrado19() throws IOException {
		Polinomio pol = new Polinomio("Entradas/prueba-grado19.txt", "Salidas/prueba-grado19.txt");
		assertEquals(8.364818571401083E13, pol.evaluarMSucesivas(5), 0.001);
	}
	
	@Test
	public void testPruebagrado29() throws IOException {
		Polinomio pol = new Polinomio("Entradas/prueba-grado29.txt", "Salidas/prueba-grado29.txt");
		assertEquals(8.168768136133957E20, pol.evaluarMSucesivas(5), 0.001);
	}
	
	@Test
	public void testPruebagrado49() throws IOException {
		Polinomio pol = new Polinomio("Entradas/prueba-grado49.txt", "Salidas/prueba-grado49.txt");
		assertEquals(7.635469317744624E34, pol.evaluarMSucesivas(5), 0.001);
	}
	
	@Test
	public void testPruebagrado59() throws IOException {
		Polinomio pol = new Polinomio("Entradas/prueba-grado59.txt", "Salidas/prueba-grado59.txt");
		assertEquals(7.456513005609984E41, pol.evaluarMSucesivas(5), 0.001);
	}
	
	@Test
	public void testPruebagrado99() throws IOException {
		Polinomio pol = new Polinomio("Entradas/prueba-grado99.txt", "Salidas/prueba-grado99.txt");
		assertEquals(6.781659072303221E69, pol.evaluarMSucesivas(5), 0.1);
	}
	
	@Test
	public void testPruebPolinomioImpar() throws IOException {
		Polinomio pol = new Polinomio("Entradas/prueba-polinomioImpar.txt", "Salidas/prueba-polinomioImpar.txt");
		assertEquals(487.0, pol.evaluarMSucesivas(5), 0.001);
	}
	

}
