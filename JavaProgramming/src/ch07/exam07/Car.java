package ch07.exam07;

public class Car {
	//Field
	private Tire tire;
	//Constructor
	public Car(Tire tire){
		this.tire = tire;
	}
	public void setTire(Tire tire) {
		this.tire = tire;
	}
	//Method
	public void run() {
		tire.roll();
	}
}
