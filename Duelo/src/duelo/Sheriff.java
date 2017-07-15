package duelo;

public class Sheriff extends Personaje {
	public Sheriff(String nombre,Arma arma,int posX,int posY){
		super(nombre,arma,posX,posY);
		this.salud=10;
		this.tipoPersonaje="Sheriff";
	}
}
