# Problem link: https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/description/
# Time: O(n * (m + k))
# Space: O(max(m, k))
class Solution:
    def findLongestWord(self, s: str, dictionary: List[str]) -> str:
        
        def isSub(word):
            idx = 0

            for c in s:
                if idx < len(word) and word[idx] == c:
                    idx += 1
            
            return idx == len(word)
        
        result = ""
        
        for word in dictionary:
            if isSub(word):
                if len(word) > len(result) or len(word) == len(result) and word < result:
                    result = word
        
        return result
