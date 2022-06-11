
public class TestMonsters {

	public static void main (String[] args) {
		
		Monster m1, m2, m3, m4, m5, m6, m7;
		MonsterMash mash;
		String str;

		// --------------- Test 1 --------------- [monster sub-classes]
		
		m1 = new Blub(0, 0, "horizontal");
		m2 = new Grink(0, 0, null);
		m3 = new Orbin(0, 0, "east");

		if (m1 instanceof Monster && m2 instanceof Monster && m3 instanceof Monster) {
			System.out.println("Test 1 passed");
		} else {
			System.out.println("Test 1 failed");
		}

		// --------------- Test 2 --------------- [sub-class constructors]

		Monster.resetIdCounter();
		mash = new MonsterMash(5);
		
		m1 = new Blub(2, 2, "horizontal");
		mash.addMonster(m1);
		m2 = new Grink(3, 0, null);
		mash.addMonster(m2);
		m3 = new Orbin(0, 4, "north");
		mash.addMonster(m3);

		str = "__ __ __ G2 __ \n__ __ __ __ __ \n__ __ B1 __ __ \n__ __ __ __ __ \nO3 __ __ __ __ \n";

		if (mash.toString().equals(str)) {
			System.out.println("Test 2 passed");
		} else {
			System.out.println("Test 2 failed");
		}

		// --------------- Test 3 --------------- [Blub dancing]

		Monster.resetIdCounter();
		mash.clearMonsters();

		m1 = new Blub(3, 2, "horizontal");
		mash.addMonster(m1);
		m2 = new Blub(4, 0, "vertical");
		mash.addMonster(m2);
		m3 = new Blub(0, 3, "vertical");
		mash.addMonster(m3);
		m4 = new Blub(1, 2, "horizontal");
		mash.addMonster(m4);
		m5 = new Blub(1, 4, "horizontal");
		mash.addMonster(m5);
		mash.danceSteps(3);
	
		str = "__ __ __ __ __ \n__ __ __ __ B2 \n__ __ B4 __ B1 \n__ __ __ __ __ \nB3 __ B5 __ __ \n";

		if (mash.toString().equals(str)) {
			System.out.println("Test 3 passed");
		} else {
			System.out.println("Test 3 failed");
		}


		// --------------- Test 4 --------------- [Grink dancing]

		Monster.resetIdCounter();
		mash.clearMonsters();

		m1 = new Grink(0, 0, new String[] {"east", "south", "west", "north", "repeat"});
		mash.addMonster(m1);
		m2 = new Grink(2, 4, new String[] {"north", "west", "west", "south", "east"});
		mash.addMonster(m2);
		m3 = new Grink(1, 2, new String[] {"east", "east", "west", "west", "repeat"});
		mash.addMonster(m3);
		m4 = new Grink(3, 0, new String[] {"west", "south", "east", "east", "north", "west", "repeat"});
		mash.addMonster(m4);
		mash.danceSteps(10);

		str = "__ __ __ __ __ \n__ G1 __ __ G4 \n__ __ __ G3 __ \n__ __ __ __ __ \n__ G2 __ __ __ \n";

		if (mash.toString().equals(str)) {
			System.out.println("Test 4 passed");
		} else {
			System.out.println("Test 4 failed");
		}

		// --------------- Test 5 --------------- [Orbin dancing]

		Monster.resetIdCounter();
		mash.clearMonsters();
		m1 = new Orbin(0, 0, "east");
		mash.addMonster(m1);
		m2 = new Orbin(2, 1, "west");
		mash.addMonster(m2);
		m3 = new Orbin(4, 0, "south");
		mash.addMonster(m3);
		m4 = new Orbin(2, 4, "west");
		mash.addMonster(m4);
		mash.danceSteps(5);

		str = "__ __ O2 __ __ \nO4 __ __ __ O1 \n__ __ __ __ __ \n__ __ __ __ __ \n__ __ __ O3 __ \n";

		if (mash.toString().equals(str)) {
			System.out.println("Test 5 passed");
		} else {
			System.out.println("Test 5 failed");
		}
		
		// --------------- Test 6 --------------- [Combined dancing]
		
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
		
		str = "__ __ __ __ O4 \n__ B1 __ __ __ \nO5 __ __ B2 __ \n__ __ G3 __ __ \n__ __ __ __ __ \n";

		if (mash.toString().equals(str)) {
			System.out.println("Test 6 passed");
		} else {
			System.out.println("Test 6 failed");
		}
		
		// --------------- Test 7 --------------- [Blub and Grink boundaries]

		Monster.resetIdCounter();
		mash.clearMonsters();
		m1 = new Blub(4, 4, "vertical");
		mash.addMonster(m1);
		m2 = new Grink(1, 2, new String[] {"west", "west", "west", "north"});
		mash.addMonster(m2);

		mash.danceSteps(5);

		str = "__ __ __ __ __ \nG2 __ __ __ __ \n__ __ __ __ __ \n__ __ __ __ __ \n__ __ __ __ B1 \n";

		if (mash.toString().equals(str)) {
			System.out.println("Test 7 passed");
		} else {
			System.out.println("Test 7 failed");
		}

	}
}
