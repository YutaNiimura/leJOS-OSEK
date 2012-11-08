package LightValCtrlAlgorithm;

import LightValCtrlCommon.*;

public class PIDLightValCtrlParm extends LightValCtrlParm{
	private float lKp;
	private float lKi;
	private float lKd;

	public PIDLightValCtrlParm(){
		this.lKp = (float) 1.85;
		this.lKi = (float) 0.03;
		this.lKd = (float) 0.003;
	}

	public float getLKp(){
		return this.lKp;
	}

	public void setLKp(float parm){
		this.lKp = parm;
	}

	public float getLKi(){
		return this.lKi;
	}

	public void setLKi(float parm){
		this.lKi = parm;
	}

	public float getLKd(){
		return this.lKd;
	}

	public void setLKd(float parm){
		this.lKd = parm;
	}
}
