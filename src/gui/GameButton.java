package gui;

import Entity.HorizontalDestroy;
import Entity.Ship01;
import Entity.Ship02;
import Entity.Ship03;
import Entity.Ship04;
import Entity.VerticalDestroy;
import Entity.Base.BaseShip;
import Entity.Base.Buttonable;
import Entity.Base.Skill;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class GameButton extends Button {

	private Buttonable buttonContent;
	
	GameButton(Buttonable buttonable){
        // TODO complete the constructor

        super();
        this.setPadding(new Insets(9.5));

        if(buttonable instanceof Ship01) {
            this.buttonContent = new Ship01();
        } else if (buttonable instanceof Ship02) {
            this.buttonContent = new Ship02();
        }else if (buttonable instanceof Ship03) {
            this.buttonContent = new Ship03();
        }else if (buttonable instanceof Ship04) {
            this.buttonContent = new Ship04();
        }else if (buttonable instanceof HorizontalDestroy) {
            this.buttonContent = new HorizontalDestroy();
        }else if (buttonable instanceof VerticalDestroy) {
            this.buttonContent = new VerticalDestroy();
        }


        this.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        this.setBorder(new Border(new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID, 
                CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        Image image = new Image(buttonContent.getTotalImageUrl());
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(80);
        imageView.setFitWidth(80);
        if(buttonable instanceof VerticalDestroy || buttonable instanceof HorizontalDestroy) {
        	imageView.setFitHeight(120);
            imageView.setFitWidth(120);
        }
        this.setGraphic(imageView);
    }
	
	
	public void highlight() {
		// TODO 
		this.setBackground(new Background(new BackgroundFill(Color.LIMEGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
	}
	
	public void unhighlight() {
		// TODO
		this.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
	}
	
	// TODO GETTER
	
	

	public Buttonable getButtonContent() {
		return buttonContent;
	}

}
//TODO cancel skill button after selected