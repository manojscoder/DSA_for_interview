# Problem link: https://leetcode.com/problems/my-calendar-i/description
# Time: O(n)
# Space: O(n)
class MyCalendar:

    def __init__(self):
        self.store = []

    def book(self, start: int, end: int) -> bool:
        left, right = 0, len(self.store) - 1

        while left <= right:
            mid = (left + right) // 2

            st, ed = self.store[mid]

            if not (end <= st or start >= ed):
                return False

            if ed <= start:
                left = mid + 1
            else:
                right = mid - 1
        
        self.store.insert(left, [start, end])

        return True
