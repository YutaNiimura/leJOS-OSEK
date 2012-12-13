package Interface;

import lejos.nxt.MotorPort;
import Common.SpeedEncoder;

public class LejosWheelMotorEncoder implements SpeedEncoder {

	public int bf_speed;

	public LejosWheelMotorEncoder(){
		this.bf_speed = 0;
	}

	public int getSpeed() {
		double coeff = 1000.0 / (360 * 4);

		int cnt = (int)((MotorPort.B.getTachoCount() + MotorPort.C.getTachoCount())/2);

		int hensa = cnt - this.bf_speed;

		this.bf_speed = cnt;

		return (int)coeff * hensa;

	}

}
