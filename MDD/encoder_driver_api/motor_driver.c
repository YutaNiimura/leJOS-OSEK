#include "sfr29.h"
#include "motor_driver.h"


// モータ関連ポート、レジスタの定義
#define FORWARD_L	p8_0
#define REVERSE_L	p7_7
#define PWM_L		ta3

#define FORWARD_R	p7_4
#define REVERSE_R	p7_3
#define PWM_R		ta1


// モータ使用時の初期化
void init_motor()
{
	// モータ制御用ポート出力設定
	pd8 = 0x01;
	pd7 = 0x98;
	
	// タイマA3の設定 左モータPWM出力用
	ta3mr = 0x27;		// パルス変調MODE, 8bitパルス変調, count source f1
	ta3   = 0x0000;		// count初期値
	ta3s  = 1;			// TA3カウント開始
	
	// タイマA1の設定 右車輪PWM出力用
	ta1mr = 0x27;		// パルス変調MODE, 8bitパルス変調, count source f1
	ta1   = 0x0000; 	// count初期値
	ta1s  = 1;			// TA1カウント開始
}	


void set_l_motor_mode(enum MotorMode mode)
{
	if (mode == MOTOR_FORWARD) {
		REVERSE_L = 1;
		FORWARD_L = 0;
	} else if (mode == MOTOR_REVERSE) {
		FORWARD_L = 1;
		REVERSE_L = 0;
	} else {
		FORWARD_L = 1;
		REVERSE_L = 1;
	}		
}


void set_r_motor_mode(enum MotorMode mode)
{
	if (mode == MOTOR_FORWARD) {
		REVERSE_R = 1;
		FORWARD_R = 0;
	} else if (mode == MOTOR_REVERSE) {
		FORWARD_R = 1;
		REVERSE_R = 0;
	} else {
		FORWARD_R = 1;
		REVERSE_R = 1;
	}		
}


void set_r_motor_pwm(int pwm)
{
	int scaled_pwm = (5 * pwm) / 2;
	PWM_R = (scaled_pwm << 8) | 0x00;
}



void set_l_motor_pwm(int pwm)
{
	int scaled_pwm = (5 * pwm) / 2;
	PWM_L = (scaled_pwm << 8) | 0x00;
}
