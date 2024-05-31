import java.util.*;

public class yapCycleDetection {

    private int yapNumVertices;
    private LinkedList<Integer> yapAdjacencyList[];


    public yapCycleDetection(int yapV) {
        if (yapV < 0) {
            throw new IllegalArgumentException("Number of vertices must be non-negative");
        }
        yapNumVertices = yapV;
        yapAdjacencyList = new LinkedList[yapV];
        for (int yapI = 0; yapI < yapV; ++yapI) {
            yapAdjacencyList[yapI] = new LinkedList<>();
        }
    }


    public void yapAddEdge(int yapV, int yapW) {
        if (yapV < 0 || yapV >= yapNumVertices || yapW < 0 || yapW >= yapNumVertices) {
            throw new IllegalArgumentException("Vertex index out of bounds");
        }
        yapAdjacencyList[yapV].add(yapW);
        yapAdjacencyList[yapW].add(yapV);
    }


    private boolean yapIsCyclicUtil(int yapV, boolean yapVisited[], int yapParent) {
        yapVisited[yapV] = true;


        for (Integer yapVertex : yapAdjacencyList[yapV]) {

            if (!yapVisited[yapVertex]) {
                if (yapIsCyclicUtil(yapVertex, yapVisited, yapV))
                    return true;
            }
            // If an adjacent vertex is visited and not parent of the current vertex, then there is a cycle
            else if (yapVertex != yapParent)
                return true;
        }
        return false;
    }


    public boolean yapIsCyclic() {
        boolean yapVisited[] = new boolean[yapNumVertices];
        Arrays.fill(yapVisited, false);

        for (int yapU = 0; yapU < yapNumVertices; yapU++) {
            if (!yapVisited[yapU]) {
                if (yapIsCyclicUtil(yapU, yapVisited, -1))
                    return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner yapScanner = new Scanner(System.in);
        try {
            System.out.print("Enter the number of vertices: ");
            int yapV = yapScanner.nextInt();
            yapCycleDetection graph = new yapCycleDetection(yapV);

            System.out.print("Enter the number of edges: ");
            int yapE = yapScanner.nextInt();

            System.out.println("Enter the edges (format: v w): ");
            for (int yapI = 0; yapI < yapE; yapI++) {
                yapV = yapScanner.nextInt();
                int yapW = yapScanner.nextInt();
                graph.yapAddEdge(yapV, yapW);
            }

            if (graph.yapIsCyclic()) {
                System.out.println("Graph contains a cycle");
            } else {
                System.out.println("Graph doesn't contain a cycle");
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            yapScanner.close();
        }
    }
}

/* TEST CASES
Test case 1
Enter the number of vertices: 5
Enter the number of edges: 5
Enter the edges (format: v w):
0 1
0 2
1 2
1 3
3 4
Graph contains a cycle

Test case 2
Enter the number of vertices: 5
Enter the number of edges: 4
Enter the edges (format: v w):
0 1
0 2
2 3
3 4
Graph doesn't contain a cycle

Test case 3
Enter the number of vertices: 6
Enter the number of edges: 4
Enter the edges (format: v w):
0 1
1 2
3 4
4 5
Graph doesn't contain a cycle

Test case 4
Enter the number of vertices: 7
Enter the number of edges: 6
0 1
1 2
3 4
4 6
5 6
3 5
Graph contains a cycle

Test case 5
Enter the number of vertices: 4
Enter the number of edges: 4
0 1
1 2
2 3
3 0
Graph contains a cycle
 */