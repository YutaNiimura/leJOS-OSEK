/*
 * (注) 当プログラムは、LEGO MINDSTORMS NXT 2輪型倒立振子ロボット「NXYway-GS」の
 * バランス制御プログラム（C/C++） を、 leJOS NXJ 向け（Java）に移植したものです。
 * 用途は、ETロボコン参加、および個人使用に限ります。 <br>
 * <br>
 * date     2009/07/31<br>
 * @version 0.1 <br>
 * @author  ojima＠銀河系はねうま by Jacom Co.,LTD. <br>
 */
//原文 -----------------------------------------------------------------------
/*
 ******************************************************************************
 **	ファイル名 : balancer.h
 **
 ** モデル関連情報:
 **   モデル名   : balancer.mdl
 **   バージョン : 1.893
 **   履歴       : y_yama - Tue Sep 25 11:37:09 2007
 **                takashic - Sun Sep 28 17:50:53 2008
 **
 ** Copyright (c) 2008 CYBERNET SYSTEMS CO.,LTD.
 ** All rights reserved.
 ******************************************************************************
 **/
//-----------------------------------------------------------------------------
/**
 * NXTway-GSバランス制御
 */
abstract class BasicBalancer {

	protected static final float CMD_MAX = 100.0F; /* 前進/旋回命令絶対最大値 */
	protected static final float DEG2RAD = 0.01745329238F; /* 角度単位変換係数(=pi/180) */

	// protected static final float EXEC_PERIOD = 0.00400000019F; /*
	// バランス制御実行周期(秒) */

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
