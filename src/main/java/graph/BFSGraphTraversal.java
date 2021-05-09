package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// BFS Traversal
// Time complexity - O(V+ E)
// Space complexity - O(V)
public class BFSGraphTraversal {
    public static void main(String[] args) {
        {
            int N = 7;
            ArrayList<Integer>[] adjacencyList = new ArrayList[N];
            for (int i = 0; i < N; i++) {
                adjacencyList[i] = new ArrayList<>();
            }

            adjacencyList[0].add(1);
            adjacencyList[1].add(0);

            adjacencyList[1].add(2);
            adjacencyList[2].add(1);

            adjacencyList[2].add(3);
            adjacencyList[3].add(2);

            adjacencyList[4].add(3);
            adjacencyList[3].add(4);


            adjacencyList[0].add(4);
            adjacencyList[4].add(0);

            adjacencyList[5].add(6);
            adjacencyList[6].add(5);


            //visited[0] = true;
            System.out.print("BFS Recursive - ");
            bfsRunner(adjacencyList);

        }
    }

    private static void bfsRunner(ArrayList<Integer>[] adjacencyList) {
        boolean[] visited = new boolean[adjacencyList.length];
        for (int i = 0; i < adjacencyList.length; i++) {
            if (!visited[i])
                bfs(i, adjacencyList, visited);
        }
    }

    private static void bfs(int startingNode, ArrayList<Integer>[] adjacencyList, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startingNode);
        visited[startingNode] = true;

        while (!queue.isEmpty()) {
            int front = queue.poll();
            System.out.print(front + " ");
            final ArrayList<Integer> adjacentNodes = adjacencyList[front];
            for (int node : adjacentNodes) {
                if (!visited[node]) {
                    queue.add(node);
                    visited[node] = true;
                }
            }
        }
    }


}
