import lejos.nxt.*;

public class Sample12 {

	static void main(String[] args) {

		Motor.B.setSpeed(720);
		Motor.C.setSpeed(720);

		Motor.B.forward();
		Motor.C.backward();

		try{
			Thread.sleep(5000);
		}catch(InterruptedException e){
		}

		Motor.B.stop();
		Motor.C.stop();
	}

}
