package etrobo.nxj.balancer;

/**
 * (注) 当プログラムは、LEGO MINDSTORMS NXT 2輪型倒立振子ロボット「NXYway-GS」の バランス制御プログラム（C/C++） を、
 * leJOS NXJ 向け（Java）に移植したものです。 用途は、ETロボコン参加、および個人使用に限ります。 <br>
 * <br>
 * (原注)------------------------------------------------------------ <br>
 * 2輪型倒立振子ロボット「NXTway-GS」バランス制御プログラム NXTway-GSのバランス制御には、サーボ制御(状態 + 積分フィードバック)
 * という現代制御を適用しています。制御対象の同定および制御器の開発 にはThe MathWorks社のMATLAB&Simulinkという製品を使用した、
 * MBD(モデルベースデザイン/開発)開発手法を用いています。このCプログラムは SimulinkモデルからReal-Time Workshop
 * Embedded Coderコード生成標準機能を 使用して自動生成されたものです。バランス制御器の制御パラメータについては
 * ユーザーハンドコード側で定義する必要があります。定義例として、
 * nxtOSEK\samples\nxtway_gs\balancer_param.cを参照してください。 バランス制御アルゴリズムの詳細情報につきましては <br>
 * 日本語: http://www.cybernet.co.jp/matlab/library/library/detail.php?id=TA060 <br>
 * 英語 :
 * http://www.mathworks.com/matlabcentral/fileexchange/loadFile.do?objectId=
 * 19147&objectType=file <br>
 * を参照してください。 <br>
 * ------------------------------------------------------------------ <br>
 * <br>
 * 作成日 2009/07/31<br>
 * 
 * @version 0.1 <br>
 * @author ojima＠銀河系はねうま by Jacom Co.,LTD. <br>
 */
// 原文 -----------------------------------------------------------------------
/*
 * *****************************************************************************
 * * FILE NAME : balancer.c** ABSTRUCT : Two wheeled self-balancing robot
 * "NXTway-GS" balance control program.* NXTway-GS balance control algorithum is
 * based on modern control theory* which is servo control (state + integral
 * feedback).* To develop the controller and indentify the plant, The MathWorks*
 * MATLAB&Simulink had been used and this design methodology is* called MBD
 * (Model-Based Design/Development). This C source code* is automatically
 * generated from a Simulink model by using standard features* of Real-Time
 * Workshop Embedded Coder. All control parameters need to be defined* by user
 * and the sample parameters are defined in
 * nxtOSEK\samples\nxtway_gs\balancer_param.c.* For more detailed information
 * about the controller alogorithum, please check:* English :
 * http://www.mathworks
 * .com/matlabcentral/fileexchange/loadFile.do?objectId=19147&objectType=file*
 * Japanese:
 * http://www.cybernet.co.jp/matlab/library/library/detail.php?id=TA060** MODEL
 * INFO:* MODEL NAME : balancer.mdl* VERSION : 1.893* HISTORY : y_yama - Tue Sep
 * 25 11:37:09 2007* takashic - Sun Sep 28 17:50:53 2008** Copyright (c) 2008
 * CYBERNET SYSTEMS CO.,LTD.* All rights reserved.
 * *****************************************************************************
 */
/*
 * *****************************************************************************
 * * ファイル名 : balancer.c** 概要 : 2輪型倒立振子ロボット「NXTway-GS」バランス制御プログラム*
 * NXTway-GSのバランス制御には、サーボ制御(状態 + 積分フィードバック)* という現代制御を適用しています。制御対象の同定および制御器の開発*
 * にはThe MathWorks社のMATLAB&Simulinkという製品を使用した、*
 * MBD(モデルベースデザイン/開発)開発手法を用いています。このCプログラムは* SimulinkモデルからReal-Time Workshop
 * Embedded Coderコード生成標準機能を* 使用して自動生成されたものです。バランス制御器の制御パラメータについては*
 * ユーザーハンドコード側で定義する必要があります。定義例として、*
 * nxtOSEK\samples\nxtway_gs\balancer_param.cを参照してください。*
 * バランス制御アルゴリズムの詳細情報につきましては* 日本語:
 * http://www.cybernet.co.jp/matlab/library/library/detail.php?id=TA060* 英語 :
 * http
 * ://www.mathworks.com/matlabcentral/fileexchange/loadFile.do?objectId=19147
 * &objectType=file* を参照してください。** モデル関連情報:* モデル名 : balancer.mdl* バージョン : 1.893*
 * 履歴 : -* -** Copyright (c) 2008 CYBERNET SYSTEMS CO.,LTD.* All rights
 * reserved.
 * *****************************************************************************
 */
// -----------------------------------------------------------------------------
public class Balancer extends BasicBalancer {

	private float ud_err_theta; /* 左右車輪の平均回転角度(θ)目標誤差状態値 */
	private float ud_psi; /* 車体ピッチ角度(ψ)状態値 */
	private float ud_theta_lpf; /* 左右車輪の平均回転角度(θ)状態値 */
	private float ud_theta_ref; /* 左右車輪の目標平均回転角度(θ)状態値 */
	private float ud_thetadot_cmd_lpf; /* 左右車輪の目標平均回転角速度(dθ/dt)状態値 */

	private int pwm_l; /* 左モータPWM出力値 */
	private int pwm_r; /* 右モータPWM出力値 */

	float[] tmp = new float[4];
	float[] tmp_theta_0 = new float[4];

	private float A_D; /* ローパスフィルタ係数(左右車輪の平均回転角度用) */
	private float A_R; /* ローパスフィルタ係数(左右車輪の目標平均回転角度用) */
	private float[] K_F = new float[4]; /* 状態フィードバック係数 */
	/*
	 * K_F[0]: 車輪回転角度係数 K_F[1]: 車体傾斜角度係数 K_F[2]: 車輪回転角速度係数 K_F[3]: 車体傾斜角速度係数
	 */
	private float K_I; /* サーボ制御用積分フィードバック係数 */
	private float K_PHIDOT; /* 車体目標旋回角速度係数 */
	private float K_THETADOT; /* モータ目標回転角速度係数 */
	private float BATTERY_GAIN; /* PWM出力算出用バッテリ電圧補正係数 */
	private float BATTERY_OFFSET; /* PWM出力算出用バッテリ電圧補正オフセット */
	private float EXEC_PERIOD;

	/**
	 * @param param
	 *            倒立振子制御パラメータ<br>
	 *            (原注)------------------------------------------------------------
	 * <br>
	 *            倒立振子制御パラメータは制御特性に大きな影響を与えます。 <br>
	 *            ----------------------------------------------------------------
	 *            -- <br>
	 */
	public Balancer(BalancerParam param) {
		ud_err_theta = 0.0F;
		ud_theta_ref = 0.0F;
		ud_thetadot_cmd_lpf = 0.0F;
		ud_psi = 0.0F;
		ud_theta_lpf = 0.0F;

		pwm_l = 0;
		pwm_r = 0;

		A_D = param.getAD();
		A_R = param.getAR();
		K_F = param.getKF();
		K_I = param.getKI();
		K_PHIDOT = param.getKPhidot();
		K_THETADOT = param.getKThetadot();
		BATTERY_GAIN = param.getBatteryGain();
		BATTERY_OFFSET = param.getBatteryOffset();
		EXEC_PERIOD = param.getExecPeriod();
	}

	/**
	 * NXTway-GSバランス制御初期化関数。 <br>
	 * <br>
	 * (原注)------------------------------------------------------------ <br>
	 * 内部状態量変数を初期化します。 <br>
	 * この関数によりバランス制御機能を初期化する場合は、併せて左右の <br>
	 * 車輪駆動モーターのエンコーダ値を0にリセットしてください。 <br>
	 * ------------------------------------------------------------------ <br>
	 */
	/* Model initialize function */
	@Override
	public void init() {
		/* Registration code */

		/* states (dwork) */

		/* custom states */
		ud_err_theta = 0.0F;
		ud_theta_ref = 0.0F;
		ud_thetadot_cmd_lpf = 0.0F;
		ud_psi = 0.0F;
		ud_theta_lpf = 0.0F;
	}

	/**
	 * NXTway-GSバランス制御関数。 <br>
	 * <br>
	 * 本メソッド実行後、getPwmL および getPwmR で左右モータPMW出力値を取得します。 <br>
	 * <br>
	 * (原注)------------------------------------------------------------ <br>
	 * この関数は4msec周期で起動されることを前提に設計されています。 <br>
	 * なお、ジャイロセンサオフセット値はセンサ個体および通電によるドリフト <br>
	 * を伴いますので、適宜補正する必要があります。また、左右の車輪駆動 <br>
	 * モータは個体差により、同じPWM出力を与えても回転数が異なる場合が <br>
	 * あります。その場合は別途補正機能を追加する必要があります。 <br>
	 * ------------------------------------------------------------------ <br>
	 * 
	 * @param args_cmd_forward
	 *            前進/後進命令。100(前進最大値)〜-100(後進最大値)
	 * @param args_cmd_turn
	 *            旋回命令。100(右旋回最大値)〜-100(左旋回最大値)
	 * @param args_gyro
	 *            ジャイロセンサ値
	 * @param args_gyro_offset
	 *            ジャイロセンサオフセット値
	 * @param args_theta_m_l
	 *            左モータエンコーダ値
	 * @param args_theta_m_r
	 *            右モータエンコーダ値
	 * @param args_battery
	 *            バッテリ電圧値(mV)
	 */
	/* Model step function */
	@Override
	public void control(float args_cmd_forward, float args_cmd_turn,
			float args_gyro, float args_gyro_offset, float args_theta_m_l,
			float args_theta_m_r, float args_battery) {
		float tmp_theta;
		float tmp_theta_lpf;
		float tmp_pwm_r_limiter;
		float tmp_psidot;
		float tmp_pwm_turn;
		float tmp_pwm_l_limiter;
		float tmp_thetadot_cmd_lpf;
		// float[] tmp = new float[4];
		// float[] tmp_theta_0 = new float[4];
		int tmp_0;

		/*
		 * Sum: '<S8>/Sum' incorporates: Constant: '<S3>/Constant6' Constant:
		 * '<S8>/Constant' Constant: '<S8>/Constant1' Gain: '<S3>/Gain1' Gain:
		 * '<S8>/Gain2' Inport: '<Root>/cmd_forward' Product: '<S3>/Divide'
		 * Product: '<S8>/Product' Sum: '<S8>/Sum1' UnitDelay: '<S8>/Unit Delay'
		 */
		tmp_thetadot_cmd_lpf = (((args_cmd_forward / CMD_MAX) * K_THETADOT) * (1.0F - A_R))
				+ (A_R * ud_thetadot_cmd_lpf);

		/*
		 * Gain: '<S4>/Gain' incorporates: Gain: '<S4>/deg2rad' Gain:
		 * '<S4>/deg2rad1' Inport: '<Root>/theta_m_l' Inport: '<Root>/theta_m_r'
		 * Sum: '<S4>/Sum1' Sum: '<S4>/Sum4' Sum: '<S4>/Sum6' UnitDelay:
		 * '<S10>/Unit Delay'
		 */
		tmp_theta = (((DEG2RAD * args_theta_m_l) + ud_psi) + ((DEG2RAD * args_theta_m_r) + ud_psi)) * 0.5F;

		/*
		 * Sum: '<S11>/Sum' incorporates: Constant: '<S11>/Constant' Constant:
		 * '<S11>/Constant1' Gain: '<S11>/Gain2' Product: '<S11>/Product' Sum:
		 * '<S11>/Sum1' UnitDelay: '<S11>/Unit Delay'
		 */
		tmp_theta_lpf = ((1.0F - A_D) * tmp_theta) + (A_D * ud_theta_lpf);

		/*
		 * Gain: '<S4>/deg2rad2' incorporates: Inport: '<Root>/gyro' Inport:
		 * '<Root>/gyro_offset' Sum: '<S4>/Sum2'
		 */
		tmp_psidot = (args_gyro - args_gyro_offset) * DEG2RAD;

		/*
		 * Gain: '<S2>/Gain' incorporates: Constant: '<S3>/Constant2' Constant:
		 * '<S3>/Constant3' Constant: '<S6>/Constant' Constant: '<S9>/Constant'
		 * Gain: '<S1>/FeedbackGain' Gain: '<S1>/IntegralGain' Gain:
		 * '<S6>/Gain3' Inport: '<Root>/battery' Product: '<S2>/Product'
		 * Product: '<S9>/Product' Sum: '<S1>/Sum2' Sum: '<S1>/sum_err' Sum:
		 * '<S6>/Sum2' Sum: '<S9>/Sum' UnitDelay: '<S10>/Unit Delay' UnitDelay:
		 * '<S11>/Unit Delay' UnitDelay: '<S5>/Unit Delay' UnitDelay: '<S7>/Unit
		 * Delay'
		 */
		tmp[0] = ud_theta_ref;
		tmp[1] = 0.0F;
		tmp[2] = tmp_thetadot_cmd_lpf;
		tmp[3] = 0.0F;
		tmp_theta_0[0] = tmp_theta;
		tmp_theta_0[1] = ud_psi;
		tmp_theta_0[2] = (tmp_theta_lpf - ud_theta_lpf) / EXEC_PERIOD;
		tmp_theta_0[3] = tmp_psidot;
		tmp_pwm_r_limiter = 0.0F;
		for (tmp_0 = 0; tmp_0 < 4; tmp_0++) {
			tmp_pwm_r_limiter += (tmp[tmp_0] - tmp_theta_0[tmp_0])
					* K_F[(tmp_0)];
		}

		tmp_pwm_r_limiter = (((K_I * ud_err_theta) + tmp_pwm_r_limiter) / ((BATTERY_GAIN * args_battery) - BATTERY_OFFSET)) * 100.0F;

		/*
		 * Gain: '<S3>/Gain2' incorporates: Constant: '<S3>/Constant1' Inport:
		 * '<Root>/cmd_turn' Product: '<S3>/Divide1'
		 */
		tmp_pwm_turn = (args_cmd_turn / CMD_MAX) * K_PHIDOT;

		/* Sum: '<S2>/Sum' */
		tmp_pwm_l_limiter = tmp_pwm_r_limiter + tmp_pwm_turn;

		/* Saturate: '<S2>/pwm_l_limiter' */
		tmp_pwm_l_limiter = rt_SATURATE(tmp_pwm_l_limiter, -100.0F, 100.0F);

		/*
		 * Outport: '<Root>/pwm_l' incorporates: DataTypeConversion: '<S1>/Data
		 * Type Conversion'
		 */
		pwm_l = (int) tmp_pwm_l_limiter;

		/* Sum: '<S2>/Sum1' */
		tmp_pwm_r_limiter -= tmp_pwm_turn;

		/* Saturate: '<S2>/pwm_r_limiter' */
		tmp_pwm_r_limiter = rt_SATURATE(tmp_pwm_r_limiter, -100.0F, 100.0F);

		/*
		 * Outport: '<Root>/pwm_r' incorporates: DataTypeConversion: '<S1>/Data
		 * Type Conversion6'
		 */
		pwm_r = (int) tmp_pwm_r_limiter;

		/*
		 * Sum: '<S7>/Sum' incorporates: Gain: '<S7>/Gain' UnitDelay: '<S7>/Unit
		 * Delay'
		 */
		tmp_pwm_l_limiter = (EXEC_PERIOD * tmp_thetadot_cmd_lpf) + ud_theta_ref;

		/*
		 * Sum: '<S10>/Sum' incorporates: Gain: '<S10>/Gain' UnitDelay:
		 * '<S10>/Unit Delay'
		 */
		tmp_pwm_turn = (EXEC_PERIOD * tmp_psidot) + ud_psi;

		/*
		 * Sum: '<S5>/Sum' incorporates: Gain: '<S5>/Gain' Sum: '<S1>/Sum1'
		 * UnitDelay: '<S5>/Unit Delay' UnitDelay: '<S7>/Unit Delay'
		 */
		tmp_pwm_r_limiter = ((ud_theta_ref - tmp_theta) * EXEC_PERIOD)
				+ ud_err_theta;

		/* user code (Update function Body) */
		/* System '<Root>' */
		/* 次回演算用状態量保存処理 */

		/* Update for UnitDelay: '<S5>/Unit Delay' */
		ud_err_theta = tmp_pwm_r_limiter;

		/* Update for UnitDelay: '<S7>/Unit Delay' */
		ud_theta_ref = tmp_pwm_l_limiter;

		/* Update for UnitDelay: '<S8>/Unit Delay' */
		ud_thetadot_cmd_lpf = tmp_thetadot_cmd_lpf;

		/* Update for UnitDelay: '<S10>/Unit Delay' */
		ud_psi = tmp_pwm_turn;

		/* Update for UnitDelay: '<S11>/Unit Delay' */
		ud_theta_lpf = tmp_theta_lpf;
	}

	/**
	 * 左モータPMW出力値取得
	 * 
	 * @return 100(前進最大値)〜-100(後進最大値)
	 */
	/* left motor PWM output */
	@Override
	public int getPwmL() {
		return pwm_l;
	}

	/**
	 * 右モータPMW出力値取得
	 * 
	 * @return 100(前進最大値)〜-100(後進最大値)
	 */
	/* right motor PWM output */
	@Override
	public int getPwmR() {
		return pwm_r;
	}

	/* rt_SATURATE.h */
	private float rt_SATURATE(float sig, float ll, float ul) {
		return (((sig) >= (ul)) ? (ul) : (((sig) <= (ll)) ? (ll) : (sig)));
	}
}
