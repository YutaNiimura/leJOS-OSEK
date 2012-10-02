import lejos.nxt.*;
public class Sample13 {

	public static void main(String[] args) {
		LightSensor lightS3 = new LightSensor(SensorPort.S3);

		while(true){
			LCD.clear();
			int lightvalue = lightS3.readValue();
			LCD.drawInt(lightvalue, 0, 0);

			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
			}
		}
	}
}
