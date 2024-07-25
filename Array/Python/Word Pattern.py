# Problem link: https://leetcode.com/problems/word-pattern/description/
# Time: O(n)
# Space: O(n)
class Solution:
    def wordPattern(self, pattern: str, s: str) -> bool:
        words = s.split()

        if len(pattern) != len(words):
            return False

        store_1, store_2 = {}, {} 

        for idx in range(len(pattern)):
            if words[idx] in store_1 and store_1[words[idx]] != pattern[idx]:
                return False

            if pattern[idx] in store_2 and store_2[pattern[idx]] != words[idx]:
                return False
            
            store_1[words[idx]] = pattern[idx]
            store_2[pattern[idx]] = words[idx]
        
        return True
