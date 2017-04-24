package ch09.exam02;

public class A {
	//Field
	int aField;
	//Constructor
	A() {
		//로컬 클래스
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
		//로컬 클래스
		class D{}
		class E{}
	}
	
	//Nested Class
	//중첩 멤버 클래스
	class B {
		//Field
		
		//Constrcutor
		
		//Method
		void bMethod(){
			aField = 10;
		}
	}			//A없이 생성 불가능, A에 종속된 것
	static class C{
		//Field
		
		//Constrcutor
		
		//Method
		void aMethod(){
		//	aField = 10; 			
		}
	}	//A없이도 C생성 가능하지만 A와 연관된 것
	

}
