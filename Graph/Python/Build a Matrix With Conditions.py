# Problem link: https://leetcode.com/problems/build-a-matrix-with-conditions/description/
# Time: O(k * k)
# Space: O(k * k)

# Approach: DFS
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

# Approach: BFS
class Solution:
    def buildMatrix(self, k: int, rowConditions: List[List[int]], colConditions: List[List[int]]) -> List[List[int]]:
        rowIndex = self.topoSort(rowConditions, k)
        colIndex = self.topoSort(colConditions, k)

        if len(rowIndex) != k or len(colIndex) != k:
            return []

        result = [[0] * k for _ in range(k)]
        indicesDetails = {}

        for idx in range(len(rowIndex)):
            indicesDetails[rowIndex[idx]] = idx

        for idx in range(len(colIndex)):
            result[indicesDetails[colIndex[idx]]][idx] = colIndex[idx]
        
        return result
    

    def topoSort(self, edges, totalNodes):
        indegree, topoOrder = [0] * (totalNodes), []
        adjList = {}
        
        for u, v in edges:
            if u not in adjList:
                adjList[u] = []
            adjList[u].append(v)
            indegree[v - 1] += 1
        
        queue, visit = deque(), set()
        
        for idx in range(len(indegree)):
            if indegree[idx] == 0:
                queue.append(idx + 1)
        
        while queue:
            node = queue.popleft()
            topoOrder.append(node)
            
            if node in adjList:
                for ver in adjList[node]:
                    indegree[ver - 1] -= 1
                    if indegree[ver - 1] == 0:
                        queue.append(ver)
        
        return topoOrder
