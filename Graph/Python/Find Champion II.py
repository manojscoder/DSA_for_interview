# Problem link: https://leetcode.com/problems/find-champion-ii/description
# Time: O(V + E)
# Space: O(V)
class Solution:
    def findChampion(self, n: int, edges: List[List[int]]) -> int:
        indegree, result = [0] * n, -1

        for a, b in edges:
            indegree[b] += 1
        
        for node, num in enumerate(indegree):
            if num == 0:
                if result != -1:
                    return -1
                result = node

        return result
