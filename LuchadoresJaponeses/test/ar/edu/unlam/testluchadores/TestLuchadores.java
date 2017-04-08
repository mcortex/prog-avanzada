package ar.edu.unlam.testluchadores;

import ar.edu.unlam.luchadores.Luchador;

import org.junit.Test;
import org.junit.Assert;

public class TestLuchadores {

	@Test
	public void queDomina(){
		Luchador luchadorUno = new Luchador(200,220);
		Luchador luchadorDos = new Luchador(200,250);
		Assert.assertEquals(true, luchadorDos.domina(luchadorUno));
		Assert.assertEquals(false, luchadorUno.domina(luchadorDos));
	}
	
	@Test
	public void noDominaNadie(){
		Luchador luchadorUno = new Luchador(321,123);
		Luchador luchadorDos = new Luchador(123,321);
		Assert.assertEquals(false, luchadorDos.domina(luchadorUno));
		Assert.assertEquals(false, luchadorUno.domina(luchadorDos));
	}
	
	
}
