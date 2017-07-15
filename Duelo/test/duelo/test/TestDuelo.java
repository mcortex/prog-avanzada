package duelo.test;

import org.junit.Test;
import org.junit.Assert;

import duelo.*;

public class TestDuelo {

	@Test
	public void dueloSheriffRenegado(){

			Sheriff martin = new Sheriff("Martin", new Colt(), 1,1);
			Renegado ruperto = new Renegado("Ruperto", new Derringer(), 1,3);
			
			// se arma la balacera mientras esten vivos o ambas armas no se rompan
			while (martin.estaVivo() && ruperto.estaVivo() 
					&& (martin.tengoArma() || ruperto.tengoArma())){
				
				martin.duelo(ruperto);
				ruperto.duelo(martin);
					
			}
			
			Assert.assertTrue(martin.estaVivo());
			Assert.assertFalse(ruperto.estaVivo());
		
	}
	
	@Test
	public void dueloDeTres(){
		
		Sheriff eastwood = new Sheriff("Clint", new Colt(), 1,1);
		Alguacil norris = new Alguacil("Chuck", new Winchester(), 1,2);
		Renegado ruperto = new Renegado("Ruperto", new Derringer(), 1,3);
		
		int sobreviviente = 3;
		// se arma la balacera mientras esten vivos o las armas no se rompan	
		//while (eastwood.estaVivo() && norris.estaVivo() && ruperto.estaVivo()
		while (sobreviviente > 1 && (eastwood.tengoArma() || norris.tengoArma() || ruperto.tengoArma())){
			
			eastwood.duelo(ruperto);
			
			ruperto.duelo(eastwood);
			
			eastwood.duelo(norris);
			
			norris.duelo(eastwood);			
			
			norris.duelo(ruperto);
			
			ruperto.duelo(norris);
			
			if (!eastwood.estaVivo())
				sobreviviente--;
			if (!norris.estaVivo())
				sobreviviente--;
			if (!ruperto.estaVivo())
				sobreviviente--;
				
		}
		
		Assert.assertTrue(eastwood.estaVivo());
		Assert.assertFalse(norris.estaVivo());
		Assert.assertFalse(ruperto.estaVivo());
	
	}
}
