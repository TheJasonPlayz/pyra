import java.util.Scanner;

public class MonsterMash {

	private int size;
	private int numMonsters;
	private Monster[] monsters;
	private LinkedGrid<FloorCell> floor;
	private GUI gui;
	public static int TIME_DELAY = 0;
	public static boolean DEBUG = false;
	
	public MonsterMash (int sz) {
		floor = new LinkedGrid<FloorCell>(sz, sz);
		for (int i = 0; i < sz; i++) {
			for (int j = 0; j < sz; j++) {
				floor.setElement(j, i, new FloorCell());
			}
		}
		
		size = sz;
		monsters = new Monster[10];
		gui = new GUI(this);
	}

	public int getSize () {
		return size;
	}

	public LinkedGrid<FloorCell> getFloor () {
		return floor;
	}
	
	public LinearNode<FloorCell> getCell (int col, int row) {
		return floor.getElement(col, row);
	}
	
	public void addMonster (Monster monster) {
		monsters[numMonsters] = monster;
		numMonsters++;
		
		floor.getElement(monster.getCol(), monster.getRow()).getElement().setMonster(monster);
		gui.updateCell(monster.getCol(), monster.getRow(), monster);
	}
	
	public void clearMonsters () {
		monsters = new Monster[10];
		numMonsters = 0;
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				floor.getElement(j, i).getElement().setMonster(null);
				gui.updateCell(j, i, null);
			}
		}
	}
	
	
	public void danceSteps (int numSteps) {
		for (int i = 0; i < numSteps; i++) {
			// Pause for TIME_DELAY milliseconds between dance steps to watch the dance. Use TIME_DELAY = 0 to quickly finish the dance; or use a delay of
			// about 500 to watch the dance steps take place individually.
			try {
				Thread.sleep(TIME_DELAY);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// For debugging purposes only, perform one step at a time and hit Enter in the console to proceed. Set DEBUG to false at the top to run normally.
			if (DEBUG){
                Scanner scan = new Scanner(System.in);
                scan.nextLine();
                danceSingleStep();
                System.out.println(this);
			} else {
				danceSingleStep();
			}
		}
	}
	
	public void danceSingleStep () {
		for (int i = 0; i < monsters.length; i++) {
			if (monsters[i] != null) {
				// Get previous location of monster.
				int oc = monsters[i].getCol();
				int or = monsters[i].getRow();
				
				// Let monster dance!
				monsters[i].dance(this);
				
				// Get new location of monster.
				int nc = monsters[i].getCol();
				int nr = monsters[i].getRow();
				
				// Update the floor and GUI.
				floor.getElement(oc, or).getElement().setMonster(null);
				floor.getElement(nc, nr).getElement().setMonster(monsters[i]);
				gui.updateCell(oc, or, null);
				gui.updateCell(nc, nr, monsters[i]);
				
			}
		}
	}

	public String toString () {

		String str = "";
		for (int j = 0; j < size; j++) {
			for (int i = 0; i < size; i++) {
				if (getCell(i, j).getElement().getMonster() != null) {
					str += getCell(i, j).getElement().getMonster() + " ";
				} else {
					str += "__ ";
				}
			}
			str += "\n";
		}
		return str;
	}
	
	
	public static void main (String[] args) {
		
		MonsterMash mash = new MonsterMash(5);
		Monster m1, m2, m3, m4, m5;
		
		Monster.resetIdCounter();
		mash.clearMonsters();
		m1 = new Blub(1, 1, "horizontal");
		mash.addMonster(m1);
		m2 = new Blub(3, 2, "vertical");
		mash.addMonster(m2);
		m3 = new Grink(1, 2, new String[] {"south", "east", "north", "west", "repeat"});
		mash.addMonster(m3);
		m4 = new Orbin(2, 4, "west");
		mash.addMonster(m4);
		m5 = new Orbin(4, 0, "south");
		mash.addMonster(m5);

		mash.danceSteps(10);
	}

}
