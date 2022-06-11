/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public interface Checker
{
    /*
     public boolean process(char c) - used to process a single char c
     */

    public boolean process(char c);
    /*public boolean finished() - used for seeing if the checker needs to continue processing
     */

    public boolean finished();
    /*public Checker cloneHere(int pos) - used to create a new Checker with the same attributes but restarting at pos position in the DNA sequence

     */

    public Checker cloneHere(int pos);
}
