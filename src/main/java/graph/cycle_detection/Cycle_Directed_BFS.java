package graph.cycle_detection;

import graph.DirectedGraphImplementation;

import java.util.*;

public class Cycle_Directed_BFS {
    public static void main(String[] args) {
        List<int[]> adjList = new ArrayList<>();
        adjList.add(new int[]{0, 1});
        adjList.add(new int[]{1, 2});
        adjList.add(new int[]{2, 3});
        adjList.add(new int[]{3, 4});
        adjList.add(new int[]{1 ,4});
        //djList.add(new int[]{3, 0});
        //adjList.add(new int[]{4, 2});
        int num_of_vertex = 5;
        DirectedGraphImplementation graph = DirectedGraphImplementation.createGraph(num_of_vertex, adjList);

        boolean result = isCycleDirectedBFS_UsingKhanAlgorithm(graph.getAdj(), num_of_vertex);
        System.out.printf("Cycle exist %b\n", result);

    }

    private static boolean isCycleDirectedBFS_UsingKhanAlgorithm(List<Integer>[] adj, int num_of_vertex) {
        int[] in_degree = new int[num_of_vertex];
        int count = 0;
        for (int i = 0; i < num_of_vertex; i++) {
            final List<Integer> neighbours = adj[i];
            for (int neighbour : neighbours) {
                in_degree[neighbour]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < num_of_vertex; i++) {
            if (in_degree[i] == 0)
                queue.add(i);
        }

        while (!queue.isEmpty()) {
            final Integer element = queue.poll();
            for (int neighbour : adj[element]) {
                if (--in_degree[neighbour] == 0)
                    queue.add(neighbour);

            }
            count++;
        }

        return count != num_of_vertex;
    }

}
