package tasks_abstraction;

interface TvRemote {
	public void powerOn();
	public void changeChannel();
	public void soundControl();
}
interface SmartTvRemote extends TvRemote {
	public void setColor();
	public void adjustDisplay();
}
public class Television implements SmartTvRemote {

	@Override
	public void powerOn() {
		System.out.println("click power button to on the TV");
	}
	@Override
	public void changeChannel() {
		System.out.println("Move to the next channel");
	}
	@Override
	public void soundControl() {
		System.out.println("Adjust sound for Tv");
	}
	@Override
	public void setColor() {
		System.out.println("Use settings to enable color");
	}
	@Override
	public void adjustDisplay() {
		System.out.println("Set Zoom level");
	}
	public static void main(String[] args) {
		
		SmartTvRemote remote = new Television();
		int button = 3;
		switch(button)
		{
			case 1:
				remote.powerOn();
				break;
			case 2:
				remote.soundControl();
				break;
			case 3:
				remote.changeChannel();
				break;
			case 4:
				remote.adjustDisplay();
				break;
			case 5:
				remote.setColor();
				break;
			default:
				System.out.println("Invalid button");
		}
	}
}