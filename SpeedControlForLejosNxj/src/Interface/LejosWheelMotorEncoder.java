package Interface;

import lejos.nxt.MotorPort;
import Common.SpeedEncoder;

public class LejosWheelMotorEncoder implements SpeedEncoder {

	public int getSpeed() {
		return MotorPort.B.getTachoCount();
	}

}
