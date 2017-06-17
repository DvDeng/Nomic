package test;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {
	
	static boolean answer;

	public static boolean Display(String title, String message){
		
		Stage stage = new Stage();
		
		stage.setTitle(title);
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setMinWidth(250);
		stage.setOnCloseRequest(e->AlertBox.Display("Warning", "You can't close the dialog box"));
		
		Label label = new Label(message);
		Button yesButton = new Button("Yes");
		yesButton.setOnAction(e->{answer=true;stage.close();});
		Button noButton = new Button("No");
		noButton.setOnAction(e->{answer=false;stage.close();});
		
		HBox yesNo = new HBox(10);
		yesNo.getChildren().addAll(yesButton, noButton);
		yesNo.setAlignment(Pos.BOTTOM_CENTER);
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, yesNo);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		stage.setScene(scene);
		stage.showAndWait();
		
		return answer;
	}
	
}
