package ch07.exam07;

public class CarExample {
	public static void main(String[] args) {
	//	Car car = new Car(new NormalTire());
		System.out.println("���� �ɴϴ�->");
		Car car = new Car(new SnowTire());
		car.run();
		System.out.println();
		
		System.out.println("���� ���ƽ��ϴ�->");
		car.setTire(new NormalTire());
		car.run();
		System.out.println();
		
		System.out.println("���ָ� �մϴ�->");
		car.setTire(new SpeedTire());
		car.run();
		System.out.println();
		
		System.out.println("���� �ö󰩴ϴ�->");
		car.setTire(new SuperTire());
		car.run();
		System.out.println();
		
	}
}
