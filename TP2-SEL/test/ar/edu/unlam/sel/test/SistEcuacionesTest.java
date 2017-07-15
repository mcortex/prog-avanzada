package ar.edu.unlam.sel.test;

import ar.edu.unlam.sel.*;

import org.junit.Test;
import org.junit.Assert;

public class SistEcuacionesTest {
	public final String path="C:\\Users\\Martin\\Documents\\UNLAM\\PrograAvanzada\\TPS\\TP2\\Prueba\\Preparacion de Prueba\\Lote de Prueba\\";

//	@Test
//	public void queCargaUnArchivo(){
//		
//		Sel sistema1 = new Sel(path+"Entrada\\Catedra\\01_caso2x2simple.in");
//		MatrizMath matriz = new MatrizMath(2,2);
//		double[][] esperado = {{1,1},{1.1,0.99}};
//		matriz.setComponentes(esperado);
//		double[] vector = {3,1};
//		
//		Assert.assertEquals(2,sistema1.getMatrizCoeficientes().getDimensionFil());
//		Assert.assertEquals(2,sistema1.getMatrizCoeficientes().getDimensionCol());
//		Assert.assertTrue(matriz.equals(sistema1.getMatrizCoeficientes()));
//		Assert.assertArrayEquals(vector, sistema1.getVectorTerminosIndependientes().getComponentes(), 0);
//	}
	
	@Test
	public void queResuelveUnSel(){
		
		Sel sistema1 = new Sel(path+"Entrada\\in\\04_3x3UnoADiez.in"); 
		double[] resultado = {-1,1,0};
		
		sistema1.resolver();
		
		Assert.assertEquals(3,sistema1.getMatrizCoeficientes().getDimensionFil());
		Assert.assertEquals(3,sistema1.getMatrizCoeficientes().getDimensionCol());
		Assert.assertArrayEquals(resultado, sistema1.getVectorIncognita().getComponentes(), 0);
		
		//System.out.println(sistema1.getVectorIncognita());
		//System.out.println(sistema1);	
	}
	
	@Test
	public void queResuelveUnSelConArchivos(){
		
		Sel sistema1 = new Sel(path+"Entrada\\in\\04_3x3UnoADiez.in"); 
		VectorMath resultado = new VectorMath(path+"Salida Esperada\\out\\04_3x3UnoADiez.out");
		
		sistema1.resolver();
		
		Assert.assertEquals(3,sistema1.getMatrizCoeficientes().getDimensionFil());
		Assert.assertEquals(3,sistema1.getMatrizCoeficientes().getDimensionCol());
		Assert.assertArrayEquals(resultado.getComponentes(), sistema1.getVectorIncognita().getComponentes(), 0);
		
		//System.out.println(sistema1);

	}
	
	@Test
	public void queResuelveUnSelConNumerosDouble(){
		
		Sel sistema1 = new Sel(path+"Entrada\\in\\06_2x2Simple.in"); 
		VectorMath resultado = new VectorMath(path+"Salida Esperada\\out\\06_2x2Simple.out");
		
		sistema1.resolver();
		
		Assert.assertEquals(2,sistema1.getMatrizCoeficientes().getDimensionFil());
		Assert.assertEquals(2,sistema1.getMatrizCoeficientes().getDimensionCol());
		Assert.assertArrayEquals(resultado.getComponentes(), sistema1.getVectorIncognita().getComponentes(),0.0000001); // ERROR RELATIVO 10^-6
		
		//System.out.println(sistema1);
		
		
	}
	
	@Test
	public void queResuelveUnSelDelLote(){
		
		Sel sistema1 = new Sel(path+"Entrada\\in\\05_4x4NumerosHasta5Cifras.in"); 
		VectorMath resultado = new VectorMath(path+"Salida Esperada\\out\\05_4x4NumerosHasta5Cifras.out");
		
		sistema1.resolver();
		
		Assert.assertArrayEquals(resultado.getComponentes(), sistema1.getVectorIncognita().getComponentes(), 1E-6);
		
		System.out.println(sistema1);

	}
}
