import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AVL<T extends Comparable<? super T>> implements BSTInterface<T> {
	//Add instance variables here
	private Node<T> root;
	private int size;
	
	@Override
	public void add(T data) {
		if (data == null) {
			throw new IllegalArgumentException();
		}
		if (contains(data)) {
			return;
		}
		root = add(data, root);
	}

	/**
	 * This is the recursive helper method for the add function
	 * @param data the data to add
	 * @param current the current position in the tree
	 */
	private Node<T> add(T data, Node<T> current) {
		if (current == null) {
			current = new Node<T>(data);
			current.setHeight(1);
			current.setBalanceFactor(0);
			size++;
		} else if (data.compareTo(current.getData()) < 0) {
			current.setLeft(add(data, current.getLeft()));
		} else {
			current.setRight(add(data, current.getRight()));
		}
		
		getBalanceFactor(current);		
		current = rotate(current);
		
		getHeight(current);
		getBalanceFactor(current);
		return current;
	}

	@Override
	public void addAll(Collection<T> c) {
		if (c == null) {
			throw new IllegalArgumentException();
		}
		for (T item : c) {
			add(item);
		}
	}

	@Override
	public T remove(T data) {
		if (data == null) {
			throw new IllegalArgumentException();
		}
		if (root == null) {
			return null;
		}
		T ret = get(data);
		root = remove(root, data);
		return ret;
	}
	
	/**
	 * This is the recursive helper method for removing a data entry
	 * @param current the current position in the tree
	 * @param data the data to remove
	 * @return the node that was modified
	 */
	private Node<T> remove(Node<T> current, T data) {
		if (current == null) {
			return null;
		}
		
		if (data.compareTo(current.getData()) < 0) {
			current.setLeft(remove(current.getLeft(), data));
			getBalanceFactor(current);
			current = rotate(current);
		} else if (data.compareTo(current.getData()) > 0) {
			current.setRight(remove(current.getRight(), data));
			getBalanceFactor(current);
			current = rotate(current);
		} else {
			if (current.getRight() != null && current.getLeft() != null) {
				current.setData(getSuccessor(current.getRight()).getData());
				current.setRight(remove(current.getRight(), current.getData()));
				size--;
			} else if (current.getRight() == null && current.getLeft() == null) {
				current = null;
				size--;
			} else if (current.getRight() == null) {
				current = current.getLeft();
				size--;
			} else {
				current = current.getRight();
				size--;
			}
		}
		getHeight(current);
		getBalanceFactor(current);
		return current;
	}
	
	/**
	 * This is another recursive helper method used in removing an entry.
	 * This method find the successor to the node that is removed
	 * @param start the current position in the tree 
	 * @return the node that is the successor
	 */
	private Node<T> getSuccessor(Node<T> start) {
		if (start.getLeft() == null) {
			//T data = start.getData();
			//start = null;
			return start;
		} else {
			return getSuccessor(start.getLeft());
		}
	}

	@Override
	public T get(T data) {
		if (data == null) {
			throw new IllegalArgumentException();
		}
		return get(data, root);
	}
	
	/**
	 * This is the recursive helper method for finding a specific data entry
	 * @param data the data to find
	 * @param current the current position in the tree
	 * @return the data if it exists, null otherwise
	 */
	private T get(T data, Node<T> current) {
		if (current == null) {
			return null;
		}
		
		if (current.getData().equals(data)) {
			return current.getData();
		}
		
		if (data.compareTo(current.getData()) < 0) {
			return get(data, current.getLeft());
		} else {
			return get(data, current.getRight());
		}
	}

	@Override
	public boolean contains(T data) {
		return get(data) != null;
	}

	@Override
	public List<T> preOrder() {
		ArrayList<T> accum = new ArrayList<T>();
		
		if (root == null) {
			return accum;
		}		
		preOrder(root, accum);		
		return accum;
	}
	
	/**
	 * This is a recursive helper method used to construct a preorder list
	 * @param current the current position in the tree
	 * @param accum the tree in pre-order
	 */
	private void preOrder(Node<T> current, List<T> accum) {
		if (current == null) {
			return;
		}
		accum.add(current.getData());
		preOrder(current.getLeft(), accum);
		preOrder(current.getRight(), accum);
	}

	@Override
	public List<T> inOrder() {
		ArrayList<T> accum = new ArrayList<T>();
		
		if (root == null) {
			return accum;
		}
		
		inOrder(root, accum);
		return accum;
	}
	
	/**
	 * This is a recursive helper method used to construct a inorder list
	 * @param current the current position in the tree
	 * @param accum the tree in in-order
	 */
	private void inOrder(Node<T> current, List<T> accum) {
		if (current == null) {
			return;
		}
		inOrder(current.getLeft(), accum);
		accum.add(current.getData());
		inOrder(current.getRight(), accum);
	}

	@Override
	public List<T> postOrder() {
		
		ArrayList<T> accum = new ArrayList<T>();
		
		if (root == null) {
			return accum;
		}
		
		postOrder(root, accum);
		
		return accum;
	}
	
	/**
	 * This is a recursive helper method used to construct a postorder list
	 * @param current the current position in the tree
	 * @param accum the tree in post-order
	 */
	private void postOrder(Node<T> current, List<T> accum) {
		if (current == null) {
			return;
		}
		postOrder(current.getLeft(), accum);
		postOrder(current.getRight(), accum);
		accum.add(current.getData());
	}
	
	@Override
	public List<T> levelOrder() {
		ArrayList<T> accum = new ArrayList<T>();
		
		if (root == null) {
			return accum;
		}
		Queue<Node<T>> queue = new LinkedList<Node<T>>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node<T> node = queue.remove();
			accum.add(node.getData());
			if (node.getLeft() != null) {
				queue.add(node.getLeft());
			}
			if (node.getRight() != null) {
				queue.add(node.getRight());
			}
		}
		return accum;
	}

	@Override
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		root = null;
		size = 0;
	}
	
	/**
	 * This method takes in an unbalanced node and balances that subtree.
	 * @param unbalanced Node of subtree that is unbalanced
	 * @return the balanced subtree
	 */
	private Node<T> rotate(Node<T> unbalanced) {
		if (unbalanced.getBalanceFactor() == 2) {
			if (unbalanced.getLeft().getBalanceFactor() == -1) {
				unbalanced.setLeft(rotateLeft(unbalanced.getLeft()));
			}
			return rotateRight(unbalanced);
		} else if (unbalanced.getBalanceFactor() == -2) {
			if (unbalanced.getRight().getBalanceFactor() == 1) {
				unbalanced.setRight(rotateRight(unbalanced.getRight()));
			}
			return rotateLeft(unbalanced);
		}
		return unbalanced;
	}
	
	/**
	 * This is a private helper method that performs a left rotation
	 * @param current the root node of the rotation
	 * @return current after the rotation is performed
	 */
	private Node<T> rotateLeft(Node<T> current) {
		Node<T> temp = current.getRight();
		current.setRight(temp.getLeft());
		temp.setLeft(current);
		getHeight(temp);
		getBalanceFactor(temp);
		getHeight(current);
		getBalanceFactor(current);
		return temp;
	}
	
	/**
	 * This is a private helper method that performs a right rotation
	 * @param current the root node of the rotation
	 * @return current after the rotation is performed
	 */
	private Node<T> rotateRight(Node<T> current) {
		Node<T> temp = current.getLeft();
		current.setLeft(temp.getRight());
		temp.setRight(current);
		getHeight(temp);
		getBalanceFactor(temp);
		getHeight(current);
		getBalanceFactor(current);
		return temp;
	}
	
	/**
	 * This method determines the height of a node and 
	 * sets the node's height variable to that value.
	 * @param current
	 */
	public void getHeight(Node<T> current) {
		if (current == null) {
			return;
		}
		if (current.getLeft() != null && current.getRight() != null) {
			if (current.getLeft().getHeight() > current.getRight().getHeight()) {
				current.setHeight(current.getLeft().getHeight() + 1);
			} else {
				current.setHeight(current.getRight().getHeight() + 1);
			}
		} else if (current.getRight() != null) {
			current.setHeight(current.getRight().getHeight() + 1);
		} else if (current.getLeft() != null) {
			current.setHeight(current.getLeft().getHeight() + 1);
		} else {
			current.setHeight(1);
		}
	}
	
	/**
	 * This method determines the balance factor of a node and 
	 * sets the node's balanceFactor variable to that value.
	 * @param current
	 */
	public void getBalanceFactor(Node<T> current) {
		if (current == null) {
			return;
		}
		if (current.getLeft() != null && current.getRight() != null) {
			current.setBalanceFactor(current.getLeft().getHeight() - current.getRight().getHeight());
		} else if (current.getRight() != null) {
			current.setBalanceFactor(-1 * current.getRight().getHeight());
		} else if (current.getLeft() != null) {
			current.setBalanceFactor(current.getLeft().getHeight());
		} else {
			current.setBalanceFactor(0);
		}
	}

	
	//DO NOT MODIFY OR USE ANY OF THE METHODS BELOW IN YOUR IMPLEMENTATION
	//These methods are for testing purposes only
	public Node<T> getRoot() {
		return root;
	}

	public void setRoot(Node<T> root) {
		this.root = root;
	}
}
