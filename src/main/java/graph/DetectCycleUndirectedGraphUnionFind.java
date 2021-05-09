package graph;

import java.util.ArrayList;
import java.util.Arrays;

//Coding style 1 - Using Graph class -- as per geeksforgeeks
//https://www.geeksforgeeks.org/union-find/
//method - graph.isCycle


//Coding style 2 - Using adjacency list,
// just to be consistent with other graph code in this package
//method - isCycleUsingUnionFind

public class DetectCycleUndirectedGraphUnionFind {
    private static class Graph {
        int V, E;
        Edge[] edge;

        private static class Edge {
            int src, dest;
        }


        public Graph(int v, int e) {
            V = v;
            E = e;
            edge = new Edge[E];
            for (int i = 0; i < e; i++) {
                edge[i] = new Edge();
            }
        }

        int find(int[] parent, int i) {
            if (parent[i] == -1)
                return i;
            return find(parent, parent[i]);
        }

        void Union(int[] parent, int x, int y) {
            parent[x] = y;
        }

        int isCycle(Graph graph) {
            int[] parent = new int[graph.V];
            Arrays.fill(parent, -1);


            for (int i = 0; i < graph.E; i++) {
                int x = graph.find(parent, graph.edge[i].src);
                int y = graph.find(parent, graph.edge[i].dest);

                if (x == y)
                    return 1;
                graph.Union(parent, x, y);
            }
            return 0;
        }
    }

    public static void main(String[] args) {

        //Coding style 1 - Using Graph class -- as per geeksforgeeks
        //https://www.geeksforgeeks.org/union-find/

        int V = 3, E = 3;
        Graph graph = new Graph(V, E);

        // add edge 0-1
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;

        // add edge 1-2
        graph.edge[1].src = 1;
        graph.edge[1].dest = 2;

        // add edge 0-2
        graph.edge[2].src = 0;
        graph.edge[2].dest = 2;

        if (graph.isCycle(graph) == 1)
            System.out.println("graph contains cycle");
        else
            System.out.println("graph doesn't contain cycle");

        //Coding style 2 - Using adjacency list, just to be consistent
        //with other graph code in this package

        int N = 5;
        ArrayList<Integer>[] adjacencyList = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        adjacencyList[0].add(1);
        adjacencyList[1].add(0);

        adjacencyList[0].add(2);
        adjacencyList[2].add(0);


        adjacencyList[2].add(3);
        adjacencyList[3].add(2);

        adjacencyList[2].add(4);
        adjacencyList[4].add(2);

        adjacencyList[3].add(4);
        adjacencyList[4].add(3);

        boolean result = isCycleUsingUnionFind(adjacencyList);
        if (result)
            System.out.println("graph contains cycle");
        else
            System.out.println("graph doesn't contain cycle");
    }

    private static boolean isCycleUsingUnionFind(ArrayList<Integer>[] adjacencyList) {
        int N = adjacencyList.length;
        int[] parent = new int[N];
        //boolean[] visited = new boolean[N];
        Arrays.fill(parent, -1);
        for (int i = 0; i < N; i++) {
            //visited[i] = true;
            final ArrayList<Integer> adjacentNodes = adjacencyList[i];
            for (int adjacentNode : adjacentNodes) {
                if(parent[adjacentNode] ==-1) {
                    final int parentSource = find(parent, i);
                    final int parentDestination = find(parent, adjacentNode);
                    if (parentSource == parentDestination)
                        return true;

                    union(parent, parentSource, parentDestination);
                }
            }
        }
        return false;
    }

    private static void union(int[] parent, int source, int destination) {
        parent[source] = destination;
    }

    private static int find(int[] parent, int i) {
        final int value = parent[i];
        if (value == -1)
            return i;
        else
            return find(parent, parent[i]);
    }
}
