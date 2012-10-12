import lejos.nxt.*;
public class Sample05 {

	public static void main(String[] args) {

		TouchSensor touchS1 = new TouchSensor(SensorPort.S4);

		Motor.B.forward();
		Motor.C.forward();

		while(true){
			if(!touchS1.isPressed()){
				LCD.drawString("Wait", 0, 0);
			}else{
				break;
			}
		}

		LCD.drawString("Back", 0, 0);
		Motor.B.backward();
		Motor.C.backward();
		try{
			Thread.sleep(3000);
		}catch (InterruptedException e){
		}
		LCD.drawString("Stop", 0, 0);
		Motor.B.stop();
		Motor.C.stop();
		try{
			Thread.sleep(3000);
		}catch (InterruptedException e){
		}
	}
}
