package robert_sedgewick;

import java.util.Arrays;

public class QuickUnionUF {
    private int[] id;

    public QuickUnionUF() {
        id = new int[] { 1, 8, 1, 8, 3, 0, 5, 7, 8, 8 };
    }

    public QuickUnionUF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public void union(int p, int q) {
        int parentP = parent(p);
        int parentQ = parent(q);

        id[parentP] = id[parentQ];
    }

    public boolean connected(int p, int q) {
        if (parent(p) == parent(q))
            return true;

        return false;
    }

    private int parent(int node) {

        int parentNode = node;
        while (id[node] != parentNode) {
            parentNode = id[node];
            node = parentNode;
        }

        return parentNode;
    }

    public void printIds(){
        System.out.println(Arrays.toString(id));
    }

    public static void main(String[] args) {
        QuickUnionUF quickUnionUF = new QuickUnionUF();
        System.out.println(quickUnionUF.parent(6));
        System.out.println(quickUnionUF.connected(6, 7));
        quickUnionUF.union(6, 7);
        System.out.println(quickUnionUF.connected(6, 7));

        quickUnionUF.printIds();
    }
}
