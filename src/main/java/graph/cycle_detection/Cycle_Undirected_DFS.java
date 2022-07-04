package graph.cycle_detection;

import graph.UndirectedGraphImplementation;

import java.util.ArrayList;
import java.util.List;

public class Cycle_Undirected_DFS {
    public static void main(String[] args) {
        int number_of_vertex = 4;

        List<int[]> adjList = new ArrayList<int[]>();
        adjList.add(new int[]{0, 1});
        //adjList.add(new int[]{0, 2});

        //adjList.add(new int[]{1, 0});
        adjList.add(new int[]{1, 2});

        //adjList.add(new int[]{2, 1});
        //adjList.add(new int[]{2, 0});

        //adjList.add(new int[]{3, 0});
        //adjList.add(new int[]{3, 4});

        adjList.add(new int[]{2, 0});


        final UndirectedGraphImplementation graph = UndirectedGraphImplementation.createGraph(number_of_vertex, adjList);

        boolean result = isCycleUndirectedDFS(graph.getAdj(), number_of_vertex);
        System.out.printf("Cycle exist %b\n", result);
    }

    private static boolean isCycleUndirectedDFS(List<Integer>[] adj, int number_of_vertex) {
        boolean[] visited = new boolean[number_of_vertex];
        for (int i = 0; i < number_of_vertex; i++) {
            if (!visited[i]) {
                if (isCycle(adj, visited, i, -1))
                    return true;
            }
        }
        return false;
    }

    private static boolean isCycle(List<Integer>[] adj, boolean[] visited, int i, int parent) {
        visited[i] = true;
        final List<Integer> neighbours = adj[i];
        for (Integer neighbour : neighbours) {
            if (!visited[neighbour]) {
                if (isCycle(adj, visited, neighbour, i)) return true;
            }
            //if neighbour_element is already visited
            // a) it can be parent of current node so "parent" value be same as  "neighbour_element"
            // b) else it was visited and has a cycle
            else if (neighbour != parent)
                return true;
        }
        return false;
    }

}
