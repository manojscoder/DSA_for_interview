# Problem link: https://leetcode.com/problems/jump-game-ii/description/
# Time: O(n)
# Space: O(1)
class Solution:
    def jump(self, nums: List[int]) -> int:
        l = r = res = 0

        while r < len(nums) - 1:
            far = 0
            for i in range(l, r + 1):
                far = max(far, i + nums[i])
            l, r, res = r + 1, far, res + 1
        
        return res
