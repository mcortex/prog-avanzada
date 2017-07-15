package ar.edu.unlam.sel.test;

import ar.edu.unlam.sel.*;

import org.junit.Test;
import org.junit.Assert;

public class MatrizMathTest {
	
	public final String path="C:\\Users\\Martin\\Documents\\UNLAM\\PrograAvanzada\\TPS\\TP2\\Prueba\\Preparacion de Prueba\\Lote de Prueba\\Entrada\\MatrizMath\\";
	public final String pathVec="C:\\Users\\Martin\\Documents\\UNLAM\\PrograAvanzada\\TPS\\TP2\\Prueba\\Preparacion de Prueba\\Lote de Prueba\\Entrada\\VectorMath\\";
	
	@Test
	public void queCargaUnArchivo(){
		
		MatrizMath aux = new MatrizMath(path+"simple_2x2.in");
		MatrizMath aux2 = new MatrizMath(aux.getDimensionFil(),aux.getDimensionCol());
		double[][] esperado = {{1,1},{1.1,0.99}};
		aux2.setComponentes(esperado);
		
		Assert.assertEquals(2,aux.getDimensionFil());
		Assert.assertEquals(2,aux.getDimensionCol());
		Assert.assertTrue(aux.equals(aux2));
	}
	
	@Test
	public void queSuma(){
		
		MatrizMath aux = new MatrizMath(path+"simple2_2x2.in");
		MatrizMath aux2 = new MatrizMath(path+"simple2_2x2.in");
		MatrizMath aux3 = new MatrizMath(aux.getDimensionFil(),aux.getDimensionCol());
		double[][] esperado = {{2,2},{4,6}};
		aux3.setComponentes(esperado);
		
		Assert.assertEquals(2,aux.getDimensionFil());
		Assert.assertEquals(2,aux.getDimensionCol());
		Assert.assertTrue(aux3.equals(aux.sumar(aux2)));
	}
	
	@Test
	public void queResta(){
		
		MatrizMath aux = new MatrizMath(path+"simple2_2x2.in");
		MatrizMath aux2 = new MatrizMath(path+"simple2_2x2.in");
		MatrizMath aux3 = new MatrizMath(aux.getDimensionFil(),aux.getDimensionCol());
		
		Assert.assertEquals(2,aux.getDimensionFil());
		Assert.assertEquals(2,aux.getDimensionCol());
		Assert.assertTrue(aux3.equals(aux.restar(aux2)));
	}
	
	@Test
	public void queMultiplicaPorUnVector(){
		
		VectorMath vec = new VectorMath(pathVec+"4_elem_escalar.in");
		MatrizMath mat = new MatrizMath(vec.getDimension(),vec.getDimension());
		double[][] contenido = {{1,0,0,0},{0,1,0,0},{0,0,1,0},{0,0,0,1}};
		mat.setComponentes(contenido);

		Assert.assertTrue(vec.equals(mat.producto(vec)));
	}
	
	@Test
	public void queMultiplicaPorUnaMatriz(){
		MatrizMath mat = new MatrizMath(path+"simple2_2x2.in");
		MatrizMath identidad = new MatrizMath(mat.getDimensionFil(),mat.getDimensionCol());
		double[][] contenido = {{1,0},{0,1}};
		identidad.setComponentes(contenido);
		
		Assert.assertTrue(mat.equals(mat.producto(identidad)));
	}
	
	@Test
	public void queInvierte(){
		MatrizMath mat = new MatrizMath(path+"simple2_2x2.in");
		MatrizMath resultado = new MatrizMath(mat.getDimensionFil(),mat.getDimensionCol());
		double[][] contenido = {{3,-1},{-2,1}};
		resultado.setComponentes(contenido);
		Assert.assertTrue(resultado.equals(mat.invertir()));
	}

}
