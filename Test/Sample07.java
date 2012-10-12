import lejos.nxt.*;
public class Sample07 {

	public static void main(String[] args) {

		LightSensor lightS3 = new LightSensor(SensorPort.S3);

		Motor.B.forward();
		Motor.C.forward();

		while(true){
			if(lightS3.readValue() >= 35){
				LCD.drawString("Wait", 0, 0);
			}else{
				break;
			}
		}

		LCD.drawString("Stop", 0, 0);
		Motor.B.stop();
		Motor.C.stop();
	}
}
