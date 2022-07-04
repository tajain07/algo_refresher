package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TarjanStronglyConnectedComponent {
    public static final int UNVISITED = -1;

    public static void main(String[] args) {
        int num_of_nodes = 8;
        List<int[]> adjList = new ArrayList<>();
        adjList.add(new int[]{0, 1});
        adjList.add(new int[]{0, 2});
        adjList.add(new int[]{1, 0});
        adjList.add(new int[]{1, 3});
        adjList.add(new int[]{2, 3});
        adjList.add(new int[]{3, 4});
        adjList.add(new int[]{3, 5});
        adjList.add(new int[]{4, 2});
        adjList.add(new int[]{4, 5});
        adjList.add(new int[]{4, 6});
        adjList.add(new int[]{5, 7});
        adjList.add(new int[]{6, 5});
        adjList.add(new int[]{7, 6});
        final DirectedGraphImplementation graph = DirectedGraphImplementation.createGraph(num_of_nodes, adjList);
        final List<Integer>[] adj = graph.getAdj();
        final int[] sccS = findSccS(num_of_nodes, adj);
        System.out.println(Arrays.toString(sccS));
    }

    public static int[] findSccS(int num_of_nodes, List<Integer>[] adj) {
        Integer id = 5;
        Integer sccCount = 0;
        int[] ids = new int[num_of_nodes];
        int[] lows = new int[num_of_nodes];
        boolean[] onStack = new boolean[num_of_nodes];
        Stack<Integer> stack = new Stack<>();


        for (int i = 0; i < num_of_nodes; i++) {
            ids[i] = UNVISITED;
        }
        for (int i = 0; i < num_of_nodes; i++) {
            if (ids[i] == UNVISITED)
                sccCount =  dfs(adj, i, stack, onStack, ids, lows, id, sccCount);

        }
        System.out.printf("sccCount %s\n", sccCount);
        return lows;

    }

    private static Integer dfs(List<Integer>[] adj, int at, Stack<Integer> stack, boolean[] onStack, int[] ids, int[] lows, Integer id, Integer sccCount) {
        stack.push(at);
        onStack[at] = true;
        ids[at] = lows[at] = id++;

        for (Integer to : adj[at]) {
            if (ids[to] == UNVISITED)
                sccCount = dfs(adj, to, stack, onStack, ids, lows, id, sccCount);
            if (onStack[to])
                lows[at] = Math.min(lows[at], lows[to]);

        }

        if (ids[at] == lows[at]) {
            for (int node = stack.pop(); ; node = stack.pop()) {
                onStack[node] = false;
                lows[node] = ids[at];
                if (node == at)
                    break;
            }
            sccCount = sccCount.intValue() + 1;  ;

        }
        return sccCount;
    }


}
