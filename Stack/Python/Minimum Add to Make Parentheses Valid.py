# Problem link: https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/description
# Time: O(n)
# Space: O(1)
class Solution:
    def minAddToMakeValid(self, s: str) -> int:
        result = count = 0

        for char in s:
            if char == '(':
                count += 1
            else:
                if count:
                    count -= 1
                else:
                    result += 1
        
        return result + count
