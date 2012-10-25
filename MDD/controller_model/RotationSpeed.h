/*
 * RotationSpeed.h
 * RotationSpeedクラス
 *
 * クラス名: RotationSpeed(RS)
 * 属性:
 * 操作: getValue, getTargetValue, setTargetValue
 * 関連: Tachometer(R)
 */
 
#ifndef _ROTATION_SPEED
#define _ROTATION_SPEED

#include "Tachometer.h"

/**
 * 回転速度を取得
 * @return 回転速度 [rps]
 */
extern int RS_getValue();

/**
 * 目標回転速度を取得
 * @return 目標回転速度 [rps]
 */
extern int RS_getTargetValue();

/**
 * 目標回転速度を設定
 * @param target 目標回転速度の設定値 [rps]
 */
extern void RS_setTargetValue(int target);

#endif // _ROTATION_SPEED