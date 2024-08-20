// Problem link: https://leetcode.com/problems/stone-game-ii/description
// Time: O(n ^ 3)
// Space: O(n ^ 2)
class Solution {
    public int stoneGameII(int[] piles) {
        int[][][] cache = new int[2][piles.length][piles.length + 1];

        return this.dfs(0, 0, 1, piles, cache);
    }

    private int dfs(int flag, int idx, int M, int[] piles, int[][][] cache) {
        if(idx == piles.length) {
            return 0;
        }
        else if(cache[flag][idx][M] != 0) {
            return cache[flag][idx][M];
        }

        int result = flag == 0 ? 0 : Integer.MAX_VALUE, total = 0;

        for(int i = 1; idx + i <= piles.length && i <= 2 * M; i++) {
            total += piles[idx + i - 1];

            if(flag == 0) {
                result = Math.max(result, total + this.dfs(1, idx + i, Math.max(M, i), piles, cache));
            }
            else {
                result = Math.min(result, this.dfs(0, idx + i, Math.max(M, i), piles, cache));
            }
        }

        cache[flag][idx][M] = result;
        return result;


    }
}
