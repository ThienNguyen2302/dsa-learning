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

	public void krustkal() {

		for (int i = 0; i < edges.size(); i++) {
			for (int j = 0; j < edges.size() - i - 1; j++) {
				if ((edges.get(j).compareTo(edges.get(j + 1))) == 1) {
					IntegerTriple tmp = edges.get(j);
					edges.set(j, edges.get(j + 1));
					edges.set(j + 1, tmp);
				}
			}
		}
		UnionFind uf = new UnionFind(edges.size());
		for (int i = 0; i < edges.size(); i++) {
			int v = edges.get(i).getDest();
			int w = edges.get(i).getWeight();
			if (uf.isSameSet(v, w)) {

			}
		}
	}

	public static void main(String[] args) {
		EdgeList tmp = new EdgeList();
		tmp.addEdge(0, 4, 5);
		tmp.addEdge(0, 1, 4);
		tmp.addEdge(1, 4, 1);
		tmp.krustkal();
	}
}