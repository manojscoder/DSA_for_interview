// Problem link: https://leetcode.com/problems/spiral-matrix-iii/description
// Time: O(m * n)
// Space: O(1)
class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] result = new int[rows * cols][2];
        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int steps = 1, index = 0, dir = 0;
        

        while(index < rows * cols) {
            for(int idx = 0; idx < 2; idx++) {
                for(int step = 0; step < steps; step++) {
                    if(rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
                        result[index][0] = rStart;
                        result[index++][1] = cStart;
                    }
                    rStart += direction[dir][0];
                    cStart += direction[dir][1];
                }
                dir = (dir + 1) % 4;
            }
            steps++;
        }

        return result;
    }
}
