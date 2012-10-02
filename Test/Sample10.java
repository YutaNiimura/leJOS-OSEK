import lejos.nxt.*;
public class Sample10 {

	public static void main(String[] args) {
		SubTask subTask = new SubTask();
		subTask.start();

		Motor motorB = new Motor(MotorPort.B);
		Motor motorC = new Motor(MotorPort.C);

		while(true){
			motorB.forward();
			motorC.stop();
			try{
				Thread.sleep(2000);
			}catch(InterruptedException e){
			}
			motorB.stop();
			motorC.forward();

			try{
				Thread.sleep(2000);
			}catch(InterruptedException e){
			}
		}
	}
}

class SubTask extends Thread{
	public void run(){
		LightSensor lightS3 = new LightSensor(SensorPort.S3);
		int lightvalue;
		while(true){
			lightvalue = lightS3.readValue();
			LCD.clear();
			LCD.drawInt(lightvalue, 0, 0);
			try{
				Thread.sleep(2000);
			}catch(InterruptedException e){
			}
		}
	}
}
