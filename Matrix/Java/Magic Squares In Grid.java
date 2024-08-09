// Problem link: https://leetcode.com/problems/magic-squares-in-grid/description/
// Time: O(n * m)
// Space: O(1)
class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int result = 0, rows = grid.length, cols = grid[0].length;

        for(int row = 0; row < rows - 2; row++) {
            for(int col = 0; col < cols - 2; col++) {
                if(this.magicSquare(row, col, grid)) {
                    result += 1;
                }
            }
        }

        return result;
    }

    private boolean magicSquare(int row, int col, int[][] grid) {
        int[] check = new int[10];
        int[] rowSum = {0, 0, 0}, colSum = {0, 0, 0}, diagonalSum = {0, 0};

        for(int r = row; r < row + 3; r++) {
            for(int c = col; c < col + 3; c++) {
                if(grid[r][c] > 9 || check[grid[r][c]] == 1) {
                    return false;
                }

                rowSum[r - row] += grid[r][c];
                colSum[c - col] += grid[r][c];

                if(r - row == c - col) {
                    diagonalSum[0] += grid[r][c];
                }
                if(r + c - row - col == 2) {
                    diagonalSum[1] += grid[r][c];
                }

                check[grid[r][c]] = 1;
            }
        }

        for(int idx = 0; idx < 3; idx++) {
            if(rowSum[idx] != 15 || colSum[idx] != 15 || idx < 2 && diagonalSum[idx] != 15) {
                return false;
            }
        }

        return true;
    }
}
