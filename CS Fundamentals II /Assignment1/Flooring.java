/* The Flooring class is used to encapsulate the data and methods associated with flooring materials and is the
base class for Roll, Plank, and Tile.
It contains getter and setter methods.
 */
public class Flooring {
//has 3 private variables below:
    private String type;
    private String materialName;
    private double pricePerSqInch;

    /**
     * @param material
     * @param price
     */
/* Initialize each of the instance variables (material and pricePerSqInch) with the
corresponding parameters */
    public Flooring(String material, double price) {
        this.materialName = material;
        this.pricePerSqInch = price;
        this.type = "poured";
    }

    /**
     * @return the type
     */
    public String getType() {
        return this.type;
    }

    /**
     * @param t
     */
//setType sets the type. String t is a parameter, type is then initialized as t.
    public void setType(String t) {
        this.type = t;
    }

    /**
     * @return the material
     */

    public String getMaterial() {
        return this.materialName;
    }

    /**
     * @return the price per square inch
     */
    public double getPricePerSqInch() {
        return this.pricePerSqInch;
    }
    /* Takes a length and a width of the floor in inches, as parameters.
Then it returns the amount of material required to cover the floor which in this case is calculated by the area of the floor in inches squared
     */
    public int amountOfMaterial(int length, int width) {
        // This should be printing the phrase on the right - ("Method amountOfMaterial in Floor.java is called!");
        return width * length;
    }

    /**
     * @param width
     * @param length
     * @param markup
     * @return
     */
    public int quoteCents(int width, int length, double markup) {
        int priceWithoutMarkup = (int) Math.ceil(amountOfMaterial(length,width) * pricePerSqInch * 100);
        int priceWithMarkup=(int) Math.ceil(priceWithoutMarkup + (markup*priceWithoutMarkup));
        return priceWithMarkup;
    }

    /**
     * @param inches
     * @return
     */
    public static String toFeet(int inches) {
        String toFeet = "";
        int feet = inches / 12;
        int leftover = inches % 12;
        toFeet = feet + "'" + leftover + "''";

        if ( feet == 0)
            return leftover + "''";

        if ( leftover == 0)
            return feet + "'";

        return toFeet;
    }

    /**
     * @param length
     * @param wasted
     * @return
     */
    public int unusedMaterial(int length, int wasted) {
        if (this.type.equals("poured"))
            return 0;
        else
            return length * wasted;
    }

    /**
     * @param length
     * @param width
     * @return
     */
    //wasteRatio is used to takes a length and a width of the floor in inches
    //After, it returns the ratio of the amount of unused material over the total of material used.
    public double wasteRatio(int length, int width) {
        // Returns the ratio of the amount of unused material over the total of material used
        return (double)unusedMaterial(length, width)/(double)amountOfMaterial(length, width);
    }

    /**
     *
     * @return
     */
    public String toString() {
        String s = "";
        s = "Flooring-" + this.type + " " + this.materialName + " @" + this.pricePerSqInch + " sq. in";
        return s;
    }

    /**
     *
     * @param args
     */
    public static void main(String args[]) {


        Flooring f1 = new Flooring("resin",0.04);
        System.out.println(f1);
    }
}

