import lejos.nxt.BasicMotorPort;
import lejos.nxt.MotorPort;
import lejos.util.Stopwatch;

public class TailControl implements Runnable{

	private Stopwatch stopwatch = new Stopwatch();

	private TailMotor tailmotor = new TailMotor();
	private TailAngle tailangle = new TailAngle();
	private PIDTailControl pidTailAngleCtrl = new PIDTailControl();

	private boolean available = false;

	TailControl(){
		MotorPort.C.setPWMMode(BasicMotorPort.PWM_BRAKE);
		MotorPort.C.resetTachoCount();
		MotorPort.C.controlMotor(0, 0);
	}

	public void run() {
		while(this.available == true){
			doTailCtrl();
			try {
				Thread.sleep(4); /* ñÒ4msecé¸ä˙èàóù */
			} catch (InterruptedException e) {
			}
		}
	}

	public void setTargAngle(int angle){
		tailangle.setTargTailAngle(angle);
	}

	public void setControlParm(CtrlParm parm){
		pidTailAngleCtrl.setTailControlParm(parm);
	}

	public CtrlParm getControlParm(){
		return pidTailAngleCtrl.getTailControlParm();
	}

	private void doTailCtrl()
	{
		tailmotor.setTailSpeed(pidTailAngleCtrl.calcTailAngleCtrlVal(tailangle.getTargTailAngle(), tailangle.getTailAngle(),stopwatch.elapsed()));
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
