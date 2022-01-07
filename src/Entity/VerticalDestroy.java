package Entity;

import Entity.Base.Buttonable;
import Entity.Base.Skill;
import gui.FieldCell;
import gui.FieldPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import logic.GameController;
import logic.Player;

public class VerticalDestroy extends Skill implements Buttonable{

	public VerticalDestroy() {
		super();
	}
	
	@Override
	public void useSkill(FieldCell fieldCell, Player p1, Player p2) {
		// TODO Auto-generated method stub
//		System.out.println("VDestroy");
		p1.setMaxCooldown();
		p2.getFieldPane().destroy(p2.getFieldPane().getCol(fieldCell)); 
		GameController.getSelectedGameButton().unhighlight();
		GameController.getSelectedGameButton().setGraphic(new ImageView(new Image(ClassLoader.getSystemResource("usevskill.png").toString())));
		GameController.setSelectedGameButton(null);
	}

	@Override
	public String getTotalImageUrl() {
		// TODO Auto-generated method stub
		return ClassLoader.getSystemResource("vskill.png").toString();
	}
	
}
