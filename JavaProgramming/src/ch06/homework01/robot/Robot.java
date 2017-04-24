package ch06.homework01.robot;

public class Robot {

	//Field
	Arms[] arms = { new Arms("왼팔"), new Arms("오른팔") };
	Body body = new Body();
	Head head = new Head();
	Legs[] legs = { new Legs("왼발"), new Legs("오른발") };
	String makeDay;
	String color;
	//Constructor
	Robot(String makeDay, String color){
		this.makeDay = makeDay;
		this.color = color;
	}
	
	//Method
	void power(){
		System.out.println("ROBOT");
		System.out.println("======================================");
		System.out.println("버튼을 선택하세요");
		System.out.println("1.PowerOn | 2. Robot info | 3.PowerOff");		
	}
	void powerOn(){
		System.out.println("로봇이 구동 됩니다.");
	}
	void info(){
		System.out.println("제조일자 : " + makeDay);
		System.out.println("색깔 : " + color);
		System.out.println("구성요소 : head, body, arms, legs");
	}
	void powerOff(){
		System.out.println("로봇이 종료 됩니다.");
		return;
	}
	void motionChoice(){
		System.out.println("=====================================================");
		System.out.println("모션을 선택하세요");
		System.out.println("1.인사하기 | 2.자리에 앉기 | 3.닭싸움하기 | 4.춤추기 | 5. PowerOff");
	}
	void hello(){		
		head.hello();
		body.hello();	
		arms[0].hello();
		arms[1].hello();
		legs[0].hello();
		legs[1].hello();		
	}
	void sitDown(){
		head.sitDown();		
		body.sitDown();	
		arms[0].sitDown();
		arms[1].sitDown();
		legs[0].sitDown();
		legs[1].sitDown();	
	}
	void chickenBattle(){
		head.chickenBattle();
		body.chickenBattle();	
		arms[0].chickenBattle();
		arms[1].chickenBattle();
		legs[0].chickenBattle();
		legs[1].chickenBattle();
	}
	void dance(){
		head.dance();
		body.dance();	
		arms[0].dance();
		arms[1].dance();
		legs[0].dance();
		legs[1].dance();	
	}
	
	
}
