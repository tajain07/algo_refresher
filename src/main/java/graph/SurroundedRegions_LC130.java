package graph;

import java.util.Arrays;

public class SurroundedRegions_LC130 {
    public static void main(String[] args) {

        //char[][] board = new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        //char[][] board = new char[][]{{'X'}};
        //char[][] board  = new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','O','O','X'},{'X','O','X','X'}};
        char[][] board = new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        //char[][] board = new char[][]{{'X', 'O', 'X'}, {'O', 'X', 'O'}, {'X', 'O', 'X'}};
        //char[][] board = new char[][]{{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}};
        //char[][] board = new char[][]{{}};

        solve(board);
        for (char[] subBoard : board) {
            System.out.println(Arrays.toString(subBoard));
        }
    }

    public static void solve(char[][] board) {

        for (int column = 0; column < board[0].length; column++) {
            if (board[0][column] == 'O')
                dfs(board, 0, column);
            if (board[board.length - 1][column] == 'O')
                dfs(board, board.length - 1, column);
        }

        for (int row = 0; row < board.length && board[0].length > 0; row++) {
            if (board[row][0] == 'O')
                dfs(board, row, 0);

            if (board[row][board[0].length - 1] == 'O')
                dfs(board, row, board[0].length - 1);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static void dfs(char[][] board, int r, int c) {
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length) {
            return;
        }

        if (board[r][c] == 'O') {
            board[r][c] = '#';
            dfs(board, r + 1, c);
            dfs(board, r, c + 1);
            dfs(board, r - 1, c);
            dfs(board, r, c - 1);
        }
    }
}
