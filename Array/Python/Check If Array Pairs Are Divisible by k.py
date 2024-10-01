# Problem link: https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/description
# Time: O(n)
# Space: O(k)
class Solution:
    def canArrange(self, arr: List[int], k: int) -> bool:
        store, left, right = [0] * k, 1, k - 1

        for num in arr:
            store[num % k] += 1

        while left <= right:
            if store[left] != store[right]:
                return False
            left, right = left + 1, right - 1

        return store[0] % 2 == 0
