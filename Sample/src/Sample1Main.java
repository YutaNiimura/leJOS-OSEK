
import lejos.nxt.*;

// �Q�l�� ---------------------------------------------------------------------
/*
 ******************************************************************************
 **	�t�@�C���� : sample.c
 **
 **	�T�v       : 2�֓|���U�q���C���g���[�X���{�b�g��TOPPERS/ATK(OSEK)�p�T���v���v���O����
 **
 ******************************************************************************
 **/
//-----------------------------------------------------------------------------
public class Sample1Main extends Thread {
	public static void main(String[] args) {

		TouchSensor touch = new TouchSensor(SensorPort.S1);
		while (touch.isPressed() == false)
			; /* �^�b�`�Z���T�����ҋ@ */

		/* �^�b�`�Z���T�ɂ�胍�{�b�g���s�J�n */

		Driver driver = new Driver();
		Thread thread = new Thread(driver);
		thread.setPriority(MAX_PRIORITY);
		thread.start();

		/* LEFT�{�^��(��)�ɂ�胍�{�b�g��~ */
		while (true) {
			if (Button.LEFT.isPressed() == true)
				break;
			try {
				Thread.sleep(200); /* ��200msec�������� */
			} catch (InterruptedException e) {
			}
		}
		driver.stopRunning();

		/* ESCAPE�{�^��(��)�ɂ��v���O�����I�� */
		while (true) {
			if (Button.ESCAPE.isPressed() == true)
				break;
		}
	}
}
