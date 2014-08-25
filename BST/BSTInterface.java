import java.util.Collection;
import java.util.List;

/**
 * This interface describes the public methods needed for 
 * a Binary Search Tree, which is a binary tree that utilizes
 * the property that everything to the left of a given node
 * will be less than it, and all nodes to the right greater
 * than it.
 *
 * DO NOT ALTER THIS FILE!!
 * 
 * @author Kevin Simon
 * @author Kush Mansingh
 */

public interface BSTInterface<T extends Comparable<? super T>> {
    
    /**
     * The toString method is used for debugging purposes.  The code is given
     * to you in the assignment pdf, so use that code exactly.  Do not change
     * the spacing or anything.  Literally copy and paste that exact code.
     *
     */
    public String toString();
    
    /**
     * Add data to the binary search tree.  All data to the left of
     * a node must be less than it, and all data to the right must be
     * greater than it. If the data is null throw IllegalArgumentException.
     * Do not add duplicate data to the tree.
     * 
     * @param data Data to be added to the tree.
     *            
     */
    public void add(T data);
    
    /**
     * Add the contents of the collection to the BST. 
     * If the data is null throw IllegalArgumentException.
     * 
     * @param collection A collection of data to be added to the tree.
     *            
     */
    public void addAll(Collection<T> c);
    
    /**
     * Remove the data element from the tree.
     * 
     * In the case that a node you want to remove has two children
     * replace it with the successor. If the data is null throw 
     * IllegalArgumentException.
     * 
     * @param data The data you want to remove.
     *            
     * @return The data that was removed from the tree. Return null if
     *         the data doesn't exist.
     */
    public T remove(T data);
    
    /**
     * Get the data from the tree.
     * 
     * This method simply returns the data that was stored in the tree.
     * If the data is null throw IllegalArgumentException.
     *
     * @param data The data you are searching for.
     *
     * @return The data that was found in the tree. Return null if the data
     *         doesn't exist.
     */
    public T get(T data);
    
    /**
     * See if the tree contains the data.
     * If the data is null throw IllegalArgumentException. 
     * 
     * @param data The data to search for in the tree.
     *            
     * @return Return true if the data is in the tree, false otherwise.
     */
    public boolean contains(T data);
    
    /**
     * Linearize the tree using the pre-order traversal.
     * 
     * @return A list that contains every element in pre-order.
     */
    public List<T> preOrder();
    
    /**
     * Linearize the tree using the in-order traversal.
     * 
     * @return A list that contains every element in-order.
     */
    public List<T> inOrder();
    
    /**
     * Linearize the tree using the post-order traversal.
     * 
     * @return A list that contains every element in post-order.
     */
    public List<T> postOrder();
    
    /**
     * Linearize the tree using the level-order traversal.
     * 
     * @return A list that contains every element in level-order.
     *
     */
    public List<T> levelOrder();
    
    /**
     * Test to see if the tree is empty.
     * 
     * @return Return true if the tree is empty, false otherwise.
     */
    public boolean isEmpty();
    
    /**
     * 
     * @return Return the number of elements in the tree.
     */
    public int size();
    
    /**
     * Clear the tree.
     */
    public void clear();
}
