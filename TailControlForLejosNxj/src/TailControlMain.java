import lejos.nxt.Button;


public class TailControlMain extends Thread{

	public static void main(String[] args) {

		TailControl tailControl = new TailControl();

		tailControl.setTargAngle(90);

		Thread thread = new Thread(tailControl);

		thread.setPriority(MAX_PRIORITY);
		thread.start();

		tailControl.startControl();

		/* LEFT�{�^��(��)�ɂ�胍�{�b�g��~ */
		while (true) {
			if (Button.LEFT.isDown() == true)
				break;
			try {
				Thread.sleep(200); /* ��200msec�������� */
			} catch (InterruptedException e) {
			}
		}

		tailControl.stopControl();

		/* ESCAPE�{�^��(��)�ɂ��v���O�����I�� */
		while (true) {
			if (Button.ESCAPE.isDown() == true)
				break;
		}

	}

}
