import lejos.nxt.*;

public class Sample11 {

	public static void main(String[] args) {
		Motor motorB = new Motor(MotorPort.B);
		Motor motorC = new Motor(MotorPort.C);

		motorB.setSpeed(720);
		motorC.setSpeed(720);

		motorB.forward();
		motorC.forward();

		while(true){
		}
	}

}
