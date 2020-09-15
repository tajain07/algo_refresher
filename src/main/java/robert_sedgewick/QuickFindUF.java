package robert_sedgewick;

import java.util.Arrays;

public class QuickFindUF {

    private int[] id;

    public QuickFindUF(int N) {
        id = new int[N];
        //set id of each of object to itself.
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) {
                id[i] = qid;
            }
        }
    }

    public void printIds(){
        System.out.println(Arrays.toString(id));
    }

    public static void main(String[] args) {
        QuickFindUF quickFindUF = new QuickFindUF(10);
        quickFindUF.connected(1, 2);
        quickFindUF.union(1, 2);
        quickFindUF.union(2, 2);
        quickFindUF.union(3, 2);
        quickFindUF.union(4, 2);


        System.out.println(quickFindUF.connected(1, 2));
        quickFindUF.printIds();

    }
}
