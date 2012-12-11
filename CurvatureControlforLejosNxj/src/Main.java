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

		/* LEFT�{�^��(��)�ɂ�胍�{�b�g��~ */
		while (true) {
			if (Button.LEFT.isDown() == true)
				break;
			try {
				Thread.sleep(200); /* ��200msec�������� */
			} catch (InterruptedException e) {
			}
		}

		curvatureControl.stopControl();

		/* ESCAPE�{�^��(��)�ɂ��v���O�����I�� */
		while (true) {
			if (Button.ESCAPE.isDown() == true)
				break;
		}

	}

}
