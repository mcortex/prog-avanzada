package ar.edu.unlam.sel.test;

import ar.edu.unlam.sel.*;

import org.junit.Test;
import org.junit.Assert;

public class VectorMathTest {
	
	public final String path="C:\\Users\\Martin\\Documents\\UNLAM\\PrograAvanzada\\TPS\\TP2\\Prueba\\Preparacion de Prueba\\Lote de Prueba\\Entrada\\VectorMath\\";
	
	@Test
	public void queCargaUnArchivo(){
		
		VectorMath aux = new VectorMath(path+"4_elem_escalar.in");
		double[] esperado = {1,2,3,4};
		
		Assert.assertEquals(esperado.length,aux.getDimension());
		Assert.assertArrayEquals(esperado, aux.getComponentes(), 0);
	}
	
	@Test
	public void queSumaDosVectores(){
		
		VectorMath vec1 = new VectorMath(path+"4_elem_escalar.in");
		VectorMath vec2 = new VectorMath(path+"4_elem_unitario.in");
		double[] esperado = {2,3,4,5};
		
		Assert.assertEquals(esperado.length,(vec1.sumar(vec2)).getDimension());
		Assert.assertArrayEquals(esperado, (vec1.sumar(vec2)).getComponentes(), 0);	
	}
	
	@Test
	public void queRestaDosVectores(){
		
		VectorMath vec1 = new VectorMath(path+"4_elem_escalar.in");
		VectorMath vec2 = new VectorMath(path+"4_elem_unitario.in");
		double[] esperado = {0,1,2,3};
		
		Assert.assertEquals(esperado.length,(vec1.restar(vec2)).getDimension());
		Assert.assertArrayEquals(esperado, (vec1.restar(vec2)).getComponentes(), 0);	
	}
	
	@Test
	public void queMultiplicaPorEscalar(){
		
		VectorMath vec1 = new VectorMath(path+"4_elem_unitario.in");
		double[] esperado = {2,2,2,2};
		
		Assert.assertEquals(esperado.length,vec1.getDimension());
		Assert.assertArrayEquals(esperado, (vec1.producto(2)).getComponentes(), 0);	
	}
	
	@Test
	public void queMultiplicaPorOtroVector(){
		
		VectorMath vec1 = new VectorMath(path+"4_elem_escalar.in");
		VectorMath vec2 = new VectorMath(path+"4_elem_unitario.in");
		double esperado = 10;

		Assert.assertEquals(esperado, vec1.producto(vec2), 0);		
	}
	
	@Test
	public void queSonIguales(){
		VectorMath vec1 = new VectorMath(path+"4_elem_escalar.in");
		VectorMath vec2 = new VectorMath(path+"4_elem_escalar.in");
		
		Assert.assertTrue(vec1.equals(vec2));
	}
	
	@Test
	public void queMultiplicaPorUnaMatriz(){
		
		VectorMath vec = new VectorMath(path+"4_elem_escalar.in");
		MatrizMath mat = new MatrizMath(vec.getDimension(),vec.getDimension());
		double[][] contenido = {{1,0,0,0},{0,1,0,0},{0,0,1,0},{0,0,0,1}};
		mat.setComponentes(contenido);

		Assert.assertTrue(vec.equals(vec.producto(mat)));
	}
	
}