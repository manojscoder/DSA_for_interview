# Problem link: https://leetcode.com/problems/last-stone-weight/description/
# Time: O(n * log n)
# Space: O(n)
class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        maxStones = [-s for s in stones]
        heapq.heapify(maxStones)

        while len(maxStones) > 1:
            heavyOne = -heapq.heappop(maxStones)
            heavyTwo = -heapq.heappop(maxStones)

            if heavyOne != heavyTwo:
                heapq.heappush(maxStones, -(heavyOne - heavyTwo))

        return -maxStones[0] if maxStones else 0
