import lejos.nxt.*;

public class Sample04 {

	public static void main(String[] args) {

		while(true){
			Motor.B.stop();
			Motor.C.forward();
			try{
				Thread.sleep(2000);
			}catch (InterruptedException e){
			}

			Motor.B.forward();
			Motor.C.stop();
			try{
				Thread.sleep(2000);
			}catch(InterruptedException e){
			}
		}
	}
}
