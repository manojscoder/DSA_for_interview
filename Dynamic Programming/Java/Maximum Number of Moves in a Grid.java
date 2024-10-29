// Problem link: https://leetcode.com/problems/maximum-number-of-moves-in-a-grid/description/ 
// Time: O(m * n)
// Space: O(m)
class Solution {
    public int maxMoves(int[][] grid) {
        int rows = grid.length, cols = grid[0].length, result = 0;
        int[] curr = new int[rows], prev = new int[rows];
        int[] directions = new int[] {-1, 0, 1};

        for(int col = cols - 2; col >= 0; col--) {
            for(int row = 0; row < rows; row++) {
                for(int dr : directions) {
                    if(row + dr < rows && row + dr >= 0 && grid[row][col] < grid[row + dr][col + 1]) {
                        curr[row] = Math.max(curr[row], 1 + prev[row + dr]);
                    }
                }
            }

            for(int row = 0; row < rows; row++) {
                prev[row] = curr[row];
                curr[row] = 0;
            }
        }

        for(int num : prev) {
            result = Math.max(result, num);
        }

        return result;
    }
}
