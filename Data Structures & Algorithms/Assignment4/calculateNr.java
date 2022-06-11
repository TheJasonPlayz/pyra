//This class contains the main method, declared with the usual method header: public static void
//main(String[] args) You can implement any other methods that you want in this class, but they
//must be declared as private methods.
//The code is calculating the number of words in a file.
import java.util.Iterator;

/**
 *CS2210 2022
 * @author Grace Gong
 * 251151854
 * @date March 31
 */
public class calculateNr {

    public static void main(String[] args) {
// It starts by grabbing an iterator into variable it, which is then used to get the next item in the iterator and insert that item into t1.
// The code repeats this process until there are no more items left in the iterator.

        if (args.length > 0) {
            FileWordRead words = new FileWordRead(args[0]);
            Iterator<String> it = words.getIterator(); // grabbing the iterator into variable it
            AVLTree<String, Integer> t1 = new AVLTree();
            while (it.hasNext()) { // Check if anything is left in the iterator
                String next = it.next(); // getting the next item in the iterator
                t1.insert(next);
            }
            t1.inorder();
            //Then t2 is created with two nodes: one for each word from the original file and another node for all duplicates found during iteration.
            //The code iterates through every single word in a file, checking if anything was left over after insertion into t1 or not.
            AVLTree<Integer, Integer> t2 = new AVLTree();
            AVLTree<String, Integer> duplicate = new AVLTree();
            it = words.getIterator();
            //If nothing was left over, then t2 gets its value from t1's search() method; otherwise, duplicate gets inserted before it so that they can be compared later on when searching for duplicates
            //The code iterates through the words file and creates an AVLTree
            while (it.hasNext()) {
                String next = it.next();
                if(duplicate.search(next)==null)
                {
                    t2.insert(t1.search(next).element().getValue());
                    duplicate.insert(next);
                }
            }
            System.out.println();
            t2.inorder();
        }
    }
}
