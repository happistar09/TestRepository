package ch07.exam07;

public class PolymorphismExample2 {
	public static void main(String[] args) {
		
		Tire tire1 = new Tire();
		NormalTire tire2 = new NormalTire();
		SnowTire tire3 = new SnowTire();
		
		run(tire1);
		run(tire2); //TIre tire = tire2;
		run(tire3); //Tire tire = tire3;
	}
	
	static void run (Tire tire){
		tire.roll();
	}
}


