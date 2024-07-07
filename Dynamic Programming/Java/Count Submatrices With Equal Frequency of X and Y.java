// Problem link: https://leetcode.com/problems/count-submatrices-with-equal-frequency-of-x-and-y/description/
// Time: O(n * m)
// Space: O(n * m)
class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[][][] store = new int[rows][cols][2];
        int result = 0;

        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(grid[row][col] == 'X')
                    store[row][col][0] += 1;
                else if(grid[row][col] == 'Y')
                    store[row][col][1] += 1;

                if(col > 0) {
                    store[row][col][0] += store[row][col - 1][0];
                    store[row][col][1] += store[row][col - 1][1];
                }
            }
        }

        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(row > 0) {
                    store[row][col][0] += store[row - 1][col][0];
                    store[row][col][1] += store[row - 1][col][1];
                }

                if(store[row][col][0] > 0 && store[row][col][1] == store[row][col][0])
                    result += 1;
            }
        }

        return result;
    }
}
