package algorithm;
import Common.CurvatureControlMethodParm;

public class PIDCurvatureMethodParm extends CurvatureControlMethodParm{

	public float cKp;
	public float cKi;
	public float cKd;

	public float getCKp(){
		return this.cKp;
	}

	public void setCKp(float parm){
		this.cKp = parm;
	}

	public float getCKi(){
		return this.cKi;
	}

	public void setCKi(float parm){
		this.cKi = parm;
	}

	public float getCKd(){
		return this.cKd;
	}

	public void setCKd(float parm){
		this.cKd = parm;
	}
}
