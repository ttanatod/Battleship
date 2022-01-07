package Entity;

import java.util.ArrayList;

import Entity.Base.BaseShip;
import Entity.Base.Buttonable;
import gui.FieldCell;
import logic.GameController;

public class Ship04 extends BaseShip implements Buttonable{

	public Ship04() {
		super(3, 3);
		// TODO Auto-generated constructor stub
		ArrayList<String> url = new ArrayList<String>();
	/*	url.add("Ship04_1.png");
		url.add("Ship04_2.png");
		url.add("Ship04_3.png");
		this.setUrl(url);*/
		this.addUrl("ship31.png");
		this.addUrl("ship32.png");
		this.addUrl("ship33.png");
	}

	@Override
	public boolean isAttacked() {
		// TODO Auto-generated method stub
		this.decreaseHp();
		return true;
	}

	@Override
	public boolean canPlace(FieldCell fieldCell) {
		// TODO Auto-generated method stub
		if (GameController.getFieldPane(fieldCell).getNextCell(fieldCell).getBaseShip() == null && 
			GameController.getFieldPane(fieldCell).getNextCell(GameController.getFieldPane(fieldCell).getNextCell(fieldCell)).getBaseShip() == null &&
				GameController.getFieldPane(fieldCell).isSameRow(fieldCell, GameController.getFieldPane(fieldCell).getNextCell(GameController.getFieldPane(fieldCell).getNextCell(fieldCell)))) return true;
		return false;
	}

	@Override
	public String getTotalImageUrl() {
		// TODO Auto-generated method stub
		return ClassLoader.getSystemResource("ship3.png").toString();
	}

	
}
