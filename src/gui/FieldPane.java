package gui;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class FieldPane extends GridPane{
	
	private ArrayList<FieldCell> fieldCells;
	
	public FieldPane() {
		super();
		fieldCells = new ArrayList<FieldCell>();
		this.setMinSize(505, 505);
		this.setAlignment(Pos.CENTER);
		this.setVgap(2);
		this.setHgap(2);
		//TODO adapt size and color
		this.setBorder(new Border(new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, 
				CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		
		for(int i = 0 ; i < 64; i++) {
			fieldCells.add(new FieldCell());			
		}
		
		this.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
		for (int i = 0;i < 8;i++) {
			for (int j = 0;j < 8;j++) {
				this.add(fieldCells.get(8*i+j), j, i);
			}
		}
	}
	
	public FieldCell getNextCell(FieldCell fieldcell) {
		FieldCell nextFieldCell = null;
		for (int i = 0;i < fieldCells.size();i++) {
			if(fieldCells.get(i) == fieldcell && i != 63) {
				nextFieldCell = fieldCells.get(i+1);
				break;
			}	
		}
		return nextFieldCell;
	}
	
	public void setBackgroundDeathImage() {
        for (FieldCell i : fieldCells) {
            if (i.getBaseShip() != null) {
                if(i.getBaseShip().isDead()) {
                    i.setBackgroundDeathImage();
                }
            }
        }
    }
	
	public void destroy(ArrayList<Integer> row) {
		for (int i = 0;i < row.size();i++) {
			if (!fieldCells.get(row.get(i)).isAlreadyHit()) {
				fieldCells.get(row.get(i)).isAttacked();
			//	System.out.println(i+": "+fieldCells.get(i)+"hit");
			}// else { System.out.println(i+": "+fieldCells.get(i)+"isAlreadyhit"); }
		}
	}
	
	public ArrayList<Integer> getCol(FieldCell fieldCell) {
		ArrayList<Integer> col = new ArrayList<Integer>();
		int a = fieldCells.indexOf(fieldCell);
		for (int i = a;i < fieldCells.size();i+=8) {
			col.add(i);
		} 
		for (int i = a-8;i >= 0;i-=8) {
			col.add(i);
		} return col;
	}
	
	public ArrayList<Integer> getRow(FieldCell fieldCell) {
		ArrayList<Integer> row = new ArrayList<Integer>();
		int a = fieldCells.indexOf(fieldCell);
		int k = a/8*8;
//		System.out.println("a: " + a);
//		System.out.println("k: " + k);
		for (int i = k;i < k+8;i++) {
			row.add(i);
//			System.out.println("i: " + i);
		} return row;
	}
	
	public boolean isFieldPaneHasThis(FieldCell fieldCell) {
		for (int i = 0;i < fieldCells.size();i++) {
			if(fieldCell == fieldCells.get(i)) return true;
		}
		return false;
	}
	
	public boolean isSameRow(FieldCell fieldCell1, FieldCell fieldCell2) {
		int i, j;
		for (i = 0;i < fieldCells.size();i++) {
			if(fieldCells.get(i) == fieldCell1) break;	
		}
		for (j = 0;j < fieldCells.size();j++) {
			if(fieldCells.get(j) == fieldCell2) break;	
		}
		
		return (i/8) == (j/8);
	}
	
	public void setAllCellSea() {
		for (FieldCell i : fieldCells) {
			i.setBackgroundSeaCell();
		}
	}
}
