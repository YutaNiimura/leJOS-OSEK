import lejos.nxt.*;
public class Sample01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Motor motorA = new Motor(MotorPort.A);
		Motor motorC = new Motor(MotorPort.C);
		motorA.forward();
		motorC.forward();

		try{
			Thread.sleep(2000);
		}catch(InterruptedException e){
		}
		motorA.stop();
		motorC.stop();
	}
}
