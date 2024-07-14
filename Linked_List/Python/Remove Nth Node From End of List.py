# Problem link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
# Time: O(n)
# Space: O(1)
class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        left = right = head = ListNode(-1, head)

        for _ in range(n):
            right = right.next
        
        while right.next:
            left, right = left.next, right.next
        
        left.next = left.next.next

        return head.next
