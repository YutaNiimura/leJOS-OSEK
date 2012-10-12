import lejos.nxt.*;
public class Sample08 {

	public void moveForward(int aTime){
		Motor.B.forward();
		Motor.C.forward();
		try{
			Thread.sleep(aTime);
		}catch(InterruptedException e){
		}
		Motor.B.stop();
		Motor.C.stop();
	}

	public void moveRight(int aTime){
		Motor.B.forward();
		Motor.C.stop();
		try{
			Thread.sleep(2000);
		}catch(InterruptedException e){
		}
		Motor.B.stop();
		Motor.C.stop();
	}

	public static void main(String[] args) {
		Sample08 sample = new Sample08();

		sample.moveForward(3000);
		sample.moveRight(3000);
		sample.moveForward(2000);
	}

}
