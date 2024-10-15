# Problem link: https://leetcode.com/problems/separate-black-and-white-balls/description
# Time: O(n)
# Space: O(1)
class Solution:
    def minimumSteps(self, s: str) -> int:
        count = result = 0

        for idx, char in enumerate(s):
            if char == '0':
                result += (idx - count)
                count += 1
        
        return result
