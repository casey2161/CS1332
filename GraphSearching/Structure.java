import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//DO NOT EDIT THIS CLASS!!! 

public interface Structure<T> {

	/**
	 * Checks if the Structure has no elements
	 * 
	 * @return true if structure is empty, false otherwise
	 */
	public boolean isEmpty();

	/**
	 * Removes all the elements from the structure
	 */
	public void clear();

	/**
	 * Adds node passed in a parameter to the structure according to the rules
	 * of the structure
	 * 
	 * @param node
	 */
	public void add(T node);

	/**
	 * Removes the node that should be removed next given the rules of the
	 * structure
	 * 
	 * @return
	 */
	public T remove();
	
}