package instalando.aplicaciones;

import java.util.Arrays;

public class Generador {
	public int[] apps;
	public int tam;
	public Generador(){
		this.tam=50000;
		this.apps = new int[this.tam];
	}
	
	
	public static void main(String[] args) {

		Generador vector = new Generador();
		
		for (int i=0; i<vector.apps.length; i++){
			vector.apps[i]=1;
		}
		
		System.out.println("10000 10000");
		System.out.println(vector);
	}


	@Override
	public String toString() {
//		return "Generador [apps=" + Arrays.toString(apps) + ", tam=" + tam + ", toString()=" + super.toString() + "]";
		return Arrays.toString(apps);
	}

}
