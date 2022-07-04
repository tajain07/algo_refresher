package graph;

import graph.DirectedGraphImplementation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

public class PrintAllPath_Directed_BFS {
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
        final List<String> paths = printAllPath(number_of_vertex, graph, 2, 3);

        for (String path : paths)
            System.out.println(path);
    }

    private static List<String> printAllPath(int number_of_vertex, DirectedGraphImplementation graph, int source, int destination) {
        List<String> paths = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(String.valueOf(source));


        bfs(number_of_vertex, graph.getAdj(), destination, queue, paths);

        return paths;

    }

    private static void bfs(int number_of_vertex, List<Integer>[] adj, int destination, Queue<String> queue, List<String> paths) {
        boolean[] visited = new boolean[number_of_vertex];

        while (!queue.isEmpty()) {
            final String element = queue.poll();

            if (element.charAt(element.length() - 1) - '0' == destination) {
                paths.add(element);
                continue;
            }


            for (int i = 0; i < element.length(); i++) {
                final int c_index = element.charAt(i) - '0';
                visited[c_index] = true;
            }


            final char c = element.charAt(element.length() - 1);


            for (Integer neighbor : adj[c - '0']) {
                final StringBuilder newPath = new StringBuilder(element);

                if (!visited[neighbor]) {
                    newPath.append(neighbor);
                    queue.add(newPath.toString());
                }

            }


        }
    }


}
