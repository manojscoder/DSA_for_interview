# Problem link: https://leetcode.com/problems/merge-two-sorted-lists/description/

# Approach: 1 (Iterative)
# Time: O(n)
# Space: O(1)
class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        head = curr = ListNode(-1)

        while list1 and list2:
            if list1.val < list2.val:
                curr.next, list1 = list1, list1.next
            else:
                curr.next, list2 = list2, list2.next
            curr = curr.next
        
        curr.next = list1 if list1 else list2
        return head.next


# Approach: 2 (Recursive)
# Time: O(n)
# Space: O(n) for call stack
class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        if not list1:
            return list2
        if not list2:
            return list1
        
        if list1.val < list2.val:
            list1.next = self.mergeTwoLists(list1.next, list2)
            return list1

        list2.next = self.mergeTwoLists(list1, list2.next)
        return list2
