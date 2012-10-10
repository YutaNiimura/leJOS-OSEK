import lejos.nxt.*;
import lejos.nxt.addon.*;

public class Gyro
{
	/* 下記のパラメータはセンサ個体/環境に合わせてチューニングする必要があります */
	/* ジャイロセンサオフセット値(角速度0[deg/sec]時) */
	// private static final float GYRO_OFFSET = 610F;
	private static final float GYRO_OFFSET = 589F;

	private GyroSensor gyro = new GyroSensor(SensorPort.S4);
	private float offset;

	public Gyro() {
		offset = GYRO_OFFSET;
	}

	/* ジャイロセンサ値取得 */
	public float readValue() {
		return gyro.readValue() + 600F;
	}

	/* ジャイロセンサオフセット値取得 */
	public float getOffset() {
		return offset;
	}
}