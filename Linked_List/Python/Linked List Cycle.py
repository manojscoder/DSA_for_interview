# Problem link: https://leetcode.com/problems/linked-list-cycle/description/
# Time: O(n)
# Space: O(1)
class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        slow = fast = head

        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            if slow == fast:
                return True
        
        return False
