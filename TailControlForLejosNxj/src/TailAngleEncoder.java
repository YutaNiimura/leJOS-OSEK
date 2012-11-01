import lejos.nxt.*;
public class TailAngleEncoder {

	TailAngleEncoder(){

	}

	public int getTailAngle(){
		return MotorPort.C.getTachoCount();
	}
}
