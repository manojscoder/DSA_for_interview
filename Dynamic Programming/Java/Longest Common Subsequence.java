// problem link: https://leetcode.com/problems/longest-common-subsequence/description/


// Approach: Brute force (TLE)
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        return this.LCS(text1, text2, 0, 0);
    }

    private int LCS(String text1, String text2, int idxOne, int idxTwo) {
        if(idxOne == text1.length() || idxTwo == text2.length()) {
            return 0;
        }
        else if(text1.charAt(idxOne) == text2.charAt(idxTwo)) {
            return 1 + this.LCS(text1, text2, idxOne + 1, idxTwo + 1);
        }
        return Math.max(this.LCS(text1, text2, idxOne + 1, idxTwo), this.LCS(text1, text2, idxOne, idxTwo + 1));
    }
}

// Approach: Top-down approach (Memo)
// Time: O(n * m)
// Space: O(n * m)
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] DP = new int[text1.length()][text2.length()];

        for(int row = 0; row < text1.length(); row++) {
            for(int col = 0; col < text2.length(); col++) {
                DP[row][col] = -1;
            }
        }

        return this.LCS(text1, text2, 0, 0, DP);
    }

    private int LCS(String text1, String text2, int idxOne, int idxTwo, int[][] DP) {
        if(idxOne == text1.length() || idxTwo == text2.length()) {
            return 0;
        }
        else if(DP[idxOne][idxTwo] != -1) {
            return DP[idxOne][idxTwo];
        }
        else if(text1.charAt(idxOne) == text2.charAt(idxTwo)) {
            DP[idxOne][idxTwo] = 1 + this.LCS(text1, text2, idxOne + 1, idxTwo + 1, DP);
        }
        else {
            DP[idxOne][idxTwo] = Math.max(this.LCS(text1, text2, idxOne + 1, idxTwo, DP), this.LCS(text1, text2, idxOne, idxTwo + 1, DP));
        }

        return DP[idxOne][idxTwo];
    }
}

// Approach: Bottom-up (Tabulation)
// Time: O(n * m)
// Space: o(n * m)
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int rows = text1.length(), cols = text2.length();
        int[][] DP = new int[rows + 1][cols + 1];

        for(int row = rows - 1; row >= 0; row--) {
            for(int col = cols - 1; col >= 0; col--) {
                if(text1.charAt(row) == text2.charAt(col)) {
                    DP[row][col] = 1 + DP[row + 1][col + 1];
                }
                else {
                    DP[row][col] = Math.max(DP[row + 1][col], DP[row][col + 1]);
                }
            }
        }

        return DP[0][0];
    }
}

// Approach: Space optimized
// Time: O(n * m)
// Space: O(m)
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int rows = text1.length(), cols = text2.length();
        int[] prev = new int[cols + 1];
        int[] curr = new int[cols + 1];

        for(int row = rows - 1; row >= 0; row--) {
            for(int col = cols - 1; col >= 0; col--) {
                if(text1.charAt(row) == text2.charAt(col)) {
                    curr[col] = 1 + prev[col + 1];
                }
                else {
                    curr[col] = Math.max(prev[col], curr[col + 1]);
                }
            }
            int[] store = prev;
            prev = curr;
            curr = store;
        }

        return prev[0];
    }
}
