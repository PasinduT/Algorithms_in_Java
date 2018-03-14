import java.util.Scanner;

public class PQ {
	private int qu[];
	private int N;
	private int size;
	
	public PQ(int size) {
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
	
	public int max() throws Exception {
		if (isEmpty()) throw new Exception("PQ is empty");
		int head = qu[1];
		qu[1] = qu[N--];
		sink(1);
		return head;
	}
	
	private void sink(int k) {
		int temp = qu[k];
		int n = 2*k;
		while(n <= N && temp < qu[n]) {
			qu[k] = qu[n];
			qu[n] = temp;
			k = n;
			n = 2*k;
		}
	}
	
	private void swim(int k) {
		int temp = qu[k];
		int n = k/2;
		while(n>0 && temp > qu[n]) {
			qu[k] = qu[n];
			qu[n] = temp;
			k = n;
			n = k/2;
		}
	}
	
	public void print() {
		System.out.print("[");
		for(int i = 0; i < N; i++) {
			System.out.print(qu[i] + ", ");
		}
		System.out.println(qu[N] + "]");
	}
	
	public static void main(String [] args) throws Exception {
		PQ pq = new PQ(10);
		Scanner in = new Scanner(System.in);
		
		while(true) {
			System.out.println("Enter a number to add to the queue:");
			int resp = in.nextInt();
			if (resp == -1) break;
			else if(resp == -2) {
				System.out.println(pq.max());
				pq.print();
				continue;
			}
			pq.add(resp);
			pq.print();
		}
		
		in.close();
	}
}
