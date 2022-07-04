package graph.dfs;

import graph.UndirectedGraphImplementation;

import java.util.LinkedList;
import java.util.List;

/*
    DFS
    Time complexity - O(V+E)
    Space complexity - O(V)

 */
public class DFSUndirectedGraph {
    public static void main(String[] args) {
        int numberOfVertex = 8;

        List<int[]> vertexList = new LinkedList<>();
        vertexList.add(new int[]{0, 3});
        vertexList.add(new int[]{0, 1});
        vertexList.add(new int[]{1, 2});
        vertexList.add(new int[]{3, 7});
        vertexList.add(new int[]{6, 7});
        vertexList.add(new int[]{4, 5});
        vertexList.add(new int[]{3, 4});
        vertexList.add(new int[]{4, 6});
        vertexList.add(new int[]{5, 6});
        vertexList.add(new int[]{4, 7});

        final UndirectedGraphImplementation graph = UndirectedGraphImplementation.createGraph(numberOfVertex, vertexList);
        final List<Integer>[] adj = graph.getAdj();
        dfs_main(adj);
    }

    private static void dfs_main(List<Integer>[] adjacencyList) {
        int N = adjacencyList.length;
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                dfs(i, adjacencyList, visited);
            }
        }
    }

    private static void dfs(int startNode, List<Integer>[] adjacencyList, boolean[] visited) {
        System.out.print(startNode + " ");
        visited[startNode] = true;
        for (int j = 0; j < adjacencyList[startNode].size(); j++) {
            if (!visited[adjacencyList[startNode].get(j)]) {
                dfs(adjacencyList[startNode].get(j), adjacencyList, visited);
            }
        }
    }
}
