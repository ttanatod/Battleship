package Entity;

import Entity.Base.Buttonable;
import Entity.Base.Skill;
import gui.FieldCell;
import gui.FieldPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import logic.GameController;
import logic.Player;

public class HorizontalDestroy extends Skill implements Buttonable{

	public HorizontalDestroy() {
		super();
	}
	
	@Override
	public void useSkill(FieldCell fieldCell, Player p1, Player p2) {
		// TODO Auto-generated method stub
//		System.out.println("HDestroy");
		p1.setMaxCooldown();
		p2.getFieldPane().destroy(p2.getFieldPane().getRow(fieldCell)); 
		GameController.getSelectedGameButton().unhighlight();
		GameController.getSelectedGameButton().setGraphic(new ImageView(new Image(ClassLoader.getSystemResource("usehskill.png").toString())));
		GameController.setSelectedGameButton(null);
	}

	@Override
	public String getTotalImageUrl() {
		// TODO Auto-generated method stub
		return ClassLoader.getSystemResource("hskill.png").toString();
	}
	
}
