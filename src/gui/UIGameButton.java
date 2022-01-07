package gui;

import Main.BattleShipMain;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;


public class UIGameButton extends ImageView {
	
	private boolean Allstate = false;
	
	public UIGameButton(Stage stage , String allimage,  double X , double Y , Pane root) {
		
		super();
		this.setTranslateX(X);
		this.setTranslateY(Y);
		setImage(new Image(ClassLoader.getSystemResource(allimage).toString()));
				
		AllMenuButton.ui.setTranslateX(900);
		AllMenuButton.ui.setTranslateY(860);
		
		AllMenuButton.music.setTranslateX(650);
		AllMenuButton.music.setTranslateY(860);

		root.getChildren().addAll(this,AllMenuButton.ui,AllMenuButton.music);
		
		AllMenuButton.music.setState(false);
		AllMenuButton.music.setImage(new Image(ClassLoader.getSystemResource("offmusicimage.png").toString()));
		
		AllMenuButton.ui.setVisible(false);
		AllMenuButton.music.setVisible(false);
		
		/////// MENU BUTTON ////////
		StateButton btnBack = new StateButton("MainMenuButton.png","OnMainMenuButton.png","MainMenuButton.png","OnMainMenuButton.png", 630 ,Y + 40,true);
		btnBack.setOnMouseClicked(event -> { BattleShipMain.StartPane(stage); 
			AllMenuButton.ui.setClick(new AudioClip(ClassLoader.getSystemResource("click.mp3").toString()));
			AllMenuButton.ui.getClick().play(); 
			AllMenuButton.music.getSong().stop(); 
		});
		
		
		StateButton btnExit = new StateButton("smallExitButton.png","smallOnExitButton.png", "smallExitButton.png", "smallOnExitButton.png", 882 , Y + 40 , true);
		btnExit.setOnMouseClicked(event -> { 
			AllMenuButton.ui.setClick(new AudioClip(ClassLoader.getSystemResource("click.mp3").toString()));
			AllMenuButton.ui.getClick().play(); 
			stage.close(); 
			});
		
		root.getChildren().addAll(btnBack,btnExit);	
		
		//////// SETTING /////////
		setOnMouseClicked(event -> {
			if(!Allstate) {
				AllMenuButton.ui.setVisible(true);
				AllMenuButton.music.setVisible(true);
				btnBack.setVisible(false);
				btnExit.setVisible(false);
				Allstate = true;
				if(AllMenuButton.ui.isState()) {
					AllMenuButton.ui.setClick(new AudioClip(ClassLoader.getSystemResource("click.mp3").toString()));
				}
				else {
					AllMenuButton.ui.setClick(new AudioClip(ClassLoader.getSystemResource("silence.mp3").toString()));
				}
				AllMenuButton.ui.getClick().play();
			}
			else {
				AllMenuButton.ui.setVisible(false);
				AllMenuButton.music.setVisible(false);
				btnBack.setVisible(true);
				btnExit.setVisible(true);
				Allstate = false;
				if(AllMenuButton.ui.isState()) {
					AllMenuButton.ui.setClick(new AudioClip(ClassLoader.getSystemResource("click.mp3").toString()));
				}
				else {
					AllMenuButton.ui.setClick(new AudioClip(ClassLoader.getSystemResource("silence.mp3").toString()));
				}
				AllMenuButton.ui.getClick().play();
			}
		});			
			
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
				AllMenuButton.music.getSong().stop();
				AllMenuButton.music.setState(false);
				if(AllMenuButton.ui.isState()) {
					AllMenuButton.ui.setClick(new AudioClip(ClassLoader.getSystemResource("click.mp3").toString()));
				}
				else {
					AllMenuButton.ui.setClick(new AudioClip(ClassLoader.getSystemResource("silence.mp3").toString()));
				}
				AllMenuButton.ui.getClick().play();
			}
			else {
				AllMenuButton.music.setImage(new Image(ClassLoader.getSystemResource("musicimage.png").toString()));
				AllMenuButton.music.getSong().play();	
				AllMenuButton.music.setState(true);
				if(AllMenuButton.ui.isState()) {
					AllMenuButton.ui.setClick(new AudioClip(ClassLoader.getSystemResource("click.mp3").toString()));
				}
				else {
					AllMenuButton.ui.setClick(new AudioClip(ClassLoader.getSystemResource("silence.mp3").toString()));
				}
				AllMenuButton.ui.getClick().play();
			}
		});
		
		
	}	
}

