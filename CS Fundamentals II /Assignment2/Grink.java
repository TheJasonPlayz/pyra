/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Grink extends Monster {

    LinearNode<String> actions;
    LinearNode<String> currAction;

    /**
     * public Grink(int, int, String[]) [constructor]
     *
     * Takes the column and row, which must be propagated to the Monster
     * constructor; and a String array which may contain any number of dance
     * actions. If the array is not null, call the private helper method
     * createActionList (see details below) to create a linked list with the
     * actions from the array, and set the currAction instance variable to the
     * front of the linked list as the default value.
     */
    public Grink(int c, int r, String[] actions) {
        super(c, r);
        createActionList(actions);
    }

    /**
     * private void createActionList(String[]) Takes the String array of dance
     * actions from the constructor. The possible values are "north", "east",
     * "south", "west", and "repeat" You must create a singly linked list in
     * which each node contains a String from the given array in the correct
     * order. The linked list must be referenced by the actions instance
     * variable.
     */
    private void createActionList(String[] actions) {
        LinearNode<String> node = null;
        if (actions != null) {
            for (int i = actions.length - 1; i >= 0; i--) {
                LinearNode<String> newNode = new LinearNode<String>(actions[i]);
                newNode.setNext(node);
                node = newNode;
            }
        }
        this.actions = node;
        currAction = node;
    }

    /**
     * public LinearNode<String> getActions(int) Returns the actions linked list
     */
    public LinearNode<String> getActions(int col) {
        return actions;
    }

    /**
     * public void dance(MonsterMash) [overridden] Takes in the MonsterMash
     * object in which this monster is dancing Use the currAction (which should
     * originally be the first movement in the actions list, but will later
     * change) to move the monster in that direction. If the action is "repeat"
     * then reset the currAction to the front of the list and immediately move
     * the monster based on that first direction. Update the currAction to the
     * next action. For example, if the given action sequence is: { "east",
     * "north", "repeat" }, the
     */
    public void dance(MonsterMash mash) {
        if (currAction != null) {
            if (currAction.getElement().equals("repeat")) {
                currAction = actions;
            }

            if (currAction.getElement().equals("east")) {
                this.setCol(this.getCol() + 1>=mash.getSize()?mash.getSize()-1:this.getCol() + 1);
            } else if (currAction.getElement().equals("west")) {
                this.setCol(this.getCol() - 1<0?0:this.getCol() - 1);
            } else if (currAction.getElement().equals("south")) {
                this.setRow(this.getRow() + 1>=mash.getSize()?mash.getSize()-1: this.getRow() + 1);
            } else if (currAction.getElement().equals("north")) {
                this.setRow(this.getRow() - 1<0?0:this.getRow() - 1);
            }

            currAction = currAction.getNext();

        }
    }
}
