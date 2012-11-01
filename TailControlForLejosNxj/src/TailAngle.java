public class TailAngle {

	private TailAngleEncoder tailmotorencoder = new TailAngleEncoder();

	private int targTailAngle;

	TailAngle(){
		this.targTailAngle = 0;
	}

	public int getTailAngle(){
		return tailmotorencoder.getTailAngle();
	}

	public int getTargTailAngle(){
		return this.targTailAngle;
	}

	public void setTargTailAngle(int targTailAngle){
		this.targTailAngle = targTailAngle;
	}
}
