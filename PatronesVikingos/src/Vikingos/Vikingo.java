package Vikingos;

public class Vikingo {
	public int salud;
	public int fuerza;
	public int defenza;
	public Estado estado;
	
	public Vikingo(){
		this.salud=100;
		this.fuerza=100;
		this.defenza=10;
		this.estado = new EstadoNormal();
	}
	
	public int getDefensa() {
		return this.estado.getDefensa(this.defenza);
	}
	
	public void serAtacado(int valor){
		if (this.getDefensa()<=valor)
			this.salud-=(valor-this.getDefensa()); // DEFENSA AMORTIGUA EL VALOR DEL ATAQUE
		this.estado = this.estado.serAtacado(this.salud);
	}
	
	public int atacar(){
		return this.estado.atacar(this.fuerza);		
	}
	
	public void calmarse() {
		this.estado = this.estado.calmarse();
	}
	
	public String getEstado(){
		return this.estado.getEstado();
	}
	
}
