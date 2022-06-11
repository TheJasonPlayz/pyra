
public class TestConversions {

	public static void main(String[] args) {
		
		MyFileReader mfr = new MyFileReader("RomanNumerals.csv");
		int success = 0;
		
		while (!mfr.endOfFile()) {
			String str = mfr.readString();
			String[] parts = str.split(",");
			int res = Roman2Arabic.convertWholeNumeral(parts[1]);
			if (Integer.parseInt(parts[0]) == res) {
				success++;
			} else {
				// If you want to see which ones you are not getting correct, you may un-comment the following line.
				//System.out.println("Incorrect:  " + parts[0] + " => " + parts[1] + "          " + res);
			}
		}
		
		System.out.println(success + " / 3999 are correct!");

	}


}
