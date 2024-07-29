# Problem link: https://leetcode.com/problems/the-time-when-the-network-becomes-idle/description/
# Time: O(n + m)
# Space: O(n + m)
class Solution:
    def networkBecomesIdle(self, edges: List[List[int]], patience: List[int]) -> int:
        size, result = len(patience), 0
        adjList = [[] for _ in range(size)]
        distance = [0 for _ in range(size)]
        visited = [0] * size
        queue = deque([(0, 0)])
       
        for u, v in edges:
            adjList[u].append(v)
            adjList[v].append(u)

        while queue:
            node, dist = queue.popleft()

            if visited[node]:
                continue

            visited[node] = 1
            distance[node] = dist * 2

            for nei in adjList[node]:
                queue.append((nei, dist + 1))

        for idx in range(1, size):
            if patience[idx] >= distance[idx]:
                result = max(result, distance[idx])
            else:
                remainder = distance[idx] % patience[idx]
                result = max(result, distance[idx] + distance[idx] - (remainder if remainder > 0 else patience[idx]))

        return result + 1
        
