package graph;

import java.util.ArrayList;
import java.util.List;

/*
    DFS
    Time complexity - O(V+E)
    Space complexity - O(V)

 */
public class DFSUndirectedGraph {
    public static void main(String[] args) {
        int N = 8;
        ArrayList<Integer>[] adjacencyList = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        adjacencyList[2].add(4);
        adjacencyList[4].add(2);

        adjacencyList[0].add(1);
        adjacencyList[1].add(0);

        adjacencyList[0].add(2);
        adjacencyList[2].add(0);

        adjacencyList[1].add(3);
        adjacencyList[3].add(1);

        adjacencyList[1].add(4);
        adjacencyList[4].add(1);


        adjacencyList[3].add(4);
        adjacencyList[4].add(3);

        adjacencyList[3].add(5);
        adjacencyList[5].add(3);

        adjacencyList[4].add(5);
        adjacencyList[5].add(4);


        adjacencyList[6].add(7);
        adjacencyList[7].add(6);

        dfs_main(adjacencyList);
    }

    private static void dfs_main(List<Integer>[] adjacencyList) {
        int N = adjacencyList.length;
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                dfs(i, adjacencyList, visited);
            }
        }
    }

    private static void dfs(int startNode, List<Integer>[] adjacencyList, boolean[] visited) {
        System.out.print(startNode + " ");
        visited[startNode] = true;
        for (int j = 0; j < adjacencyList[startNode].size(); j++) {
            if (!visited[adjacencyList[startNode].get(j)]) {
                dfs(adjacencyList[startNode].get(j), adjacencyList, visited);
            }
        }
    }
}
