import algorithm.*;
import Common.*;
import Interface.*;
import lejos.nxt.Button;

public class Main extends Thread{

	public static void main(String[] args) {

		LejosMotorEncoder motorEncoder = new Interface.LejosMotorEncoder();
		LejosWheelMotor wheelMotor = new Interface.LejosWheelMotor();
		PIDCurvatureMethodParm PIDCurvatureControlParm = new algorithm.PIDCurvatureMethodParm();
		PIDCurvatureCtrl PIDCurvatureControl = new algorithm.PIDCurvatureCtrl();

		PIDCurvatureControl.setCurvatureCtrlParm(PIDCurvatureControlParm);

		CurvatureControl curvatureControl = new CurvatureControl(motorEncoder,wheelMotor,PIDCurvatureControl,4);

		curvatureControl.setTargCurvature(0);

		Thread thread = new Thread(curvatureControl);

		thread.setPriority(MAX_PRIORITY);

		thread.start();

		curvatureControl.startControl();

		/* LEFTボタン(左)によりロボット停止 */
		while (true) {
			if (Button.LEFT.isDown() == true)
				break;
			try {
				Thread.sleep(200); /* 約200msec周期処理 */
			} catch (InterruptedException e) {
			}
		}

		curvatureControl.stopControl();

		/* ESCAPEボタン(下)によりプログラム終了 */
		while (true) {
			if (Button.ESCAPE.isDown() == true)
				break;
		}

	}

}
