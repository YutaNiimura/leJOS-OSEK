#include "Controller.h"

void C_setTargetValue(int target)
{
	RS_setTargetValue(target);
}

int C_getTargetValue(void)
{
	return RS_getTargetValue();
}

float C_getControlMethodParm(void)
{
	return PCP_getKParm();
}

void C_setControlMethodParm(float parm)
{
	PCP_setKParm(parm);
}

void C_doControl() {
	P_setLevel(PC_calcControlValue(RS_getTargetValue(),RS_getValue()));
}
