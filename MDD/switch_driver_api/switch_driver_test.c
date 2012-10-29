#include "sfr29.h"
#include "led_driver.h"
#include "switch_driver.h"

void init();

int main()
{
	char pattern = 0;
	
	init();
		
	while(1) {
		pattern = get_switch();
		set_led(pattern);
	}
}

void init() 
{
	prc2 = 1;			/*PACR�̏����݋���*/
	pacr = 3;			/*80�s���ɐݒ�*/
	
	/*�N���b�N�ݒ�*/
	prc0=1;
	cm21=0;
	cm06=0;
	prc0=0;
	
	//
	init_led();
	//
	init_switch();
}