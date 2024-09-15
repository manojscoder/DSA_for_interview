# Problem link: https://leetcode.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/description
# Time: O(n)
# Space: O(1)
class Solution:
    def findTheLongestSubstring(self, s: str) -> int:
        store = {'a' : 1, 'e' : 2, 'i' : 4, 'o' : 8, 'u' : 16}
        mask = result = 0
        prev_idx = [-1] * 32

        for idx, char in enumerate(s):
            if char in store:
                mask ^= store[char]
            if prev_idx[mask] != -1 or mask == 0:
                result = max(result, idx - prev_idx[mask])
            else:
                prev_idx[mask] = idx
            
        return result
