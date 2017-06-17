package nomicGUI.game.input;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import model.Game;

public class SuggestRule extends HBox{

	TextArea ruleSuggestionArea;
	Button suggestRuleButton;
	public SuggestRule(Game game) {	
		// TODO Auto-generated constructor stub
		ruleSuggestionArea = new TextArea();
		ruleSuggestionArea.setPromptText("Suggest rule");
		ruleSuggestionArea.setWrapText(true );
		ruleSuggestionArea.setMaxWidth(250);
		ruleSuggestionArea.setMaxHeight(100);
		suggestRuleButton = new Button("Suggest");
		suggestRuleButton.setOnAction(e->game.addRule(ruleSuggestionArea.getText()));
		suggestRuleButton.setAlignment(Pos.BASELINE_LEFT);
		GridPane.setConstraints(ruleSuggestionArea, 0, 0);
		GridPane.setConstraints(suggestRuleButton, 1, 0);
		this.setAlignment(Pos.CENTER);
		this.setPadding(new Insets(15, 10, 15, 10));
		this.setSpacing(10);
		this.getChildren().addAll(ruleSuggestionArea, suggestRuleButton);
	}
	
	public HBox getLayout(){
		return this;
	}
	
}
