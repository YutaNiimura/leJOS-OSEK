import lejos.nxt.*;
public class Sample09 {

	public static void main(String[] args) {

		int sleepTime[];
		sleepTime = new int[3];
		sleepTime[0] = 2000;
		sleepTime[1] = 4000;
		sleepTime[2] = 6000;

		for(int cnt = 0;cnt < 3;cnt++){
			Motor.B.forward();
			Motor.C.forward();
			try{
				Thread.sleep(sleepTime[cnt]);
			}catch(InterruptedException e){
			}
			Motor.B.stop();
			Motor.C.stop();
			try{
				Thread.sleep(2000);
			}catch(InterruptedException e){
			}
		}
	}
}
