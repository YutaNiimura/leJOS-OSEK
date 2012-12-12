package Common;

public abstract class SpeedControlMethod {

	protected SpeedControlMethodParm speedControlMethodParm;

	public abstract int calcSpeedControlVal(int targSpeed, int speed, int bfSpeed, int time);

	public abstract void initialize();

	public void setSpeedControlParm(SpeedControlMethodParm parm) {
		this.speedControlMethodParm = parm;
	}

	public SpeedControlMethodParm getSpeedControlParm() {
		return this.speedControlMethodParm;
	}

}
