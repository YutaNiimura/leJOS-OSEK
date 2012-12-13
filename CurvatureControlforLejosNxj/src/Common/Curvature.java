package Common;

import Interface.MotorEncoder;

public class Curvature {

	private final static double wheelRadius = 4.1;
	private final static double wheelDist = 16.2;

	MotorEncoder curvatureEncoder;

	public float targCurvature;
	public double bfDist;
	public double bfTheta;

	public Curvature(){
		this.targCurvature = 0;
		this.bfDist = 0;
		this.bfTheta = 0;
	}

	public Curvature(MotorEncoder curvatureEncoder){
		this.curvatureEncoder = curvatureEncoder;
	}

	public float getCurvature(){
		int LCount = curvatureEncoder.getLCount();
		int RCount = curvatureEncoder.getRCount();

		double LDist = (double)LCount * wheelRadius;
		double RDist = (double)RCount * wheelRadius;

		double dist = (LDist + RDist)/2;

		double theta = (wheelRadius / wheelDist) * (LDist - RDist);

		double curvature;

		if(theta != this.bfTheta)
			curvature = (dist - this.bfDist) / (theta - this.bfTheta);
		else
			curvature = 0;

		this.bfTheta = theta;
		this.bfDist = dist;

		return (float)curvature;
	}

	public float getTargCurvature(){
		return this.targCurvature;
	}

	public void setTargCurvature(float parm){
		this.targCurvature = parm;
	}

}
