#include "PControlMethodParm.h"

static float PCP_Kp = 1.0;

float PCP_getKParm(void)
{
	return PCP_Kp;
}

void PCP_setKParm(float parm)
{
	PCP_Kp = parm;
}
