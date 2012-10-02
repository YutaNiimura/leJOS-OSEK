import lejos.nxt.*;


public class Sample02 {
	public static void main(String[] args) {
		Motor motorB = new Motor(MotorPort.B);
		Motor motorC = new Motor(MotorPort.C);

		final int c_move_mode = 1;
		int move_mode;

		move_mode = 1;

		if(c_move_mode == move_mode){
			motorB.forward();
			motorC.forward();
		}else{
			motorB.backward();
			motorC.backward();
		}

		try{
			Thread.sleep(3000);
		}catch(InterruptedException e){
		}

		motorB.stop();
		motorC.stop();
	}

}
