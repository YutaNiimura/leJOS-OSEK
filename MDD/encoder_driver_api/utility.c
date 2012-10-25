#include "utility.h"

void wait_1ms();

void wait_ms(int n)
{
	int i;
	for (i = 0; i < n; i++)
	{
		wait_1ms();
	}
}


void wait_1ms()
{
	#pragma ASM
	MOV.W		#2857, r0
Delay:
	SBJNZ.W		#1, r0, Delay
	#pragma ENDASM
}

