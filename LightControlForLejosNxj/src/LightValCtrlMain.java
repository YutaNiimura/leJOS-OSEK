import java.io.File;

import lejos.nxt.Button;
import lejos.nxt.SensorPort;
import lejos.nxt.Sound;
import lejos.nxt.TouchSensor;
import LightValCtrlAlgorithm.*;
import LightValCtrlCommon.*;
import LightValCtrlLejosNxj.*;


public class LightValCtrlMain extends Thread{

	static final String WAV_FILE_NAME = "Trumpet.wav";
	static final int ControlCycle = 4;

	public static void main(String[] args) {
		LejosLightSensor lejosLightValSensor = new LejosLightSensor();
		LejosWheelMotor lejosWheelMotor = new LejosWheelMotor();
		PIDLightValCtrlParm pidLightValCtrlParm = new PIDLightValCtrlParm();
		PIDLightValCtrl pidLightValCtrl = new PIDLightValCtrl();
		OnOffLightValCtrlParm onOffLightValCtrlParm = new OnOffLightValCtrlParm();
		OnOffLightValCtrl onOffLightValCtrl = new OnOffLightValCtrl();

		TouchSensor touchSensor = new TouchSensor(SensorPort.S4);

		Calibration calibration = new Calibration();

		pidLightValCtrl.setLightValControlParm(pidLightValCtrlParm);
		onOffLightValCtrl.setLightValControlParm(onOffLightValCtrlParm);

		LightValCtrl lightValCtrl = new LightValCtrl(lejosLightValSensor,lejosWheelMotor,pidLightValCtrl,ControlCycle);

		lightValCtrl.setTargLightVal(calibration.calibration());

		Thread thread = new Thread(lightValCtrl);

		thread.setPriority(MAX_PRIORITY);

		while(true){
			if(touchSensor.isPressed()==true){

				try {
					Thread.sleep(Sound.playSample(new File(WAV_FILE_NAME)));
					break;
				} catch (InterruptedException e) {
					// TODO �����������ꂽ catch �u���b�N
					e.printStackTrace();
				}

			}
		}

		thread.start();

		lightValCtrl.startControl();

		/* LEFT�{�^��(��)�ɂ�胍�{�b�g��~ */
		while (true) {
			if (Button.LEFT.isDown() == true)
				break;
			try {
				Thread.sleep(200); /* ��200msec�������� */
			} catch (InterruptedException e) {
			}
		}

		lightValCtrl.stopControl();

		/* ESCAPE�{�^��(��)�ɂ��v���O�����I�� */
		while (true) {
			if (Button.ESCAPE.isDown() == true)
				break;
		}


	}

}
