import javax.swing.JLabel;

public class FloorCell extends JLabel {
	
	private Monster monster;

	public FloorCell () {
		super();
		monster = null;
	}
	
	public FloorCell (Monster monster) {
		super();
	}
	
	public Monster getMonster () {
		return monster;
	}
	
	public void setMonster (Monster monster) {
		this.monster = monster;
	}

}
