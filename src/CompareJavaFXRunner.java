// Java program to create a combo box and add event handler to it 
import java.util.Arrays;

import javafx.application.Application; 
import javafx.scene.Scene; 
import javafx.scene.control.*; 
import javafx.scene.layout.*; 
import javafx.event.ActionEvent; 
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.collections.*; 
import javafx.stage.Stage; 

public class CorrelationApplication extends Application { 

	// Launch the application 
	public void start(Stage stage) throws Exception 
	{ 
		// Set title for the stage 
		stage.setTitle("Food Data Correlation with Health Outcome Explorer"); 

		// Create a tile pane 
		//TilePane r = new TilePane(); 

		//Create comparison table.
		Comparison test= new Comparison("DataDownload.xls");
		DeathCodeReader dcr=new DeathCodeReader("NCHS_Causes_of_Death.csv");
		
		
		
		// Get list of food variable names values.
		String foodVariables[] = test.variableNames.values().toArray(new String[test.variableNames.size()]);
		Arrays.sort(foodVariables);
		
		// Create a combo box 
		ComboBox<String> combo_box_foodVariables = 
					new ComboBox<String>(FXCollections 
							.observableArrayList(foodVariables)); 
		
		// Get list of death years.
		String deathYears[] = dcr.listDeathYears().toArray(new String[dcr.listDeathYears().size()]);
		Arrays.sort(deathYears);
		
		// Create a combo box 
		ComboBox<String> combo_box_deathYears = 
					new ComboBox<String>(FXCollections 
							.observableArrayList(deathYears)); 
		
		// Get list of death types.
		String deathTypes[] = dcr.listCauseDeath().toArray(new String[dcr.listCauseDeath().size()]);
		Arrays.sort(deathTypes);

		// Create a combo box 
		ComboBox<String> combo_box_deathTypes = 
					new ComboBox<String>(FXCollections 
							.observableArrayList(deathTypes)); 

		// Label to display the selected menu item 
		Label select_foodvariable = new Label("Select food related variable of interest");
		Label select_deathtype = new Label("Select health related variable of interest");
		Label select_deathyear = new Label("Select health year of interest"); 
		Label answer = new Label("Correlation to be calculated");
		
		answer.setAlignment(Pos.CENTER);
		answer.setStyle("-fx-border-color: #000; -fx-padding: 5px;");
		
		// Create action event 
		//TODO: Handle non-selected box
		EventHandler<ActionEvent> event = 
				new EventHandler<ActionEvent>() { 
			public void handle(ActionEvent e) 
			{ 
				String selectedFoodValue = combo_box_foodVariables.getValue().toString();
				String selectedFoodKey = "Key Not Found";
				for (String key : test.variableNames.keySet()) {
				    if (selectedFoodValue.equals(test.variableNames.get(key))) {
				    	selectedFoodKey = key;
				    }
				}
				Double correlationValue = test.calculatePearson(test.stateValuesMapForVariable(selectedFoodKey), 
									dcr.computeAvgDeath(combo_box_deathYears.getValue().toString(), combo_box_deathTypes.getValue().toString()));
				//display answer
				answer.setText("Pearson's correlation: "+ correlationValue.toString());
			} 
		}; 

		
		//Create submit button
		Button submit = new Button("Submit");
		
		submit.setOnAction(event);

		// Create a tile pane 
		TilePane tile_pane = new TilePane(select_foodvariable, combo_box_foodVariables, select_deathtype, combo_box_deathTypes, select_deathyear, combo_box_deathYears, submit, answer); 

		// Create a scene 
		Scene scene = new Scene(tile_pane, 500, 500); 

		// Set the scene 
		stage.setScene(scene); 
		stage.show(); 
	} 

	public static void main(String args[]) 
	{ 
		// Launch the application 
		launch(args); 
	} 
} 
