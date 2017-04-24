package ch07.exam09;

public abstract class Tire {
	//Field
	int diameter;
	
	//Constructor
	Tire(){
		System.out.println("Tire 객체가 생성됩니다.");
	}
	//Method
	 abstract void roll();
	
	public int getDiameter() {
		return diameter;
	}
	public void setDiameter(int diameter) {
		this.diameter = diameter;
	}
	
}
