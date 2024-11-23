// Problem link: https://leetcode.com/problems/rotating-the-box/description/
// Time: O(m * n)
// Space: O(m * n)
class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length, n = box[0].length;
        char[][] result = new char[n][m];

        for(char[] row : result) {
            Arrays.fill(row, '.');
        }

        int rw = m - 1, cl, row;

        for(int col = 0; col < m; col++) {
            row = cl = n - 1;

            while(cl >= 0) {
                if(box[rw][cl] == '#') {
                    result[row][col] = '#';
                    row--;
                }
                else if(box[rw][cl] == '*') {
                    result[cl][col] = '*';
                    row = cl - 1;
                }

                cl--;
            }

            rw--;
        }

        return result;
    }
}
