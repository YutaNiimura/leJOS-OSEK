
public class OnOffLightValCtrl implements LightValCtrlMethod{

	OnOffLightValCtrlParm OnOffCtrlParm = new OnOffLightValCtrlParm();

	public void setCtrlParm(CtrlParm parm) {
		OnOffCtrlParm.setOnThreshold(parm.onThreshold);
		OnOffCtrlParm.setOffThreshold(parm.offThreshold);
	}

	public long calcLightValCtrlVal(int targLightVal, int lightVal) {
		return 0;
	}

}
