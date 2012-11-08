package Algorithm;
import Common.TailControlMethodParm;

public class PIDTailControlParm extends TailControlMethodParm{

	private float tKp;
	private float tKi;
	private float tKd;

	public PIDTailControlParm(){
		this.tKp = (float)1.0;
		this.tKi = (float)0.0;
		this.tKd = (float)0.0;
	}

	public float getTKp(){
		return this.tKp;
	}

	public void setTKp(float parm){
		this.tKp = parm;
	}

	public float getTKi(){
		return this.tKi;
	}

	public void setTKi(float parm){
		this.tKi = parm;
	}

	public float getTKd(){
		return this.tKd;
	}

	public void setTKd(float parm){
		this.tKd = parm;
	}
}
