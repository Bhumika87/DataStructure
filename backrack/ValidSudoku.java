package backrack;

class ValidSudoku {
    public void solveSudoku(char[][] board) {
        backtrack(board);
    }

    private boolean backtrack(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                // find empty cell
                if (board[row][col] == '.') {

                    // try digits 1 to 9
                    for (char ch = '1'; ch <= '9'; ch++) {
                        if (isValid(board, row, col, ch)) {
                            board[row][col] = ch;

                            if (backtrack(board)) {
                                return true;
                            }

                            // backtrack
                            board[row][col] = '.';
                        }
                    }
                    return false; // no valid digit found
                }
            }
        }
        return true; // board solved
    }

    private boolean isValid(char[][] board, int row, int col, char ch) {

        for (int i = 0; i < 9; i++) {
            // check row
            if (board[row][i] == ch) return false;

            // check column
            if (board[i][col] == ch) return false;

            // check 3x3 box
            int boxRow = 3 * (row / 3) + i / 3;
            int boxCol = 3 * (col / 3) + i % 3;

            if (board[boxRow][boxCol] == ch) return false;
        }
        return true;
    }
}
