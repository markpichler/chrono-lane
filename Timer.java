/**
 * 
 * @author: Mark Pichler
 * @pid: A11456292
 * 
 * @about: This is the "Timer" used ChronoLane.  Timer implements Runnable
 *         and uses the sleep() method to keep track of time and increments
 *         the time digits accordingly.
 */
public class Timer implements Runnable {

	
	public int s1, s2, m1, m2;
	public boolean go = true;
	
	//This is the string that displays the stopwatch time
	//in the format of "00:00"
	public String time = "" + m2 + m1 + ":" + s2 + s1;
	
	@Override
	public void run() {
		
		while(go) {
			
			time = "" + m2 + m1 + ":" + s2 + s1;
			//Wait for one second
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//Increment the tens place second digit
			if(s1 == 9) {
				s1 = 0;
				s2++;
			//Increment the ones place minute digit	
			if(s2 == 6) {
			    s2 = 0;
				m1++;
			}
			//Increment the tens place minute digit
			if(m1 == 9) {
			    m1 = 0;
				m2++;
			}
				
			time = "" + m2 + m1 + ":" + s2 + s1;
			//Wait for one second
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			  }
			}
			//Increment the ones place second digit
			s1++;
	
		}
		
	}

}
