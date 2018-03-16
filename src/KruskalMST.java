import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class KruskalMST {
	private Edge arr[];
	private Queue<Edge> q;
	private double weight;
	private int marked[];
	
	public KruskalMST(EdgeWeightedGraph g) {
		arr = new Edge[g.E()];
		weight = 0.0;
		marked = new int[g.V()];
		q = new LinkedList<Edge>();
		for (int i = 0; i < g.V(); i++)
			marked[i] = i;
		
		int i = 0;
		for (Edge e : g.edges())
			arr[i++] = e;
		
		Arrays.sort(arr);
		for (Edge e : arr) {
			int v =  e.either();
			int w = e.other(v);
			if(root(marked[v]) == root(marked[w])) continue;
			q.add(e);
			weight += e.weight();
			marked[root(v)] = root(w);
		}
		
	}
	private int root(int v) {
		while(v != marked[v])
			v = marked[v];
		return v;
	}
	
	public Iterable<Edge> edges(){
		return q;
	}
	
	public double weight() {
		return weight;
	}
	
	public static void main(String [] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter the number of vertices:");
		int n = in.nextInt();
		EdgeWeightedGraph g = new EdgeWeightedGraph(n);
		
		System.out.println("Enter the number of edges:");
		n = in.nextInt();
		
		for(int i = 0; i < n; i++) {
			int v = in.nextInt();
			int w = in.nextInt();
			double weight = in.nextDouble();
			Edge e = new Edge(v, w, weight);
			g.addEdge(e);
		}
		
		KruskalMST mst = new KruskalMST(g);
		Iterable<Edge> q = mst.edges();
		for(Edge e : q) {
			System.out.println(e.toString());
		}
		System.out.println("Weight: " + mst.weight());
	}
}
