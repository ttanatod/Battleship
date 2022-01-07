package Main;


import gui.AllMenuButton;
import gui.ShipPane;
import gui.SkillPane;
import gui.UIGameButton;
import gui.WinnerButton;
import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import logic.GameController;

public class BattleShipMain extends Application {
	
	public static Label label01;
	public static Label label11;
	public static Label label21;
	public static Label label31;
	
	public static Label label02;
	public static Label label12;
	public static Label label22;
	public static Label label32;
	
	public static ShipPane shippane1;
	public static ShipPane shippane2;
	
	public static SkillPane skillpane1;
	public static SkillPane skillpane2;
	
	public static ImageView Phase;
	
	public static Label Player1Ship;
	public static Label Player2Ship;
	
	public static Label Cooldown1;
	public static Label Cooldown2;
	
	public static Image prepare1;
	public static Image prepare2;
	public static Image attack1;
	public static Image attack2;
	
	public static boolean player1win;
	public static boolean player2win;
	
	public static Stage stage2;
	
	public static void Winner(Stage stage) { 
		stage.setTitle("Winner"); 
		Pane WinnerPane = new Pane();
		WinnerPane.setPrefSize(1920, 1080);
		
		ImageView bg = new ImageView(new Image(ClassLoader.getSystemResource("GameMenu.png").toString()));
		WinnerPane.getChildren().add(bg);	
		
		new WinnerButton(stage, "setting.png", 1600, 850, WinnerPane);
		
		if(player1win) {
			ImageView p1w = new ImageView(new Image(ClassLoader.getSystemResource("p1w.png").toString()));
			p1w.setX(160);
			p1w.setY(250);
			WinnerPane.getChildren().add(p1w);	
		}
		else {
			ImageView p2w = new ImageView(new Image(ClassLoader.getSystemResource("p2w.png").toString()));
			p2w.setX(160);
			p2w.setY(250);
			WinnerPane.getChildren().add(p2w);	
		}
	
		
		Scene WinnerScene = new Scene(WinnerPane);
		stage.setScene(WinnerScene);
		stage.setResizable(false);
		stage.sizeToScene();
		stage.setMaximized(true);
		stage.show();
	}
	
	public static void PrepareGame(Stage stage) {
		Pane PreparePane = new Pane();
		PreparePane.setPrefSize(1920, 1080);
		stage2 = stage;
		
		/////// Background ////////
		ImageView bg = new ImageView(new Image(ClassLoader.getSystemResource("GameMenu.png").toString()));
		PreparePane.getChildren().add(bg);	
		
		/////// Moving Background ////////
//		MediaPlayer bg = new MediaPlayer(new Media(ClassLoader.getSystemResource("water.mp4").toString()));
//		bg.play();
//		MediaView bgv = new MediaView(bg);
//		bgv.setFitHeight(1080);
//		bgv.setFitWidth(1920);
//		PreparePane.getChildren().add(bgv);

		AllMenuButton.music.getSong().play();
		
		new GameController();
		new UIGameButton(stage, "setting.png", 1150, 840, PreparePane);
		
		////// PHASE //////
		prepare1 = new Image(ClassLoader.getSystemResource("prepare1.png").toString());
		prepare2 = new Image(ClassLoader.getSystemResource("prepare2.png").toString());
		attack1 = new Image(ClassLoader.getSystemResource("attack1.png").toString());
		attack2 = new Image(ClassLoader.getSystemResource("attack2.png").toString());
		Phase = new ImageView(prepare1);
		Phase.setTranslateX(150);
		Phase.setTranslateY(50);
		PreparePane.getChildren().add(Phase);
		
		////// PLAYER1 //////
		GameController.getPlayer1().getFieldPane().setTranslateX(400);
		GameController.getPlayer1().getFieldPane().setTranslateY(300);
		
		label01 = new Label(GameController.getPlayer1().getMyShipInStock().get(0).toString() + "x");
		label01.setFont(new Font(80));
		label01.setTranslateX(150);
		label01.setTranslateY(300);
		label01.setTextFill(Color.WHITE);
		
		label11 = new Label(GameController.getPlayer1().getMyShipInStock().get(1).toString() + "x");
		label11.setFont(new Font(80));
		label11.setTranslateX(150);
		label11.setTranslateY(430);
		label11.setTextFill(Color.WHITE);
		
		label21 = new Label(GameController.getPlayer1().getMyShipInStock().get(2).toString() + "x");
		label21.setFont(new Font(80));
		label21.setTranslateX(150);
		label21.setTranslateY(560);
		label21.setTextFill(Color.WHITE);
		
		label31 = new Label(GameController.getPlayer1().getMyShipInStock().get(3).toString() + "x");
		label31.setFont(new Font(80));
		label31.setTranslateX(150);
		label31.setTranslateY(690);
		label31.setTextFill(Color.WHITE);
		
		Player1Ship = new Label("Ship Left : " + GameController.getPlayer1().getNumberOfShip());
		Player1Ship.setFont(new Font(60));
		Player1Ship.setTranslateX(50);
		Player1Ship.setTranslateY(720);
		Player1Ship.setTextFill(Color.WHITE);
		Player1Ship.setVisible(false);
		
		Cooldown1 = new Label("Cd : " + GameController.getPlayer1().getCooldown());
		Cooldown1.setFont(new Font(60));
		Cooldown1.setTranslateX(130);
		Cooldown1.setTranslateY(300);
		Cooldown1.setTextFill(Color.WHITE);
		Cooldown1.setVisible(false);
		
		shippane1 = new ShipPane(GameController.getPlayer1());
		shippane1.setTranslateX(250);
		shippane1.setTranslateY(300);
		
		skillpane1 = new SkillPane(GameController.getPlayer1());
		skillpane1.setTranslateX(140);
		skillpane1.setTranslateY(400);
		skillpane1.setVisible(false);
		
		////// PLAYER2 //////
		GameController.getPlayer2().getFieldPane().setTranslateX(1000);
		GameController.getPlayer2().getFieldPane().setTranslateY(300);
		
		label02 = new Label("x" + GameController.getPlayer2().getMyShipInStock().get(0).toString());
		label02.setFont(new Font(80));
		label02.setTranslateX(1705);
		label02.setTranslateY(300);
		label02.setTextFill(Color.WHITE);
		
		label12 = new Label("x" + GameController.getPlayer2().getMyShipInStock().get(1).toString());
		label12.setFont(new Font(80));
		label12.setTranslateX(1705);
		label12.setTranslateY(430);
		label12.setTextFill(Color.WHITE);
		
		label22 = new Label("x" + GameController.getPlayer2().getMyShipInStock().get(2).toString());
		label22.setFont(new Font(80));
		label22.setTranslateX(1705);
		label22.setTranslateY(560);
		label22.setTextFill(Color.WHITE);
		
		label32 = new Label("x" + GameController.getPlayer2().getMyShipInStock().get(3).toString());
		label32.setFont(new Font(80));
		label32.setTranslateX(1705);
		label32.setTranslateY(690);
		label32.setTextFill(Color.WHITE);
		
		Player2Ship = new Label("Ship Left : " + GameController.getPlayer1().getNumberOfShip());
		Player2Ship.setFont(new Font(60));
		Player2Ship.setTranslateX(1555);
		Player2Ship.setTranslateY(720);
		Player2Ship.setTextFill(Color.WHITE);
		Player2Ship.setVisible(false);
		
		Cooldown2 = new Label("Cd : " + GameController.getPlayer2().getCooldown());
		Cooldown2.setFont(new Font(60));
		Cooldown2.setTranslateX(1615);
		Cooldown2.setTranslateY(300);
		Cooldown2.setTextFill(Color.WHITE);
		Cooldown2.setVisible(false);
		
		shippane2 = new ShipPane(GameController.getPlayer2());
		shippane2.setTranslateX(1555);
		shippane2.setTranslateY(300);
		
		skillpane2 = new SkillPane(GameController.getPlayer2());
		skillpane2.setTranslateX(1635);
		skillpane2.setTranslateY(400);
		skillpane2.setVisible(false);
		
		PreparePane.getChildren().addAll(GameController.getPlayer1().getFieldPane(),GameController.getPlayer2().getFieldPane(),shippane1,shippane2,skillpane1,skillpane2);
		PreparePane.getChildren().addAll(label01,label11,label21,label31,label02,label12,label22,label32,Player1Ship,Player2Ship);
		PreparePane.getChildren().addAll(Cooldown1,Cooldown2);
		
		Scene PrepareScene = new Scene(PreparePane);
		stage.setScene(PrepareScene);
		stage.setMaximized(true);
		stage.setResizable(false);
		
		stage.show();
	}
	
	public static void HowToPlay(Stage stage) {
		Pane HTPpane = new Pane();
		HTPpane.setPrefSize(1920, 1080);
		AudioClip click = new AudioClip(ClassLoader.getSystemResource("click.mp3").toString());
		ImageView background = new ImageView(new Image(ClassLoader.getSystemResource("GameMenu.png").toString()));
		
		ImageView HTP1 = new ImageView(new Image(ClassLoader.getSystemResource("htp1prepare.jpg").toString()));
		ImageView HTP2 = new ImageView(new Image(ClassLoader.getSystemResource("htp2prepare.jpg").toString()));
		ImageView HTP3 = new ImageView(new Image(ClassLoader.getSystemResource("htp1atk1.jpg").toString()));
		ImageView HTP4 = new ImageView(new Image(ClassLoader.getSystemResource("htp2atk1.jpg").toString()));
		ImageView next1 = new ImageView(new Image(ClassLoader.getSystemResource("next.png").toString()));
		ImageView next2 = new ImageView(new Image(ClassLoader.getSystemResource("next.png").toString()));
		ImageView next3 = new ImageView(new Image(ClassLoader.getSystemResource("next.png").toString()));
		ImageView next4 = new ImageView(new Image(ClassLoader.getSystemResource("next.png").toString()));
		
		HTPpane.getChildren().addAll(background,HTP1,next1);
		
		next1.setX(1600);
		next1.setY(850);
		next2.setX(1600);
		next2.setY(850);
		next3.setX(1600);
		next3.setY(850);
		next4.setX(1600);
		next4.setY(850);

		next1.setOnMouseClicked(e->{
			HTPpane.getChildren().removeAll(HTP1,next1);
			click.play();
			HTPpane.getChildren().addAll(HTP2,next2);
		});
		next2.setOnMouseClicked(e->{
			HTPpane.getChildren().removeAll(HTP2,next2);
			click.play();
			HTPpane.getChildren().addAll(HTP3,next3);
		});
		next3.setOnMouseClicked(e->{
			HTPpane.getChildren().removeAll(HTP3,next3);
			click.play();
			HTPpane.getChildren().addAll(HTP4,next4);
		});
		next4.setOnMouseClicked(e->{
			HTPpane.getChildren().removeAll(HTP4,next4);
			click.play();
			StartPane(stage);
		});
		
		
		
		Scene HTPscene = new Scene(HTPpane);
		stage.setScene(HTPscene);
		stage.setMaximized(true);
		stage.setResizable(false);
		stage.show();
	}
	
	public static void StartPane(Stage stage) {
		
		stage2 = stage;
		
		Pane StartPane = new Pane();
		Scene StartScene = new Scene(StartPane,1920,1080);
		stage.setScene(StartScene);
		stage.setResizable(false);
		stage.sizeToScene();
		stage.setMaximized(true);
		stage.show();
		
		ImageView bg = new ImageView(new Image(ClassLoader.getSystemResource("GameMenu.png").toString()));
		StartPane.getChildren().add(bg);	
		
		ImageView tb01 = new ImageView(new Image(ClassLoader.getSystemResource("tb01.png").toString()));
		tb01.setX(200);
		tb01.setY(150);
		StartPane.getChildren().add(tb01);
		
		new AllMenuButton(stage,"setting.png", 1600, 850, StartPane);
		
	}
	
	@Override
	public void start(Stage StartStage) throws Exception {
		StartStage.setTitle("Battleship");
        StartPane(StartStage);
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
