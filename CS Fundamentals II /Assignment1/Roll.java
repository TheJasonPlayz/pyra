/* This class Roll is a subclass of Flooring and rather than being a poured material, it will create a floor
with large rolls of flexible material. Some floor dimensions are less well suited for particular rolls because of the roll’s width, creating a lot of wasted material. The rolls can be considered
arbitrarily long.
 */
public class Roll extends Flooring {

    private int rollWidthInch;
    private double rollPricePerInch;

    /**
     * @param material
     * @param width
     * @param pricePerInchOfTheRoll
     */
    public Roll(String material, int width, double pricePerInchOfTheRoll) {
        super(material, pricePerInchOfTheRoll/width);
        super.setType("roll");
        this.rollWidthInch = width;
        this.rollPricePerInch = pricePerInchOfTheRoll;
    }

    /**
     * @param length
     * @param width
     * @return
     */

    /** Takes a length and a width of the floor in inches. If the floor cannot be rolled out in a single strip, then an integer number of strips
     must be used. The resulting rolled floor will have at most one direction of seams. The roll can be parallel with the length or the width whichever uses the least
     amount of material. The math.ceil() function is used to determine the number thats rounded to nearest integer.
     */
    public int amountOfMaterial(int length, int width) {
        int numOfRoll1 = (int)Math.ceil((double)width/(double)rollWidthInch);
        int caseOne = rollWidthInch * numOfRoll1 * length;
        int numOfRoll2 = (int)Math.ceil((double)length/(double)rollWidthInch);
        int caseTwo =  rollWidthInch * numOfRoll2 * width;

        return Math.min(caseOne, caseTwo);

    }

    /**
     *
     * @param length
     * @param width
     * @return
     */

    /*Takes a length and a width of the floor in inches, Returns the difference between the amount of rolled material needed and the
    size of the floor */
    public int unusedMaterial(int length, int width) {
        int a = super.amountOfMaterial(length, width);
        //System.out.println(this.amountOfMaterial(length, width));
        //System.out.println(a);
        return this.amountOfMaterial(length, width) - a;
    }

    /**
     *
     * @return
     */
    //Returns a String representation of a Roll
    public String toString() {
        String s = "";
        s = "Flooring-" + super.getType() + " " + super.getMaterial() + " @" +
                this.rollPricePerInch + " per inch of a " + (int) Math.ceil(Math.sqrt(rollWidthInch)) + "' roll";
        return s;

    }

}
