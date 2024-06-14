// Problem link: https://leetcode.com/problems/climbing-stairs/description/

// Top-down approach
// Time: O(n)
// Space: O(n)
class Solution {
    public int climbStairs(int n) {
        int[] cache = new int[n + 1];
        cache[n] = 1;
        return DP(0, cache, n);
    }

    private int DP(int step, int[] cache, int n) {
        if(step > n)
            return 0;
        else if(cache[step] != 0)
            return cache[step];
        
        cache[step] = DP(step + 1, cache, n) + DP(step + 2, cache, n);
        return cache[step];
    }
}

// Bottom-up approach
// Time: O(n)
// Space: O(n)
class Solution {
    public int climbStairs(int n) {
        int[] cache = new int[n + 1];
        cache[n] = cache[n - 1] = 1;
        
        for(int i = n - 2; i >= 0; i--)
            cache[i] = cache[i + 1] + cache[i + 2];
        
        return cache[0];
    }
}

// Space optimized
// Time: O(n)
// Space: O(1)
class Solution {
    public int climbStairs(int n) {
        int one = 1, two = 1;

        for(int i = n - 2; i >= 0; i--) {
            one = one + two;
            two = one - two;
        }
        
        return one;
    }
}
