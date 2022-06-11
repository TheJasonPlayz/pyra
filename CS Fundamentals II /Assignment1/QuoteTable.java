/* This class QuoteTable encapsulates all the data and methods for creating desired tables of quotes for a
contractor to show to clients. The main method, display(), produces a table but it requires helper
methods.
 */
public class QuoteTable {
    private Flooring[] option;
    private int lengthInch;
    private int widthInch;
    private double markup;

    /**
     * @param floorings
     * @param length
     * @param width
     * @param markup
     */
    public QuoteTable(Flooring[] floorings, int length, int width, double markup) {
        this.option = floorings;
        this.lengthInch = length;
        this.widthInch = width;
        this.markup = markup;
    }

    /**
     * @param floorings
     */
    public void setOptions(Flooring[] floorings) {
        this.option = floorings;
    }

    /**
     * @param lengthInch
     */
    public void setLength(int lengthInch) {
        this.lengthInch = lengthInch;
    }

    /**
     * @param widthInch
     */
    public void setWidth(int widthInch) {
        this.widthInch = widthInch;
    }

    /**
     * @param markup
     */
    public void setMarkup(double markup) {
        this.markup = markup;
    }

    /**
     * @return
     */
    //Determines and returns the price in cents of the cheapest option, this must go through the array to find cheapest value.
    //The for loop goes on until the cheapest option is found. Then, it will return cheapest.
    public int getCheapestValue() {
        int cheapest = this.option[0].quoteCents(lengthInch, widthInch, markup);
        for (int i = 1; i < this.option.length; i++) {
            if ( cheapest > this.option[i].quoteCents(lengthInch, widthInch, markup))
                cheapest = this.option[i].quoteCents(lengthInch, widthInch, markup);
        }
        return cheapest;
    }

    /**
     * @return
     */
    //Determines and returns the waste ratio of the cleanest option (in terms of waste). Must go through the array to find cleanest value.
    //The for loop goes on until the cleanest option is found. Then, it will return cleanest.
    public double getCleanestValue() {
        double cleanest = this.option[0].wasteRatio(this.lengthInch, this.widthInch);
        for (int i = 1; i < this.option.length; i++) {
            //System.out.println("clean1 = " + cleanest + "  clean2 = " + this.option[i].wasteRatio(this.lengthInch, this.widthInch));
            if (cleanest > this.option[i].wasteRatio(this.lengthInch, this.widthInch)) {
                cleanest = this.option[i].wasteRatio(this.lengthInch, this.widthInch);
            }
        }
        return cleanest;
    }

    /**
     * @param hundredths
     * @return
     */
    private static String displayHundredths(int hundredths) {
        return hundredths / 100 + "." + (hundredths / 10 % 10) + "" + hundredths % 10;
    }

    /**
     * @return
     */
    public String display() {
        String out = "For a floor " + Flooring.toFeet(lengthInch) + " by " + Flooring.toFeet(widthInch) + "\n\n";

        int cheapestValue = getCheapestValue();
        double cleanestValue = getCleanestValue();

        out += "Material\tWaste\tCost\n";
        out += "--------\t-----\t----\n";
        for (int i = 0; i < option.length; i++) {
            double waste = option[i].wasteRatio(lengthInch, widthInch);
            int cost = option[i].quoteCents(lengthInch, widthInch, markup);

            out += option[i].getType() + "-";
            out += option[i].getMaterial() + "\t";
            out += displayHundredths((int) (10000 * waste)) + "%\t";
            out += "$" + displayHundredths(cost);
            if (waste == cleanestValue)
                out += " Eco";
            if (cost == cheapestValue)
                out += " $$";
            out += "\n";
        }
        return out;
    }


    public static void main(String[] args) {
        // Testing
        Flooring[] option = new Flooring[3];
        option[0] = new Plank("birch", 12 * 6, 4, 14.95);
        option[1] = new Roll("linoleum", 79, 3.92);
        option[2] = new Plank("oak", 12 * 7, 5, 23.07);
        QuoteTable qt = new QuoteTable(option, 750, 300, 0.15);

        System.out.println(qt.display());

        // QuoteTable getCleanestValue
        System.out.println(qt.getCleanestValue());
        //		test(1, "QuoteTable getCleanestValue", qt.getCleanestValue() == 0.007936507936507936);

        // QuoteTable getCheapestValue
        System.out.println(qt.getCheapestValue());
        //test(2, "QuoteTable getCheapestValue", qt.getCheapestValue() == 1352400);

        qt.setLength(510);
        qt.setMarkup(0.12);
        System.out.println(qt.display());

        // System.out.println("cleanest value *** " + qt.getCleanestValue());
        //test(3, "QuoteTable getCleanestValue 2", qt.getCleanestValue() == 0.05063291139240506);

        // QuoteTable getCheapestValue 2
        //System.out.println("cheaptest" + qt.getCheapestValue());
        //test(4, "QuoteTable getCheapestValue 2", qt.getCheapestValue() == 895642);

    }
}