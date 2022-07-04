package union_find;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UnionFind {
    private int size;

    //Track sizes of each of the components
    private int[] sz;

    //id[i] points to parent of i, if id[i] = i then i is a root node
    private int[] id;

    private int[] parent;

    //Track the number of components in the union find
    private int numComponents;

    public UnionFind(int size) {
        if (size <= 0)
            throw new IllegalArgumentException("Size <= 0 is not allowed");
        this.size = numComponents = size;
        sz = new int[size];
        id = new int[size];
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            id[i] = i; // self root
            parent[i] = i;
            sz[i] = 1; // each component is originally of size one
        }
    }


    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int components() {
        return numComponents;
    }


    public int componentSize(int p) {
        return sz[find(p)];
    }

    public int size() {
        return size;
    }

    private int findRepresentative(int x) {
        if (x == id[x])
            return x;

        return id[x] = findRepresentative(id[x]);
    }

    private int find(int x) {
        int root = x;

        while (id[root] != root) {
            root = id[root];
        }

        while (x != root) {
            int next = id[x];
            id[x] = root;
            parent[root] = x;
            x = next;
        }
        return root;
    }

    private void union(int x, int y) {

        if (connected(x, y)) return;

        final int xset = find(x);
        final int yset = find(y);

        if (sz[xset] < sz[yset]) {
            sz[yset] += sz[xset];
            int oldValue = id[xset];
            id[xset] = yset;
            replaceIdValue(oldValue, yset);
            sz[xset] = 0;
        } else {
            sz[xset] += sz[yset];
            final int oldValue = id[yset];
            id[yset] = xset;
            replaceIdValue(oldValue, xset);

            sz[yset] = 0;
        }
        numComponents--;
    }

    private void replaceIdValue(int oldValue, int newValue) {
        for (int i = 0; i < id.length; i++) {
            if (id[i] == oldValue)
                id[i] = newValue;
        }
    }


    public static void main(String[] args) {

        int[][] edges = new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 2}};
        int n = 6;
        int count = 0;
        UnionFind unionFind = new UnionFind(edges.length);
        for (int i = 0; i < edges.length; i++) {

            final int[] edge = edges[i];
            int x = edge[0];
            int y = edge[1];
            if (unionFind.id[x] != unionFind.id[y]) {
                unionFind.union(x, y);
            } else
                count++;
        }

        System.out.println(Arrays.toString(unionFind.id));

    }
}
