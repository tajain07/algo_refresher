package graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private static final String NEWLINE = System.getProperty("line.seperator");

    private final int V;
    private int E;
    private List<Integer>[] adj;


    public Graph(int V) {
        if (V < 0)
            throw new IllegalArgumentException("Number of vertices must be non-negative");

        this.V = V;
        this.E = 0;
        adj = new ArrayList[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new ArrayList<>();
        }
    }


    /**
     * Returns the vertices adjacent to vertex {@code v}.
     *
     * @param v the vertex
     * @return the vertices adjacent to vertex {@code v}, as an iterable
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    /**
     * Returns the degree of vertex {@code v}.
     *
     * @param v the vertex
     * @return the degree of vertex {@code v}
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public int degree(int v) {
        return adj[v].size();
    }

    public int maxDegree() {
        int max = 0;
        for (int i = 0; i < adj.length; i++) {
            int currentDegree = degree(i);
            max = currentDegree > max ? currentDegree : max;
        }

        return max;
    }

    public double averageDegree() {
        return 0;
    }

    public int numberOfSelfLoops(){
        return 0;
    }

    void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
    }

    public void printAdjacencyList() {
        for (int i = 0; i < adj.length; i++) {
            System.out.println("Adjacency list of " + i);
            for (int j = 0; j < adj[i].size(); j++) {
                System.out.print(adj[i].get(j) + " ");
            }
            System.out.println();
        }
    }

    //Graph from input stream
    //public Graph(In)
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);

        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);

        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.printAdjacencyList();

        System.out.println("Degree of 4  = " + graph.degree(4));
        System.out.println("Degree of 0  = " + graph.degree(0));

        System.out.println("Max degree " + graph.maxDegree());
    }


}
