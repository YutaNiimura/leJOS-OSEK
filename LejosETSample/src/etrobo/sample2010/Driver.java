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
	// �^�X�N�� : TaskMain
	// �T�v : ���C���^�X�N
	//
	public void run() {

		/* ���[�^���䏉���� */
		motor.reset();

		/* ���C���g���[�X�J�n */
		Thread tracerThread = new Thread(tracer);
		tracerThread.start();

		/* �|���U�q���䏉���� */
		BalancerParam param = new BalancerParam();
		// param.setter(); /* �|���U�q����p�����[�^�ݒ� */
		Balancer balance = new Balancer(param);
		balance.init();

		/* debug */
		int cnt = 0;
		long ms1 = System.currentTimeMillis();

		while (available == true) {
			cnt++; /* debug */

			/* �|���U�q����(forward = 0, turn = 0�ŐÎ~�o�����X) */
			balance.control(
				tracer.getForwardCmd(), /* �O��i����: -100(��i)�`0(��~)�`100(�O�i) */
				tracer.getTurnCmd(), /* ���񖽗�: -100(������)�`100(�E����) */
				gyro.readValue(), /* �W���C���Z���T�l */
				gyro.getOffset(), /* �W���C���Z���T�I�t�Z�b�g�l */
				motor.getCountL(), /* �����[�^��]�p�x[deg] */
				motor.getCountR(), /* �E���[�^��]�p�x[deg] */
				Battery.getVoltageMilliVolt()); /* �o�b�e���d��[mV] */

			motor.setPwmL(balance.getPwmL()); /* �����[�^PWM�o�̓Z�b�g */
			motor.setPwmR(balance.getPwmR()); /* �E���[�^PWM�o�̓Z�b�g */

			try {
				Thread.sleep(4); /* ��4msec�������� */
			} catch (InterruptedException e) {
			}
		}

		/* debug */
		long ms2 = System.currentTimeMillis();
		long ms = ms2 - ms1;
		System.out.print("" + cnt + "ct/");
		System.out.print(ms);
		System.out.println("ms");

		/* ���C���g���[�X�I�� */
		tracer.stopRunning();

		/* ���[�^�����~ */
		motor.stop();
	}

	/* ���s��~ */
	public void stopRunning() {
		available = false;
	}
}
