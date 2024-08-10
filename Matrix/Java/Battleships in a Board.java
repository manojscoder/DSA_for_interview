// Problem link: https://leetcode.com/problems/battleships-in-a-board/description/
// Time: O(n * m)
// Space: O(1)
class Solution {
    public int countBattleships(char[][] board) {
        int rows = board.length, cols = board[0].length, result = 0;

        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(board[row][col] == 'X') {
                    if((row > 0 && board[row - 1][col] == 'X') || (col > 0 && board[row][col - 1] == 'X')) {
                        continue;
                    }
                    result += 1;
                }
            }
        }

        return result;
    }
}
