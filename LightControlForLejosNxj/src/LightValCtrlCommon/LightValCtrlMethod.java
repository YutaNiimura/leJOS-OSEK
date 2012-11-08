package LightValCtrlCommon;

public abstract class LightValCtrlMethod {

	protected LightValCtrlParm lightValCtrlParm;

	public abstract int calcLightValCtrlVal(int targLightVal,int lightVal,int time);

	public abstract void initialize();

	public void setLightValControlParm(LightValCtrlParm parm){
		this.lightValCtrlParm = parm;
	}

	public LightValCtrlParm getLightValControlParm(){
		return this.lightValCtrlParm;
	}
}
