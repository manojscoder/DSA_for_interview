# Problem link: https://leetcode.com/problems/minimum-cost-for-tickets/description/

# Top-down approach
# Time: o(n)
# Space: O(n)
class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        cache = {}
        passes = [1, 7, 30]

        def dfs(idx):
            if idx == len(days):
                return 0
            elif idx in cache:
                return cache[idx]

            res = inf
            for j, cost in enumerate(costs):
                
                i = idx
                while i < len(days) and days[i] < days[idx] + passes[j]:
                    i += 1
                res = min(res, cost + dfs(i))
 
            cache[idx] = res
            return cache[idx]

        return dfs(0)


# Bottom-up approach
# Time: O(n)
# Space: O(n)
class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        cache = {len(days) : 0}

        for i in range(len(days) - 1, -1, -1):
            cache[i] = inf
            for d, c in zip([1, 7, 30], costs):

                j = i
                while j < len(days) and days[j] < days[i] + d:
                    j += 1
                
                cache[i] = min(cache[i], c + cache[j])

        return cache[0]
