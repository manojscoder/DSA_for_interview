# Problem link: https://leetcode.com/problems/valid-arrangement-of-pairs/description
# Time: O(V + E)
# Space: O(V + E)
class Solution:
    def validArrangement(self, pairs: List[List[int]]) -> List[List[int]]:
        g = defaultdict(list)
        d = defaultdict(int)
        for u, v in pairs:
            g[u].append(v)
            d[u] += 1
            d[v] -= 1
        
        s = pairs[0][0]
        for u in d:
            if d[u] == 1: s = u
        
        ans = []
        def dfs(u: int) -> None:
            while g[u]:
                v = g[u].pop()
                dfs(v)
                ans.append([u, v])
    
        dfs(s)
        return ans[::-1]
