package tasks_abstraction;

abstract class TelePhone
{
	abstract void lift();
	abstract void disconnect();
}
public class SmartPhone extends TelePhone {

	static int active = 1;
	@Override
	void lift() {
		System.out.println("Lift the call and say hello.....");
	}
	@Override
	void disconnect() {
		System.out.println("Call is disconnected due to network issue");
	}
	public static void main(String[] args) {
		
		SmartPhone smartPhone = new SmartPhone();
		if(active == 1)
			smartPhone.lift();
		else
			smartPhone.disconnect();
	}
}