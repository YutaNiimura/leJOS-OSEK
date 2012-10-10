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
 **	�t�@�C���� : balancer.h
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
 * NXTway-GS�o�����X����
 */
abstract class BasicBalancer {

	protected static final float CMD_MAX = 100.0F; /* �O�i/���񖽗ߐ�΍ő�l */
	protected static final float DEG2RAD = 0.01745329238F; /* �p�x�P�ʕϊ��W��(=pi/180) */

	// protected static final float EXEC_PERIOD = 0.00400000019F; /*
	// �o�����X������s����(�b) */

	/* left motor PWM output */
	abstract public int getPwmL();

	/* right motor PWM output */
	abstract public int getPwmR();

	/* Model entry point functions */
	abstract public void init();

	/* Customized model step function */
	abstract public void control(float args_cmd_forward, float args_cmd_turn,
			float args_gyro, float args_gyro_offset, float args_theta_m_l,
			float args_theta_m_r, float args_battery);
}
