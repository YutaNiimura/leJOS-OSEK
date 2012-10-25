#include "Pwm.h"

#include "motor_driver.h"

/**
 * モータへのPWM信号を設定する。
 * @param level duty比[%] (-100<= level <=100) level>0の時はモータが正転、level<0の時はモーターが逆転する。
 */
void P_setLevel(int level)
{
	if ( level > 0 ) {
		set_r_motor_mode(MOTOR_FORWARD);
		set_r_motor_pwm(level);
	} else if ( level < 0 ) {
		set_r_motor_mode(MOTOR_REVERSE);
		set_r_motor_pwm(-level);
	} else {
		set_r_motor_mode(MOTOR_STOP);
		set_r_motor_pwm(0);
	}
}
