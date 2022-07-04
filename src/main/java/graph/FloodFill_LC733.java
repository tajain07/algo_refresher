package graph;

import java.util.Arrays;

/**
 * Leetcode - 733
 * https://leetcode.com/problems/flood-fill/
 */
public class FloodFill_LC733 {

    public static void main(String[] args) {
        int[][] image = new int[][]{{1, 1, 1}, {1, 1, 0},{1,0,1}};

        int[][] newImage = floodFill(image, 1, 1, 2);
        for (int i = 0; i < image.length; i++) {
            System.out.println(Arrays.toString(image[i]));
        }
    }

    public  static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        int currentColor = image[sr][sc];
        floodFillCore(image, sr, sc, newColor, currentColor);
        return image;
    }

    private  static void floodFillCore(int[][] image, int sr, int sc, int newColor, int currentColor) {

        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[sr].length || newColor == currentColor)
            return;

        if (image[sr][sc] == currentColor) {
            image[sr][sc] = newColor;

            floodFillCore(image, sr - 1, sc, newColor, currentColor);
            floodFillCore(image, sr + 1, sc, newColor, currentColor);
            floodFillCore(image, sr, sc - 1, newColor, currentColor);
            floodFillCore(image, sr, sc + 1, newColor, currentColor);
        }

    }
}
