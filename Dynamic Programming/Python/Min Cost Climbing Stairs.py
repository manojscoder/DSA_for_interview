# Problem link: https://leetcode.com/problems/min-cost-climbing-stairs/description/

# Top-down approach
# Time: O(n)
# Space: O(n)
class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        cache = {}

        def DP(index):
            if index >= len(cost):
                return 0
            elif index in cache:
                return cache[index]

            cache[index] = cost[index] + min(DP(index + 1), DP(index + 2))
            return cache[index]

        return min(DP(0), DP(1))

# Bottom-up approach
# Time: O(n)
# Space: O(n)
class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        copy_cost = cost + [0]
        
        for i in range(len(copy_cost) - 3, -1, -1):
            copy_cost[i] = copy_cost[i] + min(copy_cost[i + 1], copy_cost[i + 2])
        
        return min(copy_cost[0], copy_cost[1])

# Space optimized
# Time: O(n)
# Space: O(1)
class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        n = len(cost)
        one, two = cost[n - 1], 0

        for i in range(n - 2, -1, -1):
            temp = one
            one = cost[i] + min(one, two)
            two = temp
        
        return min(one, two)
