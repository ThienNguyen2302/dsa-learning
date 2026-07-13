import java.util.LinkedList;
import java.util.Queue;

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

	public int numVertices() {
		return NUMBER_OF_VERTICES;
	}

	public int numEdges() {
		int sum = 0;
		for (int i = 0; i < NUMBER_OF_VERTICES; i++) {
			for (int j = 0; j < NUMBER_OF_VERTICES; j++) {
				if (adj[i][j] != 0) {
					sum++;
				}
			}
		}
		return sum / 2;
	}

	public void enumerateNeighbors(int u) {
		System.out.println("cac dinh ke cua dinh " + (u) + "\n");
		for (int i = 0; i < NUMBER_OF_VERTICES; i++) {
			if (adj[u - 1][i] != 0) {
				System.out.print(i + 1 + " ");
			}
		}
	}

	// code tam
	public boolean checkEdge(int u, int v) {
		try {
			if (adj[u - 1][v - 1] != 0)
				return true;
			return false;
		} catch (ArrayIndexOutOfBoundsException indexBounce) {
			System.out.println("The vertices is invalid");
			return false;
		}
	}

	public AdjacencyList convertToAL() {
		AdjacencyList AL = new AdjacencyList(NUMBER_OF_VERTICES);
		for (int i = 0; i < NUMBER_OF_VERTICES; i++) {
			for (int j = 0; j < NUMBER_OF_VERTICES; j++) {
				if (adj[i][j] != 0) {
					AL.addEdge(i, j);
				}
			}
		}
		return AL;
	}

	public int[] BFS(int s) {
		boolean visited[] = new boolean[NUMBER_OF_VERTICES];
		Queue<Integer> queue = new LinkedList<Integer>();
		visited[s] = true;
		queue.add(s);
		int j = 1;
		int a[] = new int[NUMBER_OF_VERTICES];
		while (!queue.isEmpty()) {
			int x = queue.poll();
			for (int i = 0; i < NUMBER_OF_VERTICES; i++) {
				if (adj[x][i] != 0 && visited[i] == false) {
					queue.add(i);
					visited[i] = true;
				}
			}
			System.out.print(x + " ");
			a[j] = x;
		}
		return a;
	}

	public void DFS_recur(int v, boolean[] visited) {
		visited[v] = true;
		System.out.print(v + " ");
		for (int i = 0; i < NUMBER_OF_VERTICES; i++) {
			if (adj[v][i] != 0 && visited[i] == false) {
				DFS_recur(i, visited);
			}
		}
	}

	public void DFS(int s) {
		boolean[] visited = new boolean[NUMBER_OF_VERTICES];
		DFS_recur(s, visited);
	}
}
