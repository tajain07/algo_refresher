import java.io.*;
import java.util.*;


class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine().trim());
        String[] arr_arr = br.readLine().split(" ");
        int[] arr = new int[N];
        for (int i_arr = 0; i_arr < arr_arr.length; i_arr++) {
            arr[i_arr] = Integer.parseInt(arr_arr[i_arr]);
        }

        ArrayList<Integer>[] out_ = Solve(arr);
        for (int i_out_ = 0; i_out_ < out_.length; i_out_++) {

            for (int j_out_ = 0; j_out_ < out_[i_out_].size(); j_out_++) {
                System.out.print(out_[i_out_].get(j_out_) + " ");
            }
            System.out.println("");
        }

        wr.close();
        br.close();
    }

    static ArrayList<Integer>[] Solve(int[] arr) {
        int current_need = arr.length;
        int n = current_need;
        ArrayList[] ans = new ArrayList[arr.length];

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0;
             i < n; i++) {
            int x = arr[i];
            if (current_need == x) {
                ArrayList<Integer> tempAns = new ArrayList<>();
                tempAns.add(x);
                current_need--;

                while (!queue.isEmpty() && current_need == queue.peek()) {
                    tempAns.add(queue.poll());
                    current_need--;
                }
                ans[i] = tempAns;
            } else {
                queue.add(x);
                ans[i] = new ArrayList<>();
            }
        }

        return ans;
    }
}