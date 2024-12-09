# Problem link: https://leetcode.com/problems/special-array-ii/description/
# Time: O(n + m)
# Space: O(m)
class Solution:
    def isArraySpecial(self, nums: List[int], queries: List[List[int]]) -> List[bool]:
        prefix, result = [0], []

        for index in range(1, len(nums)):
            if nums[index] % 2 != nums[index - 1] % 2:
                prefix.append(prefix[-1] + 1)
            else:
                prefix.append(prefix[-1])
        
        for start, end in queries:
            if end - start == prefix[end] - prefix[start]:
                result.append(True)
            else:
                result.append(False)
        
        return result
