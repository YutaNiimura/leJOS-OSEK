#ifndef _LED_DRIVER
#define _LED_DRIVER

/**
 * LED使用時の初期化
 */
void init_led();

/**
 * LED7~0を点灯する
 * @param pattern LED点灯パターン
 */
void set_led(char pattern);

#endif // _LED_DRIVER