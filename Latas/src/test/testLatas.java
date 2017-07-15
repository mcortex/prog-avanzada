package test;

import org.junit.Test;

import latas.MaquinaLatas;

import org.junit.Assert;

public class testLatas {
	@Test
	public void queCargaUnArchivo() {
		MaquinaLatas maq = new MaquinaLatas("LotePrueba/in/01_caso_simple.in","LotePrueba/out/01_caso_simple.out");
		Assert.assertEquals(5, maq.getCantLatas());
	}
	
	@Test
	public void resuelveCasoSimple() {
		MaquinaLatas maq = new MaquinaLatas("LotePrueba/in/01_caso_simple.in","LotePrueba/out/01_caso_simple.out");
		maq.resolver();
		Assert.assertEquals(5, maq.getCantLatas());
		Assert.assertEquals(2, maq.getSeqMax1());
		Assert.assertEquals(1, maq.getSeqMax2());
		Assert.assertEquals(2, maq.getDistanciaSeq());
	}
	
	@Test
	public void resuelveStressTest() {
		MaquinaLatas maq = new MaquinaLatas("LotePrueba/in/06_stress.in","LotePrueba/out/06_stress.out");
		maq.resolver();
//		Assert.assertEquals(5, maq.getCantLatas());
//		Assert.assertEquals(2, maq.getSeqMax1());
//		Assert.assertEquals(1, maq.getSeqMax2());
//		Assert.assertEquals(2, maq.getDistanciaSeq());
	}

}
