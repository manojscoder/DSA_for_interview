# Problem link: https://leetcode.com/problems/maximum-profit-in-job-scheduling/description/
# Time: O(n * logn)
# Space: O(n)
class Solution:
    def jobScheduling(self, startTime: List[int], endTime: List[int], profit: List[int]) -> int:
        intervals, cache = sorted(zip(startTime, endTime, profit)), {}
        
        def dfs(i):
            if i == len(intervals):
                return 0
            elif i in cache:
                return cache[i]

            profit = dfs(i + 1)
            nextIdx = bisect.bisect(intervals, (intervals[i][1], -1, -1))
            cache[i] = profit = max(profit, intervals[i][2] + dfs(nextIdx))

            return profit
        
        return dfs(0)
