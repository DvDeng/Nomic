package nomicGUI.game;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import model.Game;
import model.Player;

public class PlayerInputPane extends Pane {
	
	Game game;
	int player;
	int state;
	
	public PlayerInputPane(Game game, int player){
		this.game = game;
		this.player = player;
		this.getChildren().add(getState(0));
	}

	private HBox suggestRule() {	
		
		HBox layout = new HBox();

		TextArea ruleSuggestionArea = new TextArea();
		ruleSuggestionArea.setPromptText("Suggest rule");
		ruleSuggestionArea.setWrapText(true );
		ruleSuggestionArea.setMaxWidth(250);
		ruleSuggestionArea.setMaxHeight(100);
		Button suggestRuleButton = new Button("Suggest");
		suggestRuleButton.setOnAction(e->game.addRule(ruleSuggestionArea.getText()));
		suggestRuleButton.setAlignment(Pos.BASELINE_LEFT);
		GridPane.setConstraints(ruleSuggestionArea, 0, 0);
		GridPane.setConstraints(suggestRuleButton, 1, 0);
		layout.setAlignment(Pos.CENTER);
		layout.setPadding(new Insets(15, 10, 15, 10));
		layout.setSpacing(10);
		layout.getChildren().addAll(ruleSuggestionArea, suggestRuleButton);
	
		return layout;
	}
	
	private Pane voteView(){
		
		Label instruction = new Label("Vote yes or no for this rule");
//		instruction.setFont();
		
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setMaxHeight(100);
		scrollPane.setMinHeight(100);
		scrollPane.setMaxWidth(250);
		scrollPane.setMinWidth(250);
		Label suggestion = new Label(game.getCurrentSuggestion().toString());
		suggestion.setMaxWidth(100);
		suggestion.setWrapText(true);
		scrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);
		scrollPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		scrollPane.setContent(suggestion);
		
		Button yesButton = new Button("Vote yes");
		Button noButton = new Button("Vote no");
		yesButton.setOnAction(e->game.vote(game.playerList.get(player), true));
		noButton.setOnAction(e->game.vote(game.playerList.get(player), false));
		HBox options = new HBox(10);
		options.setPadding(new Insets(15, 10, 15, 10));
		options.getChildren().addAll(yesButton, noButton);
		options.setAlignment(Pos.CENTER);
		
		VBox layout = new VBox(10);
		layout.setStyle("-fx-background-color: #ececec;");
		layout.getChildren().addAll(instruction, scrollPane, options);
		return layout;
	}
	
	private StackPane waitView(){
		
		Label message = new Label(game.playerList.get(game.getCurrentPlayer()).getName() + " is currently taking their turn, wait for them to finish!");
		StackPane layout = new StackPane();
		layout.getChildren().add(message);
		return layout;
	
	}
	
	public Pane getState(int i){
		
		return suggestRule();
		
//		if(i == 0){
//			return waitView();
//		}else if(i == 1){
//			return suggestRule();
//		}else if(i == 2){
//			return voteView();
//		}
//		else return null;
	}
	
}
