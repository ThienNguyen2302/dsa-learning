import java.util.Vector;

public class EdgeList {
	private Vector<IntegerTriple> edges;

	public EdgeList() {
		edges = new Vector<IntegerTriple>();
	}

	public void addEdge(int w, int u, int v) {
		edges.add(new IntegerTriple(w, u, v));
	}

	public void printGraph() {
		for (int i = 0; i < edges.size(); i++) {
			System.out.println(edges.get(i));
		}
	}

	public int numEdges() {
		return edges.size();
	}

	public int numVertices() {
		int max = 0;
		for (int i = 0; i < edges.size(); i++) {
			if (edges.get(i).getSource() > max)
				max = edges.get(i).getSource();
			if (edges.get(i).getDest() > max)
				max = edges.get(i).getDest();
		}
		return max + 1;
	}

	public boolean checkEdges(int u, int v) {
		for (int i = 0; i < edges.size(); i++) {
			if (edges.get(i).getSource() == u)
				if (edges.get(i).getDest() == v)
					return true;
		}
		return false;
	}

	public void enumerateNeighbors(int u) {
		for (int i = 0; i < edges.size(); i++) {
			if (edges.get(i).getSource() == u) {
				System.out.print(edges.get(i).getDest() + " ");
			}
			if (edges.get(i).getDest() == u) {
				System.out.print(edges.get(i).getSource() + " ");
			}
		}
	}
}