// Problem link: https://leetcode.com/problems/delete-operation-for-two-strings/description/
// Time: O(m * n)
// Space: O(n)
class Solution {
    public int minDistance(String word1, String word2) {
        int rows = word1.length(), cols = word2.length();
        int[] prev = new int[cols + 1], curr = new int[cols + 1];

        for(int index = 0; index <= cols; index++) {
            prev[index] = cols - index;
        }

        for(int row = rows - 1; row >= 0; row--) {
            curr[cols] = rows - row;

            for(int col = cols - 1; col >= 0; col--) {
                if(word1.charAt(row) == word2.charAt(col)) {
                    curr[col] = prev[col + 1];
                }
                else {
                    curr[col] = 1 + Math.min(curr[col + 1], prev[col]);
                }
            } 

            for(int index = 0; index <= cols; index++) {
                prev[index] = curr[index];
            }
        }

        return prev[0];
    }
}
