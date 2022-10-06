// Assignment #: 6
//         Name: Suvan Kumar
//    StudentID: 1221910898
//      Lecture: MWF 10:10 - 11am
//  Description: The AircraftPane class creates the Add Aircraft tab
//				 as well as dealing with the interactions from the user. 

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import java.util.Random;

//There are 4 (FOUR) tasks to be completed in this file - Look for COMPLETED: keywords
//COMPLETED: 1. Build the GUI
//COMPLETED: 2. Write "Random" Button Handler
//COMPLETED: 3. "Add New Aircraft" button handler - Check for valid input before adding the new Aircraft to the list:
//COMPLETED: 4. Update rightTextArea with updated information from aircraftList
public class AircraftPane extends HBox {
	// COMPLETED: contains a list of aircrafts
	ArrayList<Aircraft> aircraftList;

	// COMPLETED: Save current Aircraft Type
	String selectedAircraftType;


	// COMPLETED: Main layout components
	TextArea rightTextArea;
	VBox leftVBox;
	ComboBox<String> aircraftTypeComboBox;
	ImageView imageView;

	// COMPLETED 1. a) "Declare" (Do not "initialize" them yet!!!)
	// ONE GridPane to hold
	// FOUR Labels (Name, Bomb Carrying Capacity, Attack Power, Stealth Index),
	// FOUR corresponding TextFields
	// ONE "Random" Button
	// vvvvvv 1. a) vvvvvv (about 8-12 lines)

	GridPane inputPane;
	Label name, bombCarryingCapacity, attackPower, stealthIndex;
	TextField nameText, bombCarryingCapacityText, attackPowerText, stealthIndexText;
	Button random;

	// ^^^^^^ 1. a) ^^^^^^
	
	
	// COMPLETED 1. b) "Declare" (Do not "initialize" them yet!!!)
	// ONE "Add New Aircraft!!!" Button
	// ONE red Label to display add aircraft status.
	// vvvvvv 1. b) vvvvvv (about 2 lines)
	
	Button newAircraft;
	Label aircraftStatus;

	// ^^^^^^ 1. b) ^^^^^^
	
	// COMPLETED: Define window size
	public static final int WINSIZE_X = 1000, WINSIZE_Y = 600;


	// Constructor - what to do when AircraftPane is first created
	public AircraftPane(ArrayList<Aircraft> aircraftList) {

		// COMPLETED: Assign the aircraftList passed into this constructor
		this.aircraftList = aircraftList;

		// COMPLETED: Initialize main layout components
		this.leftVBox = new VBox();
		this.rightTextArea = new TextArea();
		
		// COMPLETED: Setting up ComboBox
		String[] aircraftType = { "Fighter Jet", "Bomber - Propeller Type", "Bomber - Jet Type", "Combat Helicopter" };
		aircraftTypeComboBox = new ComboBox<String>();
		aircraftTypeComboBox.setValue("Select Aircraft Type");
		aircraftTypeComboBox.getItems().addAll(aircraftType);
		aircraftTypeComboBox.setOnAction(new AircraftTypeComboBoxHandler());
		leftVBox.getChildren().add(aircraftTypeComboBox);
		rightTextArea.setEditable(false);
		
		// COMPLETED 1. a) Initialize the instance variables
		// This is where you use the "new" keyword
		// vvvvvv 1. a) vvvvvv (about 8-12 lines)
		inputPane = new GridPane();
		name = new Label("Name");
		bombCarryingCapacity = new Label("Bomb Carrying Capacity");
		attackPower = new Label("Attack Power");
		stealthIndex = new Label("Stealth Index");
		nameText = new TextField();
		bombCarryingCapacityText = new TextField();
		attackPowerText = new TextField();
		stealthIndexText = new TextField();
		stealthIndexText.setEditable(false);
		random = new Button("Random");


		// ^^^^^^ 1. a) ^^^^^^

		
		// COMPLETED 1. b) Initialize the instance variables and set Label color to RED
		// vvvvvv 1. b) vvvvvv (about 3 lines)

		newAircraft = new Button("Add New Aircraft!!!");
		aircraftStatus = new Label("Aircraft Status");
		aircraftStatus.setTextFill(Color.RED);


		// ^^^^^^ 1. b) ^^^^^^
		
		// COMPLETED 1. c) Organize Labels, TextFields, and Button onto the GridPane
		// vvvvvv 1. c) vvvvvv (about 8-12 lines)
		inputPane.add(name, 0, 0);
		inputPane.add(bombCarryingCapacity, 0, 1);
		inputPane.add(attackPower, 0, 2);
		inputPane.add(stealthIndex, 0, 3);
		inputPane.add(nameText, 1, 0);
		inputPane.add(bombCarryingCapacityText, 1, 1);
		inputPane.add(attackPowerText, 1, 2);
		inputPane.add(stealthIndexText, 1, 3);
		inputPane.add(random, 2, 3);
		// ^^^^^^ 1. c) ^^^^^^

		
		
		// COMPLETED: 1. d) Bind buttons to their handlers (RandomButtonHandler and AddNewAircraftButtonHandler)
		// vvvvvv 1. d) vvvvvv (about 2 lines)

		random.setOnAction(new RandomButtonHandler());
		newAircraft.setOnAction(new AddNewAircraftButtonHandler());

		// ^^^^^^ 1. d) ^^^^^^
		

		
		// COMPLETED: 1. e) Add GridPane, “Add Aircraft” Button, and red Label to leftVBox
		// vvvvvv 1. e) vvvvvv (about 1-3 lines)

		leftVBox.getChildren().addAll(inputPane, newAircraft, aircraftStatus);

		// ^^^^^^ 1. e) ^^^^^^



		// COMPLETED: VBox layout alignment
		inputPane.setHgap(20);
		leftVBox.setPadding(new Insets(40, 50, 0, 50));
		leftVBox.setSpacing(40);
		leftVBox.setAlignment(Pos.TOP_CENTER);
		leftVBox.setPrefWidth(WINSIZE_X / 2);

		// COMPLETED: Setting up ImageView
		imageView = new ImageView();
		imageView.setPreserveRatio(true);
		imageView.setFitWidth(100);
		leftVBox.getChildren().add(imageView);
		FileInputStream input;
		try {
			input = new FileInputStream("fighter jet.png");
			Image image = new Image(input);
			imageView.setImage(image);
		} catch (FileNotFoundException e) {
			imageView.setImage(null);
		}
		
		// COMPLETED: Add main components to "Add Aircraft" tab
		this.getChildren().addAll(leftVBox, rightTextArea);
	}

	// We have finished setting up the GUI for Add Aircraft tab, let's move on to the
	// logic/back-end side!
	// Writing handlers
	
	// Generate random stealth index value (1 <= stealthIndex <= 10)
	private class RandomButtonHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent event) {
			// COMPLETED: 2. Write "Random" Button Handler
			// vvvvvv 2. vvvvvv (about 8-12 lines)
			if (stealthIndexText.getText().isEmpty()) {
				Random rand = new Random();
				int randomNum = rand.nextInt((10 - 1) + 1) + 1; 
				stealthIndexText.setText(String.valueOf(randomNum));
			}
			else {
				aircraftStatus.setText("Stealth index is already generated");
			}

			// ^^^^^^ 2. ^^^^^^

		}
	}


	// COMPLETED 3. "Add New Aircraft" button handler - Check for valid input before adding the new Aircraft to the list
	private class AddNewAircraftButtonHandler implements EventHandler<ActionEvent> {

		// This method will be called once we click the button
		public void handle(ActionEvent event) {

			// COMPLETED 3. a) Create 4 String variables and assign them to the values retrieved from TextFields using .getText()
			// vvvvvv 3. a) vvvvvv (about 4 lines)
			String nameResult = nameText.getText();
			String capacityResult = bombCarryingCapacityText.getText();
			String powerResult = attackPowerText.getText();
			String stealthResult = stealthIndexText.getText();

			// ^^^^^^ 3. a) ^^^^^^

			// "Always sanitize user input"
			// You need to make sure the input is valid, for example:
			// 		- Not empty 
			// 		- In the correct format (String, Integer, Double, etc)
			//  	- Satisfied all input requirement (non-negative, between a range, etc) 
			// Use this try/catch block AND "throw new Exception()" to handle invalid input
			try {
				
				// EXAMPLE: When the aircraft type is not selected
				if (selectedAircraftType == null) {
					// When you throw a new Exception, the program STOPS immediately 
					// and SKIPS to the catch{} block, so the lines below will NOT execute.
					// Check out the catch{} block below
					throw new Exception("Aircraft type is not yet selected");
				}

				// COMPLETED: 3. b) If one of the TextFields is empty, throw exception with
				// error message: "At least one of the text fields is empty"
				// vvvvvv 3. b) vvvvvv (about 4 lines)
				if (nameResult.isEmpty() || capacityResult.isEmpty() || powerResult.isEmpty() || stealthResult.isEmpty()) {
					throw new Exception("At least one of the text fields is empty");
				}

				// ^^^^^^ 3. b) ^^^^^^


				// COMPLETED: 3. c) Loop through aircraftList to check for aircraft that has the same name; throw exception with
				// error message: "Aircaft existed!"
				// vvvvvv 3. c) vvvvvv (about 5 lines)
				for (int i = 0; i < aircraftList.size(); i++) {
					if (aircraftList.get(i).contains(nameResult)) {
						throw new Exception("Aircraft existed!");
					}
				}

				// ^^^^^^ 3. c) ^^^^^^

				
				// COMPLETED: 3. d) Now try to parse Bomb Carrying Capacity, Attack Power, and Stealth Index to integers 
				// The parseInt method will automatically throw error for you if the input is not in the integer format
				// Create 3 integers and convert the Strings from 3. a)
				// vvvvvv 3. d) vvvvvv (about 3 lines)
				int bombCapacity = Integer.valueOf(capacityResult);
				int powerNum = Integer.valueOf(powerResult);
				int stealthNum = Integer.valueOf(stealthResult);

				// ^^^^^^ 3. d) ^^^^^^
				
				// COMPLETED: 3. e) Check if Bomb Carrying Capacity or Attack Power is a negative number
				// if so, throw exception with error message "Both Bomb Carrying Capacity and Attack Power must be positive numbers"
				// vvvvvv 3. e) vvvvvv (about 3 lines)

				if (bombCapacity < 0 || powerNum < 0) {
					throw new Exception("Both Bomb Carrying Capacity and Attack Power must be positive numbers");
				}

				// ^^^^^^ 3. e) ^^^^^^


				// COMPLETED: 3. f) Check if the sum of Carrying Capacity and Attack Power exceeds 5000. 
				// If so, throw exception with error message "The sum of Carrying Capacity and Attack Power must be less or equal to 5000"
				// vvvvvv 3. f) vvvvvv (about 3 lines)
				
				if ((bombCapacity + powerNum) > 5000) {
					throw new Exception("The sum of Carrying Capacity and Attack Power must be less or equal to 5000");
				}

				// ^^^^^^ 3. f) ^^^^^^

				
				
				// COMPLETED: 3. g) Input is valid, now create new Aircraft object (remember to check out Aircraft.java file)
				// with data from user input. Don't forget "selectedAircraftType"
				// Finally, add the newly created aircraft to aircraftList
				// vvvvvv 3. g) vvvvvv (about 2-8 lines, depends on your implementation)
				
				aircraftList.add(new Aircraft(stealthResult, nameResult, bombCapacity, powerNum, stealthNum));

				// ^^^^^^ 3. g) ^^^^^^

				
				// COMPLETED 3: Set the Red Label to "Aircraft added successfully" and empty all TextFields
				// vvvvvv 3. h) vvvvvv (about 5 lines)
				
				aircraftStatus.setText("Aircraft added successfully");
				nameText.clear();
				bombCarryingCapacityText.clear();
				attackPowerText.clear();
				stealthIndexText.clear();

				
				// ^^^^^^ 3. h) ^^^^^^

				// COMPLETED 4. b) Call updateTextArea() to update aircrafts list
				// vvvvvv 4. b) vvvvvv (1 line)
				
				updateTextArea();

				// ^^^^^^ 4. b) ^^^^^^

			} catch (NumberFormatException exception) {
				// set RED LABEL to "At least one of the text fields is in the incorrect format"
				// vvvvvv 3. d) vvvvvv (1 line)
				 
				aircraftStatus.setText("At least one of the text fields is in the incorrect format");

				// ^^^^^^ 3. d) ^^^^^^

			} catch (Exception exception) {
				// COMPLETED: 3. b) The message that we passed in "throw new Exception(MESSAGE);" above
				//			can be retrieved using exception.getMessage()
				// Set the value of the RED LABEL to exception.getMessage() to display error message 
				// vvvvvv 3. b) vvvvvv (1 line)
				
				aircraftStatus.setText(exception.getMessage());

				// ^^^^^^ 3. b) ^^^^^^

			}

		}
	}

	// COMPLETED 4. a) Create a String containing all aircraft information
	// and loop through aircraftList to add all aircrafts' data together
	private void updateTextArea() {
		// vvvvvv 4. a) vvvvvv (about 5-10 lines)

		String aircraftInfo = "";
		for (int i = 0; i < aircraftList.size(); i++) {
			aircraftInfo = aircraftInfo + aircraftList.get(i).toString();
		}
		rightTextArea.setText(aircraftInfo);
		// ^^^^^^ 4. a) ^^^^^^
	}
	
	
	// Completed: AircraftTypeComboBoxHandler - You don't need to modify this handler
	private class AircraftTypeComboBoxHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			selectedAircraftType = aircraftTypeComboBox.getSelectionModel().getSelectedItem();
			FileInputStream input;
			try {
				input = new FileInputStream(selectedAircraftType.toLowerCase() + ".png");
				Image image = new Image(input);
				imageView.setImage(image);
			} catch (FileNotFoundException e) {
				imageView.setImage(null);
			}

		}
	}


}