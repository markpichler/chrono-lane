import javafx.event.ActionEvent;
import javafx.event.EventHandler;
/**
 * 
 * @author: Mark Pichler
 * @pid: A11456292
 * 
 * @about: This is the Event Handling class that executes when the 
 *         "Stop" button is pressed in ChronoLane.  This class takes
 *         in a Timer object as a constructor and sets the boolean 
 *         variable in Timer that controls the timer to false,
 *         hence stopping the timer.  
 *
 */
public class PressStop implements EventHandler<ActionEvent>{
	Timer t;
	Thread time;
	public PressStop(Timer t){
		this.t = t;
	}

	@Override
	public void handle(ActionEvent arg0) {
		
		this.t.go = false;

	}

}
