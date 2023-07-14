package tasks_abstraction;

interface Animal {
	void eat();
	void sleep();
}

class Monkey {

	void bite() {
		System.out.println("Monkey can bite....");
	}
	void jump() {
		System.out.println("Monkey can jump....");
	}
}
class Human extends Monkey implements Animal {

	@Override
	public void eat() {
		System.out.println("Humans are eating...");
	}
	@Override
	public void sleep() {
		System.out.println("Humans are sleeping...");
	}
}
public class HumanMain {
	public static void main(String[] args) {
		Human human = new Human();
		
		// Calling methods from Monkey class
		human.jump();
		human.bite();
		
		// Calling methods from BasicAnimal interface
		human.eat();
		human.sleep();
		
		// Polymorphism using Monkey class
		Monkey monkey = human;
		monkey.jump();
		monkey.bite();
	}
}