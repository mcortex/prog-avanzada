package duelo;

public class Alguacil extends Personaje{
	public Alguacil(String nombre,Arma arma,int posX,int posY){
		super(nombre,arma,posX,posY);
		this.salud=6;
		this.tipoPersonaje="Alguacil";
	}
}
