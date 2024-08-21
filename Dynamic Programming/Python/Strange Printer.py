# Problem link: https://leetcode.com/problems/strange-printer/description
# Time: O(n ^ 2)
# Space: O(n ^ 2)
class Solution:
    def strangePrinter(self, s: str) -> int:
        cache = [[0] * len(s) for _ in range(len(s))]
        return self.DP(cache, 0, len(s) - 1, s)
    
    def DP(self, cache, start, end, s):
        if start == end:
            return 1
        elif cache[start][end] != 0:
            return cache[start][end]
        
        moves = inf

        for idx in range(start, end):
            moves = min(moves, self.DP(cache, start, idx, s) + self.DP(cache, idx + 1, end, s))

        cache[start][end] = moves if s[start] != s[end] else moves - 1
        return cache[start][end]
