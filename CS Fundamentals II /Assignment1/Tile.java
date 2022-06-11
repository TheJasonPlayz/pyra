/* This class Tile is a subclass of Plank with the key difference that the tiles are square.
 */
public class Tile extends Plank {
    /**
     * @param materialName
     * @param tileLengthInches
     * @param pricePerTile
     */

    // Takes the material name, a side length of the tile in inches, and the price per tile

    public Tile(String materialName, int tileLengthInches, double pricePerTile) {
        super(materialName, tileLengthInches, tileLengthInches, pricePerTile);
        super.setType("tile");
    }

    /**
     * @return
     */
    @Override

    public String toString() {
        return super.toString();
        //This will be returning "Flooring-tile " + getMaterial() + " @" + pricePerTile + " per " + toFeet(tileLengthInch) + " by " + toFeet(tileLengthInch);
    }

}