import lejos.nxt.*;
public class Sample14 {

	public static void main(String[] args) {
		TouchSensor touchS4 = new TouchSensor(SensorPort.S4);

		while(true){
			LCD.clear();

			if(touchS4.isPressed()){
				LCD.drawString("TOUCH:ON", 1, 1);
			}else{
				LCD.drawString("TOUCH:OFF", 1, 1);
			}
			try{
				Thread.sleep(500);
			}catch(InterruptedException e){
			}
		}
	}
}
