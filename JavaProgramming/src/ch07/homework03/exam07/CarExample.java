package ch07.homework03.exam07;

public class CarExample {

	public static void main(String[] args) {
		
		Car car = new Car();
		
		for(int i=1; i<=5; i++){
			int problemLocation = car.run();
			if(problemLocation!=0){
				if(problemLocation%2 == 1){
					System.out.println(car.tires[problemLocation-1].location + " HankookTire�� ��ü");
					car.tires[problemLocation-1] = new HankookTire(car.tires[problemLocation-1].location, 15);
				} else{
					System.out.println(car.tires[problemLocation-1].location + " KumhoTire�� ��ü");
					car.tires[problemLocation-1] = new KumhoTire(car.tires[problemLocation-1].location, 17);
				}
			}
			
			
			System.out.println("---------------------------"); // 1ȸ�� �� ��µǴ� ������ ����
		}

	}

}
