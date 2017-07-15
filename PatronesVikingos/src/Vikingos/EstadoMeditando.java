package Vikingos;

public class EstadoMeditando implements Estado {
	
	private String estado="MEDITADOR";

	public String getEstado(){
		return this.estado;
	}
	
	public int getDefensa(int defenza) {
		return defenza;
	}

	@Override
	public Estado calmarse() {
		return this;
	}

	@Override
	public Estado serAtacado(int salud) {
		if(salud <= 95)
			return new EstadoNormal();
		return this;
	}
	
	public int atacar(int fuerza){
		return fuerza;
	}

}
