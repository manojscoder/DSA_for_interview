// Problem link: https://leetcode.com/problems/unique-binary-search-trees/description/
// Time: O(n ^ 2)
// Space: O(n)
class Solution {
    public int numTrees(int n) {
        if(n < 3) {
            return n;
        }

        return this.DP(n, new int[n + 1]);
    }

    private int DP(int n, int[] cache) {
        if(n <= 1) {
            return 1;
        }
        else if(cache[n] != 0) {
            return cache[n];
        }

        int result = 0;

        for(int num = 1; num <= n; num++) {
            result += this.DP(num - 1, cache) * this.DP(n - num, cache);
        }

        cache[n] = result;
        return cache[n];
    }
}
