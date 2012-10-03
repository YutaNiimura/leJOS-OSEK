
public class OnOffLightValCtrlParm implements LightValCtrlParm{
	int onThreshold;
	int offThreshold;

	public float getOnThreshold(){
		return this.onThreshold;
	}

	public void setOnThreshold(int parm){
		this.onThreshold = parm;
	}

	public float getOffThreshold(){
		return this.offThreshold;
	}

	public void setOffThreshold(int parm){
		this.offThreshold = parm;
	}
}
