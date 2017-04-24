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
		
		if(location == "오른팔"){
			System.out.println("rightHand : 오른손을 좌우로 흔들어줍니다");
		}
	}
	void sitDown(){
		
	}
	void chickenBattle(){
		if(location == "왼팔"){
			System.out.println("leftHand : 손으로 오른발을 잡아줍니다");
		}
		if(location == "오른팔"){
			System.out.println("rightHand : 손으로 오른발을 잡아줍니다");
		}
	}
	void dance(){
		if(location == "왼팔"){
			System.out.println("leftHand : 왼팔을 아래 위로 흔들어줍니다");
		}
		if(location == "오른팔"){
			System.out.println("rightHand : 오른팔을 위 아래로 흔들어줍니다");
		}
	}		

}
