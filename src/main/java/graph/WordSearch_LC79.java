package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordSearch_LC79 {
    public static void main(String[] args) {


        char[][] board = new char[][]{{'a', 'b'}};
        String word = "ba";
        boolean result = exist(board, word);
        System.out.println("result for word " + word + " " + result);

        board = new char[][]{{'a', 'a'}};
         word = "aa";
         result = exist(board, word);
        System.out.println("result for word " + word + " " + result);

        board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        word = "ABCB";
        result = exist(board, word);
        System.out.println("result for word " + word + " " + result);

        board = new char[][]{{'a', 'a'}};
        word = "aa";
        result = exist(board, word);
        System.out.println("result for word " + word + " " + result);

        board = new char[][]{{'A', 'N', 'S', 'Q'}, {'S', 'O', 'L', 'R'}, {'K', 'T', 'O', 'G'}};
        word = "SOLO";
        result = exist(board, word);
        System.out.println("result for word " + word + " " + result);


        board = new char[][]{{'X', 'B', 'C', 'E'}, {'S', 'F', 'B', 'S'}, {'E', 'D', 'A', 'E'}};
        word = "ABCB";
        result = exist(board, word);
        System.out.println("result for word " + word + " " + result);

        board = new char[][]{{'A'}};
        word = "A";
        result = exist(board, word);
        System.out.println("result for word " + word + " " + result);


        board = new char[][]{{}};
        word = "ABCB";
        result = exist(board, word);
        System.out.println("result for word " + word + " " + result);

        board = new char[][]{{'a', 'a'}};
        word = "aa";
        result = exist(board, word);
        System.out.println("result for word " + word + " " + result);


    }

    public static boolean exist(char[][] board, String word) {
        final char firstCharacter = word.charAt(0);
        List<int[]> firstCharFoundIndexes = findCharIndex(board, firstCharacter);
        //First word not found - so word doesn't exist
        if (firstCharFoundIndexes.size() == 0)
            return false;

        if (word.length() == 1)
            return true;

        for (int[] index : firstCharFoundIndexes) {
            boolean[][] visited = new boolean[board.length][board[0].length];
            boolean isFound = dfs_helper(board, word, 0, index, index[0], index[1], visited);
            if (isFound)
                return isFound;

        }

        return false;
    }


    private static boolean dfs_helper(char[][] board, String word, int charIndex, int[] parent_index, int i, int j, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length)
            return false;

        if (visited[i][j])  //to avoid out of bound exception
            return false;

        if (board[i][j] == word.charAt(charIndex)) {
            if (charIndex == word.length() - 1)
                return true;

            visited[i][j] = true;
            charIndex = charIndex + 1;

            int[][] directions = new int[][]{{i - 1, j}, {i + 1, j}, {i, j + 1}, {i, j - 1}};

            for (int[] direction : directions) {

                final int i_index = direction[0];
                final int j_index = direction[1];
                boolean isEqual = Arrays.equals(direction, parent_index);
                if (!isEqual) {
                    boolean result = dfs_helper(board, word, charIndex, direction, i_index, j_index, visited);
                    if (result)
                        return true;

                }
            }
        }

        return false;
    }


    private static List<int[]> findCharIndex(char[][] board, char firstCharacter) {
        List<int[]> foundIndexes = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == firstCharacter)
                    foundIndexes.add(new int[]{i, j});
            }
        }

        return foundIndexes;
    }
}
