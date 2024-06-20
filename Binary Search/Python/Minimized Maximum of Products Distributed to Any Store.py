# Problem link: https://leetcode.com/problems/minimized-maximum-of-products-distributed-to-any-store/description/
# Time: O(n log max(quantities))
# Space: O(1)
class Solution:
    def minimizedMaximum(self, n: int, quantities: List[int]) -> int:
        result, left, right = -1, 1, max(quantities)
        

        def isPossible(diff):
            total = 0

            for q in quantities:
                total += ceil(q / diff)
            
            return total <= n

        while left <= right:
            mid = (left + right) // 2

            if(isPossible(mid)):
                result = mid
                right = mid - 1
            else:
                left = mid + 1
        
        return result
