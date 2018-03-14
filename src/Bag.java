
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Bag<Item> implements Iterable<Item>{

	private class Node<I> {
		public I data;
		public Node<I> next;
		
		public Node(I data, Node<I> next) {
			this.data = data;
			this.next = next;
		}
	}
	
	private int n;
	private Node<Item> first;
	
	public Bag() {
		first = null;
		n = 0;
	}
	
	public void add(Item data) {
		if (first == null) first.data = data;
		else first = new Node<Item>(data, first);
		n++;
	}
	
	public int size() {
		return n;
	}
	
	public boolean isEmpty() {
		return n == 0;
	}
	
	public Iterator<Item> iterator(){
		return new ListIterator<Item>(first);
	}
	
	private class ListIterator<I> implements Iterator<I>{
		private Node<I> current;
		
		public ListIterator(Node<I> first) {
			current = first;
		}
		
		public boolean hasNext() { return current != null; }
		public void remove() { ; }
		public I next() {
			if (!hasNext()) throw new NoSuchElementException();
			I data = current.data;
			current = current.next;
			return data;
		}
	}
}
