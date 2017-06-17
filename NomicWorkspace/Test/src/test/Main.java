package test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class Main extends Application{

	int sum = 0;

	Button add, sub;
	Button alert = new Button("Don't press this");
	Label text = new Label("Sum: 0");

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("NomicTest");
		stage.setOnCloseRequest(e->{e.consume();if(ConfirmBox.Display("Close", "Are you sure you want to close the window?")){stage.close();}});

	 	
		add = new Button("+");
		sub = new Button("-");
		add.setOnAction(e -> {sum++; text.setText("Sum: "+sum);} );
		sub.setOnAction(e -> {sum--; text.setText("Sum: "+sum);} );
		alert.setOnAction(e -> AlertBox.Display("Why?", "I told you not to clock this button"));
		
		VBox layout= new VBox();
		layout.getChildren().addAll(add, text, sub, alert);
		
		
		Scene scene = new Scene(layout, 300, 250);
		stage.setScene(scene);
		stage.show();
	}
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
