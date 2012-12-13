package algorithm;
import algorithm.PIDCurvatureMethodParm;
import Common.CurvatureControlMethod;

public class PIDCurvatureCtrl extends CurvatureControlMethod{

	private float deviation;
	private float integratedDeviation;
	private float differentialDeviatiion;
	private float bfDeviation;
	private float lastMeasurementTime;

	public PIDCurvatureCtrl(){
		this.deviation = 0;
		this.integratedDeviation = 0;
		this.differentialDeviatiion = 0;
		this.bfDeviation = 0;
		this.lastMeasurementTime = 0;
	}

	public int calcCurvatureCtrlVal(float targCurvature, float curvature,int time) {

		int cmd_turn;

		if(targCurvature > 0)
			this.deviation = targCurvature - curvature;
		else
			this.deviation = curvature - targCurvature;

		this.integratedDeviation = (float) (this.integratedDeviation + (this.deviation * (time - this.lastMeasurementTime) * 0.001));

		this.differentialDeviatiion = (float) ((this.deviation - this.bfDeviation)/(time - this.lastMeasurementTime * 0.001));

		cmd_turn = (int)(this.deviation * ((PIDCurvatureMethodParm)curvatureControlMethodParm).getCKp() + this.integratedDeviation * ((PIDCurvatureMethodParm)curvatureControlMethodParm).getCKi()
				+ this.differentialDeviatiion * ((PIDCurvatureMethodParm)curvatureControlMethodParm).getCKd());

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
		this.differentialDeviatiion = 0;
		this.bfDeviation = 0;
		this.lastMeasurementTime = 0;
	}

}
