# Problem link: https://leetcode.com/problems/assign-cookies/description/
# Time: O(nlogn)
# Space: O(n) for sorting
class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        g.sort()
        s.sort()
        i = j = 0

        while i < len(g) and j < len(s):
            if s[j] >= g[i]:
                i += 1
            j += 1
        
        return i
