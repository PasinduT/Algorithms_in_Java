
public class EdgeWeightedGraph {
	private int V;
	private int E;
	private Bag<Edge> adj[];

	public EdgeWeightedGraph(int V) {
		this.V = V;
		this.E = 0;
		adj = (Bag<Edge>[]) new Bag[V];
		for (int i = 0; i < V; i++)
			adj[i] = new Bag<Edge>();
	}
	
	public void addEdge(Edge edge) {
		int v = edge.either();
		int w = edge.other(v);
		adj[v].add(edge);
		adj[w].add(edge);
		E++;
	}
	
	public int E() {
		return this.E;
	}
	
	public int V() {
		return V;
	}
	
	public Iterable<Edge> adj(int v) {
		return adj[v];
	}
	
	public Iterable<Edge> edges(){
		Bag<Edge> b = new Bag<Edge>();
		for (int i = 0; i<V; i++) {
			for(Edge a : adj[i]) {
				if (a.other(i) > i)
					b.add(a);
			}
		}
		return b;
	}
}
