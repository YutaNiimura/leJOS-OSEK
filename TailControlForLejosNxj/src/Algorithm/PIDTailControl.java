package Algorithm;
import Common.TailControlMethod;

public class PIDTailControl extends TailControlMethod{

	private float deviation;
	private float integratedDeviation;
	private float differentialDeviatiion;
	private float bfDeviation;
	private float lastMeasurementTime;

	PIDTailControlParm pidTailControlParm;

	public PIDTailControl(){
		this.deviation = 0;
		this.integratedDeviation = 0;
		this.differentialDeviatiion = 0;
		this.bfDeviation = 0;
		this.lastMeasurementTime = 0;
	}

	public int calcTailAngleCtrlVal(int targTailAngle,int tailAngle,int time){

		int cmd_turn;

		if(targTailAngle > 0)
			this.deviation = targTailAngle - tailAngle;
		else
			this.deviation = tailAngle - targTailAngle;

		this.integratedDeviation = (float) (this.integratedDeviation + (this.deviation * (time - this.lastMeasurementTime) * 0.001));

		this.differentialDeviatiion = (float) ((this.deviation - this.bfDeviation)/(time - this.lastMeasurementTime * 0.001));

		cmd_turn = (int)(this.deviation * ((PIDTailControlParm) tailControlParm).getTKp() + this.integratedDeviation * ((PIDTailControlParm) tailControlParm).getTKi()
				+ this.differentialDeviatiion * ((PIDTailControlParm)tailControlParm).getTKd());

		if(cmd_turn > 100)
			cmd_turn = 100;
		else if(cmd_turn < -100)
			cmd_turn = -100;

		this.bfDeviation = this.deviation;

		this.lastMeasurementTime = time;

		return cmd_turn;
	}

	public void initialize(){
		this.deviation = 0;
		this.integratedDeviation = 0;
		this.differentialDeviatiion = 0;
		this.bfDeviation = 0;
		this.lastMeasurementTime = 0;
	}

}
