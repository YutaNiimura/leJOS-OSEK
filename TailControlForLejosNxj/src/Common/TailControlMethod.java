package Common;

public abstract class TailControlMethod {

	protected TailControlParm tailControlParm;

	public void setTailControlParm(TailControlParm parm){
		this.tailControlParm = parm;
	}

	public TailControlParm getTailControlParm(){
		return this.tailControlParm;
	}

	public abstract int calcTailAngleCtrlVal(int targTailAngle,int tailAngle,int time);
	public abstract void initialize();

}
