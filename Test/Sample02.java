import lejos.nxt.*;


public class Sample02 {
	public static void main(String[] args) {

		final int c_move_mode = 1;
		int move_mode;

		move_mode = 1;

		if(c_move_mode == move_mode){
			Motor.B.forward();
			Motor.C.forward();
		}else{
			Motor.B.backward();
			Motor.C.backward();
		}

		try{
			Thread.sleep(3000);
		}catch(InterruptedException e){
		}

		Motor.B.stop();
		Motor.C.stop();
	}

}
