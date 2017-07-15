package duelo.test;

import org.junit.Test;
import org.junit.Assert;

import duelo.*;

public class TestPersonaje {

	@Test
	public void testSheriff(){
		Sheriff s1 = new Sheriff("Martin", new Colt(), 1, 1);
		Assert.assertTrue(s1.getSalud() == 10);
		Assert.assertTrue(s1.getTipoPersonaje() == "Sheriff");
		Assert.assertTrue(s1.getArma().getTipoArma() == "Colt");
		Assert.assertTrue(s1.getArma().getAlcance() == 10);
		
		
		Sheriff s2 = new Sheriff("Diego", new Derringer(), 1, 2);
		Assert.assertTrue(s2.getSalud() == 10);
		Assert.assertTrue(s2.getTipoPersonaje() == "Sheriff");
		Assert.assertTrue(s2.getArma().getTipoArma() == "Derringer");
		Assert.assertTrue(s2.getArma().getAlcance() == 1.5);
		
		
		Sheriff s3 = new Sheriff("Ruperto", new Winchester(), 1, 3);
		Assert.assertTrue(s3.getSalud() == 10);
		Assert.assertTrue(s3.getTipoPersonaje() == "Sheriff");
		Assert.assertTrue(s3.getArma().getTipoArma() == "Winchester");
		Assert.assertTrue(s3.getArma().getAlcance() == 4);
	}
	
	@Test
	public void testAlguacil(){
		Alguacil a1 = new Alguacil("Martin", new Colt(), 1, 1);
		Assert.assertTrue(a1.getSalud() == 6);
		Assert.assertTrue(a1.getTipoPersonaje() == "Alguacil");
		Assert.assertTrue(a1.getArma().getTipoArma() == "Colt");
		Assert.assertTrue(a1.getArma().getAlcance() == 10);
		
		
		Alguacil a2 = new Alguacil("Diego", new Derringer(), 1, 2);
		Assert.assertTrue(a2.getSalud() == 6);
		Assert.assertTrue(a2.getTipoPersonaje() == "Alguacil");
		Assert.assertTrue(a2.getArma().getTipoArma() == "Derringer");
		Assert.assertTrue(a2.getArma().getAlcance() == 1.5);
		
		
		Alguacil a3 = new Alguacil("Ruperto", new Winchester(), 1, 3);
		Assert.assertTrue(a3.getSalud() == 6);
		Assert.assertTrue(a3.getTipoPersonaje() == "Alguacil");
		Assert.assertTrue(a3.getArma().getTipoArma() == "Winchester");
		Assert.assertTrue(a3.getArma().getAlcance() == 4);
	}
	
	@Test
	public void testRenegado(){
		Renegado r1 = new Renegado("Martin", new Colt(), 1, 1);
		Assert.assertTrue(r1.getSalud() == 9);
		Assert.assertTrue(r1.getTipoPersonaje() == "Renegado");
		Assert.assertTrue(r1.getArma().getTipoArma() == "Colt");
		Assert.assertTrue(r1.getArma().getAlcance() == 10);
		
		
		Renegado r2 = new Renegado("Diego", new Derringer(), 1, 2);
		Assert.assertTrue(r2.getSalud() == 9);
		Assert.assertTrue(r2.getTipoPersonaje() == "Renegado");
		Assert.assertTrue(r2.getArma().getTipoArma() == "Derringer");
		Assert.assertTrue(r2.getArma().getAlcance() == 1.5);
		
		
		Renegado r3 = new Renegado("Ruperto", new Winchester(), 1, 3);
		Assert.assertTrue(r3.getSalud() == 9);
		Assert.assertTrue(r3.getTipoPersonaje() == "Renegado");
		Assert.assertTrue(r3.getArma().getTipoArma() == "Winchester");
		Assert.assertTrue(r3.getArma().getAlcance() == 4);
	}
}
