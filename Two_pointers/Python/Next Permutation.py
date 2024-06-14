# Problem link: https://leetcode.com/problems/next-permutation/description/
# Time: O(n)
# Space: O(1)
class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        left, right = 0, len(nums) - 1

        for i in range(len(nums) - 2, -1, -1):
            if nums[i] < nums[i + 1]:

                for j in range(len(nums) - 1, i, -1):
                    if nums[j] > nums[i]:
                        nums[i], nums[j] = nums[j], nums[i]
                        break

                left = i + 1
                break

        while left < right:
            nums[left], nums[right] = nums[right], nums[left]
            left, right = left + 1, right - 1
