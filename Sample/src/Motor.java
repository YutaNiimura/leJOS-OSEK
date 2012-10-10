import lejos.nxt.*;

public class Motor
{
	public Motor() {
	}

	/* ���[�^���䏉���� */
	public void reset() {
		/* �����[�^�G���R�[�_���Z�b�g */
		MotorPort.C.setPWMMode(BasicMotorPort.PWM_BRAKE);
		MotorPort.C.resetTachoCount();
		MotorPort.C.controlMotor(0, 0);

		/* �E���[�^�G���R�[�_���Z�b�g */
		MotorPort.B.setPWMMode(BasicMotorPort.PWM_BRAKE);
		MotorPort.B.resetTachoCount();
		MotorPort.B.controlMotor(0, 0);
	}

	/* �����[�^��]�p�x[deg]�擾 */
	public int getCountL() {
		return MotorPort.C.getTachoCount();
	}

	/* �E���[�^��]�p�x[deg]�擾 */
	public int getCountR() {
		return MotorPort.B.getTachoCount();
	}

	/* �����[�^PWM�o�̓Z�b�g */
	public void setPwmL(int pwm) {
		MotorPort.C.controlMotor(pwm, 1);
	}

	/* �E���[�^PWM�o�̓Z�b�g */
	public void setPwmR(int pwm) {
		MotorPort.B.controlMotor(pwm, 1);
	}

	/* ���[�^�����~ */
	public void stop() {
		MotorPort.C.controlMotor(0, 0); /* �����[�^PWM�o�̓Z�b�g */
		MotorPort.B.controlMotor(0, 0); /* �E���[�^PWM�o�̓Z�b�g */
	}
}