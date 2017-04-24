package ch06.homework01.robot;

public class Robot {

	//Field
	Arms[] arms = { new Arms("����"), new Arms("������") };
	Body body = new Body();
	Head head = new Head();
	Legs[] legs = { new Legs("�޹�"), new Legs("������") };
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
		System.out.println("��ư�� �����ϼ���");
		System.out.println("1.PowerOn | 2. Robot info | 3.PowerOff");		
	}
	void powerOn(){
		System.out.println("�κ��� ���� �˴ϴ�.");
	}
	void info(){
		System.out.println("�������� : " + makeDay);
		System.out.println("���� : " + color);
		System.out.println("������� : head, body, arms, legs");
	}
	void powerOff(){
		System.out.println("�κ��� ���� �˴ϴ�.");
		return;
	}
	void motionChoice(){
		System.out.println("=====================================================");
		System.out.println("����� �����ϼ���");
		System.out.println("1.�λ��ϱ� | 2.�ڸ��� �ɱ� | 3.�߽ο��ϱ� | 4.���߱� | 5. PowerOff");
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
