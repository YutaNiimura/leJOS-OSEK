#include "sfr29.h"
#include "utility.h"
#include "led_driver.h"
#include "motor_driver.h"
#include "encoder_driver.h"


void init();
void show_led(float speed);

int main()
{
	float motor_speed;
	
	init();


	set_l_motor_mode(MOTOR_FORWARD);
	set_l_motor_pwm(30);

	while(1) {
		/*
		wheel_speed = get_r_motor_speed();
		show_led(wheel_speed);
		wait_ms(100);
		*/
	
		motor_speed = get_l_motor_speed();
		show_led(motor_speed);
		wait_ms(100);

	}

}

void init()
{
	prc2 = 1;			/*PACRの書込み許可*/
	pacr = 3;			/*80ピンに設定*/
	
	/*クロック設定*/
	prc0=1;
	cm21=0;
	cm06=0;
	prc0=0;
	
	//
	init_led();
	init_motor();
	//	
	init_encoder();
	
}

void show_led(float speed) {
	set_led((char)speed);
}
