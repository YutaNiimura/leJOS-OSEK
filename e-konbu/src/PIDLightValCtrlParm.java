
public class PIDLightValCtrlParm implements LightValCtrlParm{
	float lKp;
	float lKi;
	float lKd;

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
