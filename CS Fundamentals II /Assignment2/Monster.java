
public class Monster {
	
	private int id;
	private int col;
	private int row;
	private static int lastId = 0;

	public Monster (int c, int r) {
		//id = m_id;
		id = ++lastId;
		col = c;
		row = r;
	}
	
	public void setCol (int c) {
		col = c;
	}
	
	public void setRow (int r) {
		row = r;
	}
	
	public int getCol () {
		return col;
	}
	
	public int getRow () {
		return row;
	}

	public void dance (MonsterMash mm) {
		// Sub-classes will override this method.
		// It should never be called, but must be here to satisfy the compiler.
	}
	
	public static void resetIdCounter () {
		lastId = 0;
	}
	
	public String toString () {
		if (this instanceof Blub) {
			return "B" + id;
		} else if (this instanceof Grink) {
			return "G" + id;
		} else if (this instanceof Orbin) {
			return "O" + id;
		} else {
			return "";
		}
	}

}
