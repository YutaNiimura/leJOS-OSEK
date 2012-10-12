import lejos.nxt.*;

public class Sample11 {

	public static void main(String[] args) {

		Motor.B.setSpeed(720);
		Motor.C.setSpeed(720);

		Motor.B.forward();
		Motor.C.forward();

		while(true){
		}
	}

}
