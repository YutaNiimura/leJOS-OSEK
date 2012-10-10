package etrobo.nxj.balancer;

/*
 * (��) ���v���O�����́ALEGO MINDSTORMS NXT 2�֌^�|���U�q���{�b�g�uNXYway-GS�v��
 * �o�����X����v���O�����iC/C++�j ���A leJOS NXJ �����iJava�j�ɈڐA�������̂ł��B
 * �p�r�́AET���{�R���Q���A����ьl�g�p�Ɍ���܂��B <br>
 * <br>
 * date     2009/07/31<br>
 * @version 0.1 <br>
 * @author  ojima����͌n�͂˂��� by Jacom Co.,LTD. <br>
 */
//���� -----------------------------------------------------------------------
/*
 ******************************************************************************
 **	�t�@�C���� : balancer_private.h
 **
 ** ���f���֘A���:
 **   ���f����   : balancer.mdl
 **   �o�[�W���� : 1.893
 **   ����       : y_yama - Tue Sep 25 11:37:09 2007
 **                takashic - Sun Sep 28 17:50:53 2008
 **
 ** Copyright (c) 2008 CYBERNET SYSTEMS CO.,LTD.
 ** All rights reserved.
 ******************************************************************************
 **/
//-----------------------------------------------------------------------------
/**
 * �|���U�q����p�����[�^ <br>
 * (����)------------------------------------------------------------ <br>
 * �|���U�q����p�����[�^�͐�������ɑ傫�ȉe����^���܂��B <br>
 * ------------------------------------------------------------------
 */
public class BalancerParam {
	/* Imported (extern) block parameters */
	private float A_D = 0.8F; /*
							 * Variable: A_D Referenced by blocks:
							 * '<S11>/Constant1' '<S11>/Gain2'
							 * ���[�p�X�t�B���^�W��(���E�ԗւ̕��ω�]�p�x�p)
							 */
	private float A_R = 0.996F; /*
								 * Variable: A_R Referenced by blocks:
								 * '<S8>/Constant1' '<S8>/Gain2'
								 * ���[�p�X�t�B���^�W��(���E�ԗւ̖ڕW���ω�]�p�x�p)
								 */
	private float[] K_F = new float[] { -0.870303F, -31.9978F, -1.1566F,
			-2.78873F };
	/*
	 * Variable: K_F '<S1>/FeedbackGain' �T�[�{����p��ԃt�B�[�h�o�b�N�W��
	 */
	private float K_I = -0.44721F; /*
									 * Variable: K_I '<S1>/IntegralGain'
									 * �T�[�{����p�ϕ��W��
									 */
	private float K_PHIDOT = 25.0F; /*
									 * Variable: K_PHIDOT '<S3>/Gain2'
									 * �ԑ̖̂ڕW���ʉ�]���x(d��/dt)�W��
									 */
	private float K_THETADOT = 7.5F; /*
									 * Variable: K_THETADOT '<S3>/Gain1'
									 * ���E�ԗւ̕��ω�]���x(d��/dt)�W��
									 */
	private float BATTERY_GAIN = 0.001089F;/* PWM�o�͎Z�o�p�o�b�e���d���␳�W�� */
	private float BATTERY_OFFSET = 0.625F; /* PWM�o�͎Z�o�p�o�b�e���d���␳�I�t�Z�b�g */

	private float EXEC_PERIOD = 0.00400000019F; /* �o�����X������s����(�b) */

	public float getAD() {
		return A_D;
	}

	/**
	 * 
	 * @param a_d
	 *            ���[�p�X�t�B���^�W��(���E�ԗւ̕��ω�]�p�x�p)
	 */
	public void setAD(float a_d) {
		A_D = a_d;
	}

	public float getAR() {
		return A_R;
	}

	/**
	 * 
	 * @param a_r
	 *            ���[�p�X�t�B���^�W��(���E�ԗւ̖ڕW���ω�]�p�x�p)
	 */
	public void setAR(float a_r) {
		A_R = a_r;
	}

	public float[] getKF() {
		return K_F;
	}

	/**
	 * 
	 * @param k_f
	 *            �T�[�{����p��ԃt�B�[�h�o�b�N�W�� <br>
	 *            K_F[0]: �ԗ։�]�p�x�W�� K_F[1]: �ԑ̌X�Ίp�x�W�� K_F[2]: �ԗ։�]�p���x�W�� K_F[3]:
	 *            �ԑ̌X�Ίp���x�W��
	 */
	public void setKF(float[] k_f) {
		K_F = k_f;
	}

	public float getKI() {
		return K_I;
	}

	/**
	 * 
	 * @param k_i
	 *            �T�[�{����p�ϕ��W��
	 */
	public void setKI(float k_i) {
		K_I = k_i;
	}

	public float getKPhidot() {
		return K_PHIDOT;
	}

	/**
	 * 
	 * @param k_phidot
	 *            �ԑ̖̂ڕW���ʉ�]���x(d��/dt)�W��
	 */
	public void setKPhidot(float k_phidot) {
		K_PHIDOT = k_phidot;
	}

	public float getKThetadot() {
		return K_THETADOT;
	}

	/**
	 * 
	 * @param k_thetadot
	 *            ���E�ԗւ̕��ω�]���x(d��/dt)�W��
	 */
	public void setKThetadot(float k_thetadot) {
		K_THETADOT = k_thetadot;
	}

	public float getBatteryGain() {
		return BATTERY_GAIN;
	}

	/**
	 * 
	 * @param battery_gain
	 *            PWM�o�͎Z�o�p�o�b�e���d���␳�W��
	 */
	public void setBatteryGain(float battery_gain) {
		BATTERY_GAIN = battery_gain;
	}

	public float getBatteryOffset() {
		return BATTERY_OFFSET;
	}

	/**
	 * 
	 * @param battery_offset
	 *            PWM�o�͎Z�o�p�o�b�e���d���␳�I�t�Z�b�g
	 */
	public void setBatteryOffset(float battery_offset) {
		BATTERY_OFFSET = battery_offset;
	}

	public float getExecPeriod() {
		return EXEC_PERIOD;
	}

	/**
	 * (��) �{���o�����X������s������ 0.00400000019(�b)�Œ�ł����A leJOS NXJ �� nxtOSEK
	 * �ɔ�ׂď������x���x�����߁A���[�U�ύX�ΏۂƂ��Ă��܂��B �������A���̒l�̕ύX�ɂ��|������A���S���Y���ւ̉e���͖��m�F�ł��B
	 * 
	 * @param exec_period
	 *            �o�����X������s����(�b)
	 */
	public void setExecPeriod(float exec_period) {
		EXEC_PERIOD = exec_period;
	}
}
