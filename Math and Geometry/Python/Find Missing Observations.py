# Problem link: https://leetcode.com/problems/find-missing-observations/
# Time: O(n)
# Space: O(1)
class Solution:
    def missingRolls(self, rolls: List[int], mean: int, n: int) -> List[int]:
        expected_val = (len(rolls) + n) * mean
        total = sum(rolls)

        if total + (n * 6) < expected_val or total + n > expected_val:
            return []
        
        remaining = expected_val - total
        result = [remaining // n] * n

        for i in range(remaining % n):
            result[i] += 1
            
        return result
