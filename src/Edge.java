
public class Edge implements Comparable<Edge>{
	private final double weight;
	private final int v;
	private final int w;
	
	public Edge(int v, int w, double weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
	}
	
	public double weight() {
		return this.weight;
	}
	
	public int either() {
		return v;
	}
	
	public int other(int v) {
		if (v == this.v) return w;
		else if (v == w) return this.v;
		else throw new RuntimeException("Inconsistent Edge");
	}
	
	public int compareTo(Edge that) {
		if (weight > that.weight()) return 1;
		else if(weight < that.weight()) return -1;
		else return 0;
	}
	
	public String toString() {
		return String.format("%d - %d : %f", v, w, weight);
	}
	
}
