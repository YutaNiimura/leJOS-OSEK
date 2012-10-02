import lejos.nxt.*;
public class Sample05 {

	public static void main(String[] args) {
		Motor motorB = new Motor(MotorPort.B);
		Motor motorC = new Motor(MotorPort.C);
		TouchSensor touchS1 = new TouchSensor(SensorPort.S4);

		motorB.forward();
		motorC.forward();

		while(true){
			if(!touchS1.isPressed()){
				LCD.drawString("Wait", 0, 0);
			}else{
				break;
			}
		}

		LCD.drawString("Back", 0, 0);
		motorB.backward();
		motorC.backward();
		try{
			Thread.sleep(3000);
		}catch (InterruptedException e){
		}
		LCD.drawString("Stop", 0, 0);
		motorB.stop();
		motorC.stop();
		try{
			Thread.sleep(3000);
		}catch (InterruptedException e){
		}
	}
}
