import lejos.nxt.*;
public class Sample00 {
	public static void main(String args[]){
		Motor motorA = new Motor(MotorPort.A);
		motorA.forward();
		try{
			Thread.sleep(2000);
		}catch(InterruptedException e){
		}
		motorA.stop();
	}
}
