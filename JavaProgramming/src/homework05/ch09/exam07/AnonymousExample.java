package homework05.ch09.exam07;

public class AnonymousExample {

	public static void main(String[] args) {
		Anonymous anony = new Anonymous();
		//�͸� ��ü �ʵ� ���
		anony.field.wake();
		//�͸� ��ü ���� ���� ���
		anony.method1();
		//�͸� ��ü
		anony.method2(
				new Person() {
					void study(){
						System.out.println("�����մϴ�.");
					}
					@Override
					void wake() {
						System.out.println("8�ÿ� �Ͼ�ϴ�.");
						study();
					}
				}
			);

	}

}
