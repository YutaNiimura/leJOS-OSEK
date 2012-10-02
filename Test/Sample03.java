import lejos.nxt.*;


public class Sample03 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Motor motorB = new Motor(MotorPort.B);
		Motor motorC = new Motor(MotorPort.C);

		int count = 0;

		while(count < 5){
			motorB.stop();
			motorC.forward();
			try{
				Thread.sleep(2000);
			}catch(InterruptedException e){
			}

			motorB.forward();
			motorC.stop();
			try{
				Thread.sleep(2000);
			}catch(InterruptedException e){
			}
			count += 1;
	}
		motorB.stop();
		motorC.stop();
	}
}
