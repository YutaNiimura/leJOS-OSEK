package Common;

public class Speed {

	private int targSpeed;

	private int bfSpeed;

	private SpeedEncoder speedEncoder;

	public Speed(SpeedEncoder speedEncoder) {
		this.targSpeed = 0;
		this.bfSpeed = 0;
		this.speedEncoder = speedEncoder;
	}

	public void setTargSpeed(int targSpeed) {
		this.targSpeed = targSpeed;
	}

	public int getTargSpeed() {
		return this.targSpeed;
	}

	public int getSpeed() {
		int speed;
		speed = this.speedEncoder.getSpeed();
		this.bfSpeed = speed;
		return speed;
	}

	public int getbfSpeed() {
		return this.bfSpeed;
	}

}
