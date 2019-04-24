
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * 
 * @author: Mark Pichler
 * @pid: A11456292
 * 
 * @about: The name of this program is Chrono-Lane.  It's a program developed 
 *         to help swim coaches manage the lap times of multiple swimmers
 *         across multiple lanes.  The user is given the option to enter the
 *         amount of lanes they intend to keep track of (1 to 8).  They are
 *         then presented with a series of timers, each with their own thread.
 *         The user can start and stop each timer individually.
 *         Future plans for this program are to add a reset and lap number
 *         option for each timer.
 *         Programmed in Java Eclipse  
 *
 */
public class ChronoLane extends Application{
	final double POOL_HEIGHT = 75, POOL_WIDTH = 200;
	final double MENU_SPACING = 10, LANE_NUM_SPACING = 25;
	final double TIMES_SPACING = 33, STARTS_SPACING = 20;
	final double STOPS_SPACING = 20;
	String fieldLanesString = null;
	int laneNum;
	int inc;
	
	
	//The labels displaying the stopwatch times
	Label time1 = new Label("");
	Label time2 = new Label("");
	Label time3 = new Label("");
	Label time4 = new Label("");
	Label time5 = new Label("");
	Label time6 = new Label("");
	Label time7 = new Label("");
	Label time8 = new Label("");
	
	
	//The labels displaying the name of each lane
	Label lane1 = new Label("Lane 1");
	Label lane2 = new Label("Lane 2");
	Label lane3 = new Label("Lane 3");
	Label lane4 = new Label("Lane 4");
	Label lane5 = new Label("Lane 5");
	Label lane6 = new Label("Lane 6");
	Label lane7 = new Label("Lane 7");
	Label lane8 = new Label("Lane 8");
	
	
	//The Timer objects used in the PressStart and PressStop objects
    Timer timOb1 = new Timer();
	Timer timOb2 = new Timer();
	Timer timOb3 = new Timer();
	Timer timOb4 = new Timer();
	Timer timOb5 = new Timer();
	Timer timOb6 = new Timer();
	Timer timOb7 = new Timer();
	Timer timOb8 = new Timer();
	
	
	//The PressStart objects used to handle the "Start"
	//button events
	PressStart s1 = new PressStart(timOb1);
	PressStart s2 = new PressStart(timOb2);
	PressStart s3 = new PressStart(timOb3);
	PressStart s4 = new PressStart(timOb4);
	PressStart s5 = new PressStart(timOb5);
	PressStart s6 = new PressStart(timOb6);
	PressStart s7 = new PressStart(timOb7);
	PressStart s8 = new PressStart(timOb8);
	
	
	//The PressStop objects used to handle the "Stop"
    //button events
	PressStop stp1 = new PressStop(timOb1);
	PressStop stp2 = new PressStop(timOb2);
	PressStop stp3 = new PressStop(timOb3);
	PressStop stp4 = new PressStop(timOb4);
	PressStop stp5 = new PressStop(timOb5);
	PressStop stp6 = new PressStop(timOb6);
	PressStop stp7 = new PressStop(timOb7);
	PressStop stp8 = new PressStop(timOb8);
	
	
	//The "Start" buttons
	Button tStart1 = new Button("Start");
	Button tStart2 = new Button("Start");
	Button tStart3 = new Button("Start");
	Button tStart4 = new Button("Start");
	Button tStart5 = new Button("Start");
	Button tStart6 = new Button("Start");
	Button tStart7 = new Button("Start");
	Button tStart8 = new Button("Start");
	
	
	//The "Stop" buttons
	Button tStop1 = new Button("Stop");
	Button tStop2 = new Button("Stop");
	Button tStop3 = new Button("Stop");
	Button tStop4 = new Button("Stop");
	Button tStop5 = new Button("Stop");
	Button tStop6 = new Button("Stop");
	Button tStop7 = new Button("Stop");
	Button tStop8 = new Button("Stop");
	

	
	
	@Override
	/**
	 * This is the inherited method from extending the class Application.
	 * It contains the code that is executed when launch() is executed in
	 * main().
	 * 
	 * @param primaryStage 
	 */
	public void start(Stage primaryStage) throws Exception {
		
		
		//Alert Boxes
		Alert noNum = new Alert(AlertType.ERROR);
		Alert rangeNum = new Alert(AlertType.ERROR);
		noNum.setTitle("Error");
		noNum.setHeaderText("Number of Lanes not Entered");
		noNum.setContentText("Please Enter your desired Number of Lanes");
		rangeNum.setTitle("Error");
		rangeNum.setHeaderText("Not a Valid Number");
		rangeNum.setContentText("Please enter a Number between 1 and 8");
		
		
		
		
		//This Timeline is used to update the time text Labels in real time
		//every second.
		Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000),
		        ae -> {
		        	time1.setText(timOb1.time); 
		            time2.setText(timOb2.time);
		            time3.setText(timOb3.time);
		            time4.setText(timOb4.time);
		            time5.setText(timOb5.time);
		            time6.setText(timOb6.time);
		            time7.setText(timOb7.time);
		            time8.setText(timOb8.time);
		            }));
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
		
		
	
		
		//Call the event handlers for the "Start" buttons
		tStart1.setOnAction(s1);
		tStart2.setOnAction(s2);
		tStart3.setOnAction(s3);
		tStart4.setOnAction(s4);
		tStart5.setOnAction(s5);
		tStart6.setOnAction(s6);
		tStart7.setOnAction(s7);
		tStart8.setOnAction(s8);
		
		
		//Call the event handlers for the "Stop" buttons
		tStop1.setOnAction(stp1);
		tStop2.setOnAction(stp2);
		tStop3.setOnAction(stp3);
		tStop4.setOnAction(stp4);
		tStop5.setOnAction(stp5);
		tStop6.setOnAction(stp6);
		tStop7.setOnAction(stp7);
		tStop8.setOnAction(stp8);
		
		
	
		
		TextField fieldLanes = new TextField();
		
		fieldLanes.setAlignment(Pos.CENTER);
		fieldLanes.setMaxWidth(50);
		

		Button beginBut = new Button("Begin");
		beginBut.setMaxWidth(100);
		
		
		//The event handler for the main "Begin" button.
		beginBut.setOnAction(e -> {
			fieldLanesString = fieldLanes.getText();
			//Error check if the user does not enter a number
		    try {
			    laneNum = Integer.parseInt(fieldLanesString);
		    } catch(Exception NumberFormatException) {
		    	noNum.showAndWait();
		    	return;	
		    }
		    
		    //Error check if the user does enter a number between 1 and 8
		    if(laneNum > 8 | laneNum <= 0) {
		    	rangeNum.showAndWait();
		    	return;
		    }
		    
		    primaryStage.hide();
		    HBox laneNums = new HBox();
		    HBox times = new HBox();
		    HBox starts = new HBox();
		    HBox stops = new HBox();
		    VBox lanes = new VBox();
		   
		    //Determine if the user chooses 1 through 8 lanes
		    //and create the number of stopwatches
		    if(laneNum == 1) {
		    	
		    	laneNums.getChildren().add(lane1);
		    	times.getChildren().add(time1);
		    	starts.getChildren().add(tStart1);
		    	stops.getChildren().add(tStop1);
		    	
		    	
		    }else if(laneNum == 2) {
		    	laneNums.getChildren().addAll(lane1, lane2);
		    	times.getChildren().addAll(time1, time2);
		    	starts.getChildren().addAll(tStart1, tStart2);
		    	stops.getChildren().addAll(tStop1, tStop2);
		    	
		    }else if(laneNum == 3) {
		    	laneNums.getChildren().addAll(lane1, lane2, lane3);
		    	times.getChildren().addAll(time1, time2, time3);
		    	starts.getChildren().addAll(tStart1, tStart2, tStart3);
		    	stops.getChildren().addAll(tStop1, tStop2, tStop3);
		    	
		    }else if(laneNum == 4) {
		    	laneNums.getChildren().addAll(lane1, lane2, lane3, lane4);
		    	times.getChildren().addAll(time1, time2, time3, time4);
		    	starts.getChildren().addAll(tStart1, tStart2, tStart3, tStart4);
		    	stops.getChildren().addAll(tStop1, tStop2, tStop3, tStop4);
		    	
		    	
		    }else if(laneNum == 5) {
		    	laneNums.getChildren().addAll(lane1, lane2, lane3, lane4, 
		    			                      lane5);
		    	times.getChildren().addAll(time1, time2, time3, time4, 
		    			                   time5);
		    	starts.getChildren().addAll(tStart1, tStart2, tStart3, tStart4, 
		    			                    tStart5);
		    	stops.getChildren().addAll(tStop1, tStop2, tStop3, tStop4, 
		    			                   tStop5);
		    	
		    }else if(laneNum == 6) {
		    	
		    	laneNums.getChildren().addAll(lane1, lane2, lane3, lane4, 
		    			                      lane5, lane6);
		    	times.getChildren().addAll(time1, time2, time3, time4, 
		    			                   time5, time6);
		    	starts.getChildren().addAll(tStart1, tStart2, tStart3, tStart4, 
		    			                    tStart5, tStart6);
		    	stops.getChildren().addAll(tStop1, tStop2, tStop3, tStop4, 
		    			                   tStop5, tStop6);
		    	
		    	
		    }else if(laneNum == 7) {
		    	
		    	laneNums.getChildren().addAll(lane1, lane2, lane3, lane4, 
		    			                      lane5, lane6, lane7);
		    	times.getChildren().addAll(time1, time2, time3, time4, 
		    			                   time5, time6, time7);
		    	starts.getChildren().addAll(tStart1, tStart2, tStart3, tStart4, 
		    			                    tStart5, tStart6, tStart7);
		    	stops.getChildren().addAll(tStop1, tStop2, tStop3, tStop4, 
		    			                   tStop5, tStop6, tStop7);
		    	
		    }else if(laneNum == 8) {
		    	
		    	laneNums.getChildren().addAll(lane1, lane2, lane3, lane4, 
		    			                      lane5, lane6, lane7, lane8);
		    	times.getChildren().addAll(time1, time2, time3, time4, 
		    			                   time5, time6, time7, time8);
		    	starts.getChildren().addAll(tStart1, tStart2, tStart3, tStart4, 
		    			                    tStart5, tStart6, tStart7, tStart8);
		    	stops.getChildren().addAll(tStop1, tStop2, tStop3, tStop4, 
		    			                   tStop5, tStop6, tStop7, tStop8);
		    	
		    }
		    laneNums.setAlignment(Pos.CENTER);
		    times.setAlignment(Pos.CENTER);
		    starts.setAlignment(Pos.CENTER);
		    stops.setAlignment(Pos.CENTER);
		    
		    laneNums.setSpacing(LANE_NUM_SPACING);
		    times.setSpacing(TIMES_SPACING);
		    starts.setSpacing(STARTS_SPACING);
		    stops.setSpacing(STOPS_SPACING);
		    
		    lanes.getChildren().addAll(laneNums, times, starts, stops);
		    lanes.setSpacing(10);
		    
		    Scene laneScene = new Scene(lanes);
		    
			Stage pool = new Stage();
			pool.setTitle("Chrono-Lane");
			pool.setMinHeight(POOL_HEIGHT);
			pool.setMinWidth(POOL_WIDTH);
			pool.setResizable(false);
			pool.setScene(laneScene);
			pool.show();
			
			
		});
		
		//Main window title label
		Label title = new Label("          Welcome to Chrono-Lane! \n" + 
				                "Enter the Number of Lanes in your Pool \n" +
						        "                      (1 to 8 Lanes)");
		VBox menu = new VBox();
		menu.setAlignment(Pos.CENTER);
		menu.getChildren().addAll(title, fieldLanes, beginBut);
		Insets menuPad = new Insets(10, 10, 10, 10);
		menu.setPadding(menuPad);
		menu.setSpacing(MENU_SPACING);
		
		
		Scene intro = new Scene(menu);
		primaryStage.setTitle("Chrono-Lane");
		primaryStage.setScene(intro);
		primaryStage.setResizable(false);
		primaryStage.show();
		
	}
	
	/**
     * The main() method contains the launch() method inherited from 
     * Application which initializes the start() method.  
     * @param args
     */
	public static void main(String[] args) {
		launch(args);
		
	}
}