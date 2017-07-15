package Vikingos;

public class EstadoBerserk implements Estado{
	private int cuentacalma=0;
	private String estado="BERSERK";

	public String getEstado(){
		return this.estado;
	}
	
	public int getDefensa(int defenza) {
		return defenza/2;
	}
	
	
	@Override
	public Estado calmarse() {
		this.cuentacalma++;
		if (this.cuentacalma==3)
			return new EstadoNormal();
		return this;
	}

	@Override
	public Estado serAtacado(int salud) {
		return this;
	}
	
	public int atacar(int fuerza){
		return fuerza*3;
	}
}
