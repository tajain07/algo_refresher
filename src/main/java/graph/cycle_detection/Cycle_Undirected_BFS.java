package graph.cycle_detection;

import graph.UndirectedGraphImplementation;
import javafx.util.Pair;

import java.util.*;

/**
 * https://www.geeksforgeeks.org/detect-cycle-in-an-undirected-graph-using-bfs/
 * <p>
 * Using parent array and visited array
 */
public class Cycle_Undirected_BFS {
    public static void main(String[] args) {
        int number_of_vertex = 10;

        List<int[]> adjList = new ArrayList<int[]>();
        adjList.add(new int[]{0, 1});
        adjList.add(new int[]{1, 2});
        adjList.add(new int[]{2, 3});

        adjList.add(new int[]{4, 5});
        adjList.add(new int[]{5, 6});
        adjList.add(new int[]{5, 7});
        adjList.add(new int[]{7, 8});
        adjList.add(new int[]{6, 8});
        adjList.add(new int[]{8, 9});


        final UndirectedGraphImplementation graph = UndirectedGraphImplementation.createGraph(number_of_vertex, adjList);

        boolean result = isCycleUndirectedBFS(graph.getAdj(), number_of_vertex);
        System.out.printf("Cycle exist %b\n", result);



    }

    private static boolean isCycleUndirectedBFS(List<Integer>[] adj, int number_of_vertex) {
        boolean[] visited = new boolean[number_of_vertex];
        int[] parent = new int[number_of_vertex];

        for (int i = 0; i < number_of_vertex; i++) {
            if (!visited[i]) {
                if (isCycleHelper(adj, visited, parent, number_of_vertex, i))
                    return true;
            }
        }
        return false;

    }

    private static boolean isCycleHelper(List<Integer>[] adj, boolean[] visited, int[] parent, int number_of_vertex, int source) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = true;
        parent[source] = -1;

        while (!queue.isEmpty()) {
            final Integer element = queue.poll();

            final List<Integer> neighbours = adj[element];
            for (Integer neighbour : neighbours) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.add(neighbour);
                    parent[neighbour] = element;
                } else if (neighbour != parent[element]) {
                    return true;
                }
            }
        }
        return false;
    }


}
