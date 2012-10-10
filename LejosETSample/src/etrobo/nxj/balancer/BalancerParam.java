package etrobo.nxj.balancer;

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
 **	ファイル名 : balancer_private.h
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
 * 倒立振子制御パラメータ <br>
 * (原注)------------------------------------------------------------ <br>
 * 倒立振子制御パラメータは制御特性に大きな影響を与えます。 <br>
 * ------------------------------------------------------------------
 */
public class BalancerParam {
	/* Imported (extern) block parameters */
	private float A_D = 0.8F; /*
							 * Variable: A_D Referenced by blocks:
							 * '<S11>/Constant1' '<S11>/Gain2'
							 * ローパスフィルタ係数(左右車輪の平均回転角度用)
							 */
	private float A_R = 0.996F; /*
								 * Variable: A_R Referenced by blocks:
								 * '<S8>/Constant1' '<S8>/Gain2'
								 * ローパスフィルタ係数(左右車輪の目標平均回転角度用)
								 */
	private float[] K_F = new float[] { -0.870303F, -31.9978F, -1.1566F,
			-2.78873F };
	/*
	 * Variable: K_F '<S1>/FeedbackGain' サーボ制御用状態フィードバック係数
	 */
	private float K_I = -0.44721F; /*
									 * Variable: K_I '<S1>/IntegralGain'
									 * サーボ制御用積分係数
									 */
	private float K_PHIDOT = 25.0F; /*
									 * Variable: K_PHIDOT '<S3>/Gain2'
									 * 車体の目標平面回転速度(dφ/dt)係数
									 */
	private float K_THETADOT = 7.5F; /*
									 * Variable: K_THETADOT '<S3>/Gain1'
									 * 左右車輪の平均回転速度(dθ/dt)係数
									 */
	private float BATTERY_GAIN = 0.001089F;/* PWM出力算出用バッテリ電圧補正係数 */
	private float BATTERY_OFFSET = 0.625F; /* PWM出力算出用バッテリ電圧補正オフセット */

	private float EXEC_PERIOD = 0.00400000019F; /* バランス制御実行周期(秒) */

	public float getAD() {
		return A_D;
	}

	/**
	 * 
	 * @param a_d
	 *            ローパスフィルタ係数(左右車輪の平均回転角度用)
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
	 *            ローパスフィルタ係数(左右車輪の目標平均回転角度用)
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
	 *            サーボ制御用状態フィードバック係数 <br>
	 *            K_F[0]: 車輪回転角度係数 K_F[1]: 車体傾斜角度係数 K_F[2]: 車輪回転角速度係数 K_F[3]:
	 *            車体傾斜角速度係数
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
	 *            サーボ制御用積分係数
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
	 *            車体の目標平面回転速度(dφ/dt)係数
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
	 *            左右車輪の平均回転速度(dθ/dt)係数
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
	 *            PWM出力算出用バッテリ電圧補正係数
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
	 *            PWM出力算出用バッテリ電圧補正オフセット
	 */
	public void setBatteryOffset(float battery_offset) {
		BATTERY_OFFSET = battery_offset;
	}

	public float getExecPeriod() {
		return EXEC_PERIOD;
	}

	/**
	 * (注) 本来バランス制御実行周期は 0.00400000019(秒)固定ですが、 leJOS NXJ は nxtOSEK
	 * に比べて処理速度が遅いため、ユーザ変更対象としています。 ただし、この値の変更による倒立制御アルゴリズムへの影響は未確認です。
	 * 
	 * @param exec_period
	 *            バランス制御実行周期(秒)
	 */
	public void setExecPeriod(float exec_period) {
		EXEC_PERIOD = exec_period;
	}
}
