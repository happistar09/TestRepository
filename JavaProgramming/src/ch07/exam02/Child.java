package ch07.exam02;

public class Child extends Parent {

	//Filed
	String firstName = "ÀÚ¹Ù";
	//Constructor
	Child(String lastName, String firstName){
		super(lastName);
		this.firstName = firstName;
	}
	//Method
	void play(){
		System.out.println("³î¾Æ¿ä");
	}
}
