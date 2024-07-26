# Problem link: https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/description
# Algorithm: Floyd algorithm
# Time: O(n ^ 3)
# Space: O(n ^ 2)
class Solution:
    def findTheCity(self, n: int, edges: List[List[int]], distanceThreshold: int) -> int:
        adjMatrix = [[inf] * n for _ in range(n)]
        count, value, result = inf, 0, 0
        
        for u, v, d in edges:
            adjMatrix[u][v] = d
            adjMatrix[v][u] = d

        self.floyd(adjMatrix, n)
        
        for i in range(n):
            value = 0
            for j in range(n):
                if i != j and adjMatrix[i][j] <= distanceThreshold:
                    value += 1
            if count >= value:
                result = i
                count = value
                
        return result
    
    def floyd(self, adjMatrix, n):
        for k in range(n):
            for i in range(n):
                for j in range(n):
                    if adjMatrix[i][k] != inf and adjMatrix[k][j] != inf:
                        adjMatrix[i][j] = min(adjMatrix[i][j], adjMatrix[i][k] + adjMatrix[k][j])
