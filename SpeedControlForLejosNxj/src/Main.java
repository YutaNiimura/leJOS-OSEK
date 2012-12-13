import lejos.nxt.Button;
import Algorithm.*;
import Common.*;
import Interface.*;


public class Main extends Thread{

	static final int ControlCycle = 4;

	public static void main(String[] args) {
		LejosWheelMotorEncoder lejosWheelMotorEncoder = new LejosWheelMotorEncoder();
		LejosWheelMotor lejosWheelMotor = new LejosWheelMotor();
		PIDSpeedControlParm pidSpeedControlParm = new PIDSpeedControlParm();
		PIDSpeedControl pidSpeedControl = new PIDSpeedControl();

		pidSpeedControl.setSpeedControlParm(pidSpeedControlParm);

		SpeedControl speedControl = new SpeedControl(lejosWheelMotorEncoder,lejosWheelMotor,
				pidSpeedControl,ControlCycle);

		speedControl.setTargSpeed(80);

		Thread thread = new Thread(speedControl);

		thread.setPriority(MAX_PRIORITY);

		thread.start();

		speedControl.startControl();

		/* LEFTボタン(左)によりロボット停止 */
		while (true) {
			if (Button.LEFT.isDown() == true)
				break;
			try {
				Thread.sleep(200); /* 約200msec周期処理 */
			} catch (InterruptedException e) {
			}
		}

		speedControl.stopControl();

		/* ESCAPEボタン(下)によりプログラム終了 */
		while (true) {
			if (Button.ESCAPE.isDown() == true)
				break;
		}


	}

}
