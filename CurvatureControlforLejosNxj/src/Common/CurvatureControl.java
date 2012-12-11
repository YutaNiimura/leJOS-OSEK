package Common;

import lejos.util.Stopwatch;
import Interface.MotorEncoder;
import Interface.WheelMotor;


public class CurvatureControl implements Runnable{

	private Stopwatch stopwatch= new Stopwatch();

	private Curvature curvature;

	private WheelMotor wheelMotor;
	private CurvatureControlMethod curvatureControlMethod;
	private int controlCycle;

	private Boolean available = false;

	public CurvatureControl(MotorEncoder curvatureEncoder,WheelMotor wheelMotor,
			CurvatureControlMethod curvatureControlMethod,int controlCycle){
		this.wheelMotor = wheelMotor;
		this.curvatureControlMethod = curvatureControlMethod;
		this.controlCycle = controlCycle;
		this.curvature = new Curvature(curvatureEncoder);
	}

	public void setTargCurvature(float parm){
		this.curvature.setTargCurvature(parm);
	}

	public float getTargCurvature(){
		return this.curvature.getTargCurvature();
	}

	public void setControlParm(CurvatureControlMethodParm parm){
		this.curvatureControlMethod.setCurvatureCtrlParm(parm);
	}

	public CurvatureControlMethodParm getControlParm(){
		return this.curvatureControlMethod.getCurvatureCtrlParm();
	}

	public void startControl(){
		changeMode(true);
	}

	public void stopControl(){
		changeMode(false);
	}

	public void run() {
		while(this.available == true){
			doCurvatureControl();
			try {
				Thread.sleep(this.controlCycle); /* ñÒ4msecé¸ä˙èàóù */
			} catch (InterruptedException e) {
			}
		}
	}

	private void doCurvatureControl(){
		wheelMotor.setVal((int)this.curvatureControlMethod.calcCurvatureCtrlVal
				(this.curvature.getTargCurvature(), this.curvature.getCurvature(), stopwatch.elapsed()));
	}

	private void changeMode(Boolean mode){
		this.available = mode;
	}

}
