package tasks_abstraction;

abstract class Pen
{
	double ink = 15;
	public abstract void write();
	abstract void refill();
}
public class Fountain extends Pen {

	@Override
	public void write() {
		System.out.println("Use fountain pen to write the notes");
	}

	@Override
	void refill() {
		System.out.println("Refill the pen with black ink");
	}
	
	public void changeNib() {
		System.out.println("Change the nib inside the fountain pen");
	}
	
	public static void main(String[] args) {
		
		Fountain fountain = new Fountain();
		
		if(fountain.ink < 30 && fountain.ink > 10) {
			fountain.refill();
			fountain.write();
		}
		else if(fountain.ink > 50){
			fountain.write();
		}
		else {
			fountain.changeNib();
		}
	}
}