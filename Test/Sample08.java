import lejos.nxt.*;
public class Sample08 {

	Motor motorB = new Motor(MotorPort.B);
	Motor motorC = new Motor(MotorPort.C);

	public void moveForward(int aTime){
		motorB.forward();
		motorC.forward();
		try{
			Thread.sleep(aTime);
		}catch(InterruptedException e){
		}
		motorB.stop();
		motorC.stop();
	}

	public void moveRight(int aTime){
		motorB.forward();
		motorC.stop();
		try{
			Thread.sleep(2000);
		}catch(InterruptedException e){
		}
		motorB.stop();
		motorC.stop();
	}

	public static void main(String[] args) {
		Sample08 sample = new Sample08();

		sample.moveForward(3000);
		sample.moveRight(3000);
		sample.moveForward(2000);
	}

}
