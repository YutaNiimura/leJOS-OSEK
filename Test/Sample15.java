import lejos.nxt.*;
public class Sample15 {

	public static void main(String[] args) {
		SoundSensor soundS2 = new SoundSensor(SensorPort.S2,true);
		UltrasonicSensor sonicS4 = new UltrasonicSensor(SensorPort.S4);

		while(true){
			int sound = soundS2.readValue();
			int distance = sonicS4.getDistance();

			LCD.clear();
			LCD.drawString("SOUND :", 0, 0);
			LCD.drawInt(sound, 10, 0);
			LCD.drawString("DISTANCE:", 0, 1);
			LCD.drawInt(distance, 0, 0);

			try{
				Thread.sleep(500);
			}catch(InterruptedException e){
			}
		}

	}

}
