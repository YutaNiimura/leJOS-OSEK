import lejos.nxt.*;
public class LightSensorDevice {
	LightSensor lightS3 = new LightSensor(SensorPort.S3);

	public int getLightSensorVal(){
		return lightS3.getLightValue();
	}
}
