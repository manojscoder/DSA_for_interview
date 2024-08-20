# Problem link: https://leetcode.com/problems/stone-game-ii/description
# Time: O(n ^ 3)
# Space: O(n ^ 2)
class Solution:
    def stoneGameII(self, piles):
        cache = [[[0] * (len(piles) + 1) for _ in range(len(piles))] for _ in range(2)]

        return self.dfs(0, 0, 1, piles, cache)

    def dfs(self, flag, idx, M, piles, cache):
        if idx == len(piles):
            return 0
        elif cache[flag][idx][M] != 0:
            return cache[flag][idx][M]

        if flag == 0:
            result = 0
        else:
            result = float('inf')
        total = 0

        for i in range(1, min(len(piles) - idx + 1, 2 * M + 1)):
            total += piles[idx + i - 1]

            if flag == 0:
                result = max(result, total + self.dfs(1, idx + i, max(M, i), piles, cache))
            else:
                result = min(result, self.dfs(0, idx + i, max(M, i), piles, cache))

        cache[flag][idx][M] = result
        return result
