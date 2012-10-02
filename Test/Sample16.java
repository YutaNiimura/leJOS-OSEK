import lejos.nxt.*;
public class Sample16 {
	public static void main(String[] args) {
		int[][] music = {
				{523,100},
				{587,100},
				{659,100},
				{698,100},
				{784,100},
				{880,100},
				{988,100},
				{1047,100}
		};
		for(int cnt = 0;cnt < 8;cnt++){
			Sound.playTone(music[cnt][0], music[cnt][1]);

			try{
				Thread.sleep(500);
			}catch(InterruptedException e){
			}
		}
		Sound.twoBeeps();
	}
}
