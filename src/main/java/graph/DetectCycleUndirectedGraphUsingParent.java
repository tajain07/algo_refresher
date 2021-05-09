package graph;

import java.util.ArrayList;

/**
 * https://www.geeksforgeeks.org/detect-cycle-undirected-graph/
 * <p>
 * Time Complexity: O(V+E).
 * The program does a simple DFS Traversal of the graph which is represented using adjacency list.
 * So the time complexity is O(V+E).
 * <p>
 * Space Complexity: O(V).
 * To store the visited array O(V) space is required.
 */
public class DetectCycleUndirectedGraphUsingParent {
    public static void main(String[] args) {
        int N = 5;
        ArrayList<Integer>[] adjacencyList = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        adjacencyList[0].add(1);
        adjacencyList[1].add(0);

        adjacencyList[0].add(2);
        adjacencyList[2].add(0);


        adjacencyList[2].add(3);
        adjacencyList[3].add(2);

        adjacencyList[2].add(4);
        adjacencyList[4].add(2);

        adjacencyList[3].add(4);
        adjacencyList[4].add(3);

        boolean result = isCyclic(adjacencyList);
        System.out.println("isCycle " + result);
    }

    private static boolean isCyclic(ArrayList<Integer>[] adjacencyList) {

        boolean[] visited = new boolean[adjacencyList.length]; //false, false, false, false, false
        for (int i = 0; i < adjacencyList.length; i++) {
            if (!visited[i])
                return DFS(i, -1, adjacencyList, visited);
        }

        return false;

    }


    //startNode = 0, parentNode = -1
    //startNode = 1, parentNode = 0
    //startNode = 2, parentNode = 0
    //startNode = 3, parentNode = 2
    //startNode = 4, parentNode = 3
    private static boolean DFS(int startNode, int parentNode, ArrayList<Integer>[] adjacencyList, boolean[] visited) {

        visited[startNode] = true;

        for (int node : adjacencyList[startNode]) {
            //node = 2, parentNode = 3
            if (!visited[node]) {
                visited[node] = true;
                if (DFS(node, startNode, adjacencyList, visited))
                    return true;
            } else if (parentNode != node)
                return true;

        }
        return false;
    }

}
