import lejos.nxt.*;
public class TailAngle {

	private TailAngleEncoder tailmotorencoder = new TailAngleEncoder();

	private int targTailAngle;

	TailAngle(){
		this.targTailAngle = 0;
	}

	public int getTailAngle(){
		return tailmotorencoder.getTargAngle();
	}

	public int getTargTailAngle(){
		return this.targTailAngle;
	}

	public void setTargTailAngle(int targTailAngle){
		this.targTailAngle = targTailAngle;
	}
}
