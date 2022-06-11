
public class AVLNode<K, V> implements Position<K, V> {

    //private AVLNode<K, V> parent;          // reference to the parent node
    private AVLNode<K, V> left;            // reference to the left child
    private AVLNode<K, V> right;           // reference to the right child
    private DictEntry<K, V> entry;         // reference to the entry stored at the node
    private int height;                   // height of the node for checking balance-height property

    public AVLNode(DictEntry<K, V> inputEntry, AVLNode<K, V> inputLeft, AVLNode<K, V> inputRight) {
        entry = inputEntry;
        //parent = inputParent;
        left = inputLeft;
        right = inputRight;
        height = 0;
        if (left != null) {
            height = Math.max(height, 1 + left.getHeight());
        }
        if (right != null) {
            height = Math.max(height, 1 + right.getHeight());
        }
    }



    public AVLNode<K, V> left() {
        return left;
    }

    public AVLNode<K, V> right() {
        return right;
    }

    public int getHeight() {
        return height;
    }

    public DictEntry<K, V> getEntry() {
        return entry;
    }



    public void setLeft(AVLNode<K, V> newLeft) {
        left = newLeft;
    }

    public void setRight(AVLNode<K, V> newRight) {
        right = newRight;
    }

    public void setEntry(DictEntry<K, V> newEntry) {
        entry = newEntry;
    }

    public DictEntry<K, V> element() {
        return entry;
    }

    public void resetHeight() throws AVLTreeException {
        if (left == null || right == null) {
            throw new AVLTreeException("Attempt to update height for external node ");
        }
        height = 1 + Math.max(left.getHeight(), right.getHeight());
    }
    private int checkHeight(AVLNode r) throws  AVLTreeException
    {
        if(r==null)
            return -1;
        int leftHeight=checkHeight(r.left());
        int rightHeight=checkHeight(r.right());
        if(Math.abs(leftHeight-rightHeight)>=2)
            throw new AVLTreeException("");
        return Math.max(leftHeight, rightHeight)+1;
    }
    public boolean isBalanced(AVLNode r)
    {
        try {
            checkHeight(r);
        } catch (AVLTreeException ex) {
            return false;
        }
        return true;
    }

    public boolean isBST(AVLNode r)
    {
        if(r==null)
            return true;
        if(r.left()!=null)
        {
            if(((Comparable)r.left().element().getKey()).compareTo(r.element().getKey())>=0)
                return false;
        }
        else if(r.right()!=null)
        {
            if(((Comparable)r.right().element().getKey()).compareTo(r.element().getKey())<=0)
                return false;
        }
        if(!isBST(r.left()))
            return false;
        if(!isBST(r.right()))
            return false;
        return true;

    }

}
