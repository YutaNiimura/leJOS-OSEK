import lejos.nxt.*;

public class LineTracer implements Runnable
{
	/* ���L�̃p�����[�^�̓Z���T��/���ɍ��킹�ă`���[�j���O����K�v������܂� */
	private static final int WHITE = 500; /* ���F�̌��Z���T�l */
	private static final int BLACK = 700; /* ���F�̌��Z���T�l */

	private LightSensor light = new LightSensor(SensorPort.S3);
	private UltrasonicSensor sonar = new UltrasonicSensor(SensorPort.S2);
	private float forward; /* �O��i����: -100(��i)�`0(��~)�`100(�O�i) */
	private float turn; /* ���񖽗�: -100(������)�`100(�E����) */
	private boolean pause; /* �ꎞ��~ */
	private boolean available;

	public LineTracer() {
		available = true;
		forward = 0;
		turn = 0;
		pause = false;
	}

	/* ���C���g���[�X */
	public void run() {

		light.readNormalizedValue(); /* ���Z���T�ԐFLED��ON */

		int distance;	/* cm�P�� */
		int counter = 0;
		while (available == true) {

			/* �����g�Z���T�ɂ�鋗����������́A�����g�̌��������Ɉˑ����܂��B */
			if(++counter == 10) { /* ��40msec�������� */
				distance = sonar.getDistance();
				/* ��Q����30cm�ȓ��ɂ������烉�C���g���[�X���~ */
				if(distance < 30) {
					forward = 0;
					pause = true;
				}
				else {
					forward = 50;
					pause = false;
				}
				counter=0;
			}

			if(pause == true) {
				turn = 0;
			}
			else {
				/* ���C���g���[�X */
				if ((1023 - light.readNormalizedValue()) <= (WHITE + BLACK) / 2) {
					turn = 50F; /* �E�� */
				}
				else {
					turn = -50F; /* ���� */
				}
			}
			try {
				Thread.sleep(4); /* ��4msec�������� */
			} catch (InterruptedException e) {
			}
		}
	}

	/* ���񖽗ߎ擾 */
	public float getTurnCmd() {
		return turn;
	}

	/* �O��i���ߎ擾 */
	public float getForwardCmd() {
		return forward;
	}

	/* ���C���g���[�X��~ */
	public void stopRunning() {
		available = false;
	}
}
