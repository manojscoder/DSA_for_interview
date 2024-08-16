// Problem link: https://leetcode.com/problems/01-matrix/description/
// Time: O(n * m)
// Space: O(n * m)
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length, cols = mat[0].length;
        int[][] visit = new int[rows][cols];
        int[][] result = new int[rows][cols];
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();

        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(mat[row][col] == 0) {
                    queue.offer(new int[] {row, col, 0});
                    visit[row][col] = 1;
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] dim = queue.poll();
            result[dim[0]][dim[1]] = dim[2];

            for(int[] pair : directions) {
                int newR = dim[0] + pair[0], newC = dim[1] + pair[1];
                if(newR >= 0 && newC >= 0 && newR < rows && newC < cols && visit[newR][newC] == 0) {
                    queue.offer(new int[] {newR, newC, dim[2] + 1});
                    visit[newR][newC] = 1;
                }
            }
        }

        return result;
    }
}
