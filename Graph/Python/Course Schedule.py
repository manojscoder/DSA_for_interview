# Problem link: https://leetcode.com/problems/course-schedule/description/

# Approach: 1 (DFS)
# Time: O(n + e)
# Space: O(n + e)
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        adjList = [[] for _ in range(numCourses)]
        visit, path = [0] * numCourses, [0] * numCourses

        for src, des in prerequisites:
            adjList[src].append(des)
        
        for node in range(numCourses):
            if self.dfs(node, adjList, visit, path):
                return False
        
        return True
    
    def dfs(self, node, adjList, visit, path):
        if path[node]:
            return True
        elif visit[node]:
            return False

        path[node] = visit[node] = 1

        for ver in adjList[node]:
            if self.dfs(ver, adjList, visit, path):
                return True
        
        path[node] = 0
        return False


# Approach: 2 (BFS)
# Time: O(n + e)
# Space: O(n + e)
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        adjList = [[] for _ in range(numCourses)]
        indegree, queue, count = [0] * numCourses, deque(), 0

        for src, des in prerequisites:
            adjList[src].append(des)
            indegree[des] += 1
        
        for idx, degree in enumerate(indegree):
            if not degree:
                queue.append(idx)
                count += 1
        
        while queue:
            node = queue.popleft()

            for ver in adjList[node]:
                indegree[ver] -= 1
                if not indegree[ver]:
                    count += 1
                    queue.append(ver)
        
        return count == numCourses
    
    
