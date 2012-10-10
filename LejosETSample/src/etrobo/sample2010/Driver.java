package etrobo.sample2010;

import lejos.nxt.*;
import etrobo.nxj.balancer.*;

public class Driver implements Runnable
{
	private LineTracer tracer = new LineTracer();
	private Gyro gyro = new Gyro();
	private Motor motor = new Motor();
	private boolean available;

	public Driver() {
		available = true;
	}

	// =============================================================================
	// タスク名 : TaskMain
	// 概要 : メインタスク
	//
	public void run() {

		/* モータ制御初期化 */
		motor.reset();

		/* ライントレース開始 */
		Thread tracerThread = new Thread(tracer);
		tracerThread.start();

		/* 倒立振子制御初期化 */
		BalancerParam param = new BalancerParam();
		// param.setter(); /* 倒立振子制御パラメータ設定 */
		Balancer balance = new Balancer(param);
		balance.init();

		/* debug */
		int cnt = 0;
		long ms1 = System.currentTimeMillis();

		while (available == true) {
			cnt++; /* debug */

			/* 倒立振子制御(forward = 0, turn = 0で静止バランス) */
			balance.control(
				tracer.getForwardCmd(), /* 前後進命令: -100(後進)～0(停止)～100(前進) */
				tracer.getTurnCmd(), /* 旋回命令: -100(左旋回)～100(右旋回) */
				gyro.readValue(), /* ジャイロセンサ値 */
				gyro.getOffset(), /* ジャイロセンサオフセット値 */
				motor.getCountL(), /* 左モータ回転角度[deg] */
				motor.getCountR(), /* 右モータ回転角度[deg] */
				Battery.getVoltageMilliVolt()); /* バッテリ電圧[mV] */

			motor.setPwmL(balance.getPwmL()); /* 左モータPWM出力セット */
			motor.setPwmR(balance.getPwmR()); /* 右モータPWM出力セット */

			try {
				Thread.sleep(4); /* 約4msec周期処理 */
			} catch (InterruptedException e) {
			}
		}

		/* debug */
		long ms2 = System.currentTimeMillis();
		long ms = ms2 - ms1;
		System.out.print("" + cnt + "ct/");
		System.out.print(ms);
		System.out.println("ms");

		/* ライントレース終了 */
		tracer.stopRunning();

		/* モータ制御停止 */
		motor.stop();
	}

	/* 走行停止 */
	public void stopRunning() {
		available = false;
	}
}
