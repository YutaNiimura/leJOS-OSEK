package LightValCtrlCommon;

public class LightVal {

	private int targLightVal;

	private LightValEncoder lightSensor;

	public LightVal(LightValEncoder lightSensor){
		this.lightSensor = lightSensor;
	}

	public int getLightVal(){
		return lightSensor.getLightVal();
	}

	public int getTargLightVal(){
		return this.targLightVal;
	}

	public void setTargLightVal(int targLightVal){
		this.targLightVal = targLightVal;
	}

}
