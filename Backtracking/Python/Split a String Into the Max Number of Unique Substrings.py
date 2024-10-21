# Problem link: https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings/description
# Time: O(n * 2 ^ n)
# Space: O(n)
class Solution:
    def maxUniqueSplit(self, s: str) -> int:
        seen = set()
        return self.dfs(s, 0, seen)
    
    def dfs(self, s, idx, seen):
        if idx == len(s):
            return len(seen)
        
        result = 0

        for i in range(idx, len(s)):
            prev = s[idx : i + 1]
            if prev not in seen:
                seen.add(prev)
                result = max(result, self.dfs(s, i + 1, seen))
                seen.remove(prev)
        
        return result
