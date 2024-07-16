// Problem link: https://leetcode.com/problems/intersection-of-two-linked-lists/description/
// Time: O(m + n)
// Space: O(1)
public class Solution {
    public ListNode getIntersectionNode(ListNode h1, ListNode h2) {
        ListNode node_1 = h1, node_2 = h2;

        while(node_1 != node_2) {
            node_1 = node_1 == null ? h2 : node_1.next;
            node_2 = node_2 == null ? h1 : node_2.next;
        }

        return node_1;
    }
}
