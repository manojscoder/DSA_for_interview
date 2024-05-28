# Problem link: https://leetcode.com/problems/get-equal-substrings-within-budget/description
# Time: O(n)
# Space: O(1)
class Solution:
    def equalSubstring(self, s: str, t: str, maxCost: int) -> int:
        result = i = total = 0

        for j in range(len(s)):
            total += abs(ord(s[j]) - ord(t[j]))

            while i <= j and total > maxCost:
                total -= abs(ord(s[i]) - ord(t[i]))
                i += 1
                
            if total <= maxCost:
                result = max(result, j - i + 1)
            
        return result
