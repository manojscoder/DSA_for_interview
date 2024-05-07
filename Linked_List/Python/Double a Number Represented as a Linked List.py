# Problem link: https://leetcode.com/problems/double-a-number-represented-as-a-linked-list/description
# Time: O(n)
# Space: O(1)
class Solution:
    def doubleIt(self, head: Optional[ListNode]) -> Optional[ListNode]:

        def reverse(node):
            prev, curr, nxt = None, node, None

            while curr:
                nxt = curr.next
                curr.next = prev
                prev = curr
                curr = nxt
            
            return prev
        
        head, remainder = reverse(head), 0
        temp = head

        while True:
            val = (temp.val * 2) + remainder
            temp.val, remainder = val % 10, val // 10

            if not temp.next:
                temp.next = ListNode(1) if remainder == 1 else None
                return reverse(head)
            temp = temp.next
