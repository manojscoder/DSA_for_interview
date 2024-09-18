# Problem link: https://leetcode.com/problems/largest-number/description
# Time: O(n log n)
# Space: O(n)
class Solution:

    def compare(self, num1, num2):
        if num1 + num2 > num2 + num1:
            return -1
        return 1
        
    def largestNumber(self, nums: List[int]) -> str:
        return str(int("".join(sorted([str(n) for n in nums], key = cmp_to_key(self.compare)))))
