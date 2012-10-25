/*
 * PControlMethod.h
 * PControlMethodクラス
 *
 * クラス名: PControlMethod(PC)
 * 属性: hensa
 * 操作: getControlParm,setControlParm,calcControlValue,initialize
 * 関連:
 */
 
#ifndef _PCONTROLMETHOD
#define _PCONTROLMETHOD

#include "PControlMethodParm.h"

extern float PC_getControlParm(void);
extern void PC_setControlParm(float parm);
extern int PC_calcControlValue(int targvalue,int getvalue);
extern void PC_initialize(void);

#endif // _PCONTROLMETHOD