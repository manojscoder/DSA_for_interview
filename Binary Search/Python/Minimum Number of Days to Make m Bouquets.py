# Problem link: https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/description/
# Time: O(n * log D), where n is the length of the given array and D is (max_val - min_val + 1) in given array
# Space: O(1)
class Solution:
    def minDays(self, bloomDay: List[int], m: int, k: int) -> int:
        left, right, result = inf, 0, -1

        for n in bloomDay:
            left, right = min(left, n), max(right, n)
        
        while left <= right:
            mid = (left + right) // 2

            bloomed = 0
            cnt = 0

            for i in bloomDay:
                if i > mid:
                    bloomed += (cnt // k)
                    cnt = 0
                else:
                    cnt += 1
            bloomed += (cnt // k)

            if bloomed >= m:
                result = mid
                right = mid - 1
            else:
                left = mid + 1
        
        return result
