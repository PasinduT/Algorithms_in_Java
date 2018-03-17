import java.util.Iterator;

public class IndexMinPQ<Item extends Comparable<Item>>{
	private int size;
	private int n;
	private int [] pq;
	private int [] qp;
	private Item [] items;
	
	public IndexMinPQ(int capacity) {
		pq = new int[capacity];
		items = (Item[]) new Object[capacity];
		qp = new int[capacity];
		n = 0;
		size = capacity;
	}
	
	public void insert(Item key, int k) {
		items[k] = key;
		pq[++n] = k;
		swim(n);
	}
	
	private void swim(int p) {
		Item t = items[pq[p]];
		int n = p/2;
		while(n > 0 && items[pq[n]].compareTo(t) < 0) {
			int temp = pq[p];
			pq[p] = pq[n];
			pq[n] = temp;
			p = n;
			n = n/2;
		}
		qp[pq[p]] = p;
	}
	
	public int delMin() {
		if(isEmpty()) throw new RuntimeException("PQ is empty");
		int res = pq[1];
		pq[1] = pq[n--];
		sink(1);
		qp[res] = 0;
		return res;
	}
	
	public Item min() {
		if(isEmpty()) throw new RuntimeException("PQ is empty");
		return items[pq[1]];
	}
	
	
	private void sink(int p) {
		Item t = items[pq[p]];
		int n = 2*p;
		while(n <= this.n && t.compareTo(items[pq[n]]) > 0) {
			int temp = pq[n];
			pq[n] = pq[p];
			pq[p] = temp;
			p = n;
			n = n * 2;
		}
		qp[pq[p]] = p;
	}
	
	public void decreaseKey(int p, Item key) {
		items[p] = key;
		swim(qp[p]);
	}
	
	public boolean isEmpty() {
		return n == 0;
	}
	
	public int size() {
		return n;
	}
	
	public boolean contains(int k) {
		return qp[k] != 0;
	}
	
	public void delete(int k) {
		if(!contains(k)) throw new RuntimeException("No such element found");
		int res = pq[k];
		pq[k] = pq[n--];
		sink(k);
		qp[res] = 0;
	}

}
