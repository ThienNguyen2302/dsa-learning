import java.util.*;

public class AdjacencyList {
	private int V; // No. of vertices
	private LinkedList<Integer> adj[];

	public AdjacencyList(int v) {
		this.V = v;
		this.adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList<Integer>();
	}

	public void addEdge(int u, int v) {
		adj[u].add(v);
	}

	public void printGraph() {
		for (int i = 0; i < V; i++) {
			System.out.print("Vertex " + i + ": ");
			System.out.print("head");
			for (Integer v : adj[i]) {
				System.out.print("->" + v);
			}
			System.out.println();
		}
	}

	public int numVertices() {
		return V;
	}

	public int numEdges() {
		int count = 0;
		for (int i = 0; i < V; i++) {
			for (Integer v : adj[i]) {
				count++;
			}
		}
		return count / 2;
	}

	public void enumerate(int u) {
		for (Integer v : adj[u - 1]) {
			System.out.print((v + 1) + " ");
		}
	}

	// test thu
	public boolean checkEdge(int u, int v) {
		return adj[u - 1].contains(v - 1);
	}
}