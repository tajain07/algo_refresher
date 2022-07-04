package graph.dfs;

import graph.UndirectedGraphImplementation;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class DFSIterative {
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
        dfsIterative(graph.getAdj(), numberOfVertex, source);

    }

    private static void dfsIterative(List<Integer>[] adj, int numberOfVertex, int source) {
        boolean[] visited = new boolean[numberOfVertex];
        Stack<Integer> stack = new Stack<>();

        for (int i = source; i < adj.length; i++) {
            if (!visited[i]) {
                stack.push(i);
                visited[i] = true;
            }

            while (!stack.isEmpty()) {
                int element = stack.pop();
                System.out.print(element + " ");

                List<Integer> neighbours = adj[element];
                for (int neighbour : neighbours) {
                    if (!visited[neighbour]) {
                        stack.push(neighbour);
                        visited[neighbour] = true;
                    }
                }
            }
        }


    }


}
