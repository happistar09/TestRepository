package ch09.exam05;

public class A {
	//Field
	
	//Constructor
	A() {
		//���� Ŭ����
		class D{}
		D d = new D();
	
	}
	
	//Method
	void method(){
		//���� Ŭ����		
		class E{
			E e = new E();
		}
	}
	
	//Nested Class
	//��ø ��� Ŭ����
	class B {}			//A���� ���� �Ұ���, A�� ���ӵ� ��
	static class C{}	//A���̵� C���� ���������� A�� ������ ��

}
