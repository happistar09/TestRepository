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
		if(location == "왼발"){
			System.out.println("leftLeg : 왼다리를 접어서 앉는다");
		}
		if(location == "오른발"){
			System.out.println("rightLeg : 오른다리를 접어서 앉는다");
		}
	}
	void chickenBattle(){
		if(location == "왼발"){
			System.out.println("leftLeg : 왼쪽다리로 점프해서 상대방에게 돌진한다");
		}
		
		if(location == "오른발"){
			System.out.println("rightLeg : 다리를 올려서 왼쪽다리와 90도를 이루게 한다");
		}		
	}
	void dance(){
		if(location == "왼발"){
			System.out.println("leftLeg : 왼다리를 좌우로 흔들어줍니다");
		}
		if(location == "오른발"){
			System.out.println("rightLeg : 오른다리를 좌우로 흔들어줍니다");
		}
	}	
	
}
