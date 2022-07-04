package graph.dfs;

import graph.DirectedGraphImplementation;

import java.util.ArrayList;
import java.util.List;

public class DFSDirectedGraph {
    public static void main(String[] args) {
        int numberOfVertex = 6;

        List<int[]> edgeList = new ArrayList<>();
        edgeList.add(new int[]{0, 1});
        edgeList.add(new int[]{2, 1});
        edgeList.add(new int[]{1, 3});
        edgeList.add(new int[]{3, 4});
        edgeList.add(new int[]{4, 5});
        edgeList.add(new int[]{5, 3});
        edgeList.add(new int[]{5, 2});

        final DirectedGraphImplementation graph = DirectedGraphImplementation.createGraph(numberOfVertex, edgeList);
        graph.printAdjacencyList();

        dfsDirectedgraph(graph, 0);
    }

    public static void dfsDirectedgraph(DirectedGraphImplementation graph, int startVertex) {
        final List<Integer>[] adj = graph.getAdj();
        boolean[] visited = new boolean[adj.length];

        dfsHelper(adj, visited, startVertex);

    }

    private static void dfsHelper(List<Integer>[] adj, boolean[] visited, Integer vertex) {
        if (!visited[vertex]) {
            System.out.printf("%s ", vertex);
            visited[vertex] = true;
            final List<Integer> neighbours = adj[vertex];
            for (Integer neighbour : neighbours) {
                dfsHelper(adj, visited, neighbour);
            }
        }
    }
}
