
public abstract class TailControlMethod {

	PIDTailControlParm tailControlParm = new PIDTailControlParm();

	public void setTailControlParm(CtrlParm parm){
		tailControlParm.setTKp(parm.Kp);
		tailControlParm.setTKp(parm.Ki);
		tailControlParm.setTKd(parm.Kd);
	}

	public CtrlParm getTailControlParm(){
		CtrlParm parm = new CtrlParm();

		parm.Kp = tailControlParm.getTKp();
		parm.Ki = tailControlParm.getTKi();
		parm.Kd = tailControlParm.getTKd();

		return parm;
	}

	public abstract int calcTailAngleCtrlVal(int targTailAngle,int tailAngle,int time);
	public abstract void initialize();
}
