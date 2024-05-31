import java.util.*;

public class yapBipartiteGraphChecker {

/* YAPProblem5
Write a java program that receives a list of edges of a simple graph and
determine whether the graph is bipartite.
 */
    public static boolean yapIsBipartite(int yapV, List<int[]> yapEdges) {

        List<List<Integer>> yapAdj = new ArrayList<>();
        for (int yapI = 0; yapI < yapV; yapI++) {
            yapAdj.add(new ArrayList<>());
        }


        for (int[] yapEdge : yapEdges) {
            yapAdj.get(yapEdge[0]).add(yapEdge[1]);
            yapAdj.get(yapEdge[1]).add(yapEdge[0]);
        }

        // Array to store colors, initialized with -1
        int[] yapColor = new int[yapV];
        Arrays.fill(yapColor, -1);

        // BFS to check bipartite nature
        for (int yapI = 0; yapI < yapV; yapI++) {
            if (yapColor[yapI] == -1) {
                if (!yapBfsCheck(yapAdj, yapColor, yapI)) {
                    return false;
                }
            }
        }
        return true;
    }

    // BFS to check if the graph can be colored using two colors
    private static boolean yapBfsCheck(List<List<Integer>> yapAdj, int[] yapColor, int yapStart) {
        Queue<Integer> yapQueue = new LinkedList<>();
        yapQueue.add(yapStart);
        yapColor[yapStart] = 0;

        while (!yapQueue.isEmpty()) {
            int yapNode = yapQueue.poll();

            for (int yapNeighbor : yapAdj.get(yapNode)) {
                if (yapColor[yapNeighbor] == -1) { // Not colored yet
                    yapColor[yapNeighbor] = 1 - yapColor[yapNode]; // Alternate color
                    yapQueue.add(yapNeighbor);
                } else if (yapColor[yapNeighbor] == yapColor[yapNode]) { // Same color as current node
                    return false; // Not bipartite
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner yapScanner = new Scanner(System.in);


        System.out.print("Enter the number of vertices: ");
        int yapV = yapScanner.nextInt();


        System.out.print("Enter the number of edges: ");
        int yapE = yapScanner.nextInt();

        // Read the edges
        List<int[]> yapEdges = new ArrayList<>();
        System.out.println("Enter the edges : ");
        for (int yapI = 0; yapI < yapE; yapI++) {
            int yapU = yapScanner.nextInt();
            int yapv = yapScanner.nextInt();
            yapEdges.add(new int[]{yapU, yapv});
        }

        // Check if the graph is bipartite
        boolean yapResult = yapIsBipartite(yapV, yapEdges);
        if (yapResult) {
            System.out.println("The graph is bipartite.");
        } else {
            System.out.println("The graph is not bipartite.");
        }

        yapScanner.close();
    }
}

/* TEST CASES
Test case 1
Enter the number of vertices: 4
Enter the number of edges: 4
Enter the edges (format: u v):
0 1
0 3
1 2
2 3
The graph is bipartite.

Test case 2
Enter the number of vertices: 3
Enter the number of edges: 3
Enter the edges (format: u v):
0 1
1 2
2 0
The graph is not bipartite.

Test case 3
Enter the number of vertices: 6
Enter the number of edges: 4
Enter the edges (format: u v):
0 1
0 2
3 4
3 5
The graph is bipartite.

Test case 4
Enter the number of vertices: 4
Enter the number of edges: 3
Enter the edges (format: u v):
0 1
0 3
1 3
The graph is not bipartite.

Test case 5
Enter the number of vertices: 6
Enter the number of edges: 7
Enter the edges (format: u v):
0 1
0 2
1 3
1 4
2 4
3 5
4 5
The graph is bipartite.
 */