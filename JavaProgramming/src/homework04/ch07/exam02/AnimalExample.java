package homework04.ch07.exam02;

public class AnimalExample {

	public static void main(String[] args) {
		Dog dog = new Dog();
		Cat cat = new Cat();
		dog.sound();
		dog.breathe();
		cat.sound();
		cat.breathe();
		System.out.println("----------");
		
		Animal animal = null;
		animal = new Dog();
		animal.sound();
		animal.breathe();
		animal = new Cat();
		animal.sound();
		animal.breathe();
		System.out.println("----------");
		
		//메소드의 다형성
		animalSound(new Dog());
		animalSound(new Cat());
		

	}
	
	public static void animalSound(Animal animal){
		animal.sound();
	}

}
