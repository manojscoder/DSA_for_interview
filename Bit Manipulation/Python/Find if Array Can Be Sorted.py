# Problem link:  https://leetcode.com/problems/find-if-array-can-be-sorted/description
# Time: O(n)
# Space: O(1)
class Solution:
    def canSortArray(self, nums: List[int]) -> bool:
        
        def countBits(num):
            count = 0

            while num:
                if num & 1:
                    count += 1
                num >>= 1

            return count
            
        currMin = currMax = nums[0]
        prevMax = float('-inf')

        for num in nums:
            if countBits(num) == countBits(currMin):
                currMin = min(currMin, num)
                currMax = max(currMax, num)
            else:
                if currMin < prevMax:
                    return False
                prevMax = currMax
                currMin = currMax = num
        
        return not (currMin < prevMax)
