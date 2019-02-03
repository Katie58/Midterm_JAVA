package midterm;

import java.util.TimerTask;

public class Timer {
	
	private int time = 0;
		
	public int getTime() {
		return time;
	}
	
	public Timer()
	{
	  final java.util.Timer tmr = new java.util.Timer();
	  tmr.scheduleAtFixedRate(new TimerTask()
	  {
	    public void run()
	    {
	      time++;
	    }
	  },0,1000);
	}
	//public static void main(String[] args){new Testing();} {}
}

