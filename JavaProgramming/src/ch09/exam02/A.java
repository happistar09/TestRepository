package ch09.exam02;

public class A {
	//Field
	int aField;
	//Constructor
	A() {
		//���� Ŭ����
		class D{
			//Field
			
			//Constrcutor
			
			//Method
			void dMethod(){
				aField = 10;
			}
		}
		class E{
			//Field
			
			//Constrcutor
			
			//Method
			void eMethod(){
				aField = 10;
			}
		}
	}
	
	//Method
	void method(){
		//���� Ŭ����
		class D{}
		class E{}
	}
	
	//Nested Class
	//��ø ��� Ŭ����
	class B {
		//Field
		
		//Constrcutor
		
		//Method
		void bMethod(){
			aField = 10;
		}
	}			//A���� ���� �Ұ���, A�� ���ӵ� ��
	static class C{
		//Field
		
		//Constrcutor
		
		//Method
		void aMethod(){
		//	aField = 10; 			
		}
	}	//A���̵� C���� ���������� A�� ������ ��
	

}
