package graph;

import java.util.*;

public class BidirectionalBFS {
    public static void main(String[] args) {
        int number_of_vertex = 15;

        List<int[]> adjList = new ArrayList<int[]>();
        adjList.add(new int[]{0, 4});

        adjList.add(new int[]{1, 4});

        adjList.add(new int[]{2, 5});
        adjList.add(new int[]{3, 5});

        adjList.add(new int[]{4, 6});
        adjList.add(new int[]{5, 6});

        adjList.add(new int[]{6, 7});
        adjList.add(new int[]{7, 8});

        adjList.add(new int[]{8, 9});
        adjList.add(new int[]{8, 10});

        adjList.add(new int[]{9, 11});
        adjList.add(new int[]{9, 12});

        adjList.add(new int[]{10, 13});
        adjList.add(new int[]{10, 14});


        final UndirectedGraphImplementation graph = UndirectedGraphImplementation.createGraph(number_of_vertex, adjList);

        int source = 0;
        int destination = 3;

        bidirectional_search(number_of_vertex, graph, source, destination);


    }

    private static void bidirectional_search(int number_of_vertex, UndirectedGraphImplementation graph, int source, int destination) {
        Queue<Integer> sourceQueue = new LinkedList<>();
        boolean[] sourceVisited = new boolean[number_of_vertex];
        int[] sourcePath = new int[number_of_vertex];

        Queue<Integer> destinationQueue = new LinkedList<>();
        boolean[] destinationVisited = new boolean[number_of_vertex];
        int[] destinationPath = new int[number_of_vertex];

        sourceQueue.add(source);
        sourceVisited[source] = true;
        sourcePath[source] = -1;

        destinationQueue.add(destination);
        destinationVisited[destination] = true;
        destinationPath[destination] = -1;


        while (!sourceQueue.isEmpty() && !destinationQueue.isEmpty()) {
            bfs(graph, sourceQueue, sourceVisited, sourcePath, destinationQueue, destinationVisited, destinationPath, "forward");
            bfs(graph, sourceQueue, sourceVisited, sourcePath, destinationQueue, destinationVisited, destinationPath, "backward");

            Integer intersecting_node = is_intersecting(number_of_vertex, sourceVisited, destinationVisited);

            if (intersecting_node != -1) {
                System.out.printf("Path exists between %s and %s\n", source, destination);
                System.out.printf("Intersection at : %s\n", intersecting_node);

                print_path(intersecting_node,
                        source, sourcePath, destination, destinationPath);
                break;

            }

        }
    }

    private static Integer is_intersecting(int number_of_vertex, boolean[] sourceVisited, boolean[] destinationVisited) {
        for (int i = 0; i < number_of_vertex; i++) {
            if (sourceVisited[i] && destinationVisited[i])
                return i;
        }

        return -1;
    }

    private static void bfs(UndirectedGraphImplementation graph, Queue<Integer> sourceQueue, boolean[] sourceVisited, int[] sourcePath, Queue<Integer> destinationQueue, boolean[] destinationVisited, int[] destinationPath, String direction) {

        final List<Integer>[] adj = graph.getAdj();
        if (direction.equals("forward")) {

            final Integer current = sourceQueue.poll();
            final List<Integer> connected_nodes = adj[current];
            for (Integer connected_node : connected_nodes) {
                if (!sourceVisited[connected_node]) {
                    sourceQueue.add(connected_node);
                    sourceVisited[connected_node] = true;
                    sourcePath[connected_node] = current;
                }
            }

        } else {
            final Integer current = destinationQueue.poll();
            final List<Integer> connected_nodes = adj[current];
            for (Integer connected_node : connected_nodes) {
                if (!destinationVisited[connected_node]) {
                    destinationQueue.add(connected_node);
                    destinationVisited[connected_node] = true;
                    destinationPath[connected_node] = current;
                }
            }

        }
    }


    private static void print_path(Integer intersecting_node, int source, int[] sourcePath, int destination, int[] destinationPath) {
        List<Integer> path = new ArrayList<>();
        path.add(intersecting_node);

        int i = intersecting_node;

        while (i != source) {
            final int i1 = sourcePath[i];
            path.add(i1);
            i = i1;
        }
        Collections.reverse(path);

        i = intersecting_node;
        while (i != destination) {
            final int i1 = destinationPath[i];
            path.add(i1);
            i = i1;
        }

        System.out.println(path);

    }
}
