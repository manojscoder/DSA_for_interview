# Problem link: https://leetcode.com/problems/parallel-courses-iii/description/
# Time: O(n + e)
# Space: O(n + e)
class Solution:
    def minimumTime(self, n: int, relations: List[List[int]], time: List[int]) -> int:
        adjList, track = [[] for _ in range(n)], [tm for tm in time]
        indegree, result = [0] * n, 0

        for u, v in relations:
            adjList[u - 1].append(v - 1)
            indegree[v - 1] += 1

        queue = deque([node for node in range(n) if indegree[node] == 0])

        while queue:
            node = queue.popleft()

            for nei in adjList[node]:
                track[nei] = max(track[nei], track[node] + time[nei])
                indegree[nei] -= 1

                if indegree[nei] == 0:
                    queue.append(nei)
            
            result = max(result, track[node])

        return result
