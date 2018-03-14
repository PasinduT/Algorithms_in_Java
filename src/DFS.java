import java.util.Stack;

public class DFS {
	private Graph graph;
	private boolean marked[];
	private int s;
	private int edgeTo[];
	
	public DFS(Graph graph, int s) {
		this.graph = graph;
		marked = new boolean[graph.V()];
		for (int i = 0; i < graph.V(); i++) {
			marked[i] = false;
		}
		this.s = s;
		runDFS(s);
	}
	
	public void runDFS(int V) {
		marked[V] = true;
		for (int a : graph.adj(V)) {
			if(!marked[a]) {
				edgeTo[a] = V;
				runDFS(a);
			}
		}
	}
	
	public boolean hasPathTo(int v) {
		return marked[v];
	}
	
	public Iterable<Integer> pathTo(int v){
		if (!hasPathTo(v)) return null;
		Stack<Integer> path = new Stack<Integer>();
		for(int c = v; c != s; ) {
			path.push(c);
			c = edgeTo[c];
		}
		path.push(s);
		return path;
	}
}
