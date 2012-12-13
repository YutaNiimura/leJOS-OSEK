package Common;

public abstract class CurvatureControlMethod {

	public CurvatureControlMethodParm curvatureControlMethodParm;

	public abstract int calcCurvatureCtrlVal(float targCurvature,float curvature,int time);
	public abstract void initialize();

	public void setCurvatureCtrlParm(CurvatureControlMethodParm parm){
		this.curvatureControlMethodParm = parm;
	}

	public CurvatureControlMethodParm getCurvatureCtrlParm(){
		return this.curvatureControlMethodParm;
	}
}
