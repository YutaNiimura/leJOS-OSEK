#include "sfr29.h"
#include "encoder_driver.h"

#pragma INTERRUPT int_tb1		/*タイマB1アンダーフロー割り込み*/
#pragma INTERRUPT int_int1		/*右車輪A相*/
#pragma INTERRUPT int_int2		/*右車輪B相*/
#pragma INTERRUPT int_int3		/*左車輪A相*/
#pragma INTERRUPT int_int4		/*左車輪B相*/

//
const int CPR = 32;			// モータ1回転あたりのエンコーダカウント数
const float DELTA_T = 20.0; // タイマー周期 20 [ms]


/*グローバル変数*/
int countR = 0;	// 右ロータリエンコーダのカウント値
int countL = 0; // 左ロータリエンコーダのカウント値
int countR_prev = 0;
int countL_prev = 0;

void init_encoder()
{
	/*タイマB1の設定*/
	tck1_tb1mr=1;		/*タイマーモード：f32*/
	tb1=2*6250-1;			/*20msで割り込み発生*/
	ilvl0_tb1ic=1;		/*割り込みレベル1*/
	tb1s = 1;			/*カウントスタート*/

	/*INT割り込み設定*/
	ilvl2_int1ic=1;			/*INT1割り込みレベル4*/
	ilvl2_int2ic=1;			/*INT2割り込みレベル4*/
	ilvl2_int3ic=1; 		/*INT3割り込みレベル4*/
	ilvl2_int4ic=1; 		/*INT4割り込みレベル4*/

	ifsr = 0x5e;			/*INT1,2,3,4 両エッジで割り込み*/
			
	/* 割込み許可*/ 
	#pragma ASM
		FSET I
	#pragma ENDASM
}

/*
float get_r_motor_speed()
{
	const float coeff = 1000.0 / (CPR * DELTA_T);

	int cnt = countR_prev;

	float speed = coeff * cnt;
	 	
	return speed;
}
*/


int get_r_motor_speed()
{
	const float coeff = 1000.0 / (CPR * DELTA_T);
	
	int cnt = countR_prev;
	int speed = (int) (coeff * cnt);	 	
	return cnt;
}

/*
float get_l_motor_speed()
{
	const float coeff = 1000.0 / (CPR * DELTA_T);

	int cnt = countL_prev;	

	float speed = coeff * cnt;
	 	
	return speed;
}

*/
int get_l_motor_speed()
{
	
	const float coeff = 1000.0 / (CPR * DELTA_T);
	
	int cnt = countL_prev;
	int speed = (int) (coeff * cnt);	 	
	return cnt;

}

/******************************************************************************
	外部(INT1)割り込みハンドラ
******************************************************************************/
void int_int1(void)
{
	if (!p8_3)
	{/* 立ち下がりエッジの場合 */
		if (p8_4) {
			-countR;
		} else {
			++countR;
		}
	} else {/* 立ち上がりエッジの場合 */
		if (p8_4) {
			++countR;
		} else {
			--countR;
		}
	}
	ir_int1ic = 0;		/* 割込み要求クリア */
}

/******************************************************************************
	外部(INT2)割り込みハンドラ
******************************************************************************/
void int_int2(void)
{
	if (!p8_4) {/* 立ち下がりエッジの場合 */
		if (p8_3) {
			++countR;
		} else {
			--countR;
		}
	} else {/* 立ち上がりエッジの場合 */
		if (p8_3) {
			--countR;
		} else {
			++countR;
		}
	}
	ir_int2ic = 0;		/* 割込み要求クリア */
}


/******************************************************************************
	外部(INT3)割り込みハンドラ
******************************************************************************/
void int_int3(void)
{
	if (!p1_5) {/* 立ち下がりエッジの場合 */
		if (p1_6) {
			--countL;
		} else {
			++countL;
		}
	} else {/* 立ち上がりエッジの場合 */
		if (p1_6) {
			++countL;
		} else {
			--countL;
		}
	}
	ir_int3ic = 0;		/* 割込み要求クリア */
}

/******************************************************************************
	外部(INT4)割り込みハンドラ
******************************************************************************/
void int_int4(void)
{
	if (!p1_6) {/* 立ち下がりエッジの場合 */
		if (p1_5) {
			++countL;
		} else {
			--countL;
		}
	} else {/* 立ち上がりエッジの場合 */
		if (p1_5) {
			--countL;
		} else {
			++countL;
		}
	}
	ir_int4ic = 0;		/* 割込み要求クリア */
}


/******************************************************************************
	タイマB1アンダフロー割り込みハンドラ(100Hz)
******************************************************************************/
void int_tb1(void)
{
	// カウント数の保持
	countR_prev = countR;
	countL_prev = countL;
	
	// カウント数のリセット
	countR = 0;
	countL = 0;
}
