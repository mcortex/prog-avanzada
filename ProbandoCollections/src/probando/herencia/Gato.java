package probando.herencia;

public class Gato extends Puma {
	public Gato() {
		System.out.println("Gato");
	}
		
	public static void main(String[] args) {
		new Gato().go();
	}

	private void go() {
		System.out.println(this.tipo+" "+super.tipo);
		this.tipo="G";
		System.out.println(this.tipo+" "+super.tipo);
		
	}
	

}
