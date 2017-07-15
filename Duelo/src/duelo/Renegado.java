package duelo;

public class Renegado extends Personaje {
	public Renegado(String nombre,Arma arma,int posX,int posY){
		super(nombre,arma,posX,posY);
		this.salud=9;
		this.tipoPersonaje="Renegado";
	}
}
