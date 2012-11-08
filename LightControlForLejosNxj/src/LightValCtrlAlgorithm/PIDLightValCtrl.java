package LightValCtrlAlgorithm;

import LightValCtrlAlgorithm.PIDLightValCtrlParm;
import LightValCtrlCommon.*;

public class PIDLightValCtrl extends LightValCtrlMethod{

	private float deviation;
	private float integratedDeviation;
	private float differentialDeviation;
	private float lastMeasurementTime;
	private float bfDeviation;

	public int calcLightValCtrlVal(int targLightVal, int lightVal, int time) {

		int cmd_turn;

		if(targLightVal > 0)
			this.deviation = targLightVal - lightVal;
		else
			this.deviation = lightVal - targLightVal;

		this.integratedDeviation = (float) (this.integratedDeviation + (this.deviation * (time - this.lastMeasurementTime) * 0.001));

		this.differentialDeviation = (float) ((this.deviation - this.bfDeviation)/(time - this.lastMeasurementTime * 0.001));

		cmd_turn = (int)(this.deviation * ((PIDLightValCtrlParm) lightValCtrlParm).getLKp() + this.integratedDeviation * ((PIDLightValCtrlParm) lightValCtrlParm).getLKi()
				+ this.differentialDeviation * ((PIDLightValCtrlParm)lightValCtrlParm).getLKd());

		if(cmd_turn > 100)
			cmd_turn = 100;
		else if(cmd_turn < -100)
			cmd_turn = -100;

		this.bfDeviation = this.deviation;

		this.lastMeasurementTime = time;

		return cmd_turn;
	}

	public void initialize() {
		this.deviation = 0;
		this.integratedDeviation = 0;
		this.differentialDeviation = 0;
		this.lastMeasurementTime = 0;
		this.bfDeviation = 0;
	}
}
