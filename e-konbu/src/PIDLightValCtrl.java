
public class PIDLightValCtrl implements LightValCtrlMethod{
	float deviation;
	float integratedDeviation;
	float lastMeasurementTime;
	float differentialDeviation;
	float bfDeviation;

	PIDLightValCtrlParm PIDCtrlParm = new PIDLightValCtrlParm();

	public void setCtrlParm(CtrlParm parm) {
		PIDCtrlParm.setLKp(parm.Kp);
		PIDCtrlParm.setLKi(parm.Ki);
		PIDCtrlParm.setLKd(parm.Kd);
	}

	public long calcLightValCtrlVal(int targLightVal, int lightVal) {
		return 0;
	}
}
