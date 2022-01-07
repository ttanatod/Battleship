package gui;

import Main.BattleShipMain;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;


public class AllMenuButton extends ImageView {
	
	private boolean Allstate = false;
	public static StateButton ui;
	public static StateButton music;
	
	public AllMenuButton(Stage stage , String allimage,  double X , double Y , Pane root) {
		
		super();
		this.setTranslateX(X);
		this.setTranslateY(Y);
		setImage(new Image(ClassLoader.getSystemResource(allimage).toString()));
		ui = new StateButton("uiimage.png", "uiimage.png", "offuiimage.png", "offuiimage.png", X, Y - 150,true);
		music = new StateButton("musicimage.png", "musicimage.png", "offmusicimage.png", "offmusicimage.png" , X, Y - 300,true);
		music.setState(false);
		music.setImage(new Image(ClassLoader.getSystemResource("offmusicimage.png").toString()));
		root.getChildren().addAll(this,ui,music);
		ui.setVisible(false);
		music.setVisible(false);
		
		//////// SETTING /////////
		setOnMouseClicked(event -> {
			if(!Allstate) {
				ui.setVisible(true);
				music.setVisible(true);
				Allstate = true;
				ui.getClick().play();
			}
			else {
				ui.setVisible(false);
				music.setVisible(false);
				Allstate = false;
				ui.getClick().play();
			}
		});	
		
		/////// MENU BUTTON ////////
		StateButton btnStart = new StateButton("StartButton.png","OnStartButton.png","StartButton.png","OnStartButton.png",700,520,true);
		btnStart.setOnMouseClicked(event -> { BattleShipMain.PrepareGame(stage); ui.getClick().play(); music.getSong().stop();});
		
		StateButton btnHTP = new StateButton("HTPButton.png","OnHTPButton.png","HTPButton.png","OnHTPButton.png", 700,690 , true);
		btnHTP.setOnMouseClicked(event -> { ui.getClick().play(); BattleShipMain.HowToPlay(BattleShipMain.stage2); });
		
		StateButton btnExit = new StateButton("ExitButton.png","OnExitButton.png", "ExitButton.png", "OnExitButton.png", 700, 860 , true);
		btnExit.setOnMouseClicked(event -> { ui.getClick().play(); stage.close(); });
		
		root.getChildren().addAll(btnStart,btnHTP,btnExit);	
			
		/////// UI ///////
		ui.setOnMouseClicked(event -> {
			if(ui.isState()) {
				ui.setImage(new Image(ClassLoader.getSystemResource("offuiimage.png").toString()));
				ui.setClick(new AudioClip(ClassLoader.getSystemResource("silence.mp3").toString()));
				ui.setState(false);
			}
			else {
				ui.setImage(new Image(ClassLoader.getSystemResource("uiimage.png").toString()));
				ui.setClick(new AudioClip(ClassLoader.getSystemResource("click.mp3").toString()));
				ui.getClick().play();	
				ui.setState(true);
			}
		});
		
		/////// MUSIC ///////
		music.setOnMouseClicked(event -> {
			if(music.isState()) {
				music.setImage(new Image(ClassLoader.getSystemResource("offmusicimage.png").toString()));
				music.getSong().stop();
				music.setState(false);
				ui.getClick().play();
			}
			else {
				music.setImage(new Image(ClassLoader.getSystemResource("musicimage.png").toString()));
				music.getSong().play();	
				music.setState(true);
				ui.getClick().play();
			}
		});
		
		
	}	
}

