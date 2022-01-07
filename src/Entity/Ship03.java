package Entity;

import java.util.ArrayList;

import Entity.Base.BaseShip;
import Entity.Base.Buttonable;
import gui.FieldCell;
import gui.FieldPane;
import logic.GameController;

public class Ship03 extends BaseShip implements Buttonable{

	public Ship03() {
		super(2, 2);
		// TODO Auto-generated constructor stub
		ArrayList<String> url = new ArrayList<String>();
		/*url.add("Ship03_1.png");
		url.add("Ship03_2.png");
		this.setUrl(url);*/
		this.addUrl("ship21.png");
		this.addUrl("ship22.png");
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
				GameController.getFieldPane(fieldCell).isSameRow(fieldCell, GameController.getFieldPane(fieldCell).getNextCell(fieldCell))) return true;
		return false;
	}

	@Override
	public String getTotalImageUrl() {
		// TODO Auto-generated method stub
		return ClassLoader.getSystemResource("ship2.png").toString();
	}




}

//TODO problem how to know long ship isAlive how to clear all cell