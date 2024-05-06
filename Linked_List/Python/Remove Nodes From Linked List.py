# Time: O(n)
# Space: O(1)
# Problem link: https://leetcode.com/problems/remove-nodes-from-linked-list/description/
class Solution:
    def removeNodes(self, head: Optional[ListNode]) -> Optional[ListNode]:
        
        def reverse(node):
            prev, curr, nxt = None, node, None

            while curr:
                nxt = curr.next
                curr.next = prev
                prev = curr
                curr = nxt
            
            return prev
        
        head = temp = reverse(head)

        while temp.next:
            if temp.next.val < temp.val:
                temp.next = temp.next.next
            else:
                temp = temp.next
        
        return reverse(head)
