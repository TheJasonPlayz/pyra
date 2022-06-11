/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 
 */
public class Orbin extends Monster {
    private String dir;

    /**
     *
     * @param c
     * @param r
     * @param dir
     */
    public Orbin(int c, int r, String dir) {
        super(c, r);
        this.dir=dir;
    }

    /**
     * public void dance(MonsterMash) [overridden] Takes in the MonsterMash
     * object in which this monster is dancing Use the dir variable to move the
     * monster in that direction. If the monster reaches the edge of the room in
     * the direction they are sliding, they must turn 90 degrees to continue
     * dancing around the edge of the room in clockwise fashion. You do not need
     * to check for out of bounds for an Orbin.
     *
     *
     * @param mash
     */
    public void dance(MonsterMash mash) {
        if(dir.equals("east"))
        {
            if(this.getCol()==mash.getSize()-1)
            {
                dir="";
            }
            else
            {
                this.setCol(this.getCol()+1);
            }            
        }
        else if(dir.equals("west"))
        {
            if(this.getCol()==0)
            {
                dir="";
            }
            else
            {
                this.setCol(this.getCol()-1);
            }            
        }
        else if(dir.equals("north"))
        {
            if(this.getRow()==0)
            {
                dir="";
            }
            else
            {
                this.setRow(this.getRow()-1);                
            }            
        }
        else if(dir.equals("south"))
        {
            if(this.getRow()==mash.getSize()-1)
            {
                dir="";
            }
            else
            {
                this.setRow(this.getRow()+1);                
            }            
        }

        if(dir.equals(""))
        {
            if(this.getCol()==0&&this.getRow()==0)
            {
                this.setCol(1);
            }
            else if(this.getCol()== mash.getSize()-1&&this.getRow()==0)
            {
                this.setRow(1);
            }
            else if(this.getCol()==mash.getSize()-1&&this.getRow()== mash.getSize()-1)
            {
                this.setCol(mash.getSize()-2);
            }
            else if(this.getCol()==0&&this.getRow()== mash.getSize()-1)
            {
                this.setRow(mash.getSize()-2);
            }
            else if(this.getCol()==0)
            {
                this.setRow(this.getRow()-1);
            }
            else if(this.getRow()==0)
            {
                this.setCol(this.getCol()+1);
            }
            else if(this.getCol()==mash.getSize()-1)
            {
                this.setRow(this.getRow()+1);
            }
            else if(this.getRow()==mash.getSize()-1)
            {
                this.setCol(this.getCol()-1);
            }
        }
        
        
        

    }

}
