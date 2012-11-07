package Common;

import lejos.nxt.BasicMotorPort;
import lejos.nxt.MotorPort;
import lejos.util.Stopwatch;

public class TailControl implements Runnable{

	private Stopwatch stopwatch = new Stopwatch();

	private TailMotor tailmotor;
	private TailAngle tailangle;
	private TailControlMethod tailControlMethod;

	private int controlCycle;	//��Ń^�C�}�[�N���X������

	private boolean available = false;

	public TailControl(TailAngleMeter tailAngleMeter,TailMotor tailMotor,TailControlMethod tailControlMethod,int ControlCycle){
		this.tailmotor = tailMotor;
		this.tailControlMethod = tailControlMethod;
		this.tailangle = new TailAngle(tailAngleMeter);
		this.controlCycle = ControlCycle;

		MotorPort.C.setPWMMode(BasicMotorPort.PWM_BRAKE);
		MotorPort.C.resetTachoCount();
		MotorPort.C.controlMotor(0, 0);
	}

	public void run() {
		while(this.available == true){
			doTailCtrl();
			try {
				Thread.sleep(this.controlCycle); /* ��4msec�������� */
			} catch (InterruptedException e) {
			}
		}
	}

	public void setTargAngle(int angle){
		tailangle.setTargTailAngle(angle);
	}

	public void setControlParm(TailControlParm parm){
		tailControlMethod.setTailControlParm(parm);
	}

	public TailControlParm getControlParm(){
		return tailControlMethod.getTailControlParm();
	}

	private void doTailCtrl()
	{
		tailmotor.setTailSpeed(tailControlMethod.calcTailAngleCtrlVal(tailangle.getTargTailAngle(), tailangle.getTailAngle(),stopwatch.elapsed()));
	}

	public void startControl(){
		changeMode(true);
	}

	public void stopControl(){
		changeMode(false);
		MotorPort.C.controlMotor(0, 0);
	}

	private void changeMode(boolean mode){
		this.available = mode;
	}

}
