// Problem link: https://leetcode.com/problems/longest-palindromic-subsequence/description/

// Approach: Brute force(TLE)
class Solution {
    public int longestPalindromeSubseq(String s) {
        return this.LCS(s, s.length() - 1, s.length() - 1);
    }

    private int LCS(String s, int idxOne, int idxTwo) {
        if(idxOne < 0 || idxTwo < 0) {
            return 0;
        }
        else if(s.charAt(idxOne) == s.charAt(s.length() - idxTwo - 1)) {
            return 1 + this.LCS(s, idxOne - 1, idxTwo - 1);
        }
        return Math.max(this.LCS(s, idxOne - 1, idxTwo), this.LCS(s, idxOne, idxTwo - 1));
    }
}

// Approach: Top-down approach
// Time: O(n * n)
// Space: O(n * n)
class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] DP = new int[n][n];

        for(int row = 0; row < n; row++) {
            for(int col = 0; col < n; col++) {
                DP[row][col] = -1;
            }
        }
        
        return this.LCS(s, s.length() - 1, s.length() - 1, DP);
    }

    private int LCS(String s, int idxOne, int idxTwo, int[][] DP) {
        if(idxOne < 0 || idxTwo < 0) {
            return 0;
        }
        else if(DP[idxOne][idxTwo] != -1) {
            return DP[idxOne][idxTwo];
        }
        else if(s.charAt(idxOne) == s.charAt(s.length() - idxTwo - 1)) {
            DP[idxOne][idxTwo] = 1 + this.LCS(s, idxOne - 1, idxTwo - 1, DP);
        }
        else {
            DP[idxOne][idxTwo] = Math.max(this.LCS(s, idxOne - 1, idxTwo, DP), this.LCS(s, idxOne, idxTwo - 1, DP));
        }
        return DP[idxOne][idxTwo];
    }
}

// Approach: Bottom-up
// Time: O(n * n)
// Space: O(n * n)
class Solution {
    public int longestPalindromeSubseq(String s) {
        int rows = s.length(), cols = s.length();
        int[][] DP = new int[rows + 1][cols + 1];

        for(int row = rows - 1; row >= 0; row--) {
            for(int col = cols - 1; col >= 0; col--) {
                if(s.charAt(row) == s.charAt(cols - col - 1)) {
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
// Time: O(n * n)
// Space: O(n)
class Solution {
    public int longestPalindromeSubseq(String s) {
        int rows = s.length(), cols = s.length();
        int[] prev = new int[cols + 1];
        int[] curr = new int[cols + 1];

        for(int row = rows - 1; row >= 0; row--) {
            for(int col = cols - 1; col >= 0; col--) {
                if(s.charAt(row) == s.charAt(cols - col - 1)) {
                    curr[col] = 1 + prev[col + 1];
                }
                else {
                    curr[col] = Math.max(curr[col + 1], prev[col]);
                }
            }
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[0];
    }
}
