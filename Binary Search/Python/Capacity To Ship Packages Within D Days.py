# Problem link: https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/
# Time: O(n log (sum(weights) - max(weights)))
# Space: O(1)
class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:
        left, right = max(weights), sum(weights)

        while left <= right:
            mid = (left + right) // 2

            count, total = 1, 0

            for w in weights:
                total += w

                if total > mid:
                    count, total = count + 1, w

                    if count > days:
                        break
            
            if count <= days:
                right = mid - 1
            else:
                left = mid + 1
        
        return left
