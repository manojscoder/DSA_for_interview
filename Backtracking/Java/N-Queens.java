// Problem link: https://leetcode.com/problems/n-queens/description/
// Time: O(n!)
// Space: O(n ^ 2)
class Solution {
    HashSet<Integer> colSet, negDig, posDig;
    char[][] board;
    List<List<String>> result;
    List<String> copy;
    StringBuilder str;

    public List<List<String>> solveNQueens(int n) {
        this.colSet = new HashSet<>();
        this.negDig = new HashSet<>();
        this.posDig = new HashSet<>();
        this.board = new char[n][n];
        this.result = new ArrayList<>();
        this.str = new StringBuilder();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                this.board[i][j] = '.';
            }
        }

        this.backTrack(0, n);

        return this.result;
    }

    private void backTrack(int row, int n) {
        if(row == n) {
            this.copy = new ArrayList<>();

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    this.str.append(this.board[i][j]);
                }
                this.copy.add(this.str.toString());
                this.str.setLength(0);
            }

            this.result.add(this.copy);
            return;
        }

        for(int c = 0; c < n; c++) {
            if(!this.colSet.contains(c) && !this.posDig.contains(row + c) && !this.negDig.contains(row - c)) {
                this.board[row][c] = 'Q';
                this.colSet.add(c);
                this.posDig.add(row + c);
                this.negDig.add(row - c);

                this.backTrack(row + 1, n);

                this.board[row][c] = '.';
                this.colSet.remove(c);
                this.posDig.remove(row + c);
                this.negDig.remove(row - c);
            }
        }
    }
}
