package backrack;

class solveSudoku {
    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }

    private boolean solve(char[][] board, int row, int col) {
        // Base case: If row == board length, board filled
        if (row == board.length) {
            return true;
        }

        // Move next row current row is filled
        if (col == board[0].length) {
            return solve(board, row + 1, 0);
        }

        // Skip cells is filled
        if (board[row][col] != '.') {
            return solve(board, row, col + 1);
        }

        // Try ALL Number
        for (char num = '1'; num <= '9'; num++) {
            if (isValidPlacement(board, row, col, num)) {
                board[row][col] = num;

                // next cell
                if (solve(board, row, col + 1)) {
                    return true;
                }

                // Backtrack if solution not found
                board[row][col] = '.';
            }
        }

        return false;
    }

    private boolean isValidPlacement(char[][] board, int row, int col, char num) {
        // Checking in row, column or 3x3 subgrid
        for (int i = 0; i < board.length; i++) {
            // row
            if (board[i][col] == num) {
                return false;
            }

            // column
            if (board[row][i] == num) {
                return false;
            }

            //  3x3 subgrid
            int subgridRow = 3 * (row / 3) + i / 3; //row index subgrid
            int subgridCol = 3 * (col / 3) + i % 3; //column index  subgrid

            if (board[subgridRow][subgridCol] == num) {
                return false;
            }
        }

        return true;

    }
}
