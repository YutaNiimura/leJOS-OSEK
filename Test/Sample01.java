import lejos.nxt.*;
public class Sample01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Motor.B.forward();
		Motor.C.forward();

		try{
			Thread.sleep(2000);
		}catch(InterruptedException e){
		}
		Motor.B.stop();
		Motor.C.stop();
	}
}
