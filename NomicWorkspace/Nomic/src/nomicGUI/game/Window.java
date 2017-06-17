package nomicGUI.game;

import java.util.Observable;
import java.util.Observer;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.Game;
import nomicGUI.game.input.SuggestRule;

public class Window extends Application implements Observer{
	
	
	Stage stage;
	HBox playersInfo;
	VBox rules;
	int player;
	int state = 0;
	BorderPane gameLayout;
	PlayerInputPane inputPane;

	final int SUGGEST_RULE = 0;
	final int VOTE = 1;
	final int WHAIT = 2;
	
	Game game;
	

	@Override
	public void start(Stage stage) throws Exception {
		
		this.stage = stage;
		
		stage.setTitle("Nomic(Moderator)");
		Scene launcher = createLauncher();		
		stage.setScene(launcher);
		stage.show();
	}

	private void createGame() {
		
		player = 0;
		playersInfo = new HBox(5);
		rules = new VBox(10);
		
		game = new Game();
		game.addObserver(this);
		game.addPlayer();
		
		PlayerInputPane inputPane = new PlayerInputPane(game, player);
		
		
		
			
			
		
		
		BorderPane gameLayout = new BorderPane();
		gameLayout.setTop(playersInfo);
		gameLayout.setCenter(rules());
		gameLayout.setRight(testCase());
		gameLayout.setBottom(inputPane);
		
		Scene gameScene = new Scene(gameLayout, 500, 500);
		
		
		stage.setScene(gameScene);
		
	}

	private GridPane testCase() {
		
		Button addPlayerButton = new Button("Add Player");
		addPlayerButton.setOnAction(e->game.addPlayer());
		
		Button nextPlayerButton = new Button("Next Player");
		nextPlayerButton.setOnAction((e->game.nextPlayer()));
		
		TextField playerToRemove = new TextField();
		playerToRemove.setMaxWidth(75);
		playerToRemove.setPromptText("Player to remove");
		
		Button removePlayerButton = new Button("Remove Player");
		removePlayerButton.setOnAction(e->game.removePlayer(Integer.parseInt(playerToRemove.getText())));
		
		Button changeStateButton = new Button("Change state");
		changeStateButton.setOnAction(e->{gameLayout.setBottom(inputPane.getState(1));});
		GridPane.setConstraints(changeStateButton, 1, 3);
		
		TextField ruleToSetActive = new TextField();
		ruleToSetActive.setMaxWidth(75);
		ruleToSetActive.setPromptText("Set Active");
		
		Button setRuleActive = new Button("Set Active");
		setRuleActive.setOnAction(e->game.setRuleActive(Integer.parseInt(ruleToSetActive.getText()),true));
		GridPane.setConstraints(ruleToSetActive, 0, 2);
		GridPane.setConstraints(setRuleActive, 1, 2);
		
		GridPane testCaseLayout = new GridPane();
		testCaseLayout.setVgap(10);
		testCaseLayout.setHgap(10);
		GridPane.setConstraints(addPlayerButton, 0, 0);
		GridPane.setConstraints(nextPlayerButton, 1, 0);
		GridPane.setConstraints(playerToRemove, 0, 1);
		GridPane.setConstraints(removePlayerButton, 1, 1);	
		
		testCaseLayout.setAlignment(Pos.CENTER);
		testCaseLayout.getChildren().addAll(addPlayerButton, nextPlayerButton, playerToRemove, removePlayerButton, changeStateButton, ruleToSetActive, setRuleActive);
		return testCaseLayout;
	}

	@Override
	public void update(Observable o, Object arg) {
		playersInfo.getChildren().clear();
		for(int i = 0; i<game.playerList.size();i++){
			playersInfo.getChildren().add(playerInfo(i));
		}
		rules.getChildren().clear();
		for(int i = 0; i<game.rules.size();i++){
			Label rule = ruleLabel(game.rules.get(i).toString());
			if(game.rules.get(i).isActive()){
				rule.setTextFill(Color.web("#000000"));
			}else{
				rule.setTextFill(Color.web("#bcbcbc"));
			}
			rules.getChildren().add(rule);
		}
		
	}
	
	public static void main(String[] args){	
		launch();	
	}
	
	private Scene createLauncher(){
		Button createButton = new Button("Create Game");
		Button joinButton = new Button("Join Game");
		createButton.setOnAction(e->createGame());
		
		HBox hBox = new HBox(10);
		hBox.getChildren().addAll(createButton, joinButton);
		hBox.setAlignment(Pos.CENTER);
	
		BorderPane layout = new BorderPane();
		layout.setPadding(new Insets(15,10,15,10));
		layout.setBottom(hBox);
		layout.setCenter(new Label("What do you want to do?"));
		
		return new Scene(layout, 300, 150);
	}
	
	private VBox playerInfo(int player){
		Label name;
		VBox playerInfoLayout = new VBox(5);
		if(player==this.player){
			name = new Label("You");
		}else{
			name = new Label(game.playerList.get(player).getName());
		}
		if(player==game.getCurrentPlayer()){
			playerInfoLayout.setStyle("-fx-background-color: #ececec;");
		}
		Label score = new Label("Score: " + game.playerList.get(player).getScore());
		playerInfoLayout.setPadding(new Insets(10, 10, 10, 10));
		playerInfoLayout.getChildren().addAll(name, score);
		return playerInfoLayout;
	
	}
	
	private Label ruleLabel(String theRule){
		Label label = new Label(theRule);
		label.setFont(new Font(18));
		label.setWrapText(true);
		label.setMaxWidth(250);
		label.setAlignment(Pos.TOP_LEFT);
		label.setPadding(new Insets(10, 10, 10, 10));
		return label;
	}
	
	private ScrollPane rules(){
		ScrollPane rules = new ScrollPane();
		rules.setHbarPolicy(ScrollBarPolicy.NEVER);
		rules.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		rules.setContent(this.rules);
		return rules;
	}
}
