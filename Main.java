// Assignment #: 6
//         Name: Suvan Kumar
//    StudentID: 1221910898
//      Lecture: MWF 10:10 - 11am
//Description: The Assignment6 class creates a TabPane Pane with
//           two tabs, one for adding Aircrafts and one for
//           creating a fleet

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.StackPane;
import java.util.ArrayList;

public class Main extends Application {
 private TabPane tabPane;
 private AircraftPane aircraftPane;
 private FleetPane fleetPane;
 private ArrayList<Aircraft> aircraftList;
 public static final int WINSIZE_X = 1000, WINSIZE_Y = 600;


 public void start(Stage stage) {
     StackPane root = new StackPane();
     
     // aircraftList to be used in all tabs
     Aircraft defaultVal = new Aircraft("Mig-29", "FighterJet", 90, 1425, 6);
     aircraftList = new ArrayList<Aircraft>();
     aircraftList.add(defaultVal);
     aircraftPane = new AircraftPane(aircraftList);
     fleetPane = new FleetPane(aircraftList);


     tabPane = new TabPane();

     Tab tab1 = new Tab();
     tab1.setText("Add Aircraft");
     tab1.setContent(aircraftPane);

     Tab tab2 = new Tab();
     tab2.setText("Create Fleet");
     tab2.setContent(fleetPane);

     tabPane.getSelectionModel().select(0);
     tabPane.getTabs().addAll(tab1, tab2);

     root.getChildren().add(tabPane);

     Scene scene = new Scene(root, WINSIZE_X, WINSIZE_Y);
     stage.setTitle("Create your fleet!");
     stage.setScene(scene);
     stage.show();
 }

 public static void main(String[] args) {
     launch(args);
 }
}