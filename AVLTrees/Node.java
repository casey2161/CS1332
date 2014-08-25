/**
 * Class to describe a node object used to store data in a tree
 *
 * @author Kushagra Mansingh
 *
 * DO NOT ALTER THIS FILE!
 */

public class Node<T> {
    private T data;
    private Node<T> left;
    private Node<T> right;
    private int balanceFactor;
    private int height;
    
    public Node(T data) {
        this.data = data;
    }
    
    /**
     * gets the data inside the node
     * @return the data inside of the node
     */
    public T getData() {
        return data;
    }
    
    /**
     * sets the data of this node
     * @param data the new value for data
     */
    public void setData(T data) {
        this.data = data;
    }
    
    /**
     * gets the left child of this node
     * @return the left child
     */
    public Node<T> getLeft() {
        return left;
    }
    
    /**
     * sets the left child of this node
     * @param left the new left child
     */
    public void setLeft(Node<T> left) {
        this.left = left;
    }
    
    /**
     * gets the right child of this node
     * @return the right child
     */
    public Node<T> getRight() {
        return right;
    }
    
    /**
     * sets the right child of this node
     * @param right the new node on the right
     */
    public void setRight(Node<T> right) {
        this.right = right;
    }
    
    /**
     * sets the balance factor of the node
     * @param balance factor
     */
    public void setBalanceFactor(int balanceFactor) {
    	this.balanceFactor = balanceFactor;
    }
    
    /**
     * gets the balance factor of the node
     * @return balance factor
     */
    public int getBalanceFactor() {
    	return balanceFactor;
    }
    
    /**
     * sets the height of the node
     * @param height
     * 
     */
    public void setHeight(int height) {
    	this.height = height;
    }
    
    /**
     * gets the height of the node
     * @return height
     */
    public int getHeight() {
    	return height;
    }
    /**
     * recursively generates a string representation of the node and it's children
     */
    public String toString() {
        if (left == null && right == null) {
            return "(" + data.toString() + "()" + "()" + ")";
        } else if (left == null) {
            return "(" + data.toString() + "()" + right.toString() + ")";
        } else if (right == null) {
            return "(" + data.toString() + left.toString() + "()" + ")";
        } else {
            return "(" + data.toString() + left.toString() + right.toString() + ")";
        }
    }
}