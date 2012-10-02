import lejos.nxt.*;
public class Sample07 {

	public static void main(String[] args) {
		Motor motorB = new Motor(MotorPort.B);
		Motor motorC = new Motor(MotorPort.C);
		LightSensor lightS3 = new LightSensor(SensorPort.S3);

		motorB.forward();
		motorC.forward();

		while(true){
			if(lightS3.readValue() >= 35){
				LCD.drawString("Wait", 0, 0);
			}else{
				break;
			}
		}

		LCD.drawString("Stop", 0, 0);
		motorB.stop();
		motorC.stop();
	}
}
