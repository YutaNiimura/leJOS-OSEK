import lejos.nxt.*;
public class Sample00 {
	public static void main(String args[]){
		Motor.B.forward();
		try{
			Thread.sleep(2000);
		}catch(InterruptedException e){
		}
		Motor.B.stop();
	}
}
