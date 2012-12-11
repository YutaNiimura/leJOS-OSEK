package Common;

import Interface.MotorEncoder;

public class Curvature {

	MotorEncoder curvatureEncoder;

	public float targCurvature;
	public int bfDist;
	public double bfTheta;
	public double wheelRadius;
	public double wheelDist;

	Curvature(){
		this.targCurvature = 0;
		this.bfDist = 0;
		this.bfTheta = 0;
		this.wheelRadius = 4.1;
		this.wheelDist = 16.2;
	}

	public Curvature(MotorEncoder curvatureEncoder){
		this.curvatureEncoder = curvatureEncoder;
	}

	public float getCurvature(){
		int LCount = curvatureEncoder.getLCount();
		int RCount = curvatureEncoder.getRCount();

		double LDist = LCount * this.wheelRadius;
		double RDist = RCount * this.wheelRadius;

		double dist = (LDist + RDist)/2;

		double theta = (this.wheelRadius / this.wheelDist) * (LDist - RDist);

		double curvature;

		if(theta != this.bfTheta)
			curvature = (dist - this.bfDist) / (theta - this.bfTheta);
		else
			curvature = 0;

		return (float)curvature;
	}

	public float getTargCurvature(){
		return this.targCurvature;
	}

	public void setTargCurvature(float parm){
		this.targCurvature = parm;
	}

}
