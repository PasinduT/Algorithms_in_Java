
public class ConnectedComponents {
	private boolean marked[];
	private Graph graph;
	private int id[];
	private int count;
	
	public ConnectedComponents(Graph graph) {
		this.graph = graph;
		marked = new boolean[graph.V()];
		id = new int[graph.V()];
		
		for(int i = 0; i < graph.V(); i++)
			marked[i] = false;
		
		count = 0;
		for(int i = 0; i < graph.V(); i++) {
			if (!marked[i]) {
				dfs(i);
				count++;
			}
		}		
	}
	
	public boolean connected(int v, int w) {
		return id[v] == id[w];
	}
	
	private void dfs(int v) {
		this.id[v] = count;
		marked[v] = true;
		for(int a : graph.adj(v)) 
			if(!marked[a]) 
				dfs(a);
	}
	
	public int count() {
		return this.count;
	}
	
	public int id(int v) {
		return id[v];
	}

}
