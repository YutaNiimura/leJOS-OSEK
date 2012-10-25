#include "sfr29.h"
#include "utility.h"
#include "led_driver.h"


void led_driver_test_init();

void led_driver_test()
{
	char pattern = 0;

	led_driver_test_init();
		
	while(1) {
	set_led(pattern);
	wait_ms(500);
	pattern++;
	}
}

void led_driver_test_init() 
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
}
