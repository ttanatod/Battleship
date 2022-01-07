package Entity.Base;

import gui.FieldCell;
import logic.Player;

public abstract class Skill {
	private boolean isAlreadyUse;
	private String url;
	
	public Skill() {
		isAlreadyUse =  false;
	}

	public boolean isAlreadyUse() {
		return isAlreadyUse;
	}

	public void setAlreadyUse() {
		this.isAlreadyUse = true;
	}
	
	public String getUrl() {
		return this.url;
	}

	public abstract void useSkill(FieldCell fieldCell, Player p1, Player p2);
}
