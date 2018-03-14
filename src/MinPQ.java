
public class MinPQ {

	private int qu[];
	private int N;
	private int size;
	
	public MinPQ(int size) {
		this.size = size;
		qu = new int[size + 1];
		this.N = 0;
	}
	
	private void resize(int size) {
		int q [] = new int[size];
		for (int i = 0; i < N; i++) {
			q[i] = qu[i];
		}
		this.qu = q;
		this.size = size;
	}
	
	public void add(int item) {
		if (N == size-2) resize(2*size);
		qu[++N] = item;
		swim(N);
	}
	
	public boolean isEmpty() {
		return N==0;
	}
	
	public int min() throws Exception {
		if (isEmpty()) throw new Exception("PQ is empty");
		int head = qu[1];
		qu[1] = qu[N--];
		sink(1);
		return head;
	}
	
	private void sink(int k) {
		int temp = qu[k];
		int n = 2*k;
		while(n <= N && temp > qu[n]) {
			qu[k] = qu[n];
			qu[n] = temp;
			k = n;
			n = 2*k;
		}
	}
	
	private void swim(int k) {
		int temp = qu[k];
		int n = k/2;
		while(n>0 && temp < qu[n]) {
			qu[k] = qu[n];
			qu[n] = temp;
			k = n;
			n = k/2;
		}
	}
	
}
