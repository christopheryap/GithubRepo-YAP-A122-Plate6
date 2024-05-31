import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class YAPProblem2 {
/*
Write a java program that accepts an adjacency matrix of a graph. The program should list the edges of this
graph and give the number of times each edge appears.
 */
    public static void main(String[] args) {
        Scanner yapScanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices in the graph: ");
        int yapVertices = yapScanner.nextInt();

        int[][] yapAdjacencyMatrix = new int[yapVertices][yapVertices];

        System.out.println("Enter the adjacency matrix: ");
        for (int yapI = 0; yapI < yapVertices; yapI++) {
            for (int yapJ = 0; yapJ < yapVertices; yapJ++) {
                yapAdjacencyMatrix[yapI][yapJ] = yapScanner.nextInt();
            }
        }

        Map<String, Integer> yapEdgeCountMap = new HashMap<>();

        /* +1 on yapI on inner loop = Traverse the upper triangle of the adjacency matrix to find edges and
        to avoid doubling the count of edges. */
        for (int yapI = 0; yapI < yapVertices; yapI++) {
            for (int yapJ = yapI + 1; yapJ < yapVertices; yapJ++) {
                if (yapAdjacencyMatrix[yapI][yapJ] > 0) {
                    String yapEdge = "(" + yapI + ", " + yapJ + ")";
                    yapEdgeCountMap.put(yapEdge, yapAdjacencyMatrix[yapI][yapJ]);
                }
            }
        }

        System.out.println("\nEdges and their counts:");
        for (Map.Entry<String, Integer> yapEntry : yapEdgeCountMap.entrySet()) {
            System.out.println("Edge " + yapEntry.getKey() + " appears " + yapEntry.getValue() + " times.");
        }

        yapScanner.close();
    }
}


/* TEST CASES
Test case 1
Enter the number of vertices in the graph: 4
Enter the adjacency matrix:
0 1 2 0
1 0 0 1
2 0 0 3
0 1 3 0

Edges and their counts:
Edge (2, 3) appears 3 times.
Edge (0, 2) appears 2 times.
Edge (1, 3) appears 1 times.
Edge (0, 1) appears 1 times.

Test case 2
Enter the number of vertices in the graph: 2
Enter the adjacency matrix:
0 1
1 0

Edges and their counts:
Edge (0, 1) appears 1 times.

Test case 3
Enter the number of vertices in the graph: 3
Enter the adjacency matrix:
0 2 1
2 0 3
1 3 0

Edges and their counts:
Edge (0, 2) appears 1 times.
Edge (1, 2) appears 3 times.
Edge (0, 1) appears 2 times.

Test case 4
Enter the number of vertices in the graph: 4
Enter the adjacency matrix:
0 1 0 0
1 0 2 2
0 2 0 3
0 2 3 0

Edges and their counts:
Edge (2, 3) appears 3 times.
Edge (1, 3) appears 2 times.
Edge (1, 2) appears 2 times.
Edge (0, 1) appears 1 times.

Test case 5
Enter the number of vertices in the graph: 5
Enter the adjacency matrix:
0 1 1 1 1
1 0 1 1 1
1 1 0 1 1
1 1 1 0 1
1 1 1 1 0

Edges and their counts:
Edge (3, 4) appears 1 times.
Edge (2, 3) appears 1 times.
Edge (2, 4) appears 1 times.
Edge (0, 3) appears 1 times.
Edge (0, 2) appears 1 times.
Edge (1, 4) appears 1 times.
Edge (0, 4) appears 1 times.
Edge (1, 3) appears 1 times.
Edge (1, 2) appears 1 times.
Edge (0, 1) appears 1 times.
 */