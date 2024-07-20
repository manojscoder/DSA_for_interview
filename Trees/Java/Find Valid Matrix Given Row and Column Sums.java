// Problem link: Find Valid Matrix Given Row and Column Sums
// Time: O(n * m)
// Space: O(1)
class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int rows = rowSum.length, cols = colSum.length;
        int[][] result = new int[rows][cols];

        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                result[row][col] = Math.min(rowSum[row], colSum[col]);
                rowSum[row] -= result[row][col];
                colSum[col] -= result[row][col];
            }
        }

        return result;
    }
}
