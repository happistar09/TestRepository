package homework04.ch07.exam01;

public abstract class Phone {
	
// p.332 7.8.3 추상 클래스 선언
	//Field
	public String owner;
	
	//Constructor
	public Phone(String owner){
		this.owner = owner;
	}
	//Method
	public void turnOn(){
		System.out.println("폰 전원을 켭니다");
	}
	public void turnOff(){
		System.out.println("폰 전원을 끕니다.");;
	}
}
