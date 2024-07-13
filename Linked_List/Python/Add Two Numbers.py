# Problem link: https://leetcode.com/problems/add-two-numbers/
# Time: O(n) where n is the max length of l1 list and l2 list
# Space: O(1)

class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        remainder = 0
        result = curr = ListNode(0)

        while l1 or l2 or remainder:
            value = (l1.val if l1 else 0) + (l2.val if l2 else 0) + remainder
            curr.next = ListNode(value % 10)
            remainder = value // 10
            curr = curr.next
            l1 = l1.next if l1 else l1
            l2 = l2.next if l2 else l2
        
        return result.next
