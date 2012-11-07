import Algorithm.*;
import Common.*;
import Lejosnxj.*;
import lejos.nxt.Button;

public class TailControlMain extends Thread{

	public static void main(String[] args) {

		LejosTailAngleMeter tailAngleMeter = new Lejosnxj.LejosTailAngleMeter();
		LejosTailMotor tailMotor = new Lejosnxj.LejosTailMotor();
		PIDTailControlParm PIDtailControlParm = new Algorithm.PIDTailControlParm();
		PIDTailControl PIDtailControl = new Algorithm.PIDTailControl();
//		DummyTailControlParm dummy = new Algorithm.DummyTailControlParm();
		PIDtailControl.setTailControlParm(PIDtailControlParm);

		TailControl tailControl = new TailControl(tailAngleMeter,tailMotor,PIDtailControl,4);

		tailControl.setTargAngle(90);

		Thread thread = new Thread(tailControl);

		thread.setPriority(MAX_PRIORITY);
		thread.start();

		tailControl.startControl();

		/* LEFTボタン(左)によりロボット停止 */
		while (true) {
			if (Button.LEFT.isDown() == true)
				break;
			try {
				Thread.sleep(200); /* 約200msec周期処理 */
			} catch (InterruptedException e) {
			}
		}

		tailControl.stopControl();

		/* ESCAPEボタン(下)によりプログラム終了 */
		while (true) {
			if (Button.ESCAPE.isDown() == true)
				break;
		}

	}

}
