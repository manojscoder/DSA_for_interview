# problem link: https://leetcode.com/problems/intersection-of-two-linked-lists/description/
# Time: O(m + n)
# Space: O(1)
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        node_1, node_2 = headA, headB

        while node_1 != node_2:
            node_1 = node_1.next if node_1 else headB
            node_2 = node_2.next if node_2 else headA
        
        return node_1
