package LightValCtrlCommon;

import lejos.nxt.BasicMotorPort;
import lejos.nxt.MotorPort;
import lejos.util.Stopwatch;

public class LightValCtrl implements Runnable{

	private Stopwatch stopwatch = new Stopwatch();
	private LightValCtrlMotor lightValCtrlMotor;
	private LightVal lightVal;
	private LightValCtrlMethod lightValCtrlMethod;

	private int controlCycle;

	private int speed;

	private boolean available;

	public LightValCtrl(LightValEncoder lightSensor,LightValCtrlMotor lightValCtrlMotor,LightValCtrlMethod lightValCtrlMethod,int time){
		this.lightValCtrlMotor = lightValCtrlMotor;
		this.lightValCtrlMethod = lightValCtrlMethod;
		this.lightVal = new LightVal(lightSensor);
		this.controlCycle = time;

		this.available = false;
		this.speed = 0;

		MotorPort.B.setPWMMode(BasicMotorPort.PWM_BRAKE);
		MotorPort.B.resetTachoCount();
		MotorPort.B.controlMotor(0, 0);

		MotorPort.C.setPWMMode(BasicMotorPort.PWM_BRAKE);
		MotorPort.C.resetTachoCount();
		MotorPort.C.controlMotor(0, 0);
	}

	public void run(){
		while(this.available == true){
			doControl();
			try {
				Thread.sleep(this.controlCycle); /* ñÒ4msecé¸ä˙èàóù */
			} catch (InterruptedException e) {
			}
		}
	}

	public void setTargLightVal(int targLightVal){
		lightVal.setTargLightVal(targLightVal);
	}

	public int getTargLightVal(){
		return lightVal.getLightVal();
	}

	public void setControlParm(LightValCtrlParm parm){
		lightValCtrlMethod.setLightValControlParm(parm);
	}

	public LightValCtrlParm getControlParm(){
		return lightValCtrlMethod.getLightValControlParm();
	}

	public void startControl(){
		changeMode(true);
	}

	public void stopControl(){
		changeMode(false);
	}

	private void doControl(){
		lightValCtrlMotor.setLMotorSpeed(this.speed + lightValCtrlMethod.calcLightValCtrlVal(lightVal.getTargLightVal(), lightVal.getLightVal(), stopwatch.elapsed()));
		lightValCtrlMotor.setRMotorSpeed(this.speed - lightValCtrlMethod.calcLightValCtrlVal(lightVal.getTargLightVal(), lightVal.getLightVal(), stopwatch.elapsed()));
	}

	private void changeMode(boolean mode){
		this.available = mode;
	}
}
