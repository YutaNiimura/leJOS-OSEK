package LightValCtrlLejosNxj;

import LightValCtrlCommon.LightValEncoder;
import lejos.nxt.*;

public class LejosLightSensor implements LightValEncoder{

	private LightSensor lightSensor = new LightSensor(SensorPort.S3);
	public LejosLightSensor(){
		lightSensor.readNormalizedValue(); /* ���Z���T�ԐFLED��ON */
	}

	public int getLightVal() {
		return lightSensor.getNormalizedLightValue();
	}

}
