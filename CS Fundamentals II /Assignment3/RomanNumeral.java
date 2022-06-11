public class RomanNumeral implements Comparable<RomanNumeral> {
    private String numeral;
    /**
     *
     * @param numeral
     */
    public RomanNumeral(String numeral) {
        this.numeral = numeral;
    }
    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return (String) numeral;
    }
    /**
     *
     * @param r
     * @return
     */
    // this compares the given roman numeral r with the 'this' roman numeral
    public int compareTo(RomanNumeral r) {
        int result = 0;
        result = (Roman2Arabic.convertWholeNumeral(this.numeral) < Roman2Arabic.convertWholeNumeral(r.numeral)) ? -1 : 1;
        return result;
    }
}
