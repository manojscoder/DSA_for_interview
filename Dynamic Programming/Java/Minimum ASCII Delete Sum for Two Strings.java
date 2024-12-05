// Problem link: https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/description/
// Time: O(n * m)
// Space: O(m)
class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int rows = s1.length(), cols = s2.length();
        int[] curr = new int[cols + 1], prev = new int[cols + 1];

        for(int col = cols - 1; col >= 0; col--) {
            prev[col] = prev[col + 1] + (int)s2.charAt(col);
        }

        for(int row = rows - 1; row >= 0; row--) {
            curr[cols] = prev[cols] + (int)s1.charAt(row);

            for(int col = cols - 1; col >= 0; col--) {
                if(s1.charAt(row) == s2.charAt(col)) {
                    curr[col] = prev[col + 1];
                }
                else {
                    curr[col] = Math.min((int)s1.charAt(row) + prev[col], (int)s2.charAt(col) + curr[col + 1]);
                }
            }

            for(int col = 0; col <= cols; col++) {
                prev[col] = curr[col];
            }
        }

        return prev[0];
    }
}
