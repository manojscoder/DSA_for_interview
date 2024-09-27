# Problem link: https://leetcode.com/problems/my-calendar-ii/description
# Time: O(n)
# Space: O(n)
class MyCalendarTwo:

    def __init__(self):
        self.store = []
        self.overlap = []
        
    def book(self, start: int, end: int) -> bool:
        for st, ed in self.overlap:
            if not(end <= st or start >= ed):
                return False
        
        for st, ed in self.store:
            if not(end <= st or start >= ed):
                self.overlap.append((max(start, st), min(end, ed)))
        
        self.store.append((start, end))
        return True
