/*
 * RotationSpeed.h
 * RotationSpeed�N���X
 *
 * �N���X��: RotationSpeed(RS)
 * ����:
 * ����: getValue, getTargetValue, setTargetValue
 * �֘A: Tachometer(R)
 */
 
#ifndef _ROTATION_SPEED
#define _ROTATION_SPEED

#include "Tachometer.h"

/**
 * ��]���x���擾
 * @return ��]���x [rps]
 */
extern int RS_getValue();

/**
 * �ڕW��]���x���擾
 * @return �ڕW��]���x [rps]
 */
extern int RS_getTargetValue();

/**
 * �ڕW��]���x��ݒ�
 * @param target �ڕW��]���x�̐ݒ�l [rps]
 */
extern void RS_setTargetValue(int target);

#endif // _ROTATION_SPEED