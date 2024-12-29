// Problem link: https://leetcode.com/problems/number-of-ways-to-form-a-target-string-given-a-dictionary/description
// Time: O(n * w + m * w)
// Space: O(m * w)
class Solution {
    public int numWays(String[] words, String target) {
        int targetSize = target.length(), wordSize = words[0].length(), MOD = 1000000007;
        int[][] countChar = new int[wordSize][26];
        int[][] DP = new int[targetSize + 1][wordSize + 1];

        for(String word : words) {
            for(int index = 0; index < wordSize; index++) {
                countChar[index][word.charAt(index) - 'a']++;
            }
        }

        for(int index = 0; index < wordSize + 1; index++) {
            DP[targetSize][index] = 1;
        }

        for(int tIndex = targetSize - 1; tIndex >= 0; tIndex--) {
            for(int wIndex = wordSize - 1; wIndex >= 0; wIndex--) {
                DP[tIndex][wIndex] = DP[tIndex][wIndex + 1];
                DP[tIndex][wIndex] %= MOD;
                DP[tIndex][wIndex] += (countChar[wIndex][target.charAt(tIndex) - 'a'] * (long)DP[tIndex + 1][wIndex + 1]) % MOD;
                DP[tIndex][wIndex] %= MOD;
            }
        }

        return DP[0][0];
    }
}
