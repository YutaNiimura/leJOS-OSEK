package Common;

public abstract class TailControlMethod {

	protected TailControlMethodParm tailControlParm;

	public void setTailControlParm(TailControlMethodParm parm){
		this.tailControlParm = parm;
	}

	public TailControlMethodParm getTailControlParm(){
		return this.tailControlParm;
	}

	public abstract int calcTailAngleCtrlVal(int targTailAngle,int tailAngle,int time);
	public abstract void initialize();

}
