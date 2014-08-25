import java.util.LinkedList;

//DO NOT EDIT THIS CLASS!!!
public class StructureQueue<T> implements Structure<T>{
	private LinkedList<T> q = new LinkedList<T>();
	
	@Override
	public boolean isEmpty(){
		return q.isEmpty();
	}
	
	@Override
	public void clear(){
		q.clear();
	}

	@Override
	public void add(T node){
		q.add(node);
	}
	
	@Override
	public T remove(){
		return(q.removeFirst());
	}
}