// Problem link: https://leetcode.com/problems/count-square-submatrices-with-all-ones/description/
// Time: O(m * n)
// Space: O(m * n)
class Solution {
    public int countSquares(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length, result = 0;
        int[][] DP = new int[rows][cols];

        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(matrix[row][col] == 1) {
                    if(row > 0 && col > 0) {
                        DP[row][col] = Math.min(DP[row - 1][col - 1], Math.min(DP[row][col - 1], DP[row - 1][col]));
                    }
                    DP[row][col] += 1;
                }
            }
        }

        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                result += DP[row][col];
            }
        }

        return result;
    }
}
