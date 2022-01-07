package gui;

import java.util.ArrayList;

import Entity.HorizontalDestroy;
import Entity.Ship01;
import Entity.Ship02;
import Entity.Ship03;
import Entity.Ship04;
import Entity.VerticalDestroy;
import Entity.Base.BaseShip;
import Entity.Base.Skill;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import logic.GameController;
import logic.Player;

//TODO same as lab5
//TODO in method setOnAction: add stock in player to keep number of ship that need to place on the grid
//TODO setPadding width etc
public class ShipPane extends VBox {
	private ArrayList<GameButton> shipButtonList = new ArrayList<GameButton>();
	private Player player;
	
	public ShipPane(Player player) {
		super(30);
		this.setAlignment(Pos.CENTER);
		this.setPrefSize(50 , 50);
		this.setFillWidth(true);
		
		this.setBorder(new Border(new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.NONE, 
				CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		
		this.player = player;
		
		Ship01 ship1 = new Ship01();
		Ship02 ship2 = new Ship02();
		Ship03 ship3 = new Ship03();
		Ship04 ship4 = new Ship04();
		
		GameButton button1 = new GameButton(ship1);
		GameButton button2 = new GameButton(ship2);
		GameButton button3 = new GameButton(ship3);
		GameButton button4 = new GameButton(ship4);
		
		shipButtonList.add(button1);
		shipButtonList.add(button2);
		shipButtonList.add(button3);
		shipButtonList.add(button4);
		
		button1.setOnAction(event -> {	
			if(GameController.getAtkPlayer().getInStock(ship1)>0 && GameController.getAtkPlayer() == this.player){
				setSelectedButton(button1);
				if(AllMenuButton.ui.isState()) {
					AllMenuButton.ui.getClick().play();
				}
			}		
		});
		
		
		button2.setOnAction(event -> {
			if(GameController.getAtkPlayer().getInStock(ship2)>0 && GameController.getAtkPlayer() == this.player) {
				setSelectedButton(button2);
				if(AllMenuButton.ui.isState()) {
					AllMenuButton.ui.getClick().play();
				}
			}
		});
		button3.setOnAction(event -> {
			if(GameController.getAtkPlayer().getInStock(ship3)>0 && GameController.getAtkPlayer() == this.player) {
				setSelectedButton(button3);
				if(AllMenuButton.ui.isState()) {
					AllMenuButton.ui.getClick().play();
				}
			}
		});
		button4.setOnAction(event -> {
			if(GameController.getAtkPlayer().getInStock(ship4)>0 && GameController.getAtkPlayer() == this.player) {
				setSelectedButton(button4);
				if(AllMenuButton.ui.isState()) {
					AllMenuButton.ui.getClick().play();
				}
			}
		});
		
		this.getChildren().addAll(button1, button2, button3, button4);
	}
	
	public void setSelectedButton (GameButton selectedGameButton ) {
		// TODO set selectedItemButton of SimulationManager to given ItemButton
		// resetButtonsBackgroundColor and the highlight the selecteditemButton
		GameController.setSelectedGameButton(selectedGameButton);
		resetButtonsBackGroundColor();
		selectedGameButton.highlight();
	}

	public void resetButtonsBackGroundColor() {
		// TODO unhighlight each button in itemButtonList

		for (GameButton i : shipButtonList) {
			i.unhighlight();
		}
	}
}
