# Problem link: https://leetcode.com/problems/reorder-list/description/
# Time: O(n)
# Space: O(1)
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        slow, fast = head, head.next

        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        
        prev, curr, nxt = None, slow.next, None

        while curr:
            nxt = curr.next
            curr.next = prev
            prev = curr
            curr = nxt
        
        fast = head

        while prev:
            nxt = prev.next
            fast.next, prev.next = prev, fast.next
            fast = prev.next
            prev = nxt
        
        fast.next = prev
