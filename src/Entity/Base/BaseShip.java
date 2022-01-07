package Entity.Base;

import java.util.ArrayList;

import gui.FieldCell;

public abstract class BaseShip {
	private int hp;
	private int size;
	private boolean isDead;
	private ArrayList<String> url;
	private int inStock;
	
	public BaseShip(int size, int hp) {
		this.hp = hp;
		this.size = size;
		url = new ArrayList<String>();
		isDead = false;
		inStock = 2;
	}
	
	public abstract boolean isAttacked(); 
	
	public void decreaseHp() {
		this.hp -= 1;
		if (hp == 0) isDead = true;
		//TODO throws exception hp < 0
	}
	
	public boolean isDead() {
		return isDead;
	}

	public ArrayList<String> getUrl() {
		return url;
	}

	public void addUrl(String s) {
		this.url.add(s);
	}
	
	public void decreaseInStock() {
		this.inStock -= 1;
	}
	
	public int getInStock() {
		return inStock;
	}

	public int getSize() {
		return size;
	}
	

	public int getHp() {
		return hp;
	}

	public abstract boolean canPlace(FieldCell fieldCell) ;
	
}
