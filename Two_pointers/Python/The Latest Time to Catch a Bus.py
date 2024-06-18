# Problem link: https://leetcode.com/problems/the-latest-time-to-catch-a-bus/description/
# Time: O(nlogn)
# Space: O(n)
class Solution:
    def latestTimeCatchTheBus(self, buses: List[int], passengers: List[int], capacity: int) -> int:
        buses.sort()
        passengers.sort()
        idx = 0

        for st in buses:
            cap = capacity

            while idx < len(passengers) and st >= passengers[idx] and cap > 0:
                cap, idx = cap - 1, idx + 1
            
        
        result = st if cap > 0 else passengers[idx - 1]

        while idx - 1 >= 0 and result == passengers[idx - 1]:
            result -= 1
            idx -= 1
        
        return result
