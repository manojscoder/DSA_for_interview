# Problem link: https://leetcode.com/problems/redundant-connection/description/
# Time: O(n)
# Space: O(n)
class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        rank = [1 for _ in range(len(edges) + 1)]
        parent = [i for i in range(len(edges) + 1)]
        result = 0

        for i in range(len(edges)):
            if not self.union(edges[i][0], edges[i][1], parent, rank):
                result = i
        
        return edges[result]


    def find(self, parent, node):
        node = parent[node]

        while node != parent[node]:
            parent[node] = parent[parent[node]]
            node = parent[node]
        
        return node
    
    def union(self, node_1, node_2, parent, rank):
        p1, p2 = self.find(parent, node_1), self.find(parent, node_2)

        if p1 == p2:
            return False
        
        if rank[p1] > rank[p2]:
            rank[p1] += rank[p2]
            parent[p2] = p1
        else:
            rank[p2] += rank[p1]
            parent[p1] = p2
        
        return True

