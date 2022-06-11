
public class TestNumerals {
	
	public static void main(String[] args) {
		
		// -------------------- Test 1 --------------------
		
		if (Roman2Arabic.convertSingleNumeral('V') == 5) {
			System.out.println("Test 1 Passed");
		} else {
			System.out.println("Test 1 Failed");
		}
		
		// -------------------- Test 2 --------------------
		
		if (Roman2Arabic.convertSingleNumeral('L') == 50) {
			System.out.println("Test 2 Passed");
		} else {
			System.out.println("Test 2 Failed");
		}
	
		// -------------------- Test 3 --------------------
		
		if (Roman2Arabic.convertSingleNumeral('M') == 1000) {
			System.out.println("Test 3 Passed");
		} else {
			System.out.println("Test 3 Failed");
		}
		
		// -------------------- Test 4 --------------------
		
		if (Roman2Arabic.convertWholeNumeral("II") == 2) {
			System.out.println("Test 4 Passed");
		} else {
			System.out.println("Test 4 Failed");
		}
		
		// -------------------- Test 5 --------------------
		
		if (Roman2Arabic.convertWholeNumeral("XVIII") == 18) {
			System.out.println("Test 5 Passed");
		} else {
			System.out.println("Test 5 Failed");
		}
		
		
		// -------------------- Test 6 --------------------
		
		if (Roman2Arabic.convertWholeNumeral("C") == 100) {
			System.out.println("Test 6 Passed");
		} else {
			System.out.println("Test 6 Failed");
		}
		
		// -------------------- Test 7 --------------------
		
		if (Roman2Arabic.convertWholeNumeral("MMXXI") == 2021) {
			System.out.println("Test 7 Passed");
		} else {
			System.out.println("Test 7 Failed");
		}
		
		// -------------------- Test 8 --------------------
		
		if (Roman2Arabic.convertWholeNumeral("MXXVII") == 1027) {
			System.out.println("Test 8 Passed");
		} else {
			System.out.println("Test 8 Failed");
		}
		
		// -------------------- Test 9 --------------------

		if (Roman2Arabic.convertWholeNumeral("XCIX") == 99) {
			System.out.println("Test 9 Passed");
		} else {
			System.out.println("Test 9 Failed");
		}
		
		// -------------------- Test 10 --------------------

		if (Roman2Arabic.convertWholeNumeral("CXC") == 190) {
			System.out.println("Test 10 Passed");
		} else {
			System.out.println("Test 10 Failed");
		}
		
		// -------------------- Test 11 --------------------

		if (Roman2Arabic.convertWholeNumeral("XXXVII") == 37) {
			System.out.println("Test 11 Passed");
		} else {
			System.out.println("Test 11 Failed");
		}
		
		// -------------------- Test 12 --------------------

		if (Roman2Arabic.convertWholeNumeral("MI") == 1001) {
			System.out.println("Test 12 Passed");
		} else {
			System.out.println("Test 12 Failed");
		}
		
		// -------------------- Test 13 --------------------
		
		try {
			Roman2Arabic.convertWholeNumeral("IIII");
			System.out.println("Test 13 Failed");
		} catch (RomanNumeralException e) {
			System.out.println("Test 13 Passed");
		} catch (Exception e) {
			System.out.println("Test 13 Failed");
		}
		
		// -------------------- Test 14 --------------------
	
		try {
			Roman2Arabic.convertWholeNumeral("VVII");
			System.out.println("Test 14 Failed");
		} catch (RomanNumeralException e) {
			System.out.println("Test 14 Passed");
		} catch (Exception e) {
			System.out.println("Test 14 Failed");
		}
		
		// -------------------- Test 15 --------------------
		
		try {
			Roman2Arabic.convertWholeNumeral("LL");
			System.out.println("Test 15 Failed");
		} catch (RomanNumeralException e) {
			System.out.println("Test 15 Passed");
		} catch (Exception e) {
			System.out.println("Test 15 Failed");
		}

	}
}
