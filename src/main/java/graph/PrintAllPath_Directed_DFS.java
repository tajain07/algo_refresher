package graph;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPath_Directed_DFS {
    public static void main(String[] args) {
        List<int[]> adjList = new ArrayList<>();
        adjList.add(new int[]{0, 3});
        adjList.add(new int[]{0, 1});
        adjList.add(new int[]{0, 2});

        adjList.add(new int[]{1, 3});

        adjList.add(new int[]{2, 0});
        adjList.add(new int[]{2, 1});

        int number_of_vertex = 4;
        DirectedGraphImplementation graph = DirectedGraphImplementation.createGraph(number_of_vertex, adjList);
        List<String> paths = printAllPath(number_of_vertex, graph, 2, 3);

        for (String path : paths)
            System.out.println(path);
    }

    private static List<String> printAllPath(int number_of_vertex, DirectedGraphImplementation graph, int source, int destination) {
        List<String> paths = new ArrayList<>();
        final List<Integer>[] adjList = graph.getAdj();

        for (Integer node : adjList[source]) {
            boolean[] visited = new boolean[number_of_vertex];
            StringBuilder path = new StringBuilder();
            path.append(source);
            visited[source] = true;
            dfs(graph.getAdj(), node, destination, visited, path, paths);

        }
        return paths;
    }

    private static void dfs(List<Integer>[] adj, int source, int destination, boolean[] visited, StringBuilder path, List<String> paths) {
        visited[source] = true;
        path.append(source);

        if (source == destination) {
            paths.add(path.toString());

        }

        final List<Integer> neighbors = adj[source];

        for (Integer neighbor : neighbors) {
            if (!visited[neighbor]) {
                dfs(adj, neighbor, destination, visited, path, paths);
            }
        }
        visited[source] = false;
        path.deleteCharAt(path.length() - 1);
    }
}
