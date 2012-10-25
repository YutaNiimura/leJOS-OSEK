#ifndef _ENCODER_DRIVER
#define _ENDOCER_DRIVER

#pragma INTERRUPT int_tb1		/*タイマB1アンダーフロー割り込み*/
#pragma INTERRUPT int_int1		/*右車輪A相*/
#pragma INTERRUPT int_int2		/*右車輪B相*/
#pragma INTERRUPT int_int3		/*左車輪A相*/
#pragma INTERRUPT int_int4		/*左車輪B相*/

/**
 * ロータリエンコーダ使用時の初期化
 */
void init_encoder();

/**
 * 右モータの回転速度を取得する
 * @return 右車輪の回転速度 [rps]
 */
//float get_r_motor_speed();
int get_r_motor_speed();

/**
 * 左車輪の回転速度を取得する
 * @return 左車輪の回転速度 [rps]
 */
//float get_l_motor_speed();
int get_l_motor_speed();

#endif // _ENCODER_DRIVER