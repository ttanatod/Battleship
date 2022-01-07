package Entity;

import Entity.Base.BaseShip;
import Entity.Base.Buttonable;
import gui.FieldCell;

import java.util.ArrayList;
import java.util.Random;
//evasion
public class Ship01 extends BaseShip implements Buttonable {

	public Ship01() {
		super(1, 1); //size = 1 hp = 1
		// TODO Auto-generated constructor stub
		/*ArrayList<String> url = new ArrayList<String>();
		url.add("musicimage.png");*/
		this.addUrl("ship0.png");
	}

	@Override
	public boolean isAttacked() {
		// TODO Auto-generated method stub
		Random rand = new Random();
		int rng = rand.nextInt(3);
		//System.out.println("rng" + rng);
		if (rng != 0) {
			this.decreaseHp();
			return true;
		} return false;
		//return this ship is attacked or not
	}

	@Override
	public boolean canPlace(FieldCell fieldCell) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String getTotalImageUrl() {
		// TODO Auto-generated method stub
		return ClassLoader.getSystemResource("ship0.png").toString();
	}

	

	
	
}
