package etrobo.sample2010;

import lejos.nxt.*;
import lejos.nxt.addon.*;

public class Gyro
{
	/* ���L�̃p�����[�^�̓Z���T��/���ɍ��킹�ă`���[�j���O����K�v������܂� */
	/* �W���C���Z���T�I�t�Z�b�g�l(�p���x0[deg/sec]��) */
//	private static float GYRO_OFFSET = 610F;
	private static float GYRO_OFFSET = 589F;

	private GyroSensor gyro = new GyroSensor(SensorPort.S1);
	private float offset;

	public Gyro() {
		offset = GYRO_OFFSET;
	}

	/* �W���C���Z���T�l�擾 */
	public float readValue() {
		return gyro.readValue();// + 600F;
	}

	/* �W���C���Z���T�I�t�Z�b�g�l�擾 */
	public float getOffset() {
		return offset;
	}


	//�����ǂ�����H
	public static void setOffset(float value){
		GYRO_OFFSET = value;
	}
}