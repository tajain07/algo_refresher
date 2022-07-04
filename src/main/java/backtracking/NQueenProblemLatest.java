package backtracking;

public class NQueenProblemLatest {


    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        int count = queens(board, 0);
        System.out.println("count "+count);
    }

    static int queens(boolean[][] board, int row) {
        if (row == board.length) {
            display(board);
            System.out.println();
            return 1;
        }

        int count = 0;

        // placing the queen and checking for every row and column
        for (int col_itr = 0; col_itr < board.length; col_itr++) {

            //place the queen if it's safe
            boolean isValidMove = isSafe(board, row, col_itr);

            if (isValidMove) {
                board[row][col_itr] = true;
                count += queens(board, row + 1);
                board[row][col_itr] = false;
            }
        }
        return count;

    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        boolean isRowValid = checkRow(board, row, col);
        boolean isLeftDiagonalValid = checkLeftDiagonal(board, row, col);
        boolean isRightDiagonalValid = checkRightDiagonal(board, row, col);

        return isRowValid && isLeftDiagonalValid && isRightDiagonalValid;
    }

    private static boolean checkRightDiagonal(boolean[][] board, int row, int col) {
        //boolean result = true;
        //int currentCol = col + 1;
        //int currentRow = row - 1;
        int maxRight = Math.min(row, board.length - col - 1);

        for (int i = 1; i <= maxRight; i++) {
            if (board[row - i][col + i]) {
                return false;
            }
        }

        return true;
    }

    private static boolean checkLeftDiagonal(boolean[][] board, int row, int col) {
        //boolean result = true;
        //int currentCol = col - 1;
        //int currentRow = row - 1;
        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft; i++) {
            if (board[row - i][col - i]) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkRow(boolean[][] board, int row, int col) {
        boolean result = true;
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col]) {
                result = false;
                break;
            }
        }

        return result;
    }


    private static void display(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean element : row) {
                if (element)
                    System.out.print("Q ");
                else
                    System.out.print("x ");
            }
            System.out.println();
        }

    }
}
