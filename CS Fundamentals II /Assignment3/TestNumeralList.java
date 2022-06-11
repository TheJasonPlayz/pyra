import java.util.Iterator;

public class TestNumeralList {

	public static void main(String[] args) {
		
		ArrayOrderedList<RomanNumeral> ol;
		String[] ans;
		
		// -------------------- Test 1 --------------------
		
		ol = new ArrayOrderedList<RomanNumeral>();
		ans = new String[] {"IV","XIV","XXI","CV","CCCI"};

		ol.add(new RomanNumeral("XXI"));
		ol.add(new RomanNumeral("CV"));
		ol.add(new RomanNumeral("IV"));
		ol.add(new RomanNumeral("CCCI"));
		ol.add(new RomanNumeral("XIV"));

		if (correctList(ol, ans)) {
			System.out.println("Test 1 Passed");
		} else {
			System.out.println("Test 1 Failed");
		}

		// -------------------- Test 2 --------------------
		
		ol = new ArrayOrderedList<RomanNumeral>();
		ans = new String[] {"XX","L","LX","XC","C"};

		ol.add(new RomanNumeral("C"));
		ol.add(new RomanNumeral("XX"));
		ol.add(new RomanNumeral("L"));
		ol.add(new RomanNumeral("XC"));
		ol.add(new RomanNumeral("LX"));

		if (correctList(ol, ans)) {
			System.out.println("Test 2 Passed");
		} else {
			System.out.println("Test 2 Failed");
		}

		// -------------------- Test 3 --------------------
		
		ol = new ArrayOrderedList<RomanNumeral>();
		ans = new String[] {"I","C"};

		ol.add(new RomanNumeral("C"));
		ol.add(new RomanNumeral("I"));


		if (correctList(ol, ans)) {
			System.out.println("Test 3 Passed");
		} else {
			System.out.println("Test 3 Failed");
		}

		// -------------------- Test 4 --------------------
		
		ol = new ArrayOrderedList<RomanNumeral>();
		ans = new String[] {"II","IV","VIII","XVI","XXXII","LXIV"};

		ol.add(new RomanNumeral("XXXII"));
		ol.add(new RomanNumeral("VIII"));
		ol.add(new RomanNumeral("LXIV"));
		ol.add(new RomanNumeral("IV"));
		ol.add(new RomanNumeral("XVI"));
		ol.add(new RomanNumeral("II"));

		if (correctList(ol, ans)) {
			System.out.println("Test 4 Passed");
		} else {
			System.out.println("Test 4 Failed");
		}
		
		// -------------------- Test 5 --------------------
		
		ol = new ArrayOrderedList<RomanNumeral>();
		ans = new String[] {"MCMXCI", "MCMXCII","MMXXI","MMCXXI"};

		ol.add(new RomanNumeral("MMXXI"));
		ol.add(new RomanNumeral("MCMXCI"));
		ol.add(new RomanNumeral("MMCXXI"));
		ol.add(new RomanNumeral("MCMXCII"));

		if (correctList(ol, ans)) {
			System.out.println("Test 5 Passed");
		} else {
			System.out.println("Test 5 Failed");
		}
		
	}
	
	
	public static boolean correctList (ArrayOrderedList<RomanNumeral> ol, String[] ans) {
		Iterator<RomanNumeral> iter = ol.iterator();
		int i = 0;
		int corr = 0;
		
		while (iter.hasNext()) {
			if (i < ans.length) {
				if (iter.next().toString().equals(ans[i])) {
					corr++;
				}
				i++;
			} else {
				return false;
			}
		}

		if (i == ans.length && i == corr) {
			return true;
		}
		return false;
	}

}
