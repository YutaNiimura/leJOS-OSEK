#include "Tachometer.h"
#include "encoder_driver.h"

/**
 * ‰ñ“]‘¬“x‚ðŽæ“¾
 * @return ‰ñ“]‘¬“x [rps]
 */
int T_getValue()
{
	return get_r_motor_speed();
}
