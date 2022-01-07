package logic;

import java.util.ArrayList;

import Entity.Base.Skill;
import gui.FieldPane;
import Entity.HorizontalDestroy;
import Entity.Ship01;
import Entity.Ship02;
import Entity.Ship03;
import Entity.VerticalDestroy;
import Entity.Base.BaseShip;

public class Player {
	private int cooldown;
	private final int MAX_COOLDOWN = 3;
	private ArrayList<Integer> myShipInStock;
	private ArrayList<Skill> mySkill;
	private FieldPane fieldPaneShip;
	private int numberOfShip;
	public Player() {
		//myShip = new ArrayList<BaseShip>();
		mySkill = new ArrayList<Skill>();
		myShipInStock = new ArrayList<Integer>();
		
		Skill HDestroy = new HorizontalDestroy();
		Skill Vdestroy = new VerticalDestroy();
		mySkill.add(HDestroy);
		mySkill.add(Vdestroy);
		
		myShipInStock.add(2);
		myShipInStock.add(2);
		myShipInStock.add(2);
		myShipInStock.add(2);
		
		cooldown = 0;
		fieldPaneShip = new FieldPane();
		numberOfShip = 8;
	}

	public boolean alreadyUseSkill(Skill skill) {
		if (skill instanceof HorizontalDestroy) {
			return mySkill.get(0).isAlreadyUse();
		} else if (skill instanceof VerticalDestroy) {
			return mySkill.get(1).isAlreadyUse();
		} return true;
	}
	
	public void setAlreadyUseSkill(Skill skill) {
		if (skill instanceof HorizontalDestroy) {
			mySkill.get(0).setAlreadyUse();;
		} else if (skill instanceof VerticalDestroy) {
			mySkill.get(1).setAlreadyUse();;
		}
	}
	public int getCooldown() {
		return cooldown;
	}

	public void setMaxCooldown() {
		this.cooldown = MAX_COOLDOWN;
	}
	
	public void decreaseCooldown() {
		if (cooldown == 0) return;
		this.cooldown -= 1;
	}
	
	public ArrayList<Skill> getMySkill() {
		return mySkill;
	}

	public void setMySkill(ArrayList<Skill> mySkill) {
		this.mySkill = mySkill;
	}

	public FieldPane getFieldPane() {
		return fieldPaneShip;
	}
	
	public void decreaseShip() {
		this.numberOfShip -= 1;
	}
	
	
	public int getNumberOfShip() {
		return numberOfShip;
	}

	public int getInStock(BaseShip ship) {
		if (ship instanceof Ship01) return myShipInStock.get(0);
		if (ship instanceof Ship02) return myShipInStock.get(1);
		if (ship instanceof Ship03) return myShipInStock.get(2);
		return myShipInStock.get(3);
	}
	
	public void decreaseInStock(BaseShip ship) {
		if (ship instanceof Ship01) {
			myShipInStock.set(0, myShipInStock.get(0)-1);
			if(myShipInStock.get(0) == 0) {
				GameController.getSelectedGameButton().unhighlight();
				GameController.setSelectedGameButton(null);
			}
		}	else if (ship instanceof Ship02) {
			myShipInStock.set(1, myShipInStock.get(1)-1);
			if(myShipInStock.get(1) == 0) {
				GameController.getSelectedGameButton().unhighlight();
				GameController.setSelectedGameButton(null);
			}
		}	else if (ship instanceof Ship03) {
			myShipInStock.set(2, myShipInStock.get(2)-1);
			if(myShipInStock.get(2) == 0) {
				GameController.getSelectedGameButton().unhighlight();
				GameController.setSelectedGameButton(null);
			}
		} else {
			myShipInStock.set(3, myShipInStock.get(3)-1);
			if(myShipInStock.get(3) == 0) {
				GameController.getSelectedGameButton().unhighlight();
				GameController.setSelectedGameButton(null);
			}
		}
	}

	public ArrayList<Integer> getMyShipInStock() {
		return myShipInStock;
	}
	
	
}
