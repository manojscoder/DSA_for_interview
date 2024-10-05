# Problem link: https://leetcode.com/problems/permutation-in-string/description
# Time: O(26 * m + n)
# Space: O(1)
class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        storeOne = [0] * 26
        storeTwo = [0] * 26

        for char in s1:
            storeOne[ord(char) - ord('a')] += 1
        
        for idx, char in enumerate(s2):
            storeTwo[ord(char) - ord('a')] += 1

            if idx >= len(s1):
                storeTwo[ord(s2[idx - len(s1)]) - ord('a')] -= 1
            
            if storeOne == storeTwo:
                return True
        
        return False
