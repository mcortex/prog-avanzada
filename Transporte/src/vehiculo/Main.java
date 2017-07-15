package vehiculo;

public class Main {

	public static void main(String[] args) {

		Persona persona1=new Persona("Juan","chofer");
		Persona persona2=new Persona("Jose","acomp");
		Persona persona3=new Persona("Roberto1","pas");
		Persona persona4=new Persona("Roberto2","pas");
		Persona persona5=new Persona("Roberto3","pas");
		Persona persona6=new Persona("Roberto4","pas");
		Persona persona7=new Persona("Roberto5","pas");
		
		
		Motocicleta moto1=new Motocicleta();
		Autobus autobus1=new Autobus();
		autobus1.setChofer(persona1);
		autobus1.setPasajeros(persona3);
		autobus1.setPasajeros(persona4);
		
		for(int i=0;i<autobus1.getPasajeros().size();i++)
			System.out.println("ArrayList " + i + " " +
		autobus1.getPasajeros().get(i).getNombre());
		
		
		moto1.setChofer(persona1);
		moto1.asignarAcompanante(persona2);

		System.out.println("chofer: " + moto1.getChofer().getNombre() + 
				" acompanante: " +moto1.getAcompanante().getNombre());

	}
}