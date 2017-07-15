package test;

import org.junit.Test;

import instalando.aplicaciones.InstaladorAplicaciones;

import org.junit.Assert;

public class TestInstalador {
	@Test
	public void queCargaArchivo() {
		InstaladorAplicaciones ia = new InstaladorAplicaciones("LotePruebas/In/00_ejemplo_parcial.in","LotePruebas/Out/00_ejemplo_parcial.out");
		Assert.assertEquals(10, ia.getCantAplicaciones());
		Assert.assertEquals(100, ia.getPesoAplicacion());
		//System.out.println(ia.toString());
	}
	
	

//	@Test
//	public void queElSumadorFunciona() {
//		InstaladorAplicaciones ia = new InstaladorAplicaciones("LotePruebas/In/00_ejemplo_parcial.in","LotePruebas/Out/00_ejemplo_parcial.out");
//		Assert.assertEquals(10, ia.getCantAplicaciones());
//		Assert.assertEquals(100, ia.getPesoAplicacion());
//		Assert.assertEquals(2, ia.sumaPosicionesAdyacentes(1, 1));
//		Assert.assertEquals(44, ia.sumaPosicionesAdyacentes(0, 2));
//	}
	
	//00
	@Test
	public void testCasoParcial() {
		InstaladorAplicaciones ia = new InstaladorAplicaciones("LotePruebas/In/00_ejemplo_parcial.in","LotePruebas/Out/00_ejemplo_parcial.out");
//		ia.obtieneAplicaciones();
//		ia.resolver();
//		Assert.assertEquals(3, ia.getAppAdyacentesDesinstaladas());
//		Assert.assertEquals(6, ia.getPosicionPrimerApp());
	}
	
	//01
	@Test
	public void testMemoriaInsuficiente() {
		InstaladorAplicaciones ia = new InstaladorAplicaciones("LotePruebas/In/01_memoria_insuficiente.in","LotePruebas/Out/01_memoria_insuficiente.out");
		Assert.assertEquals(3, ia.getCantAplicaciones());
		Assert.assertEquals(100, ia.getPesoAplicacion());
//		ia.obtieneAplicaciones();
//		ia.resolver();
	}
	
	//02
	@Test
	public void testCaso02() {
		InstaladorAplicaciones ia = new InstaladorAplicaciones("LotePruebas/In/02_igual_numero_de_app_desempate_mb_liberados.in","LotePruebas/Out/02_igual_numero_de_app_desempate_mb_liberados.out");
//		ia.obtieneAplicaciones();
//		ia.resolver();
//		Assert.assertEquals(3, ia.getAppAdyacentesDesinstaladas());
//		Assert.assertEquals(5, ia.getPosicionPrimerApp());
	}
	
	//03
	@Test
	public void testCaso03() {
		InstaladorAplicaciones ia = new InstaladorAplicaciones("LotePruebas/In/03_igual_numero_app_igual_numero_mb_distinta_posicion.in","LotePruebas/Out/03_igual_numero_app_igual_numero_mb_distinta_posicion.out");
//		ia.obtieneAplicaciones();
//		ia.resolver();
//		Assert.assertEquals(3, ia.getAppAdyacentesDesinstaladas());
//		Assert.assertEquals(1, ia.getPosicionPrimerApp());
	}
	
	//04
	@Test
	public void testCaso04() {
		InstaladorAplicaciones ia = new InstaladorAplicaciones("LotePruebas/In/04_minima_cantidad_app.in","LotePruebas/Out/04_minima_cantidad_app.out");
//		ia.obtieneAplicaciones();
//		ia.resolver();
//		Assert.assertEquals(2, ia.getAppAdyacentesDesinstaladas());
//		Assert.assertEquals(5, ia.getPosicionPrimerApp());
	}
	
	//05
	@Test
	public void testCaso05() {
		InstaladorAplicaciones ia = new InstaladorAplicaciones("LotePruebas/In/05_unica_app.in","LotePruebas/Out/05_unica_app.out");
//		ia.obtieneAplicaciones();
//		ia.resolver();
//		Assert.assertEquals(1, ia.getAppAdyacentesDesinstaladas());
//		Assert.assertEquals(1, ia.getPosicionPrimerApp());
	}
	
	
	//06
	@Test
	public void testCaso06() {
		InstaladorAplicaciones ia = new InstaladorAplicaciones("LotePruebas/In/06_conjunto_al_final.in","LotePruebas/Out/06_conjunto_al_final.out");
//		ia.obtieneAplicaciones();
//		ia.resolver();
//		Assert.assertEquals(2, ia.getAppAdyacentesDesinstaladas());
//		Assert.assertEquals(4, ia.getPosicionPrimerApp());
	}
	
	//07
	@Test
	public void testCaso07() {
		InstaladorAplicaciones ia = new InstaladorAplicaciones("LotePruebas/In/07_conjunto_al_principio.in","LotePruebas/Out/07_conjunto_al_principio.out");
//		ia.obtieneAplicaciones();
//		ia.resolver();
//		Assert.assertEquals(2, ia.getAppAdyacentesDesinstaladas());
//		Assert.assertEquals(1, ia.getPosicionPrimerApp());
	}
	
	
	//08
	@Test
	public void testCaso08() {
		InstaladorAplicaciones ia = new InstaladorAplicaciones("LotePruebas/In/08_una_app.in","LotePruebas/Out/08_una_app.out");
		Assert.assertEquals(2, ia.getCantAplicaciones());
		Assert.assertEquals(40, ia.getPesoAplicacion());
//		ia.obtieneAplicaciones();
//		ia.resolver();
//		Assert.assertEquals(1, ia.getAppAdyacentesDesinstaladas());
//		Assert.assertEquals(1, ia.getPosicionPrimerApp());
	}
	
	//09
	@Test
	public void testFatiga() {
		InstaladorAplicaciones ia = new InstaladorAplicaciones("LotePruebas/In/09_fatiga.in","LotePruebas/Out/09_fatiga.out");
		Assert.assertEquals(10000, ia.getCantAplicaciones());
		Assert.assertEquals(10000, ia.getPesoAplicacion());
		ia.obtieneAplicaciones();
//		ia.resolver();
//		Assert.assertEquals(10000, ia.getAppAdyacentesDesinstaladas());
//		Assert.assertEquals(1, ia.getPosicionPrimerApp());
	}
	
	//10
	@Test
	public void testCaso10() {
		InstaladorAplicaciones ia = new InstaladorAplicaciones("LotePruebas/In/10_mayor_peso_al_final_una_app.in","LotePruebas/Out/10_mayor_peso_al_final_una_app.out");
		Assert.assertEquals(7, ia.getCantAplicaciones());
		Assert.assertEquals(120, ia.getPesoAplicacion());
//		ia.obtieneAplicaciones();
//		ia.resolver();
//		Assert.assertEquals(10000, ia.getAppAdyacentesDesinstaladas());
//		Assert.assertEquals(1, ia.getPosicionPrimerApp());
	}
	
	//11
	@Test
	public void testFatigaMaxima() {
		InstaladorAplicaciones ia = new InstaladorAplicaciones("LotePruebas/In/11_fatiga_maxima.in","LotePruebas/Out/11_fatiga_maxima.out");
		Assert.assertEquals(50000, ia.getCantAplicaciones());
		Assert.assertEquals(50000, ia.getPesoAplicacion());
		ia.obtieneAplicaciones();
//		ia.resolver();
//		Assert.assertEquals(10000, ia.getAppAdyacentesDesinstaladas());
//		Assert.assertEquals(1, ia.getPosicionPrimerApp());
	}

}
