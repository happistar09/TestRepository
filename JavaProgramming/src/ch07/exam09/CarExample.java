package ch07.exam09;

public class CarExample {
	public static void main(String[] args) {
		Car car = new Car(new NormalTire());	//ClasscastException �� �߻��Ѵ�
		
		car.run();
		
	}
}
