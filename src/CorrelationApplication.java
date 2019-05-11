// Java program to create a combo box and add event handler to it 
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.EncryptedDocumentException;

import javafx.application.Application; 
import javafx.scene.Scene; 
import javafx.scene.control.*; 
import javafx.scene.layout.*; 
import javafx.event.ActionEvent; 
import javafx.event.EventHandler; 
import javafx.collections.*; 
import javafx.stage.Stage; 
import javafx.scene.text.Text.*; 
import javafx.scene.paint.*; 
import javafx.scene.text.*; 

public class CorrelationApplication extends Application { 

	// Launch the application 
	public void start(Stage stage) throws EncryptedDocumentException, IOException 
	{ 
		// Set title for the stage 
		stage.setTitle("creating combo box "); 

		// Create a tile pane 
		TilePane r = new TilePane(); 

		// Create a label 
		Label description_label = 
						new Label("This is a combo box example "); 
		//Create comparison table.
		Comparison test= new Comparison("DataDownload.xls");
		
		// Get list of string values.
		String states[] = test.states.keySet().toArray(new String[test.states.size()]);
		Arrays.sort(states);

		// Create a combo box 
		ComboBox combo_box = 
					new ComboBox(FXCollections 
							.observableArrayList(states)); 

		// Label to display the selected menuitem 
		Label selected = new Label("default item selected"); 

		// Create action event 
		EventHandler<ActionEvent> event = 
				new EventHandler<ActionEvent>() { 
			public void handle(ActionEvent e) 
			{ 
				selected.setText(combo_box.getValue() + " selected"); 
			} 
		}; 

		// Set on action 
		combo_box.setOnAction(event); 

		// Create a tile pane 
		TilePane tile_pane = new TilePane(combo_box, selected); 

		// Create a scene 
		Scene scene = new Scene(tile_pane, 200, 200); 

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
