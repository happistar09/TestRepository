package ch09.exam03;

public class A {
	//Field
	int aField;
	//Constructor
	A() {
		int localVariable = 2;	//final 속성을 가진다
		//로컬 클래스
		class D{
			//Field
			
			//Constrcutor
			
			//Method
			void dMethod(){
				int result = localVariable + 8;
			//	localVariable = 10;
			}
		}
		class E{
			//Field
			
			//Constrcutor
			
			//Method
			void eMethod(){
				
			}
		}
	}
	
	//Method
	void method(){
		//로컬 클래스
		class D{}
		class E{}
	}	
	
	

}
