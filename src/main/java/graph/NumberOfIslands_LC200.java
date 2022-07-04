package graph;

/**
 * Leetcode - 200
 * https://leetcode.com/problems/number-of-islands/
 */
public class NumberOfIslands_LC200 {
    public static void main(String[] args) {
        //char[][] input = new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        char[][] input = new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};

        int numberOfIsland = numIslands(input);
        System.out.println("numberOfIsland " + numberOfIsland);
    }

    public static int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                //System.out.println(grid[i][j]);
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count += 1;
                }
            }
        }
        return count;
    }


    private static void dfs(char[][] grid, int i, int j) {

        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == '0')
            return;


        if (grid[i][j] == '1') {
            grid[i][j] = '0';
        }

        //left
        dfs(grid, i - 1, j);
        //right
        dfs(grid, i + 1, j);
        //top
        dfs(grid, i, j + 1);
        //bottom
        dfs(grid, i, j - 1);

    }
}
