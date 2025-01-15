# Problem link: https://leetcode.com/problems/minimize-xor/description
# Time: O(32)
# Space: O(1)
class Solution:
    def minimizeXor(self, num1: int, num2: int) -> int:
        count = result = index = 0

        while num2:
            if num2 & 1:
                count += 1
            num2 >>= 1

        for index in range(31, -1, -1):
            if (num1 >> index) & 1:
                result = result | (1 << index)
                count -= 1
            if count == 0:
                break

        while index < 32 and count:
            if not ((result >> index) & 1):
                result = result | (1 << index)
                count -= 1
            index += 1
        
        return result
