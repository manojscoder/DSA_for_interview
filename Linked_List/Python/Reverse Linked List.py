# Problem link: https://leetcode.com/problems/reverse-linked-list/description/
# Time: O(n)
# Space: O(1) for iteratively and O(n) for recursive solution(Call stack)

# Solution 1:(Iterative)
class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        prev, curr, nxt = None, head, None

        while curr:
            nxt = curr.next
            curr.next = prev
            prev = curr
            curr = nxt
        
        return prev

# Solution 2:(Recursive)
class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head or not head.next:
            return head
        
        new_head = self.reverseList(head.next)
        head.next.next = head
        head.next = None

        return new_head
