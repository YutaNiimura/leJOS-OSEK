/**
 * モーター駆動用ドライバ。
 * 注意)タイマーA1およびA3を利用する(PWM信号出力)
 */

#ifndef _MOTOR_DRIVER
#define _MOTOR_DRIVER


/**
 * モーターの動作モード
 */
enum MotorMode {
	MOTOR_STOP    = 0,
	MOTOR_FORWARD = 1,
	MOTOR_REVERSE = 2,
};


/**
  * モーター使用時の初期化
  */
void init_motor();


/**
  * 右モーターの動作モードを設定する
  * @param mode MOTOR_STOP: 停止、MOTOR_FORWARD: 正転、MOTOR_REVERSE: 逆転
  */
void set_r_motor_mode(enum MotorMode mode);

/**
  * 左モーターの動作モードを設定する
  * @param mode MOTOR_STOP: 停止、MOTOR_FORWARD: 正転、MOTOR_REVERSE: 逆転
  */
void set_l_motor_mode(enum MotorMode mode);

/**
  * 右モーターをduty比 pwm %で駆動する
  * @param pwm duty比 [%] (0<= pwm <=100)	
  */
void set_r_motor_pwm(int pwm);

/**
  * 左モーターをduty比 pwm %で駆動する
  * @param pwm duty比 [%] (0<= pwm <=100)	
  */
void set_l_motor_pwm(int pwm);

#endif // _MOTOR_DRIVER