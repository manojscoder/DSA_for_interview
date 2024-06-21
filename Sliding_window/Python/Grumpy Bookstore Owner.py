# Problem link: https://leetcode.com/problems/grumpy-bookstore-owner/description/
# Time: O(n)
# Space: O(1)
class Solution:
    def maxSatisfied(self, customers: List[int], grumpy: List[int], minutes: int) -> int:
        result = bonus = prev = temp = 0

        for i in range(len(customers)):
            if not grumpy[i]:
                result += customers[i]
            else:
                temp += customers[i]

            if i >= minutes - 1:
                bonus = max(bonus, temp)
                temp -= customers[prev] if grumpy[prev] else 0
                prev += 1
            
        return max(bonus, temp) + result
