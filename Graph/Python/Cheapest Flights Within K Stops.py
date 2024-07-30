# Problem link: https://leetcode.com/problems/cheapest-flights-within-k-stops/description/
# Time: O(E * K)
# Space: O(n)
class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        cost = [float('inf')] * n
        cost[src] = 0

        for _ in range(k + 1):
            tempCost = cost.copy()

            for src, des, cst in flights:
                if cost[src] + cst < tempCost[des]:
                    tempCost[des] = cost[src] + cst
            
            cost = tempCost
        
        return cost[dst] if cost[dst] != float('inf') else -1
