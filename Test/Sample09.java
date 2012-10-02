import lejos.nxt.*;
public class Sample09 {

	public static void main(String[] args) {
		Motor motorB = new Motor(MotorPort.B);
		Motor motorC = new Motor(MotorPort.C);

		int sleepTime[];
		sleepTime = new int[3];
		sleepTime[0] = 2000;
		sleepTime[1] = 4000;
		sleepTime[2] = 6000;

		for(int cnt = 0;cnt < 3;cnt++){
			motorB.forward();
			motorC.forward();
			try{
				Thread.sleep(sleepTime[cnt]);
			}catch(InterruptedException e){
			}
			motorB.stop();
			motorC.stop();
			try{
				Thread.sleep(2000);
			}catch(InterruptedException e){
			}
		}
	}
}
