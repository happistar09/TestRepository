package homework04.ch07.exam01;

public abstract class Phone {
	
// p.332 7.8.3 �߻� Ŭ���� ����
	//Field
	public String owner;
	
	//Constructor
	public Phone(String owner){
		this.owner = owner;
	}
	//Method
	public void turnOn(){
		System.out.println("�� ������ �մϴ�");
	}
	public void turnOff(){
		System.out.println("�� ������ ���ϴ�.");;
	}
}
