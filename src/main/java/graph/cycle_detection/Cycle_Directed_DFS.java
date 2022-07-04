package graph.cycle_detection;


//Video - https://youtu.be/0dJmTuMrUZM

import graph.DirectedGraphImplementation;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.thealgorists.com/Algo/CycleDetectionUsingDFS
 * <p>
 * <p>
 * Tracking Visiting status of Nodes:
 * Significance of Node State of Visiting and Visited:
 * <p>
 * VISITING: The current Node is being processed, i.e, DFS for this Node has started, but not yet finished,
 * which means all descendants in the DFS tree of this vertex are not processed yet.
 * Which also implies, this vertex is in the function call stack.
 * <p>
 * While doing DFS, if a Node whose state is Visiting is encountered, then the inbound
 * edge to the Node with state Visiting is back edge and hence there is a cycle.
 * <p>
 * VISITED: The current Node and all of its descendants are processed.
 * <p>
 * Algorithm:
 * Using the above two states of Nodes, find the back-edge is easy.
 * At any point of time while doing the DFS graph traversal, if you encounter a
 * back edge that would imply that there is a cycle. Why? Let's suppose while doing a
 * DFS graph traversal we just visited Node A. So we will be processing Node A now.
 * Now, what does processing Node A mean?
 * Processing Node A mean visiting and processing all of the descendents of Node A.
 * So, while processing Node A (whose status is now Visiting and not Visited) what
 * would it mean if we get Node A as part of DFS traversal ? This would mean that
 * some descendant of Node A is pointing to Node A, which mean a descendent of
 * Node A has a back-edge to Node A. And, what does this form? This form a cycle.
 * Exactly. So at any point of time while doing a DFS traversal from a Node if we
 * happen to find a back-edge, i.e, a node with Visiting status that would clearly
 * mean that there is a cycle in the DFS tree for that Node. And this applies to the
 * DFS traversal for any Node in a graph.
 */
public class Cycle_Directed_DFS {
    public static void main(String[] args) {
        {
            int num_of_vertex = 5;
            List<int[]> adjList = new ArrayList<>();
            adjList.add(new int[]{0, 1});
            adjList.add(new int[]{1, 2});
            adjList.add(new int[]{2, 3});
            adjList.add(new int[]{3, 4});
            adjList.add(new int[]{4, 1});

            DirectedGraphImplementation graph = DirectedGraphImplementation.createGraph(num_of_vertex, adjList);
            boolean result = isCycleDirectedDFS(graph.getAdj(), num_of_vertex);
            System.out.println("isCycle " + result);

        }
    }

    private static boolean isCycleDirectedDFS(List<Integer>[] adjacencyList, int num_of_vertex) {
        boolean[] visited = new boolean[num_of_vertex];
        boolean[] currentVisited = new boolean[num_of_vertex];
        for (int i = 0; i < num_of_vertex; i++) {
            if (!visited[i] && dfs(adjacencyList, i, visited, currentVisited)) {
                return true;
            }
        }
        return false;

    }

    private static boolean dfs(List<Integer>[] adjacencyList, int source, boolean[] visited, boolean[] currentVisited) {

        visited[source] = true;
        currentVisited[source] = true;
        final List<Integer> neighbours = adjacencyList[source];
        for (Integer neighbour : neighbours) {
            if (!visited[neighbour]) {
                if (dfs(adjacencyList, neighbour, visited, currentVisited))
                    return true;
            } else if (currentVisited[neighbour]) {
                return true;
            }
        }

        currentVisited[source] = false;

        return false;
    }


}
