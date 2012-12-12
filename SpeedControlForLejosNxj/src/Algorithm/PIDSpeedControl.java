package Algorithm;

import Common.SpeedControlMethod;

public class PIDSpeedControl extends SpeedControlMethod {

	private int deviation;

	private int integratedDeviation;

	private int differentialDeviation;

	private int bfDeviation;

	private int lastMeasurementTime;

	public PIDSpeedControl(){
		this.deviation = 0;
		this.integratedDeviation = 0;
		this.differentialDeviation = 0;
		this.bfDeviation = 0;
		this.lastMeasurementTime = 0;
	}

	public int calcSpeedControlVal(int targSpeed, int speed, int bfSpeed, int time) {

		int cmd_speed;

		if(targSpeed > 0)
			this.deviation = targSpeed - speed;
		else
			this.deviation = speed - targSpeed;

		this.integratedDeviation = (int) (this.integratedDeviation + (this.deviation * (time - this.lastMeasurementTime) * 0.001));

		this.differentialDeviation = (int) ((this.deviation - this.bfDeviation)/(time - this.lastMeasurementTime * 0.001));

		cmd_speed = (int)(this.deviation * ((PIDSpeedControlParm) speedControlMethodParm).getSKp() + this.integratedDeviation * ((PIDSpeedControlParm) speedControlMethodParm).getSKi()
				+ this.differentialDeviation * ((PIDSpeedControlParm) speedControlMethodParm).getSKd());

		if(cmd_speed > 100)
			cmd_speed = 100;
		else if(cmd_speed < -100)
			cmd_speed = -100;

		this.bfDeviation = this.deviation;

		this.lastMeasurementTime = time;

		return cmd_speed + bfSpeed;

	}

	public void initialize() {
		this.deviation = 0;
		this.integratedDeviation = 0;
		this.differentialDeviation = 0;
		this.bfDeviation = 0;
	}

}
