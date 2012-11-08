package Lejosnxj;

import Common.TailAngleMeter;
import lejos.nxt.MotorPort;

public class LejosTailAngleMeter implements TailAngleMeter{
	public int getTailAngle(){
		return MotorPort.A.getTachoCount();
	}
}
