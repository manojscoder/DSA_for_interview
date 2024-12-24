# Problem link: https://leetcode.com/problems/find-minimum-diameter-after-merging-two-trees/description
# Time: O(n + m)
# Space: O(n + m)
class Solution:
    def minimumDiameterAfterMerge(self, edges1: List[List[int]], edges2: List[List[int]]) -> int:
        adjListOne = [[] for _ in range(len(edges1) + 1)]
        adjListTwo = [[] for _ in range(len(edges2) + 1)]

        for a, b in edges1:
            adjListOne[a].append(b)
            adjListOne[b].append(a)
        
        for a, b in edges2:
            adjListTwo[a].append(b)
            adjListTwo[b].append(a)
        
        diameterOne = self.maxDiameter(-1, 0, adjListOne)[0]
        diameterTwo = self.maxDiameter(-1, 0, adjListTwo)[0]

        return max(diameterOne, diameterTwo, 1 + ceil(diameterOne / 2) + ceil(diameterTwo / 2))
    
    def maxDiameter(self, par, node, adjList):
        first = second = maxDia = 0

        for nei in adjList[node]:
            if nei != par:
                neiDia, longestPath = self.maxDiameter(node, nei, adjList)
                maxDia = max(maxDia, neiDia)
                if longestPath > first:
                    second = first
                    first = longestPath
                elif longestPath > second:
                    second = longestPath

        return [max(maxDia, first + second), first + 1]
