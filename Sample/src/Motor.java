import lejos.nxt.*;

public class Motor
{
	public Motor() {
	}

	/* モータ制御初期化 */
	public void reset() {
		/* 左モータエンコーダリセット */
		MotorPort.C.setPWMMode(BasicMotorPort.PWM_BRAKE);
		MotorPort.C.resetTachoCount();
		MotorPort.C.controlMotor(0, 0);

		/* 右モータエンコーダリセット */
		MotorPort.B.setPWMMode(BasicMotorPort.PWM_BRAKE);
		MotorPort.B.resetTachoCount();
		MotorPort.B.controlMotor(0, 0);
	}

	/* 左モータ回転角度[deg]取得 */
	public int getCountL() {
		return MotorPort.C.getTachoCount();
	}

	/* 右モータ回転角度[deg]取得 */
	public int getCountR() {
		return MotorPort.B.getTachoCount();
	}

	/* 左モータPWM出力セット */
	public void setPwmL(int pwm) {
		MotorPort.C.controlMotor(pwm, 1);
	}

	/* 右モータPWM出力セット */
	public void setPwmR(int pwm) {
		MotorPort.B.controlMotor(pwm, 1);
	}

	/* モータ制御停止 */
	public void stop() {
		MotorPort.C.controlMotor(0, 0); /* 左モータPWM出力セット */
		MotorPort.B.controlMotor(0, 0); /* 右モータPWM出力セット */
	}
}