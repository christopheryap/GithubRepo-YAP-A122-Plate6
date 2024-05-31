import java.util.*;

public class yapGraphDegree {
    public static void main(String[] args) {
        Scanner yapScanner = new Scanner(System.in);
/* YAPProblem 4
Write a java program, given the pair of vertex associated to the edges of an undirected graph, it will output the degree of
vertex
 */
        Map<Integer, Integer> yapVertexDegreeMap = new HashMap<>();

        System.out.print("Enter the number of edges: ");
        int edges = yapScanner.nextInt();
        System.out.println("Enter the edges (pairs of vertices): ");

        for (int yapI = 0; yapI < edges; yapI++) {
            int yapVertex1 = yapScanner.nextInt();
            int yapVertex2 = yapScanner.nextInt();

            yapVertexDegreeMap.put(yapVertex1, yapVertexDegreeMap.getOrDefault(yapVertex1, 0) + 1);
            yapVertexDegreeMap.put(yapVertex2, yapVertexDegreeMap.getOrDefault(yapVertex2, 0) + 1);
        }

        yapScanner.close();

        System.out.println("Degrees of vertices: ");
        for (Map.Entry<Integer, Integer> entry : yapVertexDegreeMap.entrySet()) {
            System.out.println("Vertex " + entry.getKey() + " degree = " + entry.getValue());
        }
    }
}

/* TEST CASES
Test case 1
Enter the number of edges: 5
Enter the edges (pairs of vertices):
1 2
2 3
3 4
4 1
2 4
Degrees of vertices:
Vertex 1 degree = 2
Vertex 2 degree = 3
Vertex 3 degree = 2
Vertex 4 degree = 3

Test case 2
Enter the number of edges: 4
Enter the edges (pairs of vertices):
1 2
1 3
1 4
1 5
Degrees of vertices:
Vertex 1 degree = 4
Vertex 2 degree = 1
Vertex 3 degree = 1
Vertex 4 degree = 1
Vertex 5 degree = 1

Test case 3
Enter the number of edges: 6
Enter the edges (pairs of vertices):
1 2
2 3
3 4
4 5
5 6
6 1
Degrees of vertices:
Vertex 1 degree = 2
Vertex 2 degree = 2
Vertex 3 degree = 2
Vertex 4 degree = 2
Vertex 5 degree = 2
Vertex 6 degree = 2

Test case 4
Enter the number of edges: 3
Enter the edges (pairs of vertices):
1 2
1 3
1 4
Degrees of vertices:
Vertex 1 degree = 3
Vertex 2 degree = 1
Vertex 3 degree = 1
Vertex 4 degree = 1

Test case 5
Enter the number of edges: 7
Enter the edges (pairs of vertices):
1 2
2 3
3 4
4 5
5 6
6 1
3 5
Degrees of vertices:
Vertex 1 degree = 2
Vertex 2 degree = 2
Vertex 3 degree = 3
Vertex 4 degree = 2
Vertex 5 degree = 3
Vertex 6 degree = 2
 */
