package ch06.homework01.robot;

public class Arms {

	//Field
	String location;
	
	//Constructor
	Arms(String location){
		this.location = location;
	}
	
	//method
	void hello(){
		
		if(location == "������"){
			System.out.println("rightHand : �������� �¿�� �����ݴϴ�");
		}
	}
	void sitDown(){
		
	}
	void chickenBattle(){
		if(location == "����"){
			System.out.println("leftHand : ������ �������� ����ݴϴ�");
		}
		if(location == "������"){
			System.out.println("rightHand : ������ �������� ����ݴϴ�");
		}
	}
	void dance(){
		if(location == "����"){
			System.out.println("leftHand : ������ �Ʒ� ���� �����ݴϴ�");
		}
		if(location == "������"){
			System.out.println("rightHand : �������� �� �Ʒ��� �����ݴϴ�");
		}
	}		

}
