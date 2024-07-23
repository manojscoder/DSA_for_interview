# Problem link: https://leetcode.com/problems/course-schedule-ii/description/

# Approach: 1 (DFS)
# Time: O(n + e)
# Space: O(n + e)
class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        adjList = [[] for _ in range(numCourses)]

        for src, des in prerequisites:
            adjList[src].append(des)
        
        visit, path = [0] * numCourses, [0] * numCourses
        result = []

        for idx in range(numCourses):
            if self.dfs(idx, visit, path, result, adjList):
                return []
        
        return result
    
    def dfs(self, node, visit, path, result, adjList):
        if path[node]:
            return True
        elif visit[node]:
            return False
        
        visit[node] = path[node] = 1

        for ver in adjList[node]:
            if self.dfs(ver, visit, path, result, adjList):
                return True
        
        path[node] = 0
        result.append(node)

        return False



# Approach: 2 (BFS)
# Time: O(n + e)
# Space: O(n + e)
class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        adjList = [[] for _ in range(numCourses)]
        indegree, result = [0] * numCourses, []
        queue = deque()
        
        for u, v in prerequisites:
            adjList[v].append(u)
            indegree[u] += 1
        
        for idx in range(len(indegree)):
            if not indegree[idx]:
                queue.append(idx)
        
        while queue:
            node = queue.popleft()
            result.append(node)

            for ver in adjList[node]:
                indegree[ver] -= 1
                if not indegree[ver]:
                    queue.append(ver)
        
        return result if len(result) == numCourses else []
