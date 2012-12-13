package algorithm;
import Common.CurvatureControlMethodParm;

public class PIDCurvatureMethodParm extends CurvatureControlMethodParm{

	public double cKp;
	public double cKi;
	public double cKd;

	public PIDCurvatureMethodParm(){
		this.cKp = 0.85;
		this.cKi = 0;
		this.cKd = 0;
	}

	public double getCKp(){
		return this.cKp;
	}

	public void setCKp(double parm){
		this.cKp = parm;
	}

	public double getCKi(){
		return this.cKi;
	}

	public void setCKi(double parm){
		this.cKi = parm;
	}

	public double getCKd(){
		return this.cKd;
	}

	public void setCKd(double parm){
		this.cKd = parm;
	}
}
