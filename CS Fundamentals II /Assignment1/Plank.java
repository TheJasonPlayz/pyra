/* This class Plank is a subclass of Flooring and rather than being a poured material or a roll material, it
will create a floor with planks. Many floor dimensions will create wasted material. In this case, if
a plank needs to be cut, only one part of a plank will be used, the other part will be considered
waste.*/

//Plank has the 3 private variables below:
public class Plank extends Flooring {
    private int plankLengthInch;
    private int plankWidthInch;
    private double plankPrice;

    /**
     * @param materialName
     * @param length
     * @param width
     * @param pricePerPlank
     */
    /*plank constructor, this takes the material name, the length in inches of the plank, the width in inches of
    the plank, and the price per plank. These are initialized with the keyword this. */
    public Plank(String materialName, int length, int width, double pricePerPlank) {
        super(materialName, pricePerPlank/(length*width));
        super.setType("plank");
        this.plankWidthInch=width;
        this.plankLengthInch=length;
        this.plankPrice=pricePerPlank;
    }

    /**
     *
     * @param length
     * @param width
     * @return
     */

    /* amountOfMaterial takes a length and a width of the floor in inches and they go in the same direction, then it returns the amount of material required to cover the floor
     *This will mean there are 2 cases to look through, since you need to look at whether the length or width requires the least amount of material later on
     */
    public int amountOfMaterial(int length, int width) {

        int caseOne = (int)Math.ceil((double)length/(double)plankLengthInch) *
                (int)Math.ceil((double)width/(double)plankWidthInch) * plankLengthInch * plankWidthInch;

        int caseTwo = (int)Math.ceil((double)length/(double)plankWidthInch) *
                (int)Math.ceil((double)width/(double)plankLengthInch) * plankLengthInch * plankWidthInch;
        return Math.min(caseOne, caseTwo);

    }

    /**
     *
     * @param length
     * @param width
     * @return
     */
    /*public int unusedMaterial(int, int) takes a length and a width of the floor in inches
    then returns the difference between the amount of plank material needed and the
    size of the floor. ThisAmount is initialized, superAmount is used since it refers to the parent (Flooring) class  */
    public int unusedMaterial(int length, int width) {
        int thisAmount = this.amountOfMaterial(length, width);
        int superAmount = super.amountOfMaterial(length, width);
        return thisAmount - superAmount;
    }

    /**
     *
     * @return
     */

    // The ToString method is used to return a String representation of a Plank

    public String toString() {
        String s = "";
        if ( this.plankWidthInch < 12)
            s+= "Flooring-" + super.getType() + " "+ super.getMaterial() + " @" + this.plankPrice + " per " + plankLengthInch/12 + "'" + " by " + plankWidthInch + "''" ;
        else
            s+= "Flooring-" + super.getType() + " "+ super.getMaterial() + " @" + this.plankPrice + " per " + this.plankLengthInch/12 + "'" + " by " + toFeet(this.plankWidthInch);

        return s;
        /*
         * ("Flooring-plank oak @21.02 per 8' by 5''"))
         */
    }

}

