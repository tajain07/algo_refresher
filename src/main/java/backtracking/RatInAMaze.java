package backtracking;

public class RatInAMaze {
    //1 is open
    //o is blocked
    public static void main(String[] args) {

        int N = 4;
        int maze[][] = {
        };

        final boolean b = printPaths(maze, N, 0, 0, "");
        if (!b)
            System.out.println("Path doesn't exist");
    }

    private static boolean printPaths(int[][] m, int N, int r, int c, String path) {
        if (m.length == 0)
            return false;
        if (r == N - 1 && c == N - 1 && m[r][c] == 1) {
            System.out.println(path);
            return true;
        }


        //Has a valid move?
        // yes = go into recursion
        // no - return false
        if (m[r][c] == 1) {
            m[r][c] = 0;


            //Up
            if (r - 1 > 0 && m[r - 1][c] == 1 && printPaths(m, N, r - 1, c, path + "U")) {
                return true;
            }

            if (r + 1 < m.length && m[r + 1][c] == 1 && printPaths(m, N, r + 1, c, path + "D")) {
                return true;
            }

            if (c - 1 > 0 && c - 1 < m[r].length && m[r][c - 1] == 1 && printPaths(m, N, r, c - 1, path + "L")) {
                return true;
            }

            if (c + 1 < m[r].length && m[r][c + 1] == 1 && printPaths(m, N, r, c + 1, path + "R")) {
                return true;
            }

            m[r][c] = 1;
            return false;
        }
        return false;

    }
}
