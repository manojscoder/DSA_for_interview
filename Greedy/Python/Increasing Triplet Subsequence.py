# Problem link: https://leetcode.com/problems/increasing-triplet-subsequence/description
# Time: O(n)
# Space: O(1)
class Solution:
    def increasingTriplet(self, nums: List[int]) -> bool:
        one = two = float('inf')

        for num in nums:
            if num <= one:
                one = num
            elif num <= two:
                two = num
            else:
                return True
        
        return False
