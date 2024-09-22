# Problem link: https://leetcode.com/problems/k-th-smallest-in-lexicographical-order
# Time: O(log n)
# Space: O(1)
class Solution:
    def findKthNumber(self, n: int, k: int) -> int:
        curr = idx = 1

        while idx < k:
            count = self.helper(curr, n)

            if count + idx <= k:
                idx += count
                curr += 1
            else:
                idx += 1
                curr *= 10
        
        return curr
    
    def helper(self, curr, n):
        count, nei = 0, curr + 1
    
        while curr <= n:
            count += min(nei, n + 1) - curr
            curr *= 10
            nei *= 10
        
        return count
