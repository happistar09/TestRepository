package ch09.exam05;

public class A {
	//Field
	
	//Constructor
	A() {
		//로컬 클래스
		class D{}
		D d = new D();
	
	}
	
	//Method
	void method(){
		//로컬 클래스		
		class E{
			E e = new E();
		}
	}
	
	//Nested Class
	//중첩 멤버 클래스
	class B {}			//A없이 생성 불가능, A에 종속된 것
	static class C{}	//A없이도 C생성 가능하지만 A와 연관된 것

}
