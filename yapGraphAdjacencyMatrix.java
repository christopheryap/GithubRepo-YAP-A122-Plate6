import java.util.*;

/* YAPProblem6
Write a java program that receives the vertex pairs associated to the edges of a graph, the program should construct an
adjacency matrix for the graph. (Produce a version that works when loops, multiple edges, or directed edges are present.)
 */
public class yapGraphAdjacencyMatrix {
    public static void main(String[] args) {
        Scanner yapScanner = new Scanner(System.in);


        System.out.print("Enter the number of vertices: ");
        int yapNumVertices = yapScanner.nextInt();


        int[][] yapAdjacencyMatrix = new int[yapNumVertices][yapNumVertices];


        System.out.println("Enter the edges. Type 'done' when finished:");

        while (true) {
            String yapInput = yapScanner.next();
            if (yapInput.equalsIgnoreCase("done")) {
                break;
            }

            int yapU = Integer.parseInt(yapInput);
            int yapV = yapScanner.nextInt();

            if (yapU >= yapNumVertices || yapV >= yapNumVertices || yapU < 0 || yapV < 0) {
                System.out.println("Invalid vertex number. Please enter vertices between 0 and " + (yapNumVertices - 1));
                continue;
            }

            yapAdjacencyMatrix[yapU][yapV]++;
            // Since the graph is undirected, also increment the matrix value for the edge (v, u)
            if (yapU != yapV) {
                yapAdjacencyMatrix[yapV][yapU]++;
            }
        }

        // Print the adjacency matrix
        System.out.println("Adjacency Matrix:");
        for (int yapI = 0; yapI < yapNumVertices; yapI++) {
            for (int yapJ = 0; yapJ < yapNumVertices; yapJ++) {
                System.out.print(yapAdjacencyMatrix[yapI][yapJ] + " ");
            }
            System.out.println();
        }
    }
}

/* TEST CASES
Test case 1
Enter the number of vertices: 3
Enter the edges. Type 'done' when finished:
0 1
1 2
done
Adjacency Matrix:
0 1 0
1 0 1
0 1 0

Test case 2
Enter the number of vertices: 3
Enter the edges. Type 'done' when finished:
0 1
1 2
1 1
done
Adjacency Matrix:
0 1 0
1 1 1
0 1 0

Test case 3
Enter the number of vertices: 4
Enter the edges. Type 'done' when finished:
0 1
0 1
1 2
2 3
2 3
done
Adjacency Matrix:
0 2 0 0
2 0 1 0
0 1 0 2
0 0 2 0

Test case 4
Enter the number of vertices: 3
Enter the edges. Type 'done' when finished:
0 1
0 2
1 2
done
Adjacency Matrix:
0 1 1
1 0 1
1 1 0

Test case 5
Enter the number of vertices: 4
Enter the edges. Type 'done' when finished:
0 1
2 3
done
Adjacency Matrix:
0 1 0 0
1 0 0 0
0 0 0 1
0 0 1 0
 */