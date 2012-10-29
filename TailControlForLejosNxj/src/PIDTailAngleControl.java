import lejos.nxt.*;
public class PIDTailAngleControl {

	private PIDTailAngleControlParm pidtailanglectrlparm = new PIDTailAngleControlParm();

	private float deviation;
	private float integratedDeviation;
	private float differentialDeviatiion;
	private float bfDeviation;
	private float lastMeasurementTime;

	PIDTailAngleControl(){
		this.deviation = 0;
		this.integratedDeviation = 0;
		this.differentialDeviatiion = 0;
		this.bfDeviation = 0;
		this.lastMeasurementTime = 0;
	}

	public int calcTailAngleCtrlVal(int targTailAngle,int tailAngle){
		return 0;
	}

	public void setTailAngleCtrlParm(PIDCtrlParm parm){
		pidtailanglectrlparm.setTKp(parm.Kp);
		pidtailanglectrlparm.setTKi(parm.Ki);
		pidtailanglectrlparm.setTKd(parm.Kd);
	}

	public PIDCtrlParm getPIDTailAngleCtrlParm(){
		PIDCtrlParm parm = new PIDCtrlParm();
		parm.Kp = pidtailanglectrlparm.getTKp();
		parm.Ki = pidtailanglectrlparm.getTKi();
		parm.Kd = pidtailanglectrlparm.getTKd();
		return parm;
	}
}
