// Problem link: https://leetcode.com/problems/min-cost-climbing-stairs/description/

// Top-down approach
// Time: O(n)
// Space: O(n)
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] cache = new int[cost.length];
        return Math.min(DP(cache, cost, 0), DP(cache, cost, 1));
    }

    private int DP(int[] cache, int[] cost, int index) {
        if(index >= cost.length) {
            return 0;
        }
        else if(cache[index] != 0) {
            return cache[index];
        }

        cache[index] = cost[index] + Math.min(DP(cache, cost, index + 1), DP(cache, cost, index + 2));
        return cache[index];
    }
}

// Bottom-up approach
// Time: O(n)
// Space: O(n)
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] copy_cost = new int[n + 1];
        copy_cost[n - 1] = cost[n - 1];

        for(int i = n - 2; i >= 0; i--)
            copy_cost[i] = cost[i] + Math.min(copy_cost[i + 1], copy_cost[i + 2]);

        return Math.min(copy_cost[0], copy_cost[1]);
    }
}

// Space optimized
// Time: O(n)
// Space: O(1)
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int one = cost[n - 1], two = 0, temp;

        for(int i = n - 2; i >= 0; i--) {
            temp = one;
            one = cost[i] + Math.min(one, two);
            two = temp;
        }

        return Math.min(one, two);
    }
}
