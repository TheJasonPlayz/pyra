/**
 *CS2210 2022
 * @author Grace Gong
 * 251151854
 * @date March 31
 */
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;


/* Class AVLTree */

class AVLTree<K, V> {

    private AVLNode<K, V> root;

    /* Constructor */
    public AVLTree() {
        root = null;
    }

    /* Function to check if tree is empty */
    public boolean isEmpty() {
        return root == null;
    }

    /* Make the tree logically empty */
    public void makeEmpty() {
        root = null;
    }

    /* Function to insert data */
    public void insert(K data) {
        root = insert(data, root);
    }

    /* Function to get height of node */
    private int height(AVLNode t) {
        return t == null ? -1 : t.getHeight();
    }

    /* Function to max of left/right node */
    private int max(int lhs, int rhs) {
        return lhs > rhs ? lhs : rhs;
    }

    /* Function to insert data recursively */
    private AVLNode insert(K x, AVLNode t) {
        if (t == null) {
            t = new AVLNode<K, V>(new DictEntry(x,1),null,null);
        } else if (((Comparable)x).compareTo(t.element().getKey())<0) {
            t.setLeft(insert(x, t.left()));
            if (height(t.left()) - height(t.right()) == 2) {
                if (((Comparable)x).compareTo(t.left().element().getKey())<0) {
                    t = rotateWithLeftChild(t);
                } else {
                    t = doubleWithLeftChild(t);
                }
            }

        } else if (((Comparable)x).compareTo(t.element().getKey())>0) {

            t.setRight(insert(x, t.right()));

            if (height(t.right()) - height(t.left()) == 2) {
                if (((Comparable)x).compareTo(t.right().element().getKey())>0){
                    t = rotateWithRightChild(t);
                } else {
                    t = doubleWithRightChild(t);
                }
            }

        } else
        {
            t.element().setValue((int)t.element().getValue()+1);
            ;  // increment
        }

        try {
            //t.height = max(height(t.left()), height(t.right())) + 1;
            t.resetHeight();
        } catch (AVLTreeException ex) {
        }

        return t;

    }

    /* Rotate binary tree node with left child */
    private AVLNode rotateWithLeftChild(AVLNode k2) {
        AVLNode k1 = k2.left();
        k2.setLeft(k1.right());
        k1.setRight(k2);
        //k2.height = max(height(k2.left()), height(k2.right())) + 1;
        try {
            k2.resetHeight();
        } catch (AVLTreeException ex) {
        }


        //k1.height = max(height(k1.left()), k2.height) + 1;
        try {
            k1.resetHeight();
        } catch (AVLTreeException ex) {
        }
        return k1;
    }

    /* Rotate binary tree node with right child */
    private AVLNode rotateWithRightChild(AVLNode k1) {
        AVLNode k2 = k1.right();
        k1.setRight( k2.left());

        k2.setLeft(k1);
        try {
            k1.resetHeight();
        } catch (AVLTreeException ex) {
        }
        try {
            k2.resetHeight();
        } catch (AVLTreeException ex) {

        }

        //k1.height = max(height(k1.left()), height(k1.right())) + 1;

        //k2.height = max(height(k2.right), k1.height) + 1;


        return k2;

    }

    /**
     * Double rotate binary tree node: first left child with its right child;
     * then node k3 with new left child
     */
    private AVLNode doubleWithLeftChild(AVLNode k3) {
        k3.setLeft(rotateWithRightChild(k3.left()));
        return rotateWithLeftChild(k3);
    }

    /**
     * Double rotate binary tree node: first right child with its left child;
     * then node k1 with new right child
     */
    private AVLNode doubleWithRightChild(AVLNode k1) {
        k1.setRight(rotateWithLeftChild(k1.right()));
        return rotateWithRightChild(k1);
    }

    /* Functions to count number of nodes */
    public int countNodes() {
        return countNodes(root);
    }

    private int countNodes(AVLNode r) {
        if (r == null) {
            return 0;
        } else {
            int l = 1;
            l += countNodes(r.left());
            l += countNodes(r.right());
            return l;
        }
    }

    /* Functions to search for an element */
    public AVLNode<K,V> search(K val) {
        return search(root, val);
    }

    private AVLNode<K,V>  search(AVLNode<K,V> r, K val) {

        if (r==null)
        {
            return null;
        }
        else
        {
            K rval = r.element().getKey();
            if (((Comparable)val).compareTo(rval)<0) {
                return search(r.left(),val);
            } else if (((Comparable)val).compareTo(rval)>0) {
                return search(r.right(),val);
            } else {
                return r;
            }
        }

    }

    /* Function for inorder traversal */
    public void inorder() {
        inorder(root);
    }

    private void inorder(AVLNode r) {

        if (r != null) {
            inorder(r.left());
            System.out.print(r.element() + " ");
            inorder(r.right());
        }

    }

    /* Function for preorder traversal */
    public void preorder() {

        preorder(root);

    }

    private void preorder(AVLNode r) {

        if (r != null) {

            System.out.print(r.element() + " ");
            preorder(r.left());
            preorder(r.right());

        }

    }

    /* Function for postorder traversal */
    public void postorder() {
        postorder(root);
    }

    private void postorder(AVLNode r) {
        if (r != null) {
            postorder(r.left());
            postorder(r.right());
            System.out.print(r.element() + " ");

        }
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
            if(((Comparable)r.left().element().getKey()).compareTo(r.element())>=0)
                return false;
        }
        else if(r.right()!=null)
        {
            if(((Comparable)r.right().element().getKey()).compareTo(r.element())<=0)
                return false;
        }
        if(!isBST(r.left()))
            return false;
        if(!isBST(r.right()))
            return false;
        return true;

    }

}
