package ch06.homework01.robot;

public class Legs {

	//Field
	String location;
	
	//Constructor
	Legs(String location){
		this.location = location;
	}
	
	//Method
	void hello(){		
		
	}
	void sitDown(){
		if(location == "�޹�"){
			System.out.println("leftLeg : �޴ٸ��� ��� �ɴ´�");
		}
		if(location == "������"){
			System.out.println("rightLeg : �����ٸ��� ��� �ɴ´�");
		}
	}
	void chickenBattle(){
		if(location == "�޹�"){
			System.out.println("leftLeg : ���ʴٸ��� �����ؼ� ���濡�� �����Ѵ�");
		}
		
		if(location == "������"){
			System.out.println("rightLeg : �ٸ��� �÷��� ���ʴٸ��� 90���� �̷�� �Ѵ�");
		}		
	}
	void dance(){
		if(location == "�޹�"){
			System.out.println("leftLeg : �޴ٸ��� �¿�� �����ݴϴ�");
		}
		if(location == "������"){
			System.out.println("rightLeg : �����ٸ��� �¿�� �����ݴϴ�");
		}
	}	
	
}
