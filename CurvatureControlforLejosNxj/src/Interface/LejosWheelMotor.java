package Interface;

import lejos.nxt.MotorPort;

public class LejosWheelMotor implements WheelMotor{

	public void setVal(int parm) {
		MotorPort.B.controlMotor(parm, 0);
		MotorPort.C.controlMotor(parm, 0);
	}

}
