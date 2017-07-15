package Vikingos.test;

import org.junit.Test;

import Vikingos.Vikingo;

import org.junit.Assert;

public class TestVikingo {
	@Test
	public void queCambiaDeEstado(){
		Vikingo vik = new Vikingo();
		vik.serAtacado(5);
		Assert.assertEquals("NORMAL", vik.estado.getEstado());
		Assert.assertEquals(10,vik.getDefensa());
	}
	
	@Test
	public void queCambiaDeNormalABerseker(){
		Vikingo vik = new Vikingo();
		vik.serAtacado(5);
		Assert.assertEquals("NORMAL", vik.estado.getEstado());
		vik.serAtacado(25);
		Assert.assertEquals("BERSERK", vik.estado.getEstado());
	}
	
	@Test
	public void queCambiaDeNormalAMeditando(){
		Vikingo vik = new Vikingo();
		vik.calmarse();
		Assert.assertEquals("MEDITADOR", vik.estado.getEstado());
	}
	
	
	@Test
	public void queCambiaMeditandoANormal(){
		Vikingo vik = new Vikingo();
		vik.calmarse();
		Assert.assertEquals("MEDITADOR", vik.estado.getEstado());
		vik.serAtacado(15);
		Assert.assertEquals("NORMAL", vik.estado.getEstado());
	}
	@Test
	public void queCambiaBersekerANormal(){
		Vikingo vik = new Vikingo();
		vik.serAtacado(25);
		Assert.assertEquals("BERSERK", vik.estado.getEstado());
		Assert.assertEquals(5,vik.getDefensa());
		vik.calmarse();
		vik.calmarse();
		vik.calmarse();
		Assert.assertEquals("NORMAL", vik.estado.getEstado());
		Assert.assertEquals(10,vik.getDefensa());
	}
	
	@Test
	public void queBersekerAtacaMas(){
		Vikingo vik = new Vikingo();
		Assert.assertEquals(100, vik.atacar());
		vik.serAtacado(25);
		Assert.assertEquals("BERSERK", vik.estado.getEstado());
		Assert.assertEquals(300, vik.atacar());
		Assert.assertEquals(300, vik.atacar());// ESTE SEGUNDO ASSERT VALIDA QUE NO SE HAYA SUMADO A LA FUERZA ANTERIOR
	}
	
	@Test
	public void queBerserkerBajaSuDefensa(){
		Vikingo vik = new Vikingo();
		vik.serAtacado(25);
		Assert.assertEquals("BERSERK", vik.estado.getEstado());
		Assert.assertEquals(5,vik.getDefensa());
		vik.calmarse();
		vik.calmarse();
		vik.calmarse();
		Assert.assertEquals("NORMAL", vik.estado.getEstado());
		Assert.assertEquals(10,vik.getDefensa());
	}

}
