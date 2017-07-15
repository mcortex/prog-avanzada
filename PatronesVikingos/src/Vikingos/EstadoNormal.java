package Vikingos;

public class EstadoNormal implements Estado {
	String estado="NORMAL";
	
	public String getEstado(){
		return this.estado;
	}
	
	public int getDefensa(int defenza) {
		return defenza;
	}

	@Override
	public Estado calmarse() {
		return new EstadoMeditando();
	}

	@Override
	public Estado serAtacado(int salud) {
		if(salud <= 85)
			return new EstadoBerserk();
		return new EstadoNormal();
	}
	
	public int atacar(int fuerza){
		return fuerza;
	}

}
