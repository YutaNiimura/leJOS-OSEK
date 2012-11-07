package Lejosnxj;

import Common.TailMotor;
import lejos.nxt.MotorPort;

public class LejosTailMotor implements TailMotor{

	public void setTailSpeed(int parm){
		MotorPort.C.controlMotor(parm, 1);
	}
}
