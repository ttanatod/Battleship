package logic;

import java.util.ArrayList;
import Main.BattleShipMain;
import gui.FieldCell;
import gui.FieldPane;
import gui.GameButton;
import javafx.stage.Stage;

public class GameController {
	//TODO useSkill(FieldCell, player1, player2) player1 skill is use player2.getFieldPane().getRow(FieldCell).
	//TODO if ship == 0 set win
	//TODO for all in fieldPane call isAlive if not call p1.decreaseShip fieldcell.shipremove()
	//TODO shipButton -> already place  disable button 
	private static String gamePhase;
	private static Player player1;
	private static Player player2;
	
	private static Player atkPlayer;
	private static Player defPlayer;
		
	private static GameButton selectedGameButton;
	
	public GameController() {
		player1 = new Player();
		player2 = new Player();
		gamePhase = "Player 1 : Preparation Phase";
		atkPlayer = player1;
		defPlayer = player2;
		
	}
	
	public static void isWinner() {
		
		Stage stage = BattleShipMain.stage2;
		
		if(player1.getNumberOfShip() == 0) {
			BattleShipMain.player2win = true;
			gamePhase = "END";
			BattleShipMain.Winner(stage);
		}
		
		else if(player2.getNumberOfShip() == 0) {
			BattleShipMain.player1win = true;
			gamePhase = "END";
			BattleShipMain.Winner(stage);
		}
	}
	
	public static Player getPlayerOfThisFieldPane(FieldCell fieldCell) {
        if (player1.getFieldPane().isFieldPaneHasThis(fieldCell)) return player1;
        return player2;
    }
	
	public static void gameUpdate() {
		BattleShipMain.label01.setText(GameController.getPlayer1().getMyShipInStock().get(0).toString() + "x");
		BattleShipMain.label11.setText(GameController.getPlayer1().getMyShipInStock().get(1).toString() + "x");
		BattleShipMain.label21.setText(GameController.getPlayer1().getMyShipInStock().get(2).toString() + "x");
		BattleShipMain.label31.setText(GameController.getPlayer1().getMyShipInStock().get(3).toString() + "x");
		BattleShipMain.label02.setText("x" + GameController.getPlayer2().getMyShipInStock().get(0).toString());
		BattleShipMain.label12.setText("x" + GameController.getPlayer2().getMyShipInStock().get(1).toString());
		BattleShipMain.label22.setText("x" + GameController.getPlayer2().getMyShipInStock().get(2).toString());
		BattleShipMain.label32.setText("x" + GameController.getPlayer2().getMyShipInStock().get(3).toString());
		BattleShipMain.Player1Ship.setText("Ship Left : " + GameController.getPlayer1().getNumberOfShip());
		BattleShipMain.Player2Ship.setText("Ship Left : " + GameController.getPlayer2().getNumberOfShip());
		BattleShipMain.Cooldown1.setText("Cd : " + GameController.getPlayer1().getCooldown());
		BattleShipMain.Cooldown2.setText("Cd : " + GameController.getPlayer2().getCooldown());
		player1.getFieldPane().setBackgroundDeathImage();
        player2.getFieldPane().setBackgroundDeathImage();
		nextPhase();
		isWinner();
		
		if(gamePhase == "Player 1 : Attack Phase" || gamePhase == "Player 2 : Attack Phase" ) {
			
			BattleShipMain.label01.setVisible(false);
			BattleShipMain.label11.setVisible(false);
			BattleShipMain.label21.setVisible(false);
			BattleShipMain.label31.setVisible(false);
			BattleShipMain.label02.setVisible(false);
			BattleShipMain.label12.setVisible(false);
			BattleShipMain.label22.setVisible(false);
			BattleShipMain.label32.setVisible(false);
			BattleShipMain.shippane1.setVisible(false);
			BattleShipMain.shippane2.setVisible(false);
			BattleShipMain.skillpane1.setVisible(true);
			BattleShipMain.skillpane2.setVisible(true);
			BattleShipMain.Player1Ship.setVisible(true);
			BattleShipMain.Player2Ship.setVisible(true);
			BattleShipMain.Cooldown1.setVisible(true);
			BattleShipMain.Cooldown2.setVisible(true);
			
			if(atkPlayer == player1) {
				BattleShipMain.Phase.setImage(BattleShipMain.attack1);
			}
			else if(atkPlayer == player2) {
				BattleShipMain.Phase.setImage(BattleShipMain.attack2);
			}
		}
		
		
		
		
	}
	
	public void getFieldPane(Player player) {
		player.getFieldPane();
	}
	
	public static String getGamePhase() {
		return gamePhase;
	}
	
	
	
	public static GameButton getSelectedGameButton() {
		return selectedGameButton;
	}

	public static void setSelectedGameButton(GameButton selectedGameButton) {
		GameController.selectedGameButton = selectedGameButton;
	}

	public static FieldPane getFieldPane(FieldCell fieldCell) {
		if (player1.getFieldPane().isFieldPaneHasThis(fieldCell)) return player1.getFieldPane();
		return player2.getFieldPane();
	}
	
	public static void nextPhase() {
		if(gamePhase == "Player 1 : Preparation Phase" && isPrepareFinish(player1)) { 
			gamePhase = "Player 2 : Preparation Phase"; 
			player1.getFieldPane().setAllCellSea();
			nextTurn();
			BattleShipMain.Phase.setImage(BattleShipMain.prepare2);
		}
		else if(gamePhase == "Player 2 : Preparation Phase" && isPrepareFinish(player2)) { 
			gamePhase = "Player 1 : Attack Phase"; 
			player2.getFieldPane().setAllCellSea();
			nextTurn();
			BattleShipMain.Phase.setImage(BattleShipMain.attack1);
		}
		
		else if(gamePhase == "Player 1 : Attack Phase") {
			gamePhase = "Player 2 : Attack Phase";
		}
		
		else if(gamePhase == "Player 2 : Attack Phase") {
			gamePhase = "Player 1 : Attack Phase";
		}
	}
	
	public static void nextTurn() {
		if (atkPlayer == player1) {
			atkPlayer = player2;
			defPlayer = player1;
		} else {
			atkPlayer = player1;
			defPlayer = player2;
		}
	}

	public static Player getAtkPlayer() {
		return atkPlayer;
	}

	public static Player getDefPlayer() {
		return defPlayer;
	}
	
	public static Player getPlayer1() {
		return player1;
	}

	public static Player getPlayer2() {
		return player2;
	}
	
	public static boolean isPrepareFinish(Player player) {
		ArrayList<Integer> a = player.getMyShipInStock();
		for (int i = 0;i < a.size();i++) if(a.get(i) != 0) return false;
		return true;
	}
	
}
