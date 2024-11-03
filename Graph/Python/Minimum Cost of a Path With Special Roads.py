# Problem link: https://leetcode.com/problems/minimum-cost-of-a-path-with-special-roads/description/
# Time: O(n ^ 2 * log(n))
# Space: O(n)
class Solution:
    def minimumCost(self, start: List[int], target: List[int], specialRoads: List[List[int]]) -> int:
        distance = [float('inf')] * len(specialRoads)
        PQ = [(0, start[0], start[1], -1)]
        result = abs(target[0] - start[0]) + abs(target[1] - start[1])
        
        while PQ:
            dist, x, y, index = heappop(PQ)

            if index != -1 and distance[index] < dist:
                continue
            
            result = min(result, abs(x - target[0]) + abs(y - target[1]) + dist)
            
            for index, (x1, y1, x2, y2, cost) in enumerate(specialRoads):
                cst = abs(x - x1) + abs(y - y1) + cost + dist
                if cst < distance[index]:
                    heappush(PQ, (cst, x2, y2, index))
                    distance[index] = cst
        
        return result
