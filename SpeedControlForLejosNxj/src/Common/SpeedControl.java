package Common;

import lejos.nxt.BasicMotorPort;
import lejos.nxt.MotorPort;
import lejos.util.*;;

public class SpeedControl implements Runnable {

	private Stopwatch stopwatch;

	private SpeedControlMethod speedControlMethod;

	private Speed speed;

	private SpeedControlMotor speedControlMotor;

	private int cycleTime;

	private boolean available;

	public SpeedControl(SpeedEncoder speedEncoder, SpeedControlMotor speedControlMotor, SpeedControlMethod speedControlMethod, int cycleTime) {
		this.speedControlMotor = speedControlMotor;
		this.speedControlMethod = speedControlMethod;
		this.cycleTime = cycleTime;
		this.speed = new Speed(speedEncoder);
		this.available = false;

		MotorPort.B.setPWMMode(BasicMotorPort.PWM_BRAKE);
		MotorPort.B.resetTachoCount();
		MotorPort.B.controlMotor(0, 0);

		MotorPort.C.setPWMMode(BasicMotorPort.PWM_BRAKE);
		MotorPort.C.resetTachoCount();
		MotorPort.C.controlMotor(0, 0);
	}

	public void setTargSpeed(int parm) {
		this.speed.setTargSpeed(parm);
	}

	public int getTargSpeed() {
		return this.speed.getTargSpeed();
	}

	public void setControlParm(SpeedControlMethodParm parm) {
		this.speedControlMethod.setSpeedControlParm(parm);
	}

	public SpeedControlMethodParm getControlParm() {
		return this.speedControlMethod.getSpeedControlParm();
	}

	public void startControl() {
		changeMode(true);
	}

	public void stopControl() {
		changeMode(false);
		MotorPort.B.setPWMMode(BasicMotorPort.PWM_BRAKE);
		MotorPort.B.resetTachoCount();
		MotorPort.B.controlMotor(0, 0);

		MotorPort.C.setPWMMode(BasicMotorPort.PWM_BRAKE);
		MotorPort.C.resetTachoCount();
		MotorPort.C.controlMotor(0, 0);
	}

	public void run() {
		while(this.available == true){
			doSpeedControl();
			try {
				Thread.sleep(this.cycleTime); /* ñÒ4msecé¸ä˙èàóù */
			} catch (InterruptedException e) {
			}
		}
	}

	private void doSpeedControl() {
		this.speedControlMotor.setParm(this.speedControlMethod.calcSpeedControlVal(this.speed.getTargSpeed(), this.speed.getSpeed(),
				this.speed.getbfSpeed(), this.stopwatch.elapsed()));
	}

	private void changeMode(boolean mode) {
		this.available = mode;
	}

}
