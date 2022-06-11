/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 
 */
public class Blub extends Monster {

    String axis;
    int dir;

    /*public Blub(int, int, String) [constructor]
    * Takes the column and row, which must be propagated to the Monster
    constructor; and a String representing the axis on which this Blub will move
    (either "horizontal" or "vertical").
     */

    /**
     *
     * @param c
     * @param r
     * @param axis
     */

    public Blub(int c, int r, String axis) {
        super(c, r);
        this.axis = axis;        
        dir=1;
    }

    /**
     * public void dance(MonsterMash) [overridden] Takes in the MonsterMash
     * object in which this monster is dancing Slide the monster one step in the
     * correct direction and along the correct axis as indicated by the instance
     * variables. The axis must never change after it is set in the constructor.
     * The dir variable should be toggling between 1 and -1 (or whichever values
     * you choose to use) to represent forward and backward movement,
     * respectively. The Blub can only step one cell away from its origin and
     * then it must return, and it repeats this 2-cell dance move over and over.
     * If a Blub is dancing horizontally and it starts along the eastern edge,
     * it should not move at all since it would go out of bounds. Likewise if a
     * Blub is dancing vertically and it starts along the southern edge, it
     * should not move at all.
     *
     *
     *
     * @param mash
     */
    public void dance(MonsterMash mash) {
        if(axis.equalsIgnoreCase("horizontal"))
        {
            if(getCol()+dir>mash.getSize()-1)
                dir=0;
            this.setCol(getCol()+dir);
            dir*=-1;
        }
        else if(axis.equalsIgnoreCase("vertical"))
        {
            if(getRow()+dir>mash.getSize()-1)
                dir=0;
            this.setRow(getRow()+dir);
            dir*=-1;
        }        

    }

}
