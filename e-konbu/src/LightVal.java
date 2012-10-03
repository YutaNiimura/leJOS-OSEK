public class LightVal {
	int targLightVal;

	LightSensorDevice LightSensor = new LightSensorDevice();

	public int getLightVal(){
		return LightSensor.getLightSensorVal();
	}

	public int getTargLightVal(){
		return this.targLightVal;
	}

	public void setTargLightVal(int targLightVal){
		this.targLightVal = targLightVal;
	}
}
