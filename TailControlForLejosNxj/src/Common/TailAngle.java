package Common;

public class TailAngle {

	private TailAngleMeter tailAngleMeter;

	private int targTailAngle;

	TailAngle(TailAngleMeter tailAngleMeter){
		this.tailAngleMeter = tailAngleMeter;
		this.targTailAngle = 0;
	}

	public int getTailAngle(){
		return tailAngleMeter.getTailAngle();
	}

	public int getTargTailAngle(){
		return this.targTailAngle;
	}

	public void setTargTailAngle(int targTailAngle){
		this.targTailAngle = targTailAngle;
	}
}
