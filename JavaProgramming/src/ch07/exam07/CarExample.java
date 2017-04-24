package ch07.exam07;

public class CarExample {
	public static void main(String[] args) {
	//	Car car = new Car(new NormalTire());
		System.out.println("눈이 옵니다->");
		Car car = new Car(new SnowTire());
		car.run();
		System.out.println();
		
		System.out.println("눈이 그쳤습니다->");
		car.setTire(new NormalTire());
		car.run();
		System.out.println();
		
		System.out.println("경주를 합니다->");
		car.setTire(new SpeedTire());
		car.run();
		System.out.println();
		
		System.out.println("산을 올라갑니다->");
		car.setTire(new SuperTire());
		car.run();
		System.out.println();
		
	}
}
