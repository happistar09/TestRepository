package homework05.ch09.exam08;

public class AnonymousExample {

	public static void main(String[] args) {
		Anonymous anony = new Anonymous();
		//�͸� ��ü �ʵ� ���
		anony.field.turnOn();
		//�͸� ��ü ���� ���� ���
		anony.method1();
		//�͸� ��ü �Ű��� ���
		anony.method2(
				new RemoteControl(){
					public void turnOn(){
						System.out.println("SmartTV�� �մϴ�.");
					}
					public void turnOff(){
						System.out.println("SmartTv�� ���ϴ�.");
					}
				}
		);

	}

}
