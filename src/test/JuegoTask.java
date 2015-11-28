package test;

import java.util.TimerTask;

public class JuegoTask extends TimerTask{
	public static int times;
	
	public void run() {
		times++;
		JuegoMain.window.frame.repaint();
	}
}
