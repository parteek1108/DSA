class Solution {

    public boolean exist(char[][] board, String word) {

        int rows = board.length;
        int cols = board[0].length;

        // Try every cell as a starting point
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (solve(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean solve(char[][] board, String word, int row, int col, int index) {

        // Base Case: Entire word matched
        if (index == word.length()) {
            return true;
        }

        // Boundary check
        if (row < 0 || row >= board.length ||
            col < 0 || col >= board[0].length) {
            return false;
        }

        // Character mismatch
        if (board[row][col] != word.charAt(index)) {
            return false;
        }

        // Already visited
        if (board[row][col] == '#') {
            return false;
        }

        // Choose (mark visited)
        char temp = board[row][col];
        board[row][col] = '#';

        // Explore all 4 directions
        boolean found =
                solve(board, word, row + 1, col, index + 1) ||
                solve(board, word, row - 1, col, index + 1) ||
                solve(board, word, row, col + 1, index + 1) ||
                solve(board, word, row, col - 1, index + 1);

        // Undo (backtrack)
        board[row][col] = temp;

        return found;
    }
}