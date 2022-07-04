package graph.cycle_detection;

import graph.UndirectedGraphImplementation;

import java.util.ArrayList;
import java.util.List;


/**
 * Currently this solution do not make use of union and find function but the \
 * implementation [idea] is same as Union Find
 */
public class Cycle_Undirected_Disjoint {
    public static void main(String[] args) {
        int number_of_vertex = 5;

        List<int[]> adjList = new ArrayList<int[]>();
        adjList.add(new int[]{0, 1});
        adjList.add(new int[]{0, 2});
        adjList.add(new int[]{1, 3});
        adjList.add(new int[]{1, 4});
        adjList.add(new int[]{4, 3});


        final UndirectedGraphImplementation graph = UndirectedGraphImplementation.createGraph(number_of_vertex, adjList);

        boolean result = isCycle_Undirected_UnionFind(graph.getAdj(), number_of_vertex);
        System.out.printf("Cycle exist %b\n", result);
    }

    private static boolean isCycle_Undirected_UnionFind(List<Integer>[] adj, int number_of_vertex) {
        int[] topMostParent = new int[number_of_vertex];
        boolean[] visited = new boolean[number_of_vertex];

        for (int i = 0; i < number_of_vertex; i++) {
            topMostParent[i] = i;
        }
        for (int i = 0; i < number_of_vertex; i++) {
            if (dfs(adj, number_of_vertex, visited, topMostParent, i))
                return true;
        }


        return false;
    }

    private static boolean dfs(List<Integer>[] adj, int number_of_vertex, boolean[] visited, int[] topMostParent, int source) {

        visited[source] = true;

        final List<Integer> neighbours = adj[source];
        for (int neighbour : neighbours) {
            if (!visited[neighbour]) {
                if (topMostParent[neighbour] != topMostParent[source]) {
                    topMostParent[neighbour] = topMostParent[source];
                } else {
                    return true;
                }
            }

        }


        return false;
    }


}
