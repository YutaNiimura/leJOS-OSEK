import lejos.nxt.*;

public class Sample04 {

	public static void main(String[] args) {
		Motor motorB = new Motor(MotorPort.B);
		Motor motorC = new Motor(MotorPort.C);

		while(true){
			motorB.stop();
			motorC.forward();
			try{
				Thread.sleep(2000);
			}catch (InterruptedException e){
			}

			motorB.forward();
			motorC.stop();
			try{
				Thread.sleep(2000);
			}catch(InterruptedException e){
			}
		}
	}
}
