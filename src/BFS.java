import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BFS {
	private Graph graph;
	private boolean marked[];
	private int s;
	private int edgeTo[];
	
	public BFS(Graph graph, int s) {
		this.graph = graph;
		marked = new boolean[graph.V()];
		for (int i = 0; i < graph.V(); i++) {
			marked[i] = false;
		}
		this.s = s;
		runBFS(s);
	}
	
	public void runBFS(int v) {
		Queue<Integer> qu = new LinkedList<>();
		qu.add(v);
		marked[v] = true;
		while(!qu.isEmpty()) {
			int c = qu.remove();
			for(int a : graph.adj(c)){
				if(!marked[a]) {
					qu.add(a);
					edgeTo[a] = v;
				}
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
