#include "sfr29.h"
#include "switch_driver.h"

void init_switch()
{
	/* 入力ピンをプルアップ */
	pu05 = 1; /* P24 to P27 pull-up */
	pu06 = 1; /* P30 to P33 pull-up */
	pu14 = 1; /* P60 to P63 pull-up */
}


char get_switch()
{
	char pattern = ((p2&0xF0)>>4)|((p6&0x03)<<4)|((p3&0x01)<<6)|((p3&0x08)<<4);
	return pattern;
}
