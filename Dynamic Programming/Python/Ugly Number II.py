# Problem link: https://leetcode.com/problems/ugly-number-ii/description
# Time: O(n)
# Space: O(n)
class Solution:
    def nthUglyNumber(self, n: int) -> int:
        nums = [1]
        two = three = five = 0

        for idx in range(1, n):
            nums.append(min(2 * nums[two], 3 * nums[three], 5 * nums[five]))

            if nums[idx] == 2 * nums[two]:
                two += 1
            if nums[idx] == 3 * nums[three]:
                three += 1
            if nums[idx] == 5 * nums[five]:
                five += 1
        
        return nums[n - 1]
