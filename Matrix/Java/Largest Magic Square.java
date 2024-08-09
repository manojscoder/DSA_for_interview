// Problem link: https://leetcode.com/problems/largest-magic-square/description/
// Time: O(n * m * min(n, m))
// Space: O(n * m)
class Solution {
    public int largestMagicSquare(int[][] grid) {
        int rows = grid.length, cols = grid[0].length, result = 0, dim;
        int[][] rowPrefix = new int[rows][cols];
        int[][] colPrefix = new int[rows][cols];

        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                rowPrefix[row][col] = grid[row][col] + (row > 0 ? rowPrefix[row - 1][col] : 0);
                colPrefix[row][col] = grid[row][col] + (col > 0 ? colPrefix[row][col - 1] : 0);
            }
        }

        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                dim = Math.min(rows - row, cols - col);
                result = Math.max(result, this.magicSquare(row, col, dim, rowPrefix, colPrefix, grid));
            }
        }

        return result;
    }

    private int magicSquare(int row, int col, int dim, int[][] rowPrefix, int[][] colPrefix, int[][] grid) {
        int checks, left, right, totalSum;

        for(; dim > 0; dim--) {
            totalSum = colPrefix[row][col + dim - 1] - (col > 0 ? colPrefix[row][col - 1] : 0);
            left = right = checks = 0;

            for(int idx = 0; idx < dim; idx++) {
                if(totalSum != colPrefix[row + idx][col + dim - 1] - (col > 0 ? colPrefix[row + idx][col - 1] : 0)) {
                    break;
                }

                if(totalSum != rowPrefix[row + dim - 1][col + idx] - (row > 0 ? rowPrefix[row - 1][col + idx] : 0)) {
                    break;
                }

                checks += 2;
                left += grid[row + idx][col + idx];
                right += grid[row + idx][col + dim - idx - 1];
            }

            if(checks == dim * 2 && left == totalSum && right == totalSum) {
                return dim;
            }
        }

        return 0;
    }
}
