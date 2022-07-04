package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DirectedGraphImplementation {
    private static final String NEWLINE = System.getProperty("line.seperator");

    private final int V;
    private int E;
    private static List<Integer>[] adj;

    public DirectedGraphImplementation(int V) {
        if (V < 0)
            throw new IllegalArgumentException("Number of vertices must be non-negative");

        this.V = V;
        this.E = 0;
        adj = new ArrayList[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new ArrayList<>();
        }
    }

    public List<Integer>[] getAdj() {
        return adj;
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

    public int numberOfSelfLoops() {
        return 0;
    }

    void addEdge(int u, int v) {
        adj[u].add(v);
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

    public static DirectedGraphImplementation createGraph(int number_of_vertex, List<int[]> edgeList) {

        DirectedGraphImplementation graph = new DirectedGraphImplementation(number_of_vertex);
        for (int[] edge : edgeList) {
            graph.addEdge(edge[0], edge[1]);
        }
        return graph;
    }

    public static DirectedGraphImplementation createGraph() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of vertex");
        int number_of_vertex = sc.nextInt();

        DirectedGraphImplementation graph = new DirectedGraphImplementation(number_of_vertex);

        System.out.println("Enter number of edges");
        int e = sc.nextInt();
        System.out.println("Enter edge pair, example = 1 2");

        for (int i = 0; i < e; i++) {
            int source = sc.nextInt();
            int destination = sc.nextInt();
            graph.addEdge(source, destination);

        }

        return graph;
    }

    //Graph from input stream
    //public Graph(In)
    public static void main(String[] args) {

        final DirectedGraphImplementation graph = createGraph();
        graph.printAdjacencyList();

        System.out.println("Degree of 4  = " + graph.degree(4));
        System.out.println("Degree of 0  = " + graph.degree(0));

        System.out.println("Max degree " + graph.maxDegree());
    }



}
