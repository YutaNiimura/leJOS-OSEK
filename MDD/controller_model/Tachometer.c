#include "Tachometer.h"
#include "encoder_driver.h"

/**
 * ��]���x���擾
 * @return ��]���x [rps]
 */
int T_getValue()
{
	return get_r_motor_speed();
}
