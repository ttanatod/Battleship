package gui;

import Entity.HorizontalDestroy;
import Entity.Ship01;
import Entity.Ship02;
import Entity.Ship03;
import Entity.Ship04;
import Entity.VerticalDestroy;
import Entity.Base.BaseShip;
import Entity.Base.Skill;
import Exception.NoShipSelectedException;
import Main.BattleShipMain;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import logic.GameController;
import logic.Player;

public class FieldCell extends Pane {
	private BaseShip baseShip;
	private boolean alreadyHit;
	private String deathImageUrl;
	private BaseShip ship;
	private AudioClip bomb = new AudioClip(ClassLoader.getSystemResource("bomb.mp3").toString());
	
	public FieldCell() {
		super();
		this.setPrefHeight(60);
		this.setPrefWidth(60);
		this.setMinHeight(60);
		this.setMinWidth(60);
		this.setPadding(new Insets(5));
		this.setBackgroundSeaCell();

		this.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				onClickHandler();
			}
		});
		
		bomb.setVolume(0.4);
		alreadyHit = false;
	}

	public void setBackgroundSeaCell() {
		Image bg = new Image(ClassLoader.getSystemResource("sea.png").toString());
		this.setBackgroundWithImage(bg);
	}

	public void setBackgroundAlreadyHitCell() {
		// TODO set sea picture
		Image donthit = new Image(ClassLoader.getSystemResource("hitalready.png").toString());
		this.setBackgroundWithImage(donthit);
	}

	private void setBackgroundWithImage(Image image) {
		BackgroundFill bgFill = new BackgroundFill(Color.AQUA, CornerRadii.EMPTY, Insets.EMPTY);
		BackgroundFill[] bgFillA = { bgFill };
		BackgroundSize bgSize = new BackgroundSize(60, 60, false, false, false, false);
		BackgroundImage bgImg = new BackgroundImage(image, null, null, null, bgSize);
		BackgroundImage[] bgImgA = { bgImg };
		this.setBackground(new Background(bgFillA, bgImgA));
	}

	private void setBackgroundShipIsAttacked() { // TODO set cross picture
		Image donthit = new Image(ClassLoader.getSystemResource("hit.png").toString());
		this.setBackgroundWithImage(donthit);
	}

	private void onClickHandler() {
		/*
		 * TODO 2 phase buy_phase attack_phase buy_phase: same as lab5
		 * 
		 * attack_phase: click to attack
		 * 
		 */
//		GameController.gameUpdate();
		if (GameController.getGamePhase() == "Player 1 : Preparation Phase" || GameController.getGamePhase() == "Player 2 : Preparation Phase") { // prepare phase
																													
			try {
				if(GameController.getSelectedGameButton() != null) {
					ship = (BaseShip) GameController.getSelectedGameButton().getButtonContent();
				}
				else {
					throw new NoShipSelectedException();
				}
			} catch (NoShipSelectedException e) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("NoSelectedShip");
				if (GameController.getGamePhase() == "Player 1 : Preparation Phase") {
					alert.setContentText("Player1 select ship please");
				}
				else {
					alert.setContentText("Player2 select ship please");
				}
				alert.setHeaderText(null);
				alert.show();
			}

			if (GameController.getPlayerOfThisFieldPane(this) == GameController.getAtkPlayer()) {
				if (this.baseShip == null/* && baseShip.canPlace(this) */) {
					if (ship instanceof Ship01) {
						this.baseShip = new Ship01();
						Image image = new Image(baseShip.getUrl().get(0));
						setBackgroundWithImage(image);
						GameController.getAtkPlayer().decreaseInStock(ship);
						this.deathImageUrl = "deadship0.png";
					} 
					
					else if (ship instanceof Ship02) {
						this.baseShip = new Ship02();
						Image image = new Image(baseShip.getUrl().get(0));
						setBackgroundWithImage(image);
						GameController.getAtkPlayer().decreaseInStock(ship);
						this.deathImageUrl = "deadship1.png";
					} 
					
					else if (ship instanceof Ship03) {
						this.baseShip = new Ship03();
						if (baseShip.canPlace(this)) {

							Image image1 = new Image(baseShip.getUrl().get(0));
							Image image2 = new Image(baseShip.getUrl().get(1));

							this.setBackgroundWithImage(image1);
							GameController.getFieldPane(this).getNextCell(this).setBackgroundWithImage(image2);
							GameController.getFieldPane(this).getNextCell(this).setBaseShip(this.baseShip);
							GameController.getAtkPlayer().decreaseInStock(ship);
							
							/////
							this.deathImageUrl = "deadship21.png";
                            GameController.getFieldPane(this).getNextCell(this).setDeathImageUrl("deadship22.png");

						} else {

							this.baseShip = null;
						}
					} 
					
					else if (ship instanceof Ship04) {
						this.baseShip = new Ship04();
						if (baseShip.canPlace(this)) {

							Image image1 = new Image(baseShip.getUrl().get(0));
							Image image2 = new Image(baseShip.getUrl().get(1));
							Image image3 = new Image(baseShip.getUrl().get(2));

							this.setBackgroundWithImage(image1);
							GameController.getFieldPane(this).getNextCell(this).setBackgroundWithImage(image2);
							GameController.getFieldPane(this)
									.getNextCell(GameController.getFieldPane(this).getNextCell(this))
									.setBackgroundWithImage(image3);
							GameController.getFieldPane(this).getNextCell(this).setBaseShip(this.baseShip);
							GameController.getFieldPane(this)
									.getNextCell(GameController.getFieldPane(this).getNextCell(this))
									.setBaseShip(this.baseShip);
							GameController.getAtkPlayer().decreaseInStock(ship);
							
							this.deathImageUrl = "deadship31.png";
                            GameController.getFieldPane(this).getNextCell(this).setDeathImageUrl("deadship32.png");
                            GameController.getFieldPane(this)
                            .getNextCell(GameController.getFieldPane(this).getNextCell(this))
                            .setDeathImageUrl("deadship33.png");
                            
						} else {
							this.baseShip = null;
						}
					}
//					GameController.gameUpdate();
					if(AllMenuButton.ui.isState()) {
						AllMenuButton.ui.getClick().play();
					}
				}
			}
		} else if ( (GameController.getGamePhase() == "Player 1 : Attack Phase" || GameController.getGamePhase() == "Player 2 : Attack Phase") && (GameController.getPlayerOfThisFieldPane(this) == GameController.getDefPlayer()) ) { // play phase
//			System.out.println("Click");
			AllMenuButton.ui.setClick(bomb);
			if (GameController.getSelectedGameButton() != null) {
//				System.out.println("skill");
				Skill skill = (Skill) GameController.getSelectedGameButton().getButtonContent();
				skill.useSkill(this, GameController.getAtkPlayer(), GameController.getDefPlayer());
				
				GameController.getAtkPlayer().setAlreadyUseSkill(skill);
				if(AllMenuButton.ui.isState()) {
					AllMenuButton.ui.getClick().play();
				}
				GameController.nextPhase();
				GameController.nextTurn();
			} else if (!alreadyHit) {
//				System.out.println("hit");
				this.isAttacked();
				GameController.getAtkPlayer().decreaseCooldown();
				GameController.nextPhase();
				GameController.nextTurn();
				if(AllMenuButton.ui.isState()) {
					AllMenuButton.ui.getClick().play();
				}
				
			
			}
		}
		GameController.gameUpdate();
	}

	public void isAttacked() {
		
		if (baseShip == null) {
			this.setBackgroundAlreadyHitCell();
			alreadyHit = true;
		} else {
			if (baseShip.isAttacked()) {
				setBackgroundShipIsAttacked();
				alreadyHit = true;
			//	baseShip.decreaseHp();
//				System.out.println(baseShip.getHp());
				if(baseShip.isDead()) {
					GameController.getPlayerOfThisFieldPane(this).decreaseShip();
				}
			} else {
				Image image = new Image(baseShip.getUrl().get(0));
				setBackgroundWithImage(image);
			}
		}
	}

	public BaseShip getBaseShip() {
		return baseShip;
	}

	
	
	public boolean isAlreadyHit() {
		return alreadyHit;
	}

	public void setBaseShip(BaseShip baseShip) {
		this.baseShip = baseShip;
	}
	
	public String getDeathImageUrl() {
		return deathImageUrl;
    }

    public void setDeathImageUrl(String deathImageUrl) {
        this.deathImageUrl = deathImageUrl;
    }

    public void setBackgroundDeathImage() {
        Image image = new Image(deathImageUrl);
        this.setBackgroundWithImage(image);
    }
}
