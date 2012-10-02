import lejos.nxt.*;

public class Sample12 {

	static void main(String[] args) {
		Motor motorB = new Motor(MotorPort.B);
		Motor motorC = new Motor(MotorPort.C);

		motorB.setSpeed(720);
		motorC.setSpeed(720);

		motorB.forward();
		motorC.backward();

		try{
			Thread.sleep(5000);
		}catch(InterruptedException e){
		}

		motorB.stop();
		motorC.stop();
	}

}
