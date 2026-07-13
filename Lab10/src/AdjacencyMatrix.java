public class AdjacencyMatrix {
	private int[][] adj;
	private final int NUMBER_OF_VERTICES;

	public AdjacencyMatrix(int vertices) {
		NUMBER_OF_VERTICES = vertices;
		adj = new int[NUMBER_OF_VERTICES][NUMBER_OF_VERTICES];
	}

	public void setEdge(int vertexSource, int vertexDestination, int weight) {
		try {
			adj[vertexSource][vertexDestination] = weight;
			adj[vertexDestination][vertexSource] = weight;
		} catch (ArrayIndexOutOfBoundsException indexBounce) {
			System.out.println("The vertex is invalid");
		}
	}

	public int getEdge(int vertexSource, int vertexDestination) {
		try {
			return adj[vertexSource][vertexDestination];
		} catch (ArrayIndexOutOfBoundsException indexBounce) {
			System.out.println("The vertex is invalid");
		}
		return -1;
	}

	public void printGraph() {
		for (int i = 0; i < NUMBER_OF_VERTICES; i++) {
			for (int j = 0; j < NUMBER_OF_VERTICES; j++) {
				System.out.print(adj[i][j] + " ");
			}
			System.out.println();
		}
	}

	public int unReached(boolean[] r) {

		for (int i = 0; i < r.length; i++)
			if (r[i] == false)
				return i;

		return -1;
	}

	void printMinCostEdges(int[] a) {
		System.out.println("Edges in MST: ");
		for (int i = 0; i < NUMBER_OF_VERTICES; i++)
			System.out.println(a[i] + " --> " + i);
	}

	void printCoveredNodes(boolean[] Reached) {
		System.out.print("Covered Nodes = ");
		for (int i = 0; i < Reached.length; i++)
			if (Reached[i])
				System.out.print(i + " ");
		System.out.println();
	}

	public void Prim() {
		boolean[] Reached = new boolean[NUMBER_OF_VERTICES];
		int[] predNode = new int[NUMBER_OF_VERTICES];
		int x, y;
		Reached[0] = true;
		predNode[0] = 0;
		printCoveredNodes(Reached);
		for (int k = 1; k < NUMBER_OF_VERTICES; k++) {
			x = 0;
			y = 0;

			for (int i = 0; i < NUMBER_OF_VERTICES; i++)
				for (int j = 0; j < NUMBER_OF_VERTICES; j++) {
					if (adj[x][y] == 0 && !Reached[j]) {
						x = i;
						y = j;
					}
					if (Reached[i] && !Reached[j] && adj[i][j] < adj[x][y] && adj[i][j] != 0) {
						x = i;
						y = j;
					}
				}
			System.out.println("Next selected edge: (" + x + "," + y + ")" + " cost = " + adj[x][y]);
			predNode[y] = x;
			Reached[y] = true;

			printCoveredNodes(Reached);
			System.out.println();
		}
		printMinCostEdges(predNode);
	}

	public static void main(String[] args) {
		int[][] conn = { { 0, 4, 0, 0, 5 },
				{ 4, 0, 3, 6, 1 },
				{ 0, 3, 0, 6, 2 },
				{ 0, 6, 6, 0, 7 },
				{ 5, 1, 2, 7, 0 },
		};

		AdjacencyMatrix G = new AdjacencyMatrix(5);
		G.adj = conn;
		G.Prim();
	}
}