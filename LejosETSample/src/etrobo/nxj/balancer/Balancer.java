package etrobo.nxj.balancer;

/**
 * (��) ���v���O�����́ALEGO MINDSTORMS NXT 2�֌^�|���U�q���{�b�g�uNXYway-GS�v�� �o�����X����v���O�����iC/C++�j ���A
 * leJOS NXJ �����iJava�j�ɈڐA�������̂ł��B �p�r�́AET���{�R���Q���A����ьl�g�p�Ɍ���܂��B <br>
 * <br>
 * (����)------------------------------------------------------------ <br>
 * 2�֌^�|���U�q���{�b�g�uNXTway-GS�v�o�����X����v���O���� NXTway-GS�̃o�����X����ɂ́A�T�[�{����(��� + �ϕ��t�B�[�h�o�b�N)
 * �Ƃ������㐧���K�p���Ă��܂��B����Ώۂ̓��肨��ѐ����̊J�� �ɂ�The MathWorks�Ђ�MATLAB&Simulink�Ƃ������i���g�p�����A
 * MBD(���f���x�[�X�f�U�C��/�J��)�J����@��p���Ă��܂��B����C�v���O������ Simulink���f������Real-Time Workshop
 * Embedded Coder�R�[�h�����W���@�\�� �g�p���Ď����������ꂽ���̂ł��B�o�����X�����̐���p�����[�^�ɂ��Ă�
 * ���[�U�[�n���h�R�[�h���Œ�`����K�v������܂��B��`��Ƃ��āA
 * nxtOSEK\samples\nxtway_gs\balancer_param.c���Q�Ƃ��Ă��������B �o�����X����A���S���Y���̏ڍ׏��ɂ��܂��Ă� <br>
 * ���{��: http://www.cybernet.co.jp/matlab/library/library/detail.php?id=TA060 <br>
 * �p�� :
 * http://www.mathworks.com/matlabcentral/fileexchange/loadFile.do?objectId=
 * 19147&objectType=file <br>
 * ���Q�Ƃ��Ă��������B <br>
 * ------------------------------------------------------------------ <br>
 * <br>
 * �쐬�� 2009/07/31<br>
 * 
 * @version 0.1 <br>
 * @author ojima����͌n�͂˂��� by Jacom Co.,LTD. <br>
 */
// ���� -----------------------------------------------------------------------
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
 * * �t�@�C���� : balancer.c** �T�v : 2�֌^�|���U�q���{�b�g�uNXTway-GS�v�o�����X����v���O����*
 * NXTway-GS�̃o�����X����ɂ́A�T�[�{����(��� + �ϕ��t�B�[�h�o�b�N)* �Ƃ������㐧���K�p���Ă��܂��B����Ώۂ̓��肨��ѐ����̊J��*
 * �ɂ�The MathWorks�Ђ�MATLAB&Simulink�Ƃ������i���g�p�����A*
 * MBD(���f���x�[�X�f�U�C��/�J��)�J����@��p���Ă��܂��B����C�v���O������* Simulink���f������Real-Time Workshop
 * Embedded Coder�R�[�h�����W���@�\��* �g�p���Ď����������ꂽ���̂ł��B�o�����X�����̐���p�����[�^�ɂ��Ă�*
 * ���[�U�[�n���h�R�[�h���Œ�`����K�v������܂��B��`��Ƃ��āA*
 * nxtOSEK\samples\nxtway_gs\balancer_param.c���Q�Ƃ��Ă��������B*
 * �o�����X����A���S���Y���̏ڍ׏��ɂ��܂��Ă�* ���{��:
 * http://www.cybernet.co.jp/matlab/library/library/detail.php?id=TA060* �p�� :
 * http
 * ://www.mathworks.com/matlabcentral/fileexchange/loadFile.do?objectId=19147
 * &objectType=file* ���Q�Ƃ��Ă��������B** ���f���֘A���:* ���f���� : balancer.mdl* �o�[�W���� : 1.893*
 * ���� : -* -** Copyright (c) 2008 CYBERNET SYSTEMS CO.,LTD.* All rights
 * reserved.
 * *****************************************************************************
 */
// -----------------------------------------------------------------------------
public class Balancer extends BasicBalancer {

	private float ud_err_theta; /* ���E�ԗւ̕��ω�]�p�x(��)�ڕW�덷��Ԓl */
	private float ud_psi; /* �ԑ̃s�b�`�p�x(��)��Ԓl */
	private float ud_theta_lpf; /* ���E�ԗւ̕��ω�]�p�x(��)��Ԓl */
	private float ud_theta_ref; /* ���E�ԗւ̖ڕW���ω�]�p�x(��)��Ԓl */
	private float ud_thetadot_cmd_lpf; /* ���E�ԗւ̖ڕW���ω�]�p���x(d��/dt)��Ԓl */

	private int pwm_l; /* �����[�^PWM�o�͒l */
	private int pwm_r; /* �E���[�^PWM�o�͒l */

	float[] tmp = new float[4];
	float[] tmp_theta_0 = new float[4];

	private float A_D; /* ���[�p�X�t�B���^�W��(���E�ԗւ̕��ω�]�p�x�p) */
	private float A_R; /* ���[�p�X�t�B���^�W��(���E�ԗւ̖ڕW���ω�]�p�x�p) */
	private float[] K_F = new float[4]; /* ��ԃt�B�[�h�o�b�N�W�� */
	/*
	 * K_F[0]: �ԗ։�]�p�x�W�� K_F[1]: �ԑ̌X�Ίp�x�W�� K_F[2]: �ԗ։�]�p���x�W�� K_F[3]: �ԑ̌X�Ίp���x�W��
	 */
	private float K_I; /* �T�[�{����p�ϕ��t�B�[�h�o�b�N�W�� */
	private float K_PHIDOT; /* �ԑ̖ڕW����p���x�W�� */
	private float K_THETADOT; /* ���[�^�ڕW��]�p���x�W�� */
	private float BATTERY_GAIN; /* PWM�o�͎Z�o�p�o�b�e���d���␳�W�� */
	private float BATTERY_OFFSET; /* PWM�o�͎Z�o�p�o�b�e���d���␳�I�t�Z�b�g */
	private float EXEC_PERIOD;

	/**
	 * @param param
	 *            �|���U�q����p�����[�^<br>
	 *            (����)------------------------------------------------------------
	 * <br>
	 *            �|���U�q����p�����[�^�͐�������ɑ傫�ȉe����^���܂��B <br>
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
	 * NXTway-GS�o�����X���䏉�����֐��B <br>
	 * <br>
	 * (����)------------------------------------------------------------ <br>
	 * ������ԗʕϐ������������܂��B <br>
	 * ���̊֐��ɂ��o�����X����@�\������������ꍇ�́A�����č��E�� <br>
	 * �ԗ֋쓮���[�^�[�̃G���R�[�_�l��0�Ƀ��Z�b�g���Ă��������B <br>
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
	 * NXTway-GS�o�����X����֐��B <br>
	 * <br>
	 * �{���\�b�h���s��AgetPwmL ����� getPwmR �ō��E���[�^PMW�o�͒l���擾���܂��B <br>
	 * <br>
	 * (����)------------------------------------------------------------ <br>
	 * ���̊֐���4msec�����ŋN������邱�Ƃ�O��ɐ݌v����Ă��܂��B <br>
	 * �Ȃ��A�W���C���Z���T�I�t�Z�b�g�l�̓Z���T�̂���ђʓd�ɂ��h���t�g <br>
	 * �𔺂��܂��̂ŁA�K�X�␳����K�v������܂��B�܂��A���E�̎ԗ֋쓮 <br>
	 * ���[�^�͌̍��ɂ��A����PWM�o�͂�^���Ă���]�����قȂ�ꍇ�� <br>
	 * ����܂��B���̏ꍇ�͕ʓr�␳�@�\��ǉ�����K�v������܂��B <br>
	 * ------------------------------------------------------------------ <br>
	 * 
	 * @param args_cmd_forward
	 *            �O�i/��i���߁B100(�O�i�ő�l)�`-100(��i�ő�l)
	 * @param args_cmd_turn
	 *            ���񖽗߁B100(�E����ő�l)�`-100(������ő�l)
	 * @param args_gyro
	 *            �W���C���Z���T�l
	 * @param args_gyro_offset
	 *            �W���C���Z���T�I�t�Z�b�g�l
	 * @param args_theta_m_l
	 *            �����[�^�G���R�[�_�l
	 * @param args_theta_m_r
	 *            �E���[�^�G���R�[�_�l
	 * @param args_battery
	 *            �o�b�e���d���l(mV)
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
		/* ���񉉎Z�p��ԗʕۑ����� */

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
	 * �����[�^PMW�o�͒l�擾
	 * 
	 * @return 100(�O�i�ő�l)�`-100(��i�ő�l)
	 */
	/* left motor PWM output */
	@Override
	public int getPwmL() {
		return pwm_l;
	}

	/**
	 * �E���[�^PMW�o�͒l�擾
	 * 
	 * @return 100(�O�i�ő�l)�`-100(��i�ő�l)
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