package Algorithm;

import Common.SpeedControlMethodParm;

public class PIDSpeedControlParm extends SpeedControlMethodParm {

	private double sKp;
	private double sKi;
	private double skd;

	public PIDSpeedControlParm(){
		this.sKp = 10.25;
		this.sKi = 0;
		this.skd = 0;
	}

	public double getSKp() {
		return this.sKp;
	}

	public void setSKp(double parm) {
		this.sKp = parm;
	}

	public double getSKi() {
		return this.sKi;
	}

	public void setSKi(double parm) {
		this.sKi = parm;
	}

	public double getSKd() {
		return this.skd;
	}

	public void setSKd(double parm) {
		this.skd = parm;
	}

}
