package gui;

import javafx.animation.Animation;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class StateButton extends ImageView {
	
	private boolean state;
	private AudioClip song = new AudioClip(ClassLoader.getSystemResource("future.mp3").toString());
	private AudioClip click = new AudioClip(ClassLoader.getSystemResource("click.mp3").toString());
	
	public StateButton(String image,String highlightimage, String offimage , String highlightoffimage , double X,double Y , boolean State) {
		super();
		song.setVolume(0.6);
		song.setCycleCount(Animation.INDEFINITE);
		setImage(new Image(ClassLoader.getSystemResource(image).toString()));
		setTranslateX(X);
		setTranslateY(Y);
		
		this.state = State;
		
		setOnMouseEntered(event -> {
			if(state) {
				setImage(new Image(ClassLoader.getSystemResource(highlightimage).toString()));
			}
			else {
				setImage(new Image(ClassLoader.getSystemResource(highlightoffimage).toString()));
			}
		});
		
		setOnMouseExited(event -> {
			if(state) {
				setImage(new Image(ClassLoader.getSystemResource(image).toString()));
			}
			else {
				setImage(new Image(ClassLoader.getSystemResource(offimage).toString()));
			}
		}); 
	}


	public AudioClip getSong() {
		return song;
	}



	public void setSong(AudioClip song) {
		this.song = song;
	}



	public AudioClip getClick() {
		return click;
	}



	public void setClick(AudioClip click) {
		this.click = click;
	}



	public void setState(boolean state) {
		this.state = state;
	}

	public boolean isState() {
		return state;
	}
}
