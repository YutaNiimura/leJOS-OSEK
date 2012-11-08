package LightValCtrlLejosNxj;

import lejos.nxt.MotorPort;
import LightValCtrlCommon.*;

public class LejosWheelMotor implements LightValCtrlMotor{

	public void setLMotorSpeed(int parm) {
		MotorPort.B.controlMotor(parm, 1);
	}

	public void setRMotorSpeed(int parm){
		MotorPort.C.controlMotor(parm, 1);
	}

}
