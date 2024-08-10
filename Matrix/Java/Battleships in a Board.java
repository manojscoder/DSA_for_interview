// Problem link: https://leetcode.com/problems/battleships-in-a-board/description/
// Time: O(n * m)
// Space: O(1)
class Solution {
    public int countBattleships(char[][] board) {
        int rows = board.length, cols = board[0].length, result = 0;

        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(board[row][col] == 'X') {
                    this.dfs(row, col, board, rows, cols);
                    result += 1;
                }
            }
        }

        return result;
    }

    private void dfs(int row, int col, char[][] board, int rows, int cols) {
        if(row < 0 || col < 0 || row == rows || col == cols) {
            return;
        }

        board[row][col] = '.';

        if(row + 1 < rows && board[row + 1][col] == 'X') {
            this.dfs(row + 1, col, board, rows, cols);
        }
        else if(col + 1 < cols && board[row][col + 1] == 'X') {
            this.dfs(row, col + 1, board, rows, cols);
        }
    }
}
