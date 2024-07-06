# Problem link: https://leetcode.com/problems/merge-nodes-in-between-zeros/description
# Time: O(n)
# Space: O(1)
class Solution:
    def mergeNodes(self, head: Optional[ListNode]) -> Optional[ListNode]:
        total = 0
        ptr_1, ptr_2 = head, head.next

        while ptr_2:
            total += ptr_2.val

            if ptr_2.val == 0:
                ptr_1.val, total = total, 0
                if not ptr_2.next:
                    ptr_1.next = None
                ptr_1 = ptr_1.next

            ptr_2 = ptr_2.next
        
        return head
