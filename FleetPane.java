// Assignment #: 6
//         Name: Suvan Kumar
//    StudentID: 1221910898
//      Lecture: MWF 10:10 - 11am
//  Description: ADD THIS

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class FleetPane extends BorderPane {
	// COMPLETED: contains a list of aircrafts
	ArrayList<Aircraft> aircraftList;
	
	// COMPLETED: Variables containing fleet Stealth Index, Bomb Carrying Capacity, and Attack Power
	int totalStealthIndex = 0;
	int totalBombCarryingCapacity = 0;
	int totalAttackPower = 0;

	
	// COMPLETED 5. a) "Declare" (Do not "initialize" them yet!!!)
	// ONE Label to display Fleet information
	// ONE VBox to contain CheckBoxes
	// ONE "Load Aircrafts/Clear Selection" Button
	// vvvvvv 5. a) vvvvvv (about 3 lines)
	
	Label fleetInformation;
	VBox checkBoxes;
	Button loadAircrafts; 

	// ^^^^^^ 5. a) ^^^^^^

	public FleetPane(ArrayList<Aircraft> aircraftList) {
		this.aircraftList = aircraftList;

		// COMPLETED 5. a) Initialize the instance variables
		// This is where you use the "new" keyword
		// vvvvvv 5. a) vvvvvv (about 3 lines)
		fleetInformation = new Label("Select aircrafts to add to your fleet");
		checkBoxes = new VBox();
		loadAircrafts = new Button("Load Aircrafts/Clear Selection");

		// ^^^^^^ 5. a) ^^^^^^

		// COMPLETED: 5. b) Bind "Load Aircrafts/Clear Selection" Button to its handler
		// vvvvvv 5. b) vvvvvv (1 line)
		
		loadAircrafts.setOnAction(new LoadAircraftsButtonHandler());

		// ^^^^^^ 5. b) ^^^^^^
		
		// COMPLETED: 5. c) Organize components to their positions on BorderPane
		// Remeber that THIS class "is"/extends BorderPane, use BorderPane syntax to add components
		// vvvvvv 5. c) vvvvvv (1 line)
		
		this.setTop(fleetInformation);
		this.setCenter(checkBoxes);
		this.setBottom(loadAircrafts);

		// ^^^^^^ 5. c) ^^^^^^

	}
	
	private class LoadAircraftsButtonHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			
			// COMPLETED: 6. Clear the VBox (1 line)
			// vvvvvv 6. a) vvvvvv (1 line)
			
			checkBoxes.getChildren().clear();

			// ^^^^^^ 6. a) ^^^^^^


			// TODO: 6. b), c), d)  
			// vvvvvv 6. b), c), d) vvvvvv (about 5-8 lines)
			
			/*totalAttackPower = 0;
			totalBombCarryingCapacity = 0;
			totalStealthIndex = 0; */
			for (int i = 0; i < aircraftList.size(); i++) {
				CheckBox addNew = new CheckBox(aircraftList.get(i).toString());
				addNew.setOnAction(new CheckBoxHandler(aircraftList.get(i)));
				checkBoxes.getChildren().add(addNew);
			}

			// ^^^^^^ 6. b), c), d) ^^^^^^

		}
	}

	private class CheckBoxHandler implements EventHandler<ActionEvent> {

		Aircraft aircraft;
		
		// When creating a new CheckBoxHandler, pass in a Aircraft object so it can be accessed later
		public CheckBoxHandler(Aircraft _aircraft) {
			this.aircraft = _aircraft;
		}

		@Override
		public void handle(ActionEvent event) {
			// COMPLETED: 7. a) Use event.getSource() to get the CheckBox that triggered the event, cast it to CheckBox
			// vvvvvv 7. a) vvvvvv (1 line)
			CheckBox hello = (CheckBox) event.getSource();
			// ^^^^^^ 7. a) ^^^^^^
			
			// COMPLETED: 7. b) If the CheckBox was selected, add the current aircraft scores to totalBombCarryingCapacity, 
			// 	totalAttackPower, and totalStealthIndex. Otherwise, subtract the current aircraft scores
			// vvvvvv 7. b) vvvvvv (about 8-12 lines)
			
			if (hello.isSelected()) {
				totalAttackPower += aircraft.getAttackPower();
				totalBombCarryingCapacity += aircraft.getBombCarryingCapacity();
				totalStealthIndex += aircraft.getStealthIndex();
			}
			else {
				totalAttackPower -= aircraft.getAttackPower();
				totalBombCarryingCapacity -= aircraft.getBombCarryingCapacity();
				totalStealthIndex -= aircraft.getStealthIndex();
			}

			// ^^^^^^ 7. b) ^^^^^^

			// COMPLETED: 7. c) Set the Label to 
			// "Total Stealth Index: " + totalStealthIndex + "\t\tTotal Bomb Carrying Capacity: " + totalBombCarryingCapacity + "\tTotal Attack Power: " + totalAttackPower
			// vvvvvv 7. c) vvvvvv (1 line)
			
			fleetInformation.setText("Total Stealth Index: " + totalStealthIndex + "\t\tTotal Bomb Carrying Capacity: " + totalBombCarryingCapacity + "\t\tTotal Attack Power: " + totalAttackPower);

			// ^^^^^^ 7. c) ^^^^^^

		}
	}

}