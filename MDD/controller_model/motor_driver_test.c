#include "sfr29.h"
#include "utility.h"
#include "motor_driver.h"

void motor_driver_test_init();

void motor_driver_test()
{
	
	motor_driver_test_init();

	set_r_motor_mode(MOTOR_FORWARD);	
	set_l_motor_mode(MOTOR_FORWARD);
	set_r_motor_pwm(30);
	set_l_motor_pwm(30);
	wait_ms(2000);
	set_r_motor_pwm(60);
	set_l_motor_pwm(60);
	wait_ms(2000);
	set_r_motor_mode(MOTOR_REVERSE);	
	set_l_motor_mode(MOTOR_REVERSE);
	set_r_motor_pwm(40);
	set_l_motor_pwm(40);
	wait_ms(2000);
	set_r_motor_mode(MOTOR_STOP);
	set_l_motor_mode(MOTOR_STOP);
}

void motor_driver_test_init()
{
	prc2 = 1;			/*PACRの書込み許可*/
	pacr = 3;			/*80ピンに設定*/
	
	/*クロック設定*/
	prc0=1;
	cm21=0;
	cm06=0;
	prc0=0;
	
	/* I/Oポート設定 */
	pd1 = 0x0f; /* P10 to P13 output */
	pd3 = 0xf0; /* P34 to P37 output */

	/* 入力ピンをプルアップ */
	pu05 = 1; /* P24 to P27 pull-up */
	pu06 = 1; /* P30 to P33 pull-up */
	pu14 = 1; /* P60 to P63 pull-up */


	init_motor();
	
}
