package Interface;

import lejos.nxt.MotorPort;

public class LejosMotorEncoder implements MotorEncoder{

	public int getLCount() {
		return MotorPort.B.getTachoCount();
	}

	public int getRCount(){
		return MotorPort.C.getTachoCount();
	}

}
