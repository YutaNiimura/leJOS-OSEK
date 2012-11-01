import lejos.nxt.*;

public class TailMotor {

	TailMotor(){

	}

	public void setTailSpeed(int parm){
		MotorPort.C.controlMotor(parm, 1);
	}
}
