import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * 
 * @author: Mark Pichler
 * @pid: A11456292
 * 
 * @about: This is the Event Handling class that executes when the 
 *         "Start" button is pressed in ChronoLane.  This class takes
 *         in a Timer object as a constructor and creates and starts
 *         a thread when "Start" is pressed to start the timer.
 *         A current bug is the user is still allowed to press the
 *         "Start" button multiple times in a row which creates numerous
 *         active thread, thus affecting the time output. 
 *
 */
public class PressStart implements EventHandler<ActionEvent> {
	
	Timer t;
	Thread time;
	
	public PressStart(Timer t){
		this.t = t;
	}
	
	public void handle(ActionEvent e) {
		this.t.go = true;
		time = new Thread(this.t);
	    time.start();
		 
	}

}

