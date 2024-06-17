// Problem link: https://leetcode.com/problems/minimum-cost-for-tickets/description/

// Top-down approach
// Time: O(n)
// Space: O(n)
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] cache = new int[days.length];

        return this.DP(days, costs, cache, new int[] {1, 7, 30}, 0);
    }

    private int DP(int[] days, int[] costs, int[] cache, int[] pass_days, int idx) {
        if(idx == days.length)
            return 0;
        else if(cache[idx] != 0)
            return cache[idx];
        
        cache[idx] = Integer.MAX_VALUE;

        for(int i = 0; i < 3; i++) {
            int j = idx;

            while(j < days.length && days[j] < days[idx] + pass_days[i])
                j++;

            cache[idx] = Math.min(cache[idx], costs[i] + this.DP(days, costs, cache, pass_days, j));
        }

        return cache[idx];
    }
}

// Bottom-up approach
// Time: O(n)
// Space : O(n)
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] cache = new int[days.length + 1], pass_days = {1, 7, 30};

        cache[days.length] = 0;
        int idx;

        for(int i = days.length - 1; i >= 0; i--) {
            cache[i] = Integer.MAX_VALUE;
            for(int j = 0; j < 3; j++) {
                idx = i;

                while(idx < days.length && days[idx] < days[i] + pass_days[j])
                    idx++;
                
                cache[i] = Math.min(cache[i], costs[j] + cache[idx]);
            }
        }

        return cache[0];
    }
}
