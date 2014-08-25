import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * This class is the java representation of a Binary Search Tree
 * @author casey
 *
 * @param <T> the type of object being held
 */
public class BST<T extends Comparable<T>> implements BSTInterface<T> {

	private Node<T> root;
	private int size = 0;
	
	@Override
	public void add(T data) {
		if (data == null) {
			throw new IllegalArgumentException();
		}
		if (contains(data)) {
			return;
		}
		if (root == null) {
			root = new Node<T>(data);
			size++;
		} else {
			add(data, root);
		}
	}
	
	/**
	 * This is the recursive helper method for the add function
	 * @param data the data to add
	 * @param current the current position in the tree
	 */
	private void add(T data, Node<T> current) {
		if (current == null) {
			current = new Node<T>(data);
			size++;
			return;
		}
		
		if (data.compareTo(current.getData()) < 0) {
			if (current.getLeft() != null) {
				add(data, current.getLeft());
			} else {
				size++;
				current.setLeft(new Node<T>(data));
			}
		} else {
			if (current.getRight() != null) {
				add(data, current.getRight());
			} else {
				size++;
				current.setRight(new Node<T>(data));
			}
		}
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
		} else if (data.compareTo(current.getData()) > 0) {
			current.setRight(remove(current.getRight(), data));
		} else {
			if (current.getRight() != null && current.getLeft() != null) {
				current.setData(getSuccessor(current.getRight()).getData());
				current.setRight(remove(current.getRight(), current.getData()));
			} else if (current.getRight() == null && current.getLeft() == null) {
				current = null;
			} else if (current.getRight() == null) {
				current = current.getLeft();
			} else {
				current = current.getRight();
			}
		}
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
	
	@Override
	public String toString() {
		if (root == null) {
			return "()";
		}
		return root.toString();
	}
}
