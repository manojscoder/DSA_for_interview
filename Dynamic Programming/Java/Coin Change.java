// Problem link: https://leetcode.com/problems/coin-change/description/

// Top-down approach
// Time: O(n * amount)
// Space: O(amount)
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] cache = new int[amount + 1];
        int result = this.DP(cache, amount, amount, coins);

        if(result == amount + 1)
            return -1;

        return result;
    }

    private int DP(int[] cache, int amt, int amount, int[] coins) {
        if(amt < 0)
            return amount + 1;
        else if(cache[amt] != 0)
            return cache[amt];
        else if(amt == 0)
            return 0;
        
        cache[amt] = amount + 1;

        for(int coin : coins)
            cache[amt] = Math.min(cache[amt], 1 + this.DP(cache, amt - coin, amount, coins));
        
        return cache[amt];
    }
}

// Bottom-up approach
// Time: O(n * amount)
// Space: O(amount)
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] DP = new int[amount + 1];
        Arrays.fill(DP, amount + 1);
        DP[0] = 0;

        for(int amt = 1; amt <= amount; amt++)
            for(int coin : coins)
                if(coin <= amt)
                    DP[amt] = Math.min(DP[amt], 1 + DP[amt - coin]);
        
        return DP[amount] == amount + 1 ? -1 : DP[amount];
    }
}
