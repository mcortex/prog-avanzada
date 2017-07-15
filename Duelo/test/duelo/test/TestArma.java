package duelo.test;

import org.junit.Test;
import org.junit.Assert;

import duelo.*;

public class TestArma {

	@Test
	public void armaVacia(){
		Derringer chumbito = new Derringer();
		//Gasto el cargador
		chumbito.tiro();
		chumbito.tiro();
		Assert.assertEquals(0, chumbito.getCantTiros());
		//Cargador vacio no permite disparar, debe recargar
		Assert.assertFalse(chumbito.tiro());
	}
	
}
