// Problem link: https://leetcode.com/problems/house-robber/description/

// Top-down approach
// Time: O(n)
// Space: O(n)
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] cache = new int[n];

        for(int i = 0; i < n; i++)
            cache[i] = -1;
        
        for(int i = 0; i < Math.min(2, n); i++)
            cache[i] = DP(cache, nums, i);

        if(n > 1)
            return Math.max(cache[0], cache[1]);

        return cache[0];
    }

    private int DP(int[] cache, int[] nums, int index) {
        if(cache[index] != -1)
            return cache[index];
        
        int max_amount = 0;

        for(int i = index + 2; i < nums.length; i++)
            max_amount = Math.max(max_amount, DP(cache, nums, i));
        
        cache[index] = nums[index] + max_amount;
        return cache[index];
    }

}

// Bottom-up approach
// Time: O(n)
// Space: O(n)
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1)
            return nums[0];
        else if(n == 2)
            return Math.max(nums[0], nums[1]);
        
        int[] DP = new int[n + 1];

        for(int i = 0; i < n; i++)
            DP[i] = nums[i];

        for(int i = n - 3; i >= 0; i--)
            DP[i] += Math.max(DP[i + 2], DP[i + 3]);
        
        return Math.max(DP[0], DP[1]);
    }
}

// Space optimized
// Time: O(n)
// Space: O(1)
class Solution {
    public int rob(int[] nums) {
        int one = 0, two = 0, temp;

        for(int n : nums) {
            temp = two;
            two = Math.max(one + n, two);
            one = temp;
        }

        return two;
    }
}
