#include "sfr29.h"
#include "led_driver.h"

void init_led()
{
	/* I/OÉ|Å[Égê›íË */
	pd1 = 0x0f; /* P10 to P13 output */
	pd3 = 0xf0; /* P34 to P37 output */
}


void set_led(char pattern)
{
	p3 = (~pattern & 0x0f) << 4;
	p1 = (~pattern & 0xf0) >> 4;

}