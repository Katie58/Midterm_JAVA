package midterm;

import java.util.TimerTask;

public class Testing {
	
	private int time = 0;
		
	public int getTime() {
		return time;
	}
	
	public Testing()
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


