
public class Graph {
	private int V;
	private int E;
	private Bag<Integer>[] vertices;
	
	public Graph(Integer V) {
		this.V = V;
		E = 0;
		for(int i = 0; i < V; i++) {
			vertices[i] = new Bag<Integer>();
		}
	}
	
	public void addEdge(int a, int b) {
		vertices[a].add(b);
		vertices[b].add(a);
		E++;
	}
	
	public int V() {
		return this.V;
	}
	
	public int E() {
		return this.E;
	}
	
	public Iterable<Integer> adj(int v){
		return vertices[v];
	}
}
