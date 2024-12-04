# Problem link: https://leetcode.com/problems/make-string-a-subsequence-using-cyclic-increments/description
# Time: O(n)
# Space: O(1)
class Solution:
    def canMakeSubsequence(self, str1: str, str2: str) -> bool:
        index = 0

        for idx in range(len(str1)):
            value = ord(str1[idx])

            if value == ord(str2[index]) or (value + 1 if str1[idx] != 'z' else ord('a')) == ord(str2[index]):
                index += 1
            
            if index == len(str2):
                return True
        
        return False
