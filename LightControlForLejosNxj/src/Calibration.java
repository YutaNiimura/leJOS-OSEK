import lejos.nxt.*;


public class Calibration {

	private LightSensor lightSensor = new LightSensor(SensorPort.S3);
	private TouchSensor touchSensor = new TouchSensor(SensorPort.S4);

	public int calibration(){
		int value;
		int black,white;

		while(true){
			if(touchSensor.isPressed()==true)
			{
				black = lightSensor.getNormalizedLightValue();
				try {
					Sound.beep();
					Thread.sleep(500);
					break;
				} catch (InterruptedException e) {
					// TODO �����������ꂽ catch �u���b�N
					e.printStackTrace();
				}
			}
		}

		while(true){
			if(touchSensor.isPressed()==true)
			{
				white = lightSensor.getNormalizedLightValue();
				try {
					Sound.beep();
					Thread.sleep(500);
					break;
				} catch (InterruptedException e) {
					// TODO �����������ꂽ catch �u���b�N
					e.printStackTrace();
				}
			}
		}

		value = (black+white)/2;

		return value;
	}
}
