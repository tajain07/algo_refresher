package backtracking;

import java.util.Arrays;

public class NQueenProblem {
    public static void main(String[] args) {
        boolean[][] chessBoard = new boolean[4][4];

        //(matrix, rol, col, total queens, currently_placed_queen, ans);
        placeNQueen(chessBoard, 0, 0, 4, 0, "");


    }

    private static void placeNQueen(boolean[][] board, int row, int col, int tq, int queenPlaceSoFar, String answer) {

        if (queenPlaceSoFar == tq) {
            System.out.println(answer);
            return;
        }

        if (col == board[0].length) {
            row++;
            col = 0;
        }
        if (row == board.length)
            return;
        //place
        if (isItSafeToPlace(board, row, col)) {
            //do
            board[row][col] = true;
            //recur
            placeNQueen(board, row, col + 1, tq, queenPlaceSoFar + 1, answer + "[" + row + "-" + col + "]");
            //undo
            board[row][col] = false;
        }

        //not place
        placeNQueen(board, row, col + 1, tq, queenPlaceSoFar, answer);

    }

    private static boolean isItSafeToPlace(boolean[][] board, int row, int col) {
        //vertically up;
        int r = row - 1;
        int c = col;
        while (r >= 0) {
            if (board[r][c]) {
                return false;
            }
            r--;
        }

        r = row;
        c = col - 1;
        while (c >= 0) {
            if (board[r][c])
                return false;
            c--;
        }

        //diagonally left
        r = row - 1;
        c = col - 1;
        while (r >= 0 && c >= 0) {
            if (board[r][c])
                return false;

            r--;
            c--;
        }

        //diagonally right
        r = row - 1;
        c = col + 1;
        while (r >= 0 && c < board[0].length) {
            if (board[r][c])
                return false;

            r--;
            c++;
        }
        return true;
    }


}
