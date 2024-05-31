import java.util.*;

public class YAPProblem1 {
    /*
    Write a java program that receives a list of edges of a simple graph, the program should determine whether it is connected
and find the number of connected components if it is not connected.
     */
    private static List<List<Integer>> yapAdjacencyList;
    private static boolean[] yapVisited;

    public static void main(String[] args) {
        Scanner yapScanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int yapNumVertices = yapScanner.nextInt();

        System.out.print("Enter the number of edges: ");
        int yapNumEdges = yapScanner.nextInt();

        yapAdjacencyList = new ArrayList<>();
        // use 1-based indexing
        for (int yapI = 0; yapI <= yapNumVertices; yapI++) {
            yapAdjacencyList.add(new ArrayList<>());
        }

        System.out.println("Enter the edges (u v):");
        for (int yapI = 0; yapI < yapNumEdges; yapI++) {
            int yapU = yapScanner.nextInt();
            int yapV = yapScanner.nextInt();
            yapAdjacencyList.get(yapU).add(yapV);
            yapAdjacencyList.get(yapV).add(yapU);
        }

        yapVisited = new boolean[yapNumVertices + 1];

        int yapComponents = 0;
        for (int yapV = 1; yapV <= yapNumVertices; yapV++) {
            if (!yapVisited[yapV]) {
                yapComponents++;
                yapDfs(yapV);
            }
        }

        if (yapComponents == 1) {
            System.out.println("The graph is connected.");
        } else {
            System.out.println("The graph is not connected.");
            System.out.println("Number of connected components: " + yapComponents);
        }

        yapScanner.close();
    }

    private static void yapDfs(int yapV) {
        Stack<Integer> yapStack = new Stack<>();
        yapStack.push(yapV);

        while (!yapStack.isEmpty()) {
            int yapVertex = yapStack.pop();
            if (!yapVisited[yapVertex]) {
                yapVisited[yapVertex] = true;
                for (int yapNeighbor : yapAdjacencyList.get(yapVertex)) {
                    if (!yapVisited[yapNeighbor]) {
                        yapStack.push(yapNeighbor);
                    }
                }
            }
        }
    }
}

/* TEST CASE 1
Enter the number of vertices: 4
Enter the number of edges: 3
Enter the edges (u v):
1 2
2 3
3 4
The graph is connected.
*/

/* TEST CASE 2
Enter the number of vertices: 5
Enter the number of edges: 5
Enter the edges (u v):
1 2
2 3
3 4
4 5
5 1
The graph is connected.
*/

/* TEST CASE 3
Enter the number of vertices: 5
Enter the number of edges: 4
Enter the edges (u v):
1 2
2 3
4 5
1 3
The graph is not connected.
Number of connected components: 2
*/

/* TEST CASE 4
Enter the number of vertices: 9
Enter the number of edges: 6
Enter the edges (u v):
1 7
2 6
8 9
6 4
3 5
8 7
The graph is not connected.
Number of connected components: 3
*/

/* TEST CASE 5
Enter the number of vertices: 6
Enter the number of edges: 4
Enter the edges (u v):
1 3
5 3
2 6
4 6
The graph is not connected.
Number of connected components: 2
*/
