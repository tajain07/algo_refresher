package graph;


//Video - https://youtu.be/0dJmTuMrUZM

import java.util.ArrayList;

public class DetectCycleInDirectedGraph {
    public static void main(String[] args) {
        {
            int N = 5;
            ArrayList<Integer>[] adjacencyList = new ArrayList[N];
            for (int i = 0; i < N; i++) {
                adjacencyList[i] = new ArrayList<>();
            }

            adjacencyList[0].add(1);
            adjacencyList[0].add(2);

            adjacencyList[2].add(3);
            adjacencyList[3].add(4);
            adjacencyList[4].add(2);

            boolean result = isCyclic(adjacencyList);
            System.out.println("isCycle " + result);

        }
    }

    private static boolean isCyclic(ArrayList<Integer>[] adjacencyList) {
        int V = adjacencyList.length;
        boolean[] visited = new boolean[V];
        boolean[] helper = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (visited[i] == false) {
                boolean ans = DFS(adjacencyList, i, visited, helper);
                if (ans)
                    return true;
            }
        }
        return false;

    }

    private static boolean DFS(ArrayList<Integer>[] adjacencyList, int i, boolean[] visited, boolean[] helper) {
        visited[i] = true;
        helper[i] = true;
        ArrayList<Integer> neighbours = adjacencyList[i];
        for (int j = 0; j < neighbours.size(); j++) {
            int curr = neighbours.get(j);
            if (helper[curr])
                return true;
            if (!visited[curr]) {
                boolean ans = DFS(adjacencyList, curr, visited, helper);
                if (ans)
                    return true;
            }
        }
        helper[i] = false;
        return false;
    }


}
