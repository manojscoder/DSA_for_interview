# Problem link: https://leetcode.com/problems/maximum-number-of-integers-to-choose-from-a-range-i/description
# Time: O(n)
# Space: O(n)
class Solution:
    def maxCount(self, banned: List[int], n: int, maxSum: int) -> int:
        store = set(banned)
        total = count = 0
        
        for n in range(1, n + 1):
            if n not in store:
                if total + n > maxSum:
                    return count
                count += 1
                total += n
        
        return count
