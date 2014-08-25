import java.util.Stack;

//DO NOT EDIT THIS CLASS!!!
public class StructureStack<T> implements Structure<T>{
	private Stack<T> s = new Stack<T>();
	
	@Override
	public boolean isEmpty(){
		return(s.empty());
	}

	@Override
	public void clear(){
		while(!s.empty()){
			s.pop();
		}
	}

	@Override
	public void add(T node){
		s.push(node);
	}

	@Override
	public T remove(){
		return(s.pop());
	}
}