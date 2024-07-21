# Problem link: https://leetcode.com/problems/build-a-matrix-with-conditions/description/
# Time: O(k * k)
# Space: O(k * k)

class Solution:
    def buildMatrix(self, k: int, rowConditions: List[List[int]], colConditions: List[List[int]]) -> List[List[int]]:

        rowOrder = self.topoSort(rowConditions, k)
        colOrder = self.topoSort(colConditions, k)
        
        if not rowOrder or not colOrder:
            return []
        
        result = [[0] * k for _ in range(k)]
        rowIdx = {val : idx for idx, val in enumerate(rowOrder)}
        colIdx = {val : idx for idx, val in enumerate(colOrder)}

        for idx in range(1, k + 1):
            result[rowIdx[idx]][colIdx[idx]] = idx
        
        return result
    
    def topoSort(self, edges, num):
        adjList = defaultdict(list)

        for u, v in edges:
            adjList[u].append(v)
     
        path, visited, result = [0] * (num + 1), [0] * (num + 1), []

        for idx in range(1, num + 1):
            if self.dfs(adjList, path, visited, result, idx):
                return []
        
        return result[::-1]
    
    def dfs(self, adjList, path, visited, result, node):
        if path[node]:
            return True
        elif visited[node]:
            return False
        
        path[node] = visited[node] = 1

        for ver in adjList[node]:
            if self.dfs(adjList, path, visited, result, ver):
                return True

        path[node] = 0
        result.append(node)

        return False
