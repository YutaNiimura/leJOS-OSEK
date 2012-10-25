#include "PControlMethod.h"

static float hensa = 0;

//����p�����[�^���擾����
float PC_getControlParm(void)
{
	return PCP_getKParm();
}

//����p�����[�^��ݒ肷��
void PC_setControlParm(float parm)
{
	PCP_setKParm(parm);
}

//����ʂ��Z�o����
int PC_calcControlValue(int targvalue,int getvalue)
{
	int cmd_turn;
	
	if(targvalue > 0)
		hensa = (float)targvalue - (float)getvalue;
	else
		hensa = (float)getvalue - (float)targvalue;
		
	cmd_turn = PC_getControlParm() * (int)hensa;
	
	if(cmd_turn > 100)
		cmd_turn = 100;
	else if(cmd_turn < -100)
		cmd_turn = -100;
				
	return cmd_turn;
}	

//����������
void PC_initialize(void)
{
	hensa = 0;
}

