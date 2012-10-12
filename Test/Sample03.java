import lejos.nxt.*;


public class Sample03 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int count = 0;

		while(count < 5){
			Motor.B.stop();
			Motor.C.forward();
			try{
				Thread.sleep(2000);
			}catch(InterruptedException e){
			}

			Motor.B.forward();
			Motor.C.stop();
			try{
				Thread.sleep(2000);
			}catch(InterruptedException e){
			}
			count += 1;
	}
		Motor.B.stop();
		Motor.C.stop();
	}
}
