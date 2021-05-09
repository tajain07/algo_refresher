package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Leetcode - 547
 * https://leetcode.com/problems/number-of-provinces/
 */
public class FriendsCircles {
    public static void main(String[] args) {
        int[][] friends = new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        int answer = findCircleNum(friends);
        System.out.println("answer " + answer);

    }

    public static int findCircleNum(int[][] isConnected) {
        final int N = isConnected.length;
        boolean[] visited = new boolean[N];
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                count++;
                bfs(i, isConnected, visited);
            }
        }

        return count;
    }

    private static void dfs(int node, int[][] isConnected, boolean[] visited) {
        visited[node] = true;
        final int[] adjs = isConnected[node];
        for (int i = 0; i < adjs.length; i++) {
            if (!visited[i] && adjs[i] == 1) {
                dfs(i, isConnected, visited);
            }
        }

    }

    private static void bfs(int node, int[][] isConnected, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;
        while (!queue.isEmpty()) {
            final int curr = queue.poll();
            final int[] adjs = isConnected[curr];
            for (int i = 0; i < adjs.length; i++) {
                if (!visited[i] && adjs[i] == 1) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
