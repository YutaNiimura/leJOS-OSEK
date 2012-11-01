import lejos.nxt.Button;


public class TailControlMain extends Thread{

	public static void main(String[] args) {

		TailControl tailControl = new TailControl();

		tailControl.setTargAngle(90);

		Thread thread = new Thread(tailControl);

		thread.setPriority(MAX_PRIORITY);
		thread.start();

		tailControl.startControl();

		/* LEFTボタン(左)によりロボット停止 */
		while (true) {
			if (Button.LEFT.isDown() == true)
				break;
			try {
				Thread.sleep(200); /* 約200msec周期処理 */
			} catch (InterruptedException e) {
			}
		}

		tailControl.stopControl();

		/* ESCAPEボタン(下)によりプログラム終了 */
		while (true) {
			if (Button.ESCAPE.isDown() == true)
				break;
		}

	}

}
