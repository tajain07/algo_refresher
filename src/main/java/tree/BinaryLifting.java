package tree;

import java.util.ArrayList;
import java.util.Arrays;

public class BinaryLifting {

    static ArrayList<Integer> adj[];
    static int memo[][], lev[], maxN;


    static void init(int numOfNode) {
        dfs(1, -1);
        for (int j = 1; j < maxN; j++) {
            for (int i = 1; i <= numOfNode; i++) {
                if (memo[i][j - 1] != -1) {
                    int par = memo[i][j - 1];
                    memo[i][j] = memo[par][j - 1];
                }

            }
        }
    }

    static void dfs(int node, int par) {
        memo[node][0] = par;

        for (int child : adj[node])
            if (child != par) {
                lev[child] = lev[node] + 1;

                dfs(child, node);
            }
    }

    static int lca(int a, int b) {
        if (lev[a] > lev[b]) {
            return lca(b, a);
        }
        int d = lev[b] - lev[a];
        while (d > 0) {
            int i = (int) (Math.log(d) / Math.log(2));
            b = memo[b][i];
            d -= (1 << i);
        }

        if (a == b)
            return a;

        for (int i = maxN; i >= 0; i--) {
            if (memo[a][i] != -1 && (memo[a][i] != memo[b][i])) {
                a = memo[a][i];
                b = memo[b][i];
            }
        }
        return memo[a][0];
    }

    public static void main(String[] args) {
        // Number of nodes
        int n = 8;
        adj = new ArrayList[n + 1];

        // log(n) with base 2
        maxN = (int) Math.ceil(Math.log(n) / Math.log(2));
        memo = new int[n + 1][maxN + 1];

        // Stores the level of each node
        lev = new int[n + 1];

        // Initialising memo values with -1
        for (int i = 0; i <= n; i++)
            Arrays.fill(memo[i], -1);

        for (int i = 0; i <= n; i++)
            adj[i] = new ArrayList<>();

        // Add edges
        adj[1].add(2);
        adj[2].add(1);

        adj[1].add(3);
        adj[3].add(1);

        adj[2].add(5);
        adj[5].add(2);

        adj[2].add(6);
        adj[6].add(2);

        adj[4].add(5);
        adj[5].add(4);

        adj[6].add(7);
        adj[7].add(6);

        adj[4].add(8);
        adj[8].add(4);

        init(n);

        System.out.println("The LCA of 6 and 8 is " + lca(6, 8));
        System.out.println("The LCA of 6 and 1 is " + lca(6, 1));
        System.out.println("The LCA of 3 and 8 is " + lca(3, 8));
        System.out.println("The LCA of 5 and 6 is " + lca(5, 6));
    }
}
