package graph;


/**
 * Leetcode problem - 463
 * https://leetcode.com/problems/island-perimeter/
 */
public class IslandPerimeter_LC463 {
    public static void main(String[] args) {
        int[][] island = new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        final int perimeter = islandPerimeter(island);
        System.out.println("perimeter " + perimeter);
    }

    public static int islandPerimeter(int[][] grid) {

        int perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int cellValue = grid[i][j];
                //island found, find perimeter
                if (cellValue == 1) {
                    perimeter += getPerimeterForIsland(grid, i, j);
                    return perimeter;
                }
            }
        }

        return perimeter;
    }

    private static int getPerimeterForIsland(int[][] grid, int i, int j) {
        int perimeter = 0;
        if (i < 0)
            perimeter += 1;
        else if (j < 0)
            perimeter += 1;
        else if (i >= grid.length)
            perimeter += 1;
        else if (j >= grid[0].length)
            perimeter += 1;

        if (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length) {
            if (grid[i][j] == 0)
                perimeter += 1;

                //value can be 0, 1, -1 so we need else if here [not else]
            else if (grid[i][j] == 1) {
                grid[i][j] = -1;

                perimeter += getPerimeterForIsland(grid, i - 1, j);
                perimeter += getPerimeterForIsland(grid, i, j - 1);
                perimeter += getPerimeterForIsland(grid, i + 1, j);
                perimeter += getPerimeterForIsland(grid, i, j + 1);
            }
        }

        return perimeter;
    }
}