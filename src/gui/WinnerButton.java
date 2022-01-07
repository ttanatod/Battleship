package gui;

import Main.BattleShipMain;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;


public class WinnerButton extends ImageView {
	
	private boolean Allstate = false;
	private AudioClip wrchampion = new AudioClip(ClassLoader.getSystemResource("wrchampion.mp3").toString());
	
	public WinnerButton(Stage stage , String allimage,  double X , double Y , Pane root) {
		
		super();
		this.setTranslateX(X);
		this.setTranslateY(Y);
		setImage(new Image(ClassLoader.getSystemResource(allimage).toString()));
		wrchampion.setVolume(0.3);
		wrchampion.play();
		AllMenuButton.music.setImage(new Image(ClassLoader.getSystemResource("musicimage.png").toString()));
		AllMenuButton.ui.setClick(new AudioClip(ClassLoader.getSystemResource("click.mp3").toString()));
		root.getChildren().addAll(this,AllMenuButton.ui,AllMenuButton.music);
		AllMenuButton.music.setState(true);
		//////// SETTING /////////
		setOnMouseClicked(event -> {
			if(!Allstate) {
				AllMenuButton.ui.setVisible(true);
				AllMenuButton.music.setVisible(true);
				Allstate = true;
				AllMenuButton.ui.getClick().play();
			}
			else {
				AllMenuButton.ui.setVisible(false);
				AllMenuButton.music.setVisible(false);
				Allstate = false;
				AllMenuButton.ui.getClick().play();
			}
		});	
		
		AllMenuButton.ui.setTranslateX(X);
		AllMenuButton.ui.setTranslateY(Y -150);
		
		AllMenuButton.music.setTranslateX(X);
		AllMenuButton.music.setTranslateY(Y - 300);
		
		/////// MENU BUTTON ////////
		StateButton btnStart = new StateButton("StartButton.png","OnStartButton.png","StartButton.png","OnStartButton.png",700,590,true);
		btnStart.setOnMouseClicked(event -> { BattleShipMain.PrepareGame(stage); AllMenuButton.ui.getClick().play(); wrchampion.stop();});
		
		StateButton btnExit = new StateButton("ExitButton.png","OnExitButton.png", "ExitButton.png", "OnExitButton.png", 700, 790 , true);
		btnExit.setOnMouseClicked(event -> { AllMenuButton.ui.getClick().play(); stage.close(); });
		
		root.getChildren().addAll(btnStart,btnExit);	
			
		/////// UI ///////
		AllMenuButton.ui.setOnMouseClicked(event -> {
			if(AllMenuButton.ui.isState()) {
				AllMenuButton.ui.setImage(new Image(ClassLoader.getSystemResource("offuiimage.png").toString()));
				AllMenuButton.ui.setClick(new AudioClip(ClassLoader.getSystemResource("silence.mp3").toString()));
				AllMenuButton.ui.setState(false);
			}
			else {
				AllMenuButton.ui.setImage(new Image(ClassLoader.getSystemResource("uiimage.png").toString()));
				AllMenuButton.ui.setClick(new AudioClip(ClassLoader.getSystemResource("click.mp3").toString()));
				AllMenuButton.ui.getClick().play();	
				AllMenuButton.ui.setState(true);
			}
		});
		
		/////// MUSIC ///////
		AllMenuButton.music.setOnMouseClicked(event -> {
			if(AllMenuButton.music.isState()) {
				AllMenuButton.music.setImage(new Image(ClassLoader.getSystemResource("offmusicimage.png").toString()));
				wrchampion.stop();
				AllMenuButton.music.setState(false);
				AllMenuButton.ui.getClick().play();
			}
			else {
				AllMenuButton.music.setImage(new Image(ClassLoader.getSystemResource("musicimage.png").toString()));
				wrchampion.play();	
				AllMenuButton.music.setState(true);
				AllMenuButton.ui.getClick().play();
			}
		});
		
		
	}	
}

