import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MST {
	private MinPQ<Edge> pq;
	private Queue<Edge> q;
	private int weight;
	private boolean marked[];
	
	public MST(EdgeWeightedGraph g) {
		pq = (MinPQ<Edge>) new MinPQ(g.V());
		weight = 0;
		marked = new boolean[g.V()];
		q = new LinkedList<Edge>();
		for (int i = 0; i < g.V(); i++)
			marked[i] = false;
		
		visit(g, 0);
		while(!pq.isEmpty()) {
			Edge e = pq.delMin();
			int v = e.either();
			int w = e.other(v);
			if (marked[v] && marked[w]) continue;
			q.add(e);
			weight += e.weight();
			if (!marked[v]) visit(g, v);
			if (!marked[w]) visit(g, w);
		}
		
	}
	
	private void visit(EdgeWeightedGraph g, int v) {
		marked[v] = true;
		for(Edge a : g.adj(v)) {
			pq.insert(a);
		}
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
		
		MST mst = new MST(g);
		Iterable<Edge> q = mst.edges();
		for(Edge e : q) {
			System.out.println(e.toString());
		}
	}
}
