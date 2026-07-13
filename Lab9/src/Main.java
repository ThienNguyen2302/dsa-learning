import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static AdjacencyMatrix ReadAM(File f) {
		try {
			String[] b;
			Scanner myReader = new Scanner(f);
			String data = myReader.nextLine();
			AdjacencyMatrix am = new AdjacencyMatrix(Integer.parseInt(data));
			int i = 0;
			while (myReader.hasNextLine()) {
				data = myReader.nextLine();
				b = data.split(" ");
				for (int j = 0; j < b.length; j++) {
					if (b[j] != "0") {
						am.setEdge(i, j, Integer.parseInt(b[j]));
					}
				}
				i += 1;
			}
			myReader.close();
			return am;
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return null;
	}

	public static AdjacencyList ReadAL(File f) {
		try {
			String[] b;
			Scanner myReader = new Scanner(f);
			String data = myReader.nextLine();
			AdjacencyList al = new AdjacencyList(Integer.parseInt(data));
			while (myReader.hasNextLine()) {
				data = myReader.nextLine();
				b = data.split(" ");
				for (int j = 1; j < b.length; j++) {
					al.addEdge(Integer.parseInt(b[0]), Integer.parseInt(b[j]));
				}
			}
			myReader.close();
			return al;
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return null;
	}

	public static EdgeList ReadEL(File f) {
		try {
			String[] b;
			Scanner myReader = new Scanner(f);
			EdgeList el = new EdgeList();
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				b = data.split(" ");
				el.addEdge(Integer.parseInt(b[0]), Integer.parseInt(b[1]), Integer.parseInt(b[2]));
			}
			myReader.close();
			return el;
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		File f = new File("src/AdjacencyMatrixSource.txt");
		AdjacencyMatrix AM = ReadAM(f);
		AM.printGraph();
		if (AM.checkEdge(3, 7)) {
			System.out.println("1");
		}
		f = new File("src/AdjacencyListSource.txt");
		AdjacencyList AL = ReadAL(f);
		AL.printGraph();
		if (AL.checkEdge(1, 4)) {
			System.out.println("1");
		}
		f = new File("src/EdgeListSource.txt");
		EdgeList EL = ReadEL(f);
		EL.printGraph();
		AdjacencyList AML = AM.convertToAL();
		AM.BFS(6);
		AML.numEdges();

	}
}
