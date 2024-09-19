// Problem link: https://leetcode.com/problems/unique-paths-iii/description/
// Time: O(4 ^ m * n)
// Space: O(m * n)
class Solution {
    public int uniquePathsIII(int[][] grid) {
        int[] st = new int[2], ed = new int[2];
        int count = 1;

        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[0].length; col++) {
                if(grid[row][col] == 1) {
                    st[0] = row;
                    st[1] = col;
                }
                else if(grid[row][col] == 2) {
                    ed[0] = row;
                    ed[1] = col;
                }
                else if(grid[row][col] == 0) {
                    count++;
                }
            }
        }

        return this.dfs(grid, st, ed, count);
    }

    private int dfs(int[][] grid, int[] st, int[] ed, int count) {
        if(st[0] < 0 || st[1] < 0 || st[0] == grid.length || st[1] == grid[0].length || grid[st[0]][st[1]] == -1) {
            return 0;
        }
        else if(st[0] == ed[0] && st[1] == ed[1]) {
            return count == 0 ? 1 : 0;
        }

        grid[st[0]][st[1]] = -1;
        int total = 0;
        int[][] direction = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        for(int[] dir : direction) {
            total += this.dfs(grid, new int[] {st[0] + dir[0], st[1] + dir[1]}, ed, count - 1);
        }

        grid[st[0]][st[1]] = 0;
        return total;
    }
}
