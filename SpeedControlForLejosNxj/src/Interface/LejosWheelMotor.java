package Interface;

import lejos.nxt.MotorPort;
import Common.SpeedControlMotor;

public class LejosWheelMotor implements SpeedControlMotor {

	public void setParm(int parm) {
		MotorPort.B.controlMotor(parm, 0);
		MotorPort.C.controlMotor(parm, 0);
	}

}
