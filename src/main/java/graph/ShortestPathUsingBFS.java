package graph;

import java.util.*;

public class ShortestPathUsingBFS {


    public static void main(String[] args) {
        int numberOfVertex = 8;

        List<int[]> vertexList = new LinkedList<>();
        vertexList.add(new int[]{0, 1});
        vertexList.add(new int[]{0, 3});
        vertexList.add(new int[]{1, 2});
        vertexList.add(new int[]{3, 4});
        vertexList.add(new int[]{3, 7});
        vertexList.add(new int[]{4, 5});
        vertexList.add(new int[]{4, 6});
        vertexList.add(new int[]{4, 7});
        vertexList.add(new int[]{5, 6});
        vertexList.add(new int[]{6, 7});


        final UndirectedGraphImplementation graph = UndirectedGraphImplementation.createGraph(numberOfVertex, vertexList);

        int source = 0;
        int destination = 7;

        final Integer[] pathArray = bfs(graph.getAdj(), source, numberOfVertex);
        System.out.println(Arrays.toString(pathArray));

        final List<Integer> shortestPath = reconstructPath(source, destination, pathArray);
        System.out.printf("Shortest path %s ", shortestPath);
    }

    private static List<Integer> reconstructPath(int source, int destination, Integer[] pathArray) {
        List<Integer> path = new ArrayList<>();

        for (Integer at = destination; at != null; at = pathArray[at]) {
            path.add(at);
        }

        Collections.reverse(path);

        if (path.get(0) == source)
            return path;
        return path;
    }


    /**
     * This algo will work for all connected nodes - if some part is not connect then it will not work
     *
     * @param adj
     * @param source
     * @param numberOfVertex
     * @return
     */
    private static Integer[] bfs(List<Integer>[] adj, int source, int numberOfVertex) {

        Queue<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[numberOfVertex];

        queue.add(source);
        visited[source] = true;

        Integer[] prev = new Integer[numberOfVertex];

        while (!queue.isEmpty()) {
            final Integer element = queue.poll();
            final List<Integer> neighbours = adj[element];

            for (int neighbour : neighbours) {
                if (!visited[neighbour]) {
                    queue.add(neighbour);
                    visited[neighbour] = true;
                    prev[neighbour] = element;
                }
            }
        }

        return prev;

    }
}
