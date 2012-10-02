import lejos.nxt.*;


public class Sample06 {

	public static void main(String[] args) {
		LightSensor lightS3 = new LightSensor(SensorPort.S3);
		while(true){
			int lightvalue = lightS3.readValue();

			LCD.drawInt(lightvalue, 0, 0);

			try{
				Thread.sleep(100);
			}catch(InterruptedException e){
			}
		}
	}
}
