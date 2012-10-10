import lejos.nxt.*;

public class LineTracer implements Runnable
{
	/* 下記のパラメータはセンサ個体/環境に合わせてチューニングする必要があります */
	private static final int WHITE = 500; /* 白色の光センサ値 */
	private static final int BLACK = 700; /* 黒色の光センサ値 */

	private LightSensor light = new LightSensor(SensorPort.S3);
	private UltrasonicSensor sonar = new UltrasonicSensor(SensorPort.S2);
	private float forward; /* 前後進命令: -100(後進)～0(停止)～100(前進) */
	private float turn; /* 旋回命令: -100(左旋回)～100(右旋回) */
	private boolean pause; /* 一時停止 */
	private boolean available;

	public LineTracer() {
		available = true;
		forward = 0;
		turn = 0;
		pause = false;
	}

	/* ライントレース */
	public void run() {

		light.readNormalizedValue(); /* 光センサ赤色LEDをON */

		int distance;	/* cm単位 */
		int counter = 0;
		while (available == true) {

			/* 超音波センサによる距離測定周期は、超音波の減衰特性に依存します。 */
			if(++counter == 10) { /* 約40msec周期処理 */
				distance = sonar.getDistance();
				/* 障害物が30cm以内にあったらライントレース中止 */
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
				/* ライントレース */
				if ((1023 - light.readNormalizedValue()) <= (WHITE + BLACK) / 2) {
					turn = 50F; /* 右折 */
				}
				else {
					turn = -50F; /* 左折 */
				}
			}
			try {
				Thread.sleep(4); /* 約4msec周期処理 */
			} catch (InterruptedException e) {
			}
		}
	}

	/* 旋回命令取得 */
	public float getTurnCmd() {
		return turn;
	}

	/* 前後進命令取得 */
	public float getForwardCmd() {
		return forward;
	}

	/* ライントレース停止 */
	public void stopRunning() {
		available = false;
	}
}
