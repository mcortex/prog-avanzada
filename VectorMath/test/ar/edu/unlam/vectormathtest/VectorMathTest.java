package ar.edu.unlam.vectormathtest;

import ar.edu.unlam.vectormath.VectorMath;

import org.junit.Test;
import org.junit.Assert;

public class VectorMathTest {
	
	@Test
	public void queCargaUnArchivo(){
		
		VectorMath aux = new VectorMath("4_elem_escalar.in");
		double[] esperado = {1,2,3,4};
		
		Assert.assertEquals(esperado.length,aux.getDimension());
		Assert.assertArrayEquals(esperado, aux.getComponentes(), 0);	
	}
	
	@Test
	public void queSumaDosVectores(){
		
		VectorMath vec1 = new VectorMath("4_elem_escalar.in");
		VectorMath vec2 = new VectorMath("4_elem_unitario.in");
		double[] esperado = {2,3,4,5};
		
		Assert.assertEquals(esperado.length,(vec1.sumar(vec2)).getDimension());
		Assert.assertArrayEquals(esperado, (vec1.sumar(vec2)).getComponentes(), 0);	
	}
	
	@Test
	public void queRestaDosVectores(){
		
		VectorMath vec1 = new VectorMath("4_elem_escalar.in");
		VectorMath vec2 = new VectorMath("4_elem_unitario.in");
		double[] esperado = {0,1,2,3};
		
		Assert.assertEquals(esperado.length,(vec1.restar(vec2)).getDimension());
		Assert.assertArrayEquals(esperado, (vec1.restar(vec2)).getComponentes(), 0);	
	}
	
	@Test
	public void queMultiplicaPorEscalar(){
		
		VectorMath vec1 = new VectorMath("4_elem_unitario.in");
		double[] esperado = {2,2,2,2};
		
		Assert.assertEquals(esperado.length,vec1.getDimension());
		Assert.assertArrayEquals(esperado, (vec1.producto(2)).getComponentes(), 0);	
	}
	
	@Test
	public void queMultiplicaPorOtroVector(){
		
		VectorMath vec1 = new VectorMath("4_elem_escalar.in");
		VectorMath vec2 = new VectorMath("4_elem_unitario.in");
		double esperado = 10;

		Assert.assertEquals(esperado, vec1.producto(vec2), 0);		
	}
	
	@Test
	public void queSonIguales(){
		VectorMath vec1 = new VectorMath("4_elem_escalar.in");
		VectorMath vec2 = new VectorMath("4_elem_escalar.in");
		
		Assert.assertTrue(vec1.equals(vec2));
	}
	
}
