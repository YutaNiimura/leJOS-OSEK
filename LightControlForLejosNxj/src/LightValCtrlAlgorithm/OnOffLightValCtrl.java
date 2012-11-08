package LightValCtrlAlgorithm;

import LightValCtrlCommon.*;

public class OnOffLightValCtrl extends LightValCtrlMethod{

	public int calcLightValCtrlVal(int targLightVal, int lightVal, int time) {

		if(lightVal > targLightVal)
			return ((OnOffLightValCtrlParm)lightValCtrlParm).getOffThreshold();
		else
			return ((OnOffLightValCtrlParm)lightValCtrlParm).getOnThreshold();
	}

	public void initialize() {

	}
}
