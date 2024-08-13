# Problem link: https://leetcode.com/problems/evaluate-division/description/
# Time: O(E + Q * (V + E))
# Space: O(V + E)
class Solution:
    def calcEquation(self, equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:
        adjList = {}

        for (u, v), val in zip(equations, values):
            if u not in adjList:
                adjList[u] = []
            if v not in adjList:
                adjList[v] = []
            
            adjList[u].append([v, val])
            adjList[v].append([u, 1 / val])
        
        return [self.bfs(adjList, u, v) for u, v in queries]

    def bfs(self, adjList, u, v):
        if u not in adjList or v not in adjList:
            return -1.0
            
        queue = deque([(u, 1)])
        visit = set()

        while queue:
            node, val = queue.popleft()
            
            if node == v:
                return val
            elif node in visit:
                continue

            visit.add(node)

            for nei, num in adjList[node]:
                queue.append((nei, val * num))
        
        return -1.0
