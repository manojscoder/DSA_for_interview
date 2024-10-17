# Problem link: https://leetcode.com/problems/car-pooling/description/
# Time: O(n log n)
# Space: O(n)
class Solution:
    def carPooling(self, trips: List[List[int]], capacity: int) -> bool:
        store = sorted([(start, end, num) for num, start, end in trips])
        minHeap, filled = [], 0

        for start, end, num in store:
            while minHeap and minHeap[0][0] <= start:
                filled -= heappop(minHeap)[1]
            
            if filled + num > capacity:
                return False
            
            filled += num
            heappush(minHeap, (end, num))
        
        return True
