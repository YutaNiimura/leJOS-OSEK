package Algorithm;

import Common.SpeedControlMethodParm;

public class PIDSpeedControlParm extends SpeedControlMethodParm {

	private float sKp;
	private float sKi;
	private float skd;

	public float getSKp() {
		return this.sKp;
	}

	public void setSKp(float parm) {
		this.sKp = parm;
	}

	public float getSKi() {
		return this.sKi;
	}

	public void setSKi(float parm) {
		this.sKi = parm;
	}

	public float getSKd() {
		return this.skd;
	}

	public void setSKd(float parm) {
		this.skd = parm;
	}

}
