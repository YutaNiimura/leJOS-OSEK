import lejos.nxt.*;
public class TailAngleEncoder {

	TailAngleEncoder(){

	}

	public int getTargAngle(){
		return MotorPort.C.getTachoCount();
	}
}
