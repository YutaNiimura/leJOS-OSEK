/*
 * Controller.h
 * Controllerクラス
 *
 * クラス名: Controller(C)
 * 属性:
 * 操作: setTargetVale,
 * 関連: RotationSpeed(RS)
 */

#ifndef _CONTROLLER
#define _CONTROLLER

#include "RotationSpeed.h"
#include "Pwm.h"
#include "PControlMethod.h"
#include "PControlMethodParm.h"

/**
 * 回転速度を取得
 * @return 回転速度 [rps]
 */
extern void C_setTargetValue(int target);
extern int C_getTargetValue(void);
extern void C_doControl();
extern float C_getControlMethodParm(void);
extern void C_setControlMethodParm(float parm);

#endif // _CONTROLLER