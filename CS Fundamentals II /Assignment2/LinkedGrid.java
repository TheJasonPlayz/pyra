

/**
 *
 * @author
 * @param <T>
 */
public class LinkedGrid<T> {

    int width;
    int height;
    LinearNode<T>[] grid;

    /*
    public LinkedGrid(constructor) – takes in 2 parameters for width and height and assigns their
    values into the corresponding instance variables. The grid must be initialized properly by
    creating the LinearNode objects and connecting them as singly linked lists. The first
    node of each list must be stored in the corresponding array cell in the grid parameter.
     */

    /**
     *
     * @param width
     * @param height
     */

    public LinkedGrid(int width, int height) {
        this.width = width;
        this.height = height;
        grid = new LinearNode[width];
        for (int i = 0; i < width; i++) {
            LinearNode<T> node = null;
            for (int i1 = 0; i1 < height; i1++) {
                LinearNode<T> newNode = new LinearNode<T>();
                newNode.setNext(node);
                node = newNode;
            }
            grid[i] = node;
        }
    }

    /**
     * public void setElement(int col, int row, T data) – takes in 3 parameters:
     * int col, int row, T data. If the col or row is outside the bounds of the
     * grid, throw a LinkedListException. Otherwise, find the cell in the grid
     * at the given col, row pair and set the element of that node to the given
     * value, data.
     * @param col
     * @param row
     * @param data
     */
    public void setElement(int col, int row, T data) throws LinkedListException {
        if (col < 0 || col >= width || row < 0 || row >= height) {
            throw new LinkedListException("Invalid row or column");
        }
        LinearNode<T> node = grid[col];
        for (int i1 = 0; i1 < row; i1++) {
            LinearNode<T> newNode = new LinearNode<T>();
            newNode.setNext(node);
            node = node.getNext();
        }
        node.setElement(data);
    }

    /**
     * public LinearNode<T> getElement(int col, int row) – takes in 2
     * parameters: int col, int row. If the col or row is outside the bounds of
     * the grid, throw a LinkedListException. Otherwise, find the cell in the
     * grid at the given col, row pair and return the element contained in that
     * node.
     *
     *
     * @param col
     * @param row
     * @return 
     */
    public LinearNode<T> getElement(int col, int row) {

        if (col < 0 || col >= width || row < 0 || row >= height) {
            throw new LinkedListException("Invalid row or column");
        }
        LinearNode<T> node = grid[col];
        for (int i1 = 0; i1 < row; i1++) {
            LinearNode<T> newNode = new LinearNode<T>();
            newNode.setNext(node);
            node = node.getNext();
        }
        return node;
    }

    /**
     *
     * @return
     */
    public int getWidth() {
        return width;
    }

    /**
     *
     * @return
     */
    public int getHeight() {
        return height;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        String result = "";

        for (int i = 0; i < height; i++) {

            for (int i1 = 0; i1 < width; i1++) {
                T obj = this.getElement(i1, i).getElement();
                result += (obj == null ? "null" : obj.toString()) + "  ";

            }
            result += "\n";
        }
        return result;
    }

}
