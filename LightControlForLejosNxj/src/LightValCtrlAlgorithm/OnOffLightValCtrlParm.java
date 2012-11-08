package LightValCtrlAlgorithm;

import LightValCtrlCommon.*;

public class OnOffLightValCtrlParm extends LightValCtrlParm{
	private int onThreshold;
	private int offThreshold;

	public OnOffLightValCtrlParm(){
		this.offThreshold = -100;
		this.onThreshold = 100;
	}

	public int getOnThreshold(){
		return this.onThreshold;
	}

	public void setOnThreshold(int parm){
		this.onThreshold = parm;
	}

	public int getOffThreshold(){
		return this.offThreshold;
	}

	public void setOffThreshold(int parm){
		this.offThreshold = parm;
	}
}
