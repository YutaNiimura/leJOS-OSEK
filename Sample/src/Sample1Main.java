
import lejos.nxt.*;

// 参考元 ---------------------------------------------------------------------
/*
 ******************************************************************************
 **	ファイル名 : sample.c
 **
 **	概要       : 2輪倒立振子ライントレースロボットのTOPPERS/ATK(OSEK)用サンプルプログラム
 **
 ******************************************************************************
 **/
//-----------------------------------------------------------------------------
public class Sample1Main extends Thread {
	public static void main(String[] args) {

		TouchSensor touch = new TouchSensor(SensorPort.S1);
		while (touch.isPressed() == false)
			; /* タッチセンサ押下待機 */

		/* タッチセンサによりロボット走行開始 */

		Driver driver = new Driver();
		Thread thread = new Thread(driver);
		thread.setPriority(MAX_PRIORITY);
		thread.start();

		/* LEFTボタン(左)によりロボット停止 */
		while (true) {
			if (Button.LEFT.isPressed() == true)
				break;
			try {
				Thread.sleep(200); /* 約200msec周期処理 */
			} catch (InterruptedException e) {
			}
		}
		driver.stopRunning();

		/* ESCAPEボタン(下)によりプログラム終了 */
		while (true) {
			if (Button.ESCAPE.isPressed() == true)
				break;
		}
	}
}
